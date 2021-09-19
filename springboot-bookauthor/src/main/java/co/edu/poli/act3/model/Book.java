package co.edu.poli.act3.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	//Primary key
	@Id
	@Column(name="ISBN")
	//auto_increment
	//@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long isbn;
	
	@Column(name="NAME")
	private String name;
		
	@Column(name="DATE")
	private Date publishDate;
	
	//Avoid: (cascade = CascadeType.ALL)
	//Reason: https://thorben-janssen.com/avoid-cascadetype-delete-many-assocations/
	@ManyToMany
	@JoinTable(name = "Book_Author", 
				joinColumns = { @JoinColumn(name = "Book_ISBN") }, 
				inverseJoinColumns = { @JoinColumn (name = "Author_ID") })
	private Set<Author> dataSetAuthors;
	
	public Book () {
		
	}

	public Book(long isbn, String name, String author, Date publishDate, Set<Author> dataSetAuthors) {
		this.isbn = isbn;
		this.name = name;
		this.publishDate = publishDate;
		this.dataSetAuthors = dataSetAuthors;
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

	public Date getPublishDate() {
		return publishDate;
	}
	
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Set<Author> getDataSetAuthors() {
		return dataSetAuthors;
	}

	public void setDataSetAuthors(Set<Author> dataSetAuthors) {
		this.dataSetAuthors = dataSetAuthors;
	}

}
