package co.edu.poli.act4.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Countries")
public class Country {
	
	@Id
	private String code;
	private String name;
	private ArrayList<String> denomAlt;
	private ArrayList<Double> coordinate;
	
	@OneToMany (mappedBy = "country")
	private List<State> states;
	
	@ManyToMany (mappedBy = "countries")
	@JsonIgnore
	private List<Agreement> agreement;

	public Country() {
		// TODO Auto-generated constructor stub
	}
	
	public Country(String code, String name, ArrayList<String> denomAlt, ArrayList<Double> coordinate) {
		super();
		this.code = code;
		this.name = name;
		this.denomAlt = denomAlt;
		this.coordinate = coordinate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getDenomAlt() {
		return denomAlt;
	}
	public void setDenomAlt(ArrayList<String> denomAlt) {
		this.denomAlt = denomAlt;
	}
	public ArrayList<Double> getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(ArrayList<Double> coordinate) {
		this.coordinate = coordinate;
	}
	public List<Agreement> getAgreement() {
		return agreement;
	}
	public void setAgreement(List<Agreement> agreement) {
		this.agreement = agreement;
	}

}
