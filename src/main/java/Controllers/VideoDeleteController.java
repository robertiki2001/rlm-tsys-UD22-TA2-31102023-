package Controllers;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;

import DB_Connection.ConnectionDB;
import Model.Video;

public class VideoDeleteController{

    // Método para eliminar un video de la base de datos
    public boolean eliminarVideo(Video video) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionDB.getConnection();
            String sql = "DELETE FROM videos WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, video.getId());

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                return true; // Éxito al eliminar
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }



}
