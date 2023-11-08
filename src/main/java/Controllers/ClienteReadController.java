package Controllers;

import DB_Connection.ConnectionDB;

import java.awt.event.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import Model.Cliente;
import Model.ClienteTable;
import Views.ClienteViewRead;

public class ClienteReadController implements ActionListener{
	private ClienteViewRead clienteViewRead;
	
	public ClienteReadController(Cliente cliente, ClienteViewRead clienteViewRead) {
		this.clienteViewRead = clienteViewRead;
		iniciarVista(); // Cargar registros al crear el controlador
	}
	
	public ClienteReadController(ClienteViewRead clienteViewRead2) {
	}

	public void iniciarVista() {
	    List<Cliente> clientes = obtenerClientes();
	    if (clientes != null && !clientes.isEmpty()) {
	        ClienteTable model = new ClienteTable(clientes);
	        clienteViewRead.getTabla().setModel(model);
	    }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Cliente> obtenerClientes() {
	    List<Cliente> clientes = new ArrayList<>();
	    
	    // Realiza una consulta SQL para obtener todos los clientes
	    String sql = "SELECT * FROM cliente";
	    
	    try {
	    	Connection conexion = null;
	        // Obtener la conexión utilizando la clase ConnectionDB
	        conexion = ConnectionDB.getConnection();
	        Statement stmt = conexion.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String nombre = rs.getString("nombre");
	            String apellido = rs.getString("apellido");
	            String direccion = rs.getString("direccion");
	            int dni = rs.getInt("dni");
	            Date fecha = rs.getDate("fecha");
	            
	            Cliente cliente = new Cliente(id, nombre, apellido, direccion, dni, fecha);
	            clientes.add(cliente);
	        }
	        
	        rs.close();
	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return clientes;
	}

}
