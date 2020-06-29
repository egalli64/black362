package dao;

import java.time.LocalDate;

public class User extends GenericUser {
	private int id;
	private String firstName,
					lastName;
	private LocalDate birthDate;
	private String email,
				telephone,
				city,
				address;
	private int postcode;
	
	public User(int id, String firstName, String lastName, String username, String password, String email, 
				LocalDate birthDate, String telephone, String city, String address, int postcode) {
		super();
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.username = username;
		this.password = password;
		this.email = email;
		
		this.birthDate = birthDate;	//Conversion from String?
		this.telephone = telephone;
		this.city = city;
		this.address = address;
		this.postcode = postcode;
	}
	
	
	protected int getID() {
		return id;
	}
	protected void setID(int id) {
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
