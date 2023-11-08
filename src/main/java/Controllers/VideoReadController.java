package Controllers;

import DB_Connection.ConnectionDB;

import java.awt.event.*;
import java.sql.*;
import java.util.*;

import Model.Video;
import Model.VideoTable;
import Views.VideoViewRead;

public class VideoReadController implements ActionListener{
	private VideoViewRead videosViewRead;
	
	public VideoReadController(Video videos, VideoViewRead videosViewRead) {
		this.videosViewRead = videosViewRead;
		iniciarVistaVideos(); // Cargar registros al crear el controlador
	}
	
	public VideoReadController(VideoViewRead videosViewRead2) {
	}

	public void iniciarVistaVideos() {
	    List<Video> videos = obtenerVideos();
	    if (videos != null && !videos.isEmpty()) {
	        VideoTable model = new VideoTable(videos);
	        videosViewRead.getTabla().setModel(model);
	    }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public List<Video> obtenerVideos() {
	    List<Video> videos = new ArrayList<>();
	    
	    // Realiza una consulta SQL para obtener todos los clientes
	    String sql = "SELECT * FROM videos";
	    
	    try {
	    	Connection conexion = null;
	        // Obtener la conexión utilizando la clase ConnectionDB
	        conexion = ConnectionDB.getConnection();
	        Statement stmt = conexion.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String title = rs.getString("title");
	            String director = rs.getString("director");
	            int cli_id = rs.getInt("cli_id");
	            
	            Video video = new Video(id, title, director, cli_id);
	            videos.add(video);
	        }
	        
	        rs.close();
	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return videos;
	}

}
