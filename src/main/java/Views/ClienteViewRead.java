package Views;

import java.awt.event.*;

import javax.swing.*;

import Controllers.ClienteDeleteController;
import Controllers.ClienteUpdateController;
import Controllers.VideoReadController;
import Model.Cliente;
import Model.ClienteTable;
import Model.Video;

public class ClienteViewRead extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label;
	private JButton buttonCrearCliente;
	private JButton buttonUpdateCliente;
	private JButton buttonDeleteCliente;
	private JButton buttonReadVideos;
	private JTable table;

	public ClienteViewRead() {

		setTitle("Vista listar clientes");
		setBounds(500, 500, 700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		label = new JLabel("Lista de clientes");
		label.setBounds(162, 14, 200, 20);
		contentPane.add(label);

		buttonUpdateCliente = new JButton("Editar");
		buttonUpdateCliente.setBounds(33, 355, 108, 20);
		contentPane.add(buttonUpdateCliente);

		buttonDeleteCliente = new JButton("Eliminar");
		buttonDeleteCliente.setBounds(162, 350, 108, 31);
		contentPane.add(buttonDeleteCliente);

		buttonCrearCliente = new JButton("Crear cliente");
		buttonCrearCliente.setBounds(299, 350, 121, 31);
		buttonCrearCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Crear una instancia de la vista ClienteViewCreate
				ClienteViewCreate createView = new ClienteViewCreate();
				createView.setVisible(true); // Mostrar la vista
				dispose();
			}
		});
		contentPane.add(buttonCrearCliente);

		buttonUpdateCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					ClienteTable model = (ClienteTable) table.getModel();
					Cliente clienteSeleccionado = model.getCliente(selectedRow);

					ClienteViewUpdate updateView = new ClienteViewUpdate(clienteSeleccionado);
					updateView.setVisible(true);

					ClienteUpdateController updateController = new ClienteUpdateController(updateView,
							clienteSeleccionado);
					updateView.getButtonActualizarCliente().addActionListener(updateController);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Selecciona un cliente para actualizar");
				}
			}
		});

		buttonDeleteCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					ClienteTable model = (ClienteTable) table.getModel();
					Cliente clienteSeleccionado = model.getCliente(selectedRow);

					// Crea una instancia del controlador ClienteDeleteController
					ClienteDeleteController deleteController = new ClienteDeleteController();

					int option = JOptionPane.showConfirmDialog(null,
							"¿Estás seguro de que deseas eliminar este cliente?", "Confirmar eliminación",
							JOptionPane.YES_NO_OPTION);

					if (option == JOptionPane.YES_OPTION) {
						// Llama al método para eliminar el cliente
						if (deleteController.eliminarCliente(clienteSeleccionado)) {
							JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito");
							model.removeRowAt(selectedRow);
							table.setModel(model);
							table.repaint();
						} else {
							JOptionPane.showMessageDialog(null, "Error al eliminar el cliente");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecciona un cliente para eliminar");
				}
			}
		});
		
		buttonReadVideos = new JButton("Videos");
		buttonReadVideos.setBounds(263, 11, 111, 30);
		buttonReadVideos.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
				// Crear una instancia del controlador ClienteReadController
			    Video video = new Video();
			    VideoViewRead videosViewRead = new VideoViewRead();
			    VideoReadController readController = new VideoReadController(video, videosViewRead);
			    readController.iniciarVistaVideos();
			    videosViewRead.setVisible(true);
		        dispose();
		    }
		});
		contentPane.add(buttonReadVideos);

		table = new JTable();
		table.setBounds(29, 45, 596, 259);
		contentPane.add(table);
	}

	public JTable getTabla() {
		return table;
	}

	public JButton getButtonDeleteCliente() {
		return buttonDeleteCliente;
	}

}