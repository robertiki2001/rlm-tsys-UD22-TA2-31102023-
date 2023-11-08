package Controllers;

import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;

import DB_Connection.ConnectionDB;
import Views.VideoViewUpdate;
import Model.Video;

public class VideoUpdateController implements ActionListener {
    private VideoViewUpdate updateVideoView;
    private Video video;

    public VideoUpdateController(VideoViewUpdate updateVideoView, Video video) {
        this.updateVideoView = updateVideoView;
        this.video = video;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateVideoView.getButtonActualizarVideo()) {
            String title = updateVideoView.getTextFieldTitle().getText();
            String director = updateVideoView.getTextFieldDirector().getText();
         // Obtiene el ID del cliente seleccionado en el JComboBox
            Integer cli_id = (Integer) updateVideoView.getComboBoxClienteId().getSelectedItem();

            if (title.isEmpty() || director.isEmpty() || cli_id == null) {
                JOptionPane.showMessageDialog(null, "El título, el director y el cliente son campos obligatorios");
                return;
            }
            // Actualiza los campos del cliente con los valores modificados
            video.setTitle(title);
            video.setDirector(director);
            video.setCli_id(cli_id);

            // Llamamos a un método para actualizar el cliente en la base de datos
            if (actualizarVideo(video)) {
                // Éxito al actualizar, muestra un mensaje
                JOptionPane.showMessageDialog(null, "Video actualizado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el video");
            }
        }
    }

    private boolean actualizarVideo(Video video) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionDB.getConnection();
            String sql = "UPDATE videos SET title = ?, director = ?, cli_id = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, video.getTitle());
            statement.setString(2, video.getDirector());
            statement.setInt(3, video.getCli_id());
            statement.setInt(4, video.getId());

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                return true;
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
