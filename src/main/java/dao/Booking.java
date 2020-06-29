package dao;

public class Booking {
	
	private int userID,
				id;
	private String status,
					values;
	
	public final static String DELIVERED = "DELIVERED",
								SENT = "SENT",
								PROCESSING = "PROCESSING";
	
	public Booking() {
    }

	public Booking(int id, int userID, String status, String values) {
		super();
		this.id = id;
		this.userID = userID;
		this.status = status;
		this.values = values;
	}
    
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getValues() {
		return values;
	}
	public void setValues(String values) {
		this.values = values;
	}
}
