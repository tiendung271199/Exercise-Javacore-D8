package pk3;

import java.io.Serializable;

public class News implements Serializable {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public News() {
		
	}
	public News(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return "ID: " + this.id + "\nName: " + this.name;
	}
	
	
	
}
