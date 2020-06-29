package dao;

public abstract class GenericUser {
	protected String username, password;
	protected int id;
		
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
}
