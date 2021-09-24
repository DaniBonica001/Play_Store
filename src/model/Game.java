package model;

public class Game implements Comparable<Game>{
	
	//Attributes
	private String nameShelf;
	private int id;
	private int price;
	private int quantity;

	//Constructor
	public Game(String nameShelf, int id, int price, int quantity) {
		this.nameShelf = nameShelf;
		this.id = id;
		this.price=price;
		this.quantity=quantity;
	}
	
	public Game(int id) {
		this.id = id;
	}
	
	public void setNameShelf(String nameShelf) {
		this.nameShelf = nameShelf;
	}
	public String getNameShelf() {
		return nameShelf;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String toString() {
		return "GAME:"+id+"-"+price+"-"+quantity;
	}
	
	@Override
	public int compareTo(Game o) {
		return nameShelf.compareTo(o.getNameShelf());
	}
	



	

	

	
	

}
