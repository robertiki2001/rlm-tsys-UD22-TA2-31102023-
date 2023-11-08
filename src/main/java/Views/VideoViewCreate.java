package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import Controllers.VideoCreateController;
import Controllers.VideoReadController;
import DB_Connection.FunctionsSQL;
import Model.Video;

public class VideoViewCreate extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelTitle;
	private JLabel labelDirector;
	private JLabel labelClienteID;
	private JLabel titulo;
	private JTextField textFieldTitle;
	private JTextField textFieldDirector;
	private JButton buttonCrearVideo;
	private JButton buttonReadVideos;
	private JTable table;
	private JComboBox<Integer> comboBoxClienteId;

    public VideoViewCreate() {
    	setTitle("Vista crear video");
		setBounds(600,450,400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		comboBoxClienteId = new JComboBox<Integer>();
		comboBoxClienteId.setBounds(116, 199, 96, 22);
		contentPane.add(comboBoxClienteId);

		labelTitle = new JLabel("Title:");
		labelTitle.setBounds(48,103,200,20);
		contentPane.add(labelTitle);
		
		labelDirector = new JLabel("Director:");
		labelDirector.setBounds(48, 151, 200, 20);
		contentPane.add(labelDirector);
		
		labelClienteID = new JLabel("Cliente:");
		labelClienteID.setBounds(48, 200, 200, 20);
		contentPane.add(labelClienteID);
				
		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(116, 103, 176, 20);
		contentPane.add(textFieldTitle);
		textFieldTitle.setColumns(10);
		
		textFieldDirector = new JTextField();
		textFieldDirector.setColumns(10);
		textFieldDirector.setBounds(116, 151, 176, 20);
		contentPane.add(textFieldDirector);
			
		titulo = new JLabel("REGISTO DE UN NUEVO VIDEO");
		titulo.setBounds(100, 43, 294, 30);
		contentPane.add(titulo);
		
		buttonCrearVideo = new JButton("Crear video");
		buttonCrearVideo.setBounds(118, 341, 149, 43);
		contentPane.add(buttonCrearVideo);
		
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
		
		buttonCrearVideo.addActionListener(new VideoCreateController(this));
		
		cargarClientesIds(); // Llama al método para cargar los IDs de los clientes al iniciar la vista

    }
    
    public void cargarClientesIds() {
        comboBoxClienteId.removeAllItems();

        ArrayList<Integer> clienteIds = FunctionsSQL.obtenerIdsClientes();

        for (Integer id : clienteIds) {
            comboBoxClienteId.addItem(id);
        }
    }


    public JButton getButtonCrearVideo() {
        return buttonCrearVideo;
    }
    
    public JTextField getTextFieldTitle() {
        return textFieldTitle;
    }
    
    public JTextField getTextFieldDirector() {
        return textFieldDirector;
    }
    
    public JComboBox<Integer> getComboBoxClienteId() {
        return comboBoxClienteId;
    }
}