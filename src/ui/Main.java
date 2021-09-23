package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.Client;
import model.Game;
import model.Shelf;
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
		
		orderGames(clients);

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

		//Después de ordenar los juegos se actualizarán los tiempos ya que los recogerán
		for(int i=0;i<store.getClients().size();i++) {
			int timeToAdd=store.getClients().get(i).getGames().size();
			store.getClients().get(i).setTime(store.getClients().get(i).getTime()+timeToAdd);	
			//System.out.println("TIEMPO DEL CLIENTE "+i+" :"+store.getClients().get(i).getTime());
		}
		
		/*IMPRIMIR LOS JUEGOS DE LAS ESTANTERIAS ANTES DE RESTARLE UNIDADES
		for(int i=0;i<store.getShelves().size();i++) {
			Shelf shelf= store.getShelves().get(i);
			System.out.println("A ESTANTERIA: "+shelf.getId()+"||"+shelf.getTable().toString());
		}
		*/
		
		/* 
		 Despues de ordenar los juegos cada cliente queda con una lista de sus juegos, para cada cliente
		 se recorrerá la lista y para cada juego que encuentre se le restará un ejemplar a los juegos del
		 store
		*/
		for(int i=0;i<store.getClients().size();i++) {//Para cada cliente
			Client client=store.getClients().get(i);//cliente i
			ArrayList<Game> clientGames=store.fromMyLinkedListToArrayList(client.getGames());//Los juegos del cliente en un arraylist
			
			for(int j=0;j<client.getGames().size();j++) {//Para cada juego de cada cliente
				Game game=clientGames.get(j);//juego j del cliente i
				
				for(int w=0;w<store.getShelves().size();w++) {//Para cada estantería del store
					if(store.getShelves().get(w).findGame(game)!=null) {//si la estantería contiene el juego
						Game gameToReduce=store.getShelves().get(w).getTable().get(game.getId());
						gameToReduce.setQuantity(gameToReduce.getQuantity()-1);
					}
				}
			}
		}
		
		/*IMPRIMIR LOS JUEGOS DE LAS ESTANTERIAS DESPUES DE RESTARLE UNIDADES
		for(int i=0;i<store.getShelves().size();i++) {
			Shelf shelf= store.getShelves().get(i);
			System.out.println("D ESTANTERIA: "+shelf.getId()+"||"+shelf.getTable().toString());
		}
		*/
		

	}
	

}
