package co.edu.poli.p1.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="paises")
public class Country {

	//Primary key
	@Id
	private String iso; 

	private String [] tld;
		
	private int area;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="name_id", unique=true)
	private Name name;	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="capital_id", unique=true)
	private Capital capital;
	
	@ManyToOne
	@JoinColumn(name = "continent_id")
    @JsonIgnore
	private Continent continent;
	
	@ManyToMany (mappedBy = "countries")
	@JsonIgnore
	private Set<Agreement> agreement;
	
	public Country() {
		// TODO Auto-generated constructor stub
	}

	public Country(String iso, String[] tld, int area, Name name, Capital capital, Continent continent) {
		super();
		this.iso = iso;
		this.tld = tld;
		this.area = area;
		this.name = name;
		this.capital = capital;
		this.continent = continent;
	}


	public String getIso() {
		return iso;
	}


	public void setIso(String iso) {
		this.iso = iso;
	}


	public Continent getContinent() {
		return continent;
	}


	public void setContinent(Continent continent) {
		this.continent = continent;
	}


	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
	
	public String[] getTld() {
		return tld;
	}

	public void setTld(String[] tld) {
		this.tld = tld;
	}

	public Capital getCapital() {
		return capital;
	}

	public void setCapital(Capital capital) {
		this.capital = capital;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}
	public Set<Agreement> getAgreement() {
		return agreement;
	}

	public void setAgreement(Set<Agreement> agreement) {
		this.agreement = agreement;
	}

	
}
