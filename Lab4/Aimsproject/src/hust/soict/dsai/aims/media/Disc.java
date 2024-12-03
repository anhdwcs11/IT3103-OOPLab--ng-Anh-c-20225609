package hust.soict.dsai.aims.media;

public class Disc extends Media {
	
	private String director;
    private int length;
    
    // Constructor
    public Disc(int id, String title) {
    	super(id, title);
    }
	public Disc(int id, String title, String category, float cost, String director, int length) {
		super(id, title, category, cost);
		this.director = director;
		this.length = length;
	}
	
	// Getter and Setter
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}