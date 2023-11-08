package Views;

import java.awt.event.*;

import javax.swing.*;

import Controllers.ClienteReadController;
import Controllers.VideoDeleteController;
import Controllers.VideoUpdateController;
import Model.Cliente;
import Model.Video;
import Model.VideoTable;


public class VideoViewRead extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label;
	private JButton buttonCrearVideo;
	private JButton buttonUpdateVideo;
	private JButton buttonDeleteVideo;
	private JButton buttonReadClientes;
	private JTable table;

	public VideoViewRead() {

		setTitle("Vista listar videos");
		setBounds(500, 500, 700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		label = new JLabel("Lista de videos");
		label.setBounds(162, 14, 200, 20);
		contentPane.add(label);

		buttonUpdateVideo = new JButton("Editar");
		buttonUpdateVideo.setBounds(33, 355, 108, 20);
		contentPane.add(buttonUpdateVideo);

		buttonDeleteVideo = new JButton("Eliminar");
		buttonDeleteVideo.setBounds(162, 350, 108, 31);
		contentPane.add(buttonDeleteVideo);

		buttonCrearVideo = new JButton("Crear video");
		buttonCrearVideo.setBounds(299, 350, 121, 31);
		buttonCrearVideo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Crear una instancia de la vista ClienteViewCreate
				VideoViewCreate createView = new VideoViewCreate();
				createView.setVisible(true); // Mostrar la vista
				dispose();
			}
		});
		contentPane.add(buttonCrearVideo);

		buttonUpdateVideo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					VideoTable model = (VideoTable) table.getModel();
					Video videoSeleccionado = model.getVideos(selectedRow);

					VideoViewUpdate updateView = new VideoViewUpdate(videoSeleccionado);
					updateView.setVisible(true);

					VideoUpdateController updateController = new VideoUpdateController(updateView,
							videoSeleccionado);
					updateView.getButtonActualizarVideo().addActionListener(updateController);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Selecciona un video para actualizar");
				}
			}
		});
		
		buttonDeleteVideo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					VideoTable model = (VideoTable) table.getModel();
					Video videoSeleccionado = model.getVideos(selectedRow);

					// Crea una instancia del controlador VideoDeleteController
					VideoDeleteController deleteController = new VideoDeleteController();

					int option = JOptionPane.showConfirmDialog(null,
							"¿Estás seguro de que deseas eliminar este video?", "Confirmar eliminación",
							JOptionPane.YES_NO_OPTION);

					if (option == JOptionPane.YES_OPTION) {
						// Llama al método para eliminar el cliente
						if (deleteController.eliminarVideo(videoSeleccionado)) {
							JOptionPane.showMessageDialog(null, "Video eliminado con éxito");
							model.removeRowAt(selectedRow);
							table.setModel(model);
							table.repaint();
						} else {
							JOptionPane.showMessageDialog(null, "Error al eliminar el video");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecciona un video para eliminar");
				}
			}
		});
	
		
		buttonReadClientes = new JButton("Clientes");
		buttonReadClientes.setBounds(263, 11, 111, 30);
		buttonReadClientes.addActionListener(new ActionListener() {
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
		contentPane.add(buttonReadClientes);
		
		table = new JTable();
		table.setBounds(29, 45, 596, 259);
		contentPane.add(table);
	}

	public JTable getTabla() {
		return table;
	}

	public JButton getButtonDeleteVideo() {
		return buttonDeleteVideo;
	}

}