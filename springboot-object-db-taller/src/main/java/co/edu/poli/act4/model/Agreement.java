package co.edu.poli.act4.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Agreements")
public class Agreement {
	
	@Id
	private long id;
	private Date date;
	private String obs;
	
	@ManyToMany 
	@JoinTable(name = "Agreement_Country", 
				joinColumns = { @JoinColumn(name = "Agreement_id")  }, 
				inverseJoinColumns = {@JoinColumn (name = "Country_code") })
	private List<Country> countries;
	
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

}
