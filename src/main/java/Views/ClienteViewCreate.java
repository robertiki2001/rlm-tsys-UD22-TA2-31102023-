package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controllers.ClienteCreateController;
import Controllers.ClienteReadController;
import Model.Cliente;

public class ClienteViewCreate extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelNombre;
	private JLabel labelApellido;
	private JLabel labelDireccion;
	private JLabel labelDni;
	private JLabel labelFecha;
	private JLabel titulo;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextArea textAreaDireccion;
	private JTextField textFieldDni;
	private JTextField textFieldFecha;
	private JButton buttonCrearCliente;
	private JButton buttonMenu;
	private JTable table;

    public ClienteViewCreate() {
    	setTitle("Vista crear cliente");
		setBounds(600,450,400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(48,103,200,20);
		contentPane.add(labelNombre);
		
	    labelApellido = new JLabel("Apellido:");
		labelApellido.setBounds(48, 151, 200, 20);
		contentPane.add(labelApellido);
		
	    labelDireccion = new JLabel("Direccion:");
		labelDireccion.setBounds(48, 200, 200, 20);
		contentPane.add(labelDireccion);
		
	    labelDni = new JLabel("Dni:");
		labelDni.setBounds(48, 290, 200, 20);
		contentPane.add(labelDni);
		
	    labelFecha = new JLabel("Fecha:");
		labelFecha.setBounds(48, 335, 200, 20);
		contentPane.add(labelFecha);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(104, 103, 176, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(104, 151, 176, 20);
		contentPane.add(textFieldApellido);
		
		textFieldDni = new JTextField();
		textFieldDni.setColumns(10);
		textFieldDni.setBounds(104, 290, 176, 20);
		contentPane.add(textFieldDni);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(104, 335, 176, 20);
		contentPane.add(textFieldFecha);
		
		textAreaDireccion = new JTextArea();
		textAreaDireccion.setBounds(104, 198, 176, 70);
		contentPane.add(textAreaDireccion);
		
		titulo = new JLabel("REGISTO DE UN NUEVO CLIENTE");
		titulo.setBounds(100, 43, 294, 30);
		contentPane.add(titulo);
		
		buttonCrearCliente = new JButton("Crear cliente");
		buttonCrearCliente.setBounds(86, 406, 217, 23);
		contentPane.add(buttonCrearCliente);
		
		buttonMenu = new JButton("Volver al menú");
		buttonMenu.setBounds(263, 11, 111, 30);
		buttonMenu.addActionListener(new ActionListener() {
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
		contentPane.add(buttonMenu);

		
		table = new JTable();
		table.setBounds(29, 45, 596, 259);
		contentPane.add(table);
		
		buttonCrearCliente.addActionListener(new ClienteCreateController(this));

    }

    public JButton getButtonCrearCliente() {
        return buttonCrearCliente;
    }
    
    public JTextField getTextFieldNombre() {
        return textFieldNombre;
    }
    
    public JTextField getTextFieldApellido() {
        return textFieldApellido;
    }
    
    public JTextArea getTextAreaDireccion() {
        return textAreaDireccion;
    }
    
    public JTextField getTextFieldDni() {
        return textFieldDni;
    }
    
    public JTextField getTextFieldFecha() {
        return textFieldFecha;
    }

}