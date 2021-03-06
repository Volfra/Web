package co.edu.poli.act3.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="books")
public class Book{

	//Primary key
	@Id
	//auto_increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long isbn;
	
	@Column(name="Author")
	private String author;
	
	@Column(name="Country")
	private String country;
	
	@Column(name="ImageLink")
	private String imageLink;
	
	@Column(name="Language")
	private String language;
	
	@Column(name="Link")
	private String link;
	
	@Column(name="Pages")
	private int pages;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Year")
	private int year;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CD_ID")
	private CD cd;
	
    @ManyToOne
    @JoinColumn(name = "EDITORIAL_ID")
    @JsonIgnore
    private Editorial editorial;

	public Book() {
	}
	
	public Book(String author, String country, String imageLink, String language, String link, int pages,
			String title, int year) {
		super();
		this.author = author;
		this.country = country;
		this.imageLink = imageLink;
		this.language = language;
		this.link = link;
		this.pages = pages;
		this.title = title;
		this.year = year;
	}
	
	public Long getId() {
		return isbn;
	}
	public void setId(long isbn) {
		this.isbn = isbn;
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
	public CD getCd() {
		return cd;
	}
	public void setCd(CD cd) {
		this.cd = cd;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
}
