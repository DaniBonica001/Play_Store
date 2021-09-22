package model;

public class Game implements Comparable<Game>{
	
	//Attributes
	private String nameShelf;
	private int id;
	private int price;
	private int quantity;
	
	//Relations
	private Game next;
	private Game prev;
	
	//Constructor
	public Game(String nameShelf, int id, int price, int quantity) {
		this.nameShelf = nameShelf;
		this.id = id;
		this.price=price;
		this.quantity=quantity;
		next = null;
		prev = null;
	}
	public Game(int id) {
		this.id = id;
		next = null;
		prev = null;
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

	
	public void setNext(Game next) {
		this.next = next;
	}
	
	public Game getNext() {
		return next;
	}

	public void setPrev(Game prev) {
		this.prev = prev;
	}
	
	public Game getPrev() {
		return prev;
	}
	
	public String toString() {
		return "GAME:"+id+"-"+price+"-"+quantity;
	}
	@Override
	public int compareTo(Game o) {
		return nameShelf.compareTo(o.getNameShelf());
	}
	



	

	

	
	

}
