package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Game;
import model.Store;

public class Main {
	
	public static Store store;
	
	public final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		createStore();
		
		String line;
		int cases = Integer.parseInt(br.readLine());//La primer linea que es el numero de casos
		System.out.println("cases: "+cases);
		int cashiers, shelves, clients;
		String infoShelf;
				
		for (int i=0;i<cases;i++) {
			line = br.readLine();
			 while(line!=null) {
				 cashiers = Integer.parseInt(line); //Lee la cantidad de cajeros
					createCashiers(cashiers);				
					
					shelves = Integer.parseInt(br.readLine()); //Lee la cantidad de estantes				
					for (int j=0;j<shelves;j++) {
						infoShelf = br.readLine();
						System.out.println("INFOSHELF: "+infoShelf);
						createShelves(infoShelf);						
					}
					
					System.out.println("PASO A CLIENT");
					
					clients = Integer.parseInt(br.readLine());
					createClients(clients);	
					
					line = null ;
					System.out.println("LINE: "+line);
			 }			
		}	

	}
	
	public static void createStore() {
		store = new Store();
	}
		
	public static void createCashiers(int cashiers) {
		//System.out.println("CASHIERS");
		for (int i=0;i<cashiers;i++) {
			store.createCashier();
		}		
	}

	public static void createShelves(String infoShelf) throws IOException {
		String[] parts= infoShelf.split(" "); // parts=[Identificador NumeroDeJuegos]
		Game[] games= new Game[Integer.parseInt(parts[1])];//un arreglo de juegos de tamaño del numero de juegos de la estanteria
		
		for(int i=0;i<Integer.parseInt(parts[1]);i++) {
			System.out.print("*");
			String[] infoGame=br.readLine().split(" "); //infogame=[codigo, precio, disponibilidad]
			Game newGame= new Game(Integer.parseInt(infoGame[0]),Integer.parseInt(infoGame[1]), Integer.parseInt(infoGame[2]) );
			System.out.println(newGame.toString());
			games[i]=newGame;
		}
		
		store.createShelves(infoShelf, games);
	}
	
	
	public static void createClients(int clients) throws IOException {
		//System.out.println("CLIENTS");
		String line;
				
		for (int i=0;i<clients;i++) {
			line = br.readLine();	
			store.createClient(line);
			
		}
	}
	

}
