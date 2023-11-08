package Model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class VideoTable extends AbstractTableModel  {
	
	private static final long serialVersionUID = 1L;
	private List<Video> videos;
    private String[] columnNames = {"id", "title", "director", "cli_id"};

    public VideoTable(List<Video> videos) {
        this.videos = videos;
    }
    
    public List<Video> getVideos() {
		return videos;
	}


	// Metodo para obtener el cliente en una fila específica
    public Video getVideos(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < videos.size()) {
            return videos.get(rowIndex);
        }
        return null;
    }

    public int getRowCount() {
        return videos.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Video video = videos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return video.getId();
            case 1:
                return video.getTitle();
            case 2:
                return video.getDirector();
            case 3:
                return video.getCli_id();
            default:
                return null;
        }
    }  
    
    public void removeRowAt(int row) 
    {
    	List<Video> nuevaTabla = new ArrayList<Video>();
    	
    	for (int i = 0; i < this.videos.size(); i++) 
    	{
    		if(i != row)
			nuevaTabla.add(this.videos.get(i));
		}
    	
    	this.videos = nuevaTabla;
    }

}
