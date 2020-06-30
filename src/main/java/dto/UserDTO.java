package dto;

import java.util.List;

import dao.User;

public class UserDTO {
	
	private User user;
	private List<User> utenti;
	
	public UserDTO(User user, List<User> utenti) {
		super();
		this.user = user;
		this.utenti = utenti;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<User> utenti) {
		this.utenti = utenti;
	}

	@Override
	public String toString() {
		return "UserDTO [user=" + user + ", utenti=" + utenti + "]";
	}
	
	
}
