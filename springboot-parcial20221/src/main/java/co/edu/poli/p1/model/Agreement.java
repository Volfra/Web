package co.edu.poli.p1.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tratados")
public class Agreement {
	
	@Id
	private long id;
	private Date date;
	private String obs;
	
	@ManyToMany 
	@JoinTable(name = "tratado_pais", 
				joinColumns = { @JoinColumn(name = "tratado_id")  }, 
				inverseJoinColumns = {@JoinColumn (name = "pais_iso") })
	private Set<Country> countries;

	public Agreement() {
		// TODO Auto-generated constructor stub
	}
	
	public Agreement(long id, Date date, String obs) {
		super();
		this.id = id;
		this.date = date;
		this.obs = obs;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public Set<Country> getCountries() {
		return countries;
	}
	public void setCountries(Set<Country> countries) {
		this.countries = countries;
	}
}