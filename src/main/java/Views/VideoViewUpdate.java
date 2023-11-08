package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controllers.VideoReadController;
import Model.Video;

public class VideoViewUpdate extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelTitleUpdate;
	private JLabel labelDirectorUpdate;
	private JLabel labelCliIdUpdate;
	private JLabel tituloUpdate;
	private JTextField textFieldTitleUpdate;
	private JTextField textFieldDirectorUpdate;
	private JComboBox<Integer> comboBoxClienteId;
	private JButton buttonActualizarVideo;
	private JButton buttonReadVideos;

    public VideoViewUpdate(Video videoSeleccionado) {
    	setTitle("Vista editar cliente");
		setBounds(600,450,400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		labelTitleUpdate = new JLabel("Title:");
		labelTitleUpdate.setBounds(48,103,200,20);
		contentPane.add(labelTitleUpdate);
		
		labelDirectorUpdate = new JLabel("Director");
		labelDirectorUpdate.setBounds(48, 151, 200, 20);
		contentPane.add(labelDirectorUpdate);
		
		labelCliIdUpdate = new JLabel("CLid");
		labelCliIdUpdate.setBounds(48, 200, 200, 20);
		contentPane.add(labelCliIdUpdate);		
		
		textFieldTitleUpdate = new JTextField();
		textFieldTitleUpdate.setBounds(104, 103, 176, 20);
		contentPane.add(textFieldTitleUpdate);
		textFieldTitleUpdate.setColumns(10);
		
		textFieldDirectorUpdate = new JTextField();
		textFieldDirectorUpdate.setColumns(10);
		textFieldDirectorUpdate.setBounds(104, 151, 176, 20);
		contentPane.add(textFieldDirectorUpdate);
		
		comboBoxClienteId = new JComboBox<Integer>();
		comboBoxClienteId.setBounds(104, 199, 96, 22);
		contentPane.add(comboBoxClienteId);
		
		tituloUpdate = new JLabel("ACTUALIZAR VIDEO");
		tituloUpdate.setBounds(100, 43, 294, 30);
		contentPane.add(tituloUpdate);
		
		buttonActualizarVideo = new JButton("Actualizar video");
		buttonActualizarVideo.setBounds(86, 406, 217, 23);
		contentPane.add(buttonActualizarVideo);
		
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
		

    }
    
    public JButton getButtonActualizarVideo() {
        return buttonActualizarVideo;
    }
    
    public JTextField getTextFieldTitle() {
        return textFieldTitleUpdate;
    }
    
    public JTextField getTextFieldDirector() {
        return textFieldDirectorUpdate;
    }  
    
    public JComboBox<Integer> getComboBoxClienteId() {
        return comboBoxClienteId;
    }
}