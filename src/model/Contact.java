package model;

public class Contact {
	
	private String id;
	private String name;
	private String enail;
	
	public Contact(String id, String name, String enail) {
		this.id = id;
		this.name = name;
		this.enail = enail;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEnail() {
		return enail;
	}
	
	

}
