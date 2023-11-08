package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import DB_Connection.ConnectionDB;
import Model.Video;
import Views.VideoViewCreate;

public class VideoCreateController implements ActionListener {
    private VideoViewCreate createView;

    public VideoCreateController(VideoViewCreate createView) {
        this.createView = createView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createView.getButtonCrearVideo()) {
            // Obtiene los valores del formulario
            String title = createView.getTextFieldTitle().getText();
            String director = createView.getTextFieldDirector().getText();           
            // Obtiene el ID del cliente seleccionado en el JComboBox
            Integer cli_id = (Integer) createView.getComboBoxClienteId().getSelectedItem();

            if (title.isEmpty() || director.isEmpty() || cli_id == null) {
                JOptionPane.showMessageDialog(null, "El título, el director y el cliente son campos obligatorios");
                return;
            }
            // Crea un nuevo objeto Cliente con los valores
            Video video = new Video(0, title, director, cli_id);

            // Inserta el cliente en la base de datos
            if (insertarVideo(video)) {
                // Éxito al insertar, muestra un mensaje
                JOptionPane.showMessageDialog(null, "Video insertado con éxito");
                // Limpia el formulario
                limpiarFormulario();
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar el video");
            }
        }
    }

    // Método para insertar un cliente en la base de datos
    public boolean insertarVideo(Video video) {
        Connection connection = ConnectionDB.getConnection();
        String sql = "INSERT INTO videos (title, director, cli_id) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, video.getTitle());
            statement.setString(2, video.getDirector());
            statement.setInt(3, video.getCli_id());
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private void limpiarFormulario() {
        createView.getTextFieldTitle().setText("");
        createView.getTextFieldDirector().setText("");
        createView.getComboBoxClienteId().setSelectedItem("");
    }
}
