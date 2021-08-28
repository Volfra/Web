package co.edu.poli.act3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	//Primary key
	@Id
	@Column(name="ID")
	//auto_increment
	//@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long isbn;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="AUTHOR")
	private String author;
	
	public Book () {
		
	}

	public Book(long isbn, String name, String author) {
		this.isbn = isbn;
		this.name = name;
		this.author = author;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
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
