package model;

import java.util.ArrayList;

public class Store {
	
	//Relations
	private ArrayList<Client> clients;
	private ArrayList<Shelf> shelves;
	
	public Store() {
		setClients(new ArrayList<>());
		shelves= new ArrayList<>();
	}

	public void createCashier() {
		// TODO Auto-generated method stub
		
	}

	public void createShelves(String info, Game[]games) {
		Shelf shelf= new Shelf(info);
		
		for(int i=0;i<games.length;i++) {
			shelf.getTable().put(games[i].getId(), games[i]);
		}
		shelves.add(shelf);
		
		System.out.println("TABLA DE LA ESTANTERIA:"+shelf.getTable().toString());

	}

	
	public void createClient(String line) {
		String [] lineSplit = line.split(" "); //lineSplit=[cedula, codjuego1, codjuego2, codjeugo3,....]
		String id = lineSplit[0];
		
		Client newClient = new Client(id);
		newClient.createGames(lineSplit);		
	}
	

	
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	
	public ArrayList<Client> getClients() {
		return clients;
	}

	

	

}
