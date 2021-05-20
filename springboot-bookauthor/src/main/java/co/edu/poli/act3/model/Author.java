package co.edu.poli.act3.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="authors")
public class Author {
	
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="NATIONALITY")
	private String nationality;
	
	@ManyToMany (mappedBy="dataSetAuthors")
	@JsonIgnore
	private Set<Book> dataSetBooks;

	public Author() {

	}
	
	public Author(long id, String name, String nationality, Set<Book> dataSetBooks) {
		this.id = id;
		this.name = name;
		this.nationality = nationality;
		this.dataSetBooks = dataSetBooks;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Set<Book> getDataSetBooks() {
		return dataSetBooks;
	}

	public void setDataSetBooks(Set<Book> dataSetBooks) {
		this.dataSetBooks = dataSetBooks;
	}

}
