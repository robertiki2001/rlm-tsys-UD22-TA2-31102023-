package Controllers;

import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;

import DB_Connection.ConnectionDB;
import Views.ClienteViewUpdate;
import Model.Cliente;

public class ClienteUpdateController implements ActionListener {
    private ClienteViewUpdate updateView;
    private Cliente cliente;

    public ClienteUpdateController(ClienteViewUpdate updateView, Cliente cliente) {
        this.updateView = updateView;
        this.cliente = cliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateView.getButtonActualizarCliente()) {
            String nombre = updateView.getTextFieldNombre().getText();
            String apellido = updateView.getTextFieldApellido().getText();
            String direccion = updateView.getTextAreaDireccion().getText();
            
            if (nombre.isEmpty() || apellido.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nombre y Apellido son campos obligatorios.");
                return;
            }
            int dni;
            try {
             dni = Integer.parseInt(updateView.getTextFieldDni().getText());;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "DNI debe ser un número válido.");
                return;
            }
            // Actualiza los campos del cliente con los valores modificados
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDireccion(direccion);
            cliente.setDni(dni);

            // Llamamos a un método para actualizar el cliente en la base de datos
            if (actualizarCliente(cliente)) {
                // Éxito al actualizar, muestra un mensaje
                JOptionPane.showMessageDialog(null, "Cliente actualizado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el cliente");
            }
        }
    }

    private boolean actualizarCliente(Cliente cliente) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionDB.getConnection();
            String sql = "UPDATE cliente SET nombre = ?, apellido = ?, direccion = ?, dni = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getDireccion());
            statement.setInt(4, cliente.getDni());
            statement.setInt(5, cliente.getId());

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
