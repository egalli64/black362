package dao;

import java.time.LocalDate;

public class User {
	private int id;
	private String firstName,
					lastName;
	private LocalDate birthDate;
	private String email,
				telephone,
				username,
				city,
				address;
	private int postcode;
	
	
	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	
	
	protected String getFirstName() {
		return firstName;
	}
	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	protected String getLastName() {
		return lastName;
	}
	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	protected LocalDate getBirthDate() {
		return birthDate;
	}
	protected void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	
	protected String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	
	
	protected String getTelephone() {
		return telephone;
	}
	protected void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	protected String getUsername() {
		return username;
	}
	protected void setUsername(String username) {
		this.username = username;
	}
	
	
	protected String getCity() {
		return city;
	}
	protected void setCity(String city) {
		this.city = city;
	}
	
	
	protected String getAddress() {
		return address;
	}
	protected void setAddress(String address) {
		this.address = address;
	}
	
	
	protected int getPostcode() {
		return postcode;
	}
	protected void setPostcode(int postcode) {
		this.postcode = postcode;
	}	
}
