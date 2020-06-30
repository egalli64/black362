package dao;

import java.time.LocalDate;

public class User extends GenericUser {
	private String firstName,
					lastName;
	private LocalDate birthDate;
	private String email,
				telephone,
				city,
				address;
	private int postcode;
	
	public User(int id, String firstName, String lastName, LocalDate birthDate, String email, String telephone,
				String username, String password, String city, String address, int postcode) {
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
	
	public User(String firstName, String lastName, LocalDate birthDate, String email, String telephone,
					String username, String password, String city, String address, int postcode) {
		this(0, firstName, lastName, birthDate, email, telephone, username, password, city, address, postcode);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}	
}
