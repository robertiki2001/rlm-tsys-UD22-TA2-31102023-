package Model;

public class Video {
	
	private int id;
	private String title;
	private String director;
	private int cli_id;
	
	public Video(int id, String title, String director, int cli_id) {
		this.id = id;
		this.title = title;
		this.director = director;
		this.cli_id = cli_id;
	}
	public Video() {		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public int getCli_id() {
		return cli_id;
	}


	public int setCli_id(int cli_id) {
		return this.cli_id = cli_id;
	}

}
