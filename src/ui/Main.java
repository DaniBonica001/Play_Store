package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import model.Client;
import model.Store;

public class Main {
	
	public static Store store;
	
	public final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		createStore();
		
		int cases = Integer.parseInt(br.readLine());
		int cashiers, shelves, clients;
		String infoShelf;
		String infoClient="";
		
		for (int i=0;i<cases;i++) {
			
			cashiers = Integer.parseInt(br.readLine()); //Lee la cantidad de puntos de pago
			createCashiers(cashiers);
			
			shelves = Integer.parseInt(br.readLine()); //Lee la cantidad de estantes			
			
			for (int j=0;j<shelves;j++) {
				infoShelf = br.readLine();
				createShelves(infoShelf);				
			}
			
			clients = Integer.parseInt(br.readLine());
			createClients(clients);
			
			
			
		}	

	}
	
	public static void createStore() {
		store = new Store();
	}
		
	public static void createCashiers(int cashiers) {
		for (int i=0;i<cashiers;i++) {
			store.createCashier();
		}		
	}
	public static void createShelves(String infoShelf) throws IOException {
		String nameShelf = String.valueOf(infoShelf.charAt(0));
		int levels = infoShelf.charAt(infoShelf.length()-1);
		String [] infoLevels = new String [levels];
		
		for(int i=0;i<infoLevels.length;i++) {
			infoLevels[i]=br.readLine();
		}
		
		store.createShelves(nameShelf,levels, infoLevels);		
	}
	
	public static void createClients(int clients) throws IOException {
		String line;
				
		for (int i=0;i<clients;i++) {
			line = br.readLine();
			store.createClient(line);
		}
	}
	

}
