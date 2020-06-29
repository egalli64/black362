package dao;

public class Dish {
	
	private int id;
	private String name;
	private double price;
	private String description;
	
	public Dish() {
    }

    public Dish(int id, String name, double price, String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}
    
	protected int getID() {
		return id;
	}
	protected void setID(int id) {
		this.id = id;
	}
	
	
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	
	
	protected double getPrice() {
		return price;
	}
	protected void setPrice(double price) {
		this.price = price;
	}
	
	
	protected String getDescription() {
		return description;
	}
	protected void setDescription(String description) {
		this.description = description;
	}
}
