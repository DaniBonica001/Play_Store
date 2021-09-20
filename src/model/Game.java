package model;

public class Game {
	
	//Attributes
	private int id;	
	
	//Relations
	private Game next;
	private Game prev;
	
	//Constructor
	public Game(int id) {
		this.id = id;
		next = null;
		prev = null;
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

	

	

	
	

}
