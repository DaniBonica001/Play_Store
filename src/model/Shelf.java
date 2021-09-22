package model;

import java.util.Hashtable;

public class Shelf {
	
	//Attributes
	private String id;
	private Hashtable<Integer, Game> table;
	
	//Constructor
	
	public Shelf(String info) {// info=(Id #Juegos)
		String[] parts= info.split(" ");
		id= parts[0];
		setTable(new Hashtable<>());
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void hash() {
		
	}

	public Hashtable<Integer, Game> getTable() {
		return table;
	}

	public void setTable(Hashtable<Integer, Game> table) {
		this.table = table;
	}
	
}
