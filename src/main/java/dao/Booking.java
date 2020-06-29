package dao;

public class Booking {
	private int userID,
				id;
	private String status,
					values;
	
	
	public final static String DELIVERED = "DELIVERED",
								SENT = "SENT",
								PROCESSING = "PROCESSING";
	
	protected int getUserID() {
		return userID;
	}
	protected void setUserID(int userID) {
		this.userID = userID;
	}
	
	protected int getID() {
		return id;
	}
	protected void setID(int id) {
		this.id = id;
	}
	
	protected String getStatus() {
		return status;
	}
	protected void setStatus(String status) {
		this.status = status;
	}
	
	protected String getValues() {
		return values;
	}
	protected void setValues(String values) {
		this.values = values;
	}
}
