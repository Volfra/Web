package co.edu.poli.act3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
		
	private String author;
	
	private String country;
	
	private String imageLink;
	
	private String language;
	
	private String link;
	
	private int pages;
	
	private String title;
	
	private int year; 

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String author, String country, String imageLink, String language, String link, int pages,
			String title, int year) {
		this.id = id;
		this.author = author;
		this.country = country;
		this.imageLink = imageLink;
		this.language = language;
		this.link = link;
		this.pages = pages;
		this.title = title;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}
