package Controllers;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;

import DB_Connection.ConnectionDB;
import Model.Cliente;

public class ClienteDeleteController{

    // Método para eliminar un cliente de la base de datos
    public boolean eliminarCliente(Cliente cliente) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionDB.getConnection();
            String sql = "DELETE FROM cliente WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, cliente.getId());

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
