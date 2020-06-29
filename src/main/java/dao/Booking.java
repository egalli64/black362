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
    
    public Booking(int userID, String status, String values) {
    	this(0, userID, status, values);
    }
    
    public Booking(String status, String values) {
    	this(0, 0, status, values);
    }

	public Booking(int id, int userID, String status, String values) {
		super();
		this.id = id;
		this.userID = userID;
		this.status = status;
		this.values = values;
	}
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
