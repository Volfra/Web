package co.edu.poli.mongodb.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Customers")
public class Customer {
	
	//@Id
	private String customerId;
	
	private boolean isActive;
	
	private double balance;
	
	private int age;
	
	private String eyeColor;
	
	private String name;
	
	private String gender;
	
	private String company;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	@Field("Income")
	private Double salary;
	
	private Map<String, String> cards; 
	
	private List<Shopping> transactions;
		
	public Customer() {
		
	}

	public Customer(String customerId, boolean isActive, double balance, int age, String eyeColor, String name,
			String gender, String company, String email, String phone, String address, Double salary,
			Map<String, String> cards, List<Shopping> transactions) {
		super();
		this.customerId = customerId;
		this.isActive = isActive;
		this.balance = balance;
		this.age = age;
		this.eyeColor = eyeColor;
		this.name = name;
		this.gender = gender;
		this.company = company;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.salary = salary;
		this.cards = cards;
		this.transactions = transactions;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Map<String, String> getCards() {
		return cards;
	}

	public void setCards(Map<String, String> cards) {
		this.cards = cards;
	}

	public List<Shopping> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Shopping> transactions) {
		this.transactions = transactions;
	}

}