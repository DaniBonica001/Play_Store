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
		int cashiers, shelves, clients = 0;
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
					
					//System.out.println("PASO A CLIENT");
					
					clients = Integer.parseInt(br.readLine());
					createClients(clients);	
					
					line = null ;
					//System.out.println("LINE: "+line);
			 }			
		}	
		
		//metodo para ordenar los juegos y recogerlos y deja la fila para pagar ordenada por tiempos
		orderGames(clients);		
		store.updateTimeOfClients();
		store.decreaseAmountOfEachGame();
		
		store.sortClientsByTime();		
		//PARA HACER UNA FILA ORDENADA DE MENOR A MAYOR TIEMPO QUE ES CON LA QUE LLEGARÁN AL CAJERO
		System.out.println("FILA ANTES DE PAGAR: "+store.getClients().toString());	
		
		store.paymentProcess();		
		store.sortClientsByTime();
		
		System.out.println("OUTPUT");
		store.printOutput();
	}
	
	public static void createStore() {
		store = new Store();
	}
		
	public static void createCashiers(int cashiers) {
		store.createCashier(cashiers);
	}

	public static void createShelves(String infoShelf) throws IOException {
		String[] parts= infoShelf.split(" "); // parts=[Identificador NumeroDeJuegos]
		Game[] games= new Game[Integer.parseInt(parts[1])];//un arreglo de juegos de tamaño del numero de juegos de la estanteria
		
		for(int i=0;i<Integer.parseInt(parts[1]);i++) {
			System.out.print("*");
			String[] infoGame=br.readLine().split(" "); //infogame=[estantería, codigo, precio, disponibilidad]
			Game newGame= new Game(parts[0],Integer.parseInt(infoGame[0]),Integer.parseInt(infoGame[1]), Integer.parseInt(infoGame[2]) );
			System.out.println(newGame.toString());
			games[i]=newGame;
		}
		
		store.createShelves(infoShelf, games);
	}
	
	
	public static void createClients(int clients) throws IOException {
		String line;
				
		for (int i=0;i<clients;i++) {
			line = br.readLine();	
			store.createClient(line);			
		}
		
		//ASIGNAR TIEMPOS INICIALES DE CLIENTES
		for(int i=0;i<store.getClients().size();i++) {
			store.getClients().get(i).setTime(i+1);
			//System.out.print("TIMES: "+store.getClients().get(i).getTime());
		}
		
	}
	
	/*
	 * Method that orders the games for each client in the store, then the client times are going to be updated
	 * then the games picked are gonna be decreased in copies by one for each client that picked it up
	 * and the last thing is that the list of clients (the cashier line) are going to be sorted from the client with less time
	 * to the client with more time.
	 */
	public static void orderGames(int clients) throws NumberFormatException, IOException {
		for (int i=0;i<clients;i++) {//Se pregunta a cada cliente con qué método quiere ordenar sus juegos
			System.out.print("Ingrese su código: ");
			String id = br.readLine();
			
			System.out.println("¿Por qué método desea ordenar los videojugos?"
					+"\n Ingrese 1 para usar el método de insercción."
					+"\n Ingrese 2 para usar el método burbuja"+"\n");
			
			int numberMethod = Integer.parseInt(br.readLine());
			
			store.orderGames(id,numberMethod);
		}		
	}
}
