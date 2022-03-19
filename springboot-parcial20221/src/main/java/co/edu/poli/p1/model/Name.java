package co.edu.poli.p1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="nombres")
public class Name {
	
	//Primary key
	@Id
	//auto_increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
		
	private String common;
	
	private String official;

	@OneToOne(mappedBy = "name")
	@JsonIgnore
	private Country country;
	
	public Name() {
		// TODO Auto-generated constructor stub
	}
	
	public Name(String common, String official) {
		super();
		this.common = common;
		this.official = official;
	}

	public String getCommon() {
		return common;
	}

	public void setCommon(String common) {
		this.common = common;
	}

	public String getOfficial() {
		return official;
	}

	public void setOfficial(String official) {
		this.official = official;
	}
	
}
