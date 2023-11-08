package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

import DB_Connection.ConnectionDB;
import Model.Cliente;
import Views.ClienteViewCreate;

public class ClienteCreateController implements ActionListener {
    private ClienteViewCreate createView;

    public ClienteCreateController(ClienteViewCreate createView) {
        this.createView = createView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createView.getButtonCrearCliente()) {
            // Obtiene los valores del formulario
            String nombre = createView.getTextFieldNombre().getText();
            String apellido = createView.getTextFieldApellido().getText();
            String direccion = createView.getTextAreaDireccion().getText();
            
            if (nombre.isEmpty() || apellido.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nombre y Apellido son campos obligatorios.");
                return;
            }
            int dni;
            try {
             dni = Integer.parseInt(createView.getTextFieldDni().getText());;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "DNI debe ser un número válido.");
                return;
            }
            
            java.sql.Date fecha = new java.sql.Date(new Date().getTime());

            // Crea un nuevo objeto Cliente con los valores
            Cliente cliente = new Cliente(0, nombre, apellido, direccion, dni, fecha);

            // Inserta el cliente en la base de datos
            if (insertarCliente(cliente)) {
                // Éxito al insertar, muestra un mensaje
                JOptionPane.showMessageDialog(null, "Cliente insertado con éxito");
                // Limpia el formulario
                limpiarFormulario();
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar el cliente");
            }
        }
    }

    // Método para insertar un cliente en la base de datos
    public boolean insertarCliente(Cliente cliente) {
        Connection connection = ConnectionDB.getConnection();
        String sql = "INSERT INTO cliente (nombre, apellido, direccion, dni, fecha) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getDireccion());
            statement.setInt(4, cliente.getDni());
            statement.setDate(5, cliente.getFecha());
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
        createView.getTextFieldNombre().setText("");
        createView.getTextFieldApellido().setText("");
        createView.getTextAreaDireccion().setText("");
        createView.getTextFieldDni().setText("");
        createView.getTextFieldFecha().setText("");
    }
}
