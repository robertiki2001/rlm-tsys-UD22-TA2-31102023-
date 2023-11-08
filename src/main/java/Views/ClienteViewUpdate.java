package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controllers.ClienteReadController;
import Model.Cliente;

public class ClienteViewUpdate extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelNombreUpdate;
	private JLabel labelApellidoUpdate;
	private JLabel labelDireccionUpdate;
	private JLabel labelDniUpdate;
	private JLabel labelFechaUpdate;
	private JLabel tituloUpdate;
	private JTextField textFieldNombreUpdate;
	private JTextField textFieldApellidoUpdate;
	private JTextArea textAreaDireccionUpdate;
	private JTextField textFieldDniUpdate;
	private JTextField textFieldFechaUpdate;
	private JButton buttonActualizarCliente;
	private JButton buttonMenuUpdate;

    public ClienteViewUpdate(Cliente clienteSeleccionado) {
    	setTitle("Vista editar cliente");
		setBounds(600,450,400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		labelNombreUpdate = new JLabel("Nombre:");
		labelNombreUpdate.setBounds(48,103,200,20);
		contentPane.add(labelNombreUpdate);
		
	    labelApellidoUpdate = new JLabel("Apellido:");
		labelApellidoUpdate.setBounds(48, 151, 200, 20);
		contentPane.add(labelApellidoUpdate);
		
	    labelDireccionUpdate = new JLabel("Direccion:");
		labelDireccionUpdate.setBounds(48, 200, 200, 20);
		contentPane.add(labelDireccionUpdate);
		
	    labelDniUpdate = new JLabel("Dni:");
		labelDniUpdate.setBounds(48, 290, 200, 20);
		contentPane.add(labelDniUpdate);
		
	    labelFechaUpdate = new JLabel("Fecha:");
		labelFechaUpdate.setBounds(48, 335, 200, 20);
		contentPane.add(labelFechaUpdate);
		
		textFieldNombreUpdate = new JTextField();
		textFieldNombreUpdate.setBounds(104, 103, 176, 20);
		contentPane.add(textFieldNombreUpdate);
		textFieldNombreUpdate.setColumns(10);
		
		textFieldApellidoUpdate = new JTextField();
		textFieldApellidoUpdate.setColumns(10);
		textFieldApellidoUpdate.setBounds(104, 151, 176, 20);
		contentPane.add(textFieldApellidoUpdate);
		
		textFieldDniUpdate = new JTextField();
		textFieldDniUpdate.setColumns(10);
		textFieldDniUpdate.setBounds(104, 290, 176, 20);
		contentPane.add(textFieldDniUpdate);
		
		textFieldFechaUpdate = new JTextField();
		textFieldFechaUpdate.setColumns(10);
		textFieldFechaUpdate.setBounds(104, 335, 176, 20);
		contentPane.add(textFieldFechaUpdate);
		
		textAreaDireccionUpdate = new JTextArea();
		textAreaDireccionUpdate.setBounds(104, 198, 176, 70);
		contentPane.add(textAreaDireccionUpdate);
		
		tituloUpdate = new JLabel("ACTUALIZAR CLIENTE");
		tituloUpdate.setBounds(100, 43, 294, 30);
		contentPane.add(tituloUpdate);
		
		buttonActualizarCliente = new JButton("Actualizar cliente");
		buttonActualizarCliente.setBounds(86, 406, 217, 23);
		contentPane.add(buttonActualizarCliente);
		
		buttonMenuUpdate = new JButton("Volver al menú");
		buttonMenuUpdate.setBounds(263, 11, 111, 30);
		buttonMenuUpdate.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
				// Crear una instancia del controlador ClienteReadController
			    Cliente cliente = new Cliente();
			    ClienteViewRead clienteViewRead = new ClienteViewRead();
			    ClienteReadController readController = new ClienteReadController(cliente, clienteViewRead);
			    readController.iniciarVista();
			    clienteViewRead.setVisible(true);
		        dispose();
		    }
		});
		contentPane.add(buttonMenuUpdate);
		

    }
    
    public JButton getButtonActualizarCliente() {
        return buttonActualizarCliente;
    }
    
    public JTextField getTextFieldNombre() {
        return textFieldNombreUpdate;
    }
    
    public JTextField getTextFieldApellido() {
        return textFieldApellidoUpdate;
    }
    
    public JTextArea getTextAreaDireccion() {
        return textAreaDireccionUpdate;
    }
    
    public JTextField getTextFieldDni() {
        return textFieldDniUpdate;
    }
    
    public JTextField getTextFieldFecha() {
        return textFieldFechaUpdate;
    }
}