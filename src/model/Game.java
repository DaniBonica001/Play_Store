package model;

public class Game {
	
	//Attributtes
	private int id;	
	
	//Relations
	private Game next;
	private Game prev;
	
	//Cosntructor
	public Game(int id) {
		this.id = id;
		next = null;
		prev = null;
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
