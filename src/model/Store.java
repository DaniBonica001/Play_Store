package model;

import java.util.ArrayList;

public class Store {
	
	//Relations
	private ArrayList<Client> clients; ;
	
	public Store() {
		clients = new ArrayList<>();
			
	}

	public void createCashier() {
		// TODO Auto-generated method stub
		
	}
	
	public void createShelves(String name,int levels,String []infoLevels) {
		// TODO Auto-generated method stub
		
	}

	public void createClient(String line) {
		String [] lineSplit = line.split(" ");
		String id = lineSplit[0];
		
		Client newClient = new Client(id);
		newClient.createGames(lineSplit);		
	}

	

}
