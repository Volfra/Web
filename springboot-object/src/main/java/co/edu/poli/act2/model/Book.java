package co.edu.poli.act2.model;

public class Book {
	
	private int isbn;
	private String name;
	private String author;
	
	public Book(int isbn, String name, String author) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.author = author;
	}
	public int getId() {
		return isbn;
	}
	public void setId(int id) {
		this.isbn = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
