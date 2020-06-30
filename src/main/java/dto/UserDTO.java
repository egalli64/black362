package dto;

import java.util.List;

import dao.User;

public class UserDTO {
	
	private List<User> utenti;
	
	public UserDTO(List<User> utenti) {
		this.utenti = utenti;
	}

	public List<User> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<User> utenti) {
		this.utenti = utenti;
	}

	@Override
	public String toString() {
		return "UserDTO [utenti=" + utenti + "]";
	}
	
	
}
