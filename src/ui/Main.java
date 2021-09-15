package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static Store store;
	
	public final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		createStore();
		
		int cases = Integer.parseInt(br.readLine());
		int cashiers, shelves, clients;
		String line="";
		String infoClient="";
		
		for (int i=0;i<cases;i++) {
			
			cashiers = Integer.parseInt(br.readLine());
			createCashiers(cashiers);
			
			shelves = Integer.parseInt(br.readLine());
			createShelves(shelves);
			
			for (int j=0;j<shelves;j++) {
				line = br.readLine();
				while (line!=null) {
					//Leer info de las estanterías (Creación de la hash table)
					line = br.readLine();
				}
			}
			
			clients = Integer.parseInt(br.readLine());
			
			for (int k=0;k<clients;k++) {
				infoClient = br.readLine();
			}
			
		}	

	}
	
	public static void createStore() {
		store = new Store();
	}
		
	public static void createCashiers(int cashiers) {
		for (int i=0;i<cashiers;i++) {
			store.createCashiers();
		}		
	}
	public static void createShelves(int shelves) {
		for (int i=0;i<shelves;i++) {
			store.createShelves();
		}		
	}

}
