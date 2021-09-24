package model;

import java.util.ArrayList;
import java.util.Collections;

import MyLinkedList_data_structure.MyLinkedList;
import MyLinkedList_data_structure.Node;
import MyQueue_data_structure.MyQueue;

public class Store {
	
	//Relations
	private ArrayList<Client> clients;
	private ArrayList<Shelf> shelves;
	private ArrayList<Cashier> cashiers;
	private int availableCashiers;
	private MyQueue<Client>clientsToQuit;
	
	public Store() {
		clients = new ArrayList<>();
		shelves= new ArrayList<>();
		cashiers= new ArrayList<>();
		clientsToQuit = new MyQueue<>();
		setAvailableCashiers(0);
	}
	
	
	public ArrayList<Shelf> getShelves() {
		return shelves;
	}

	public void setShelves(ArrayList<Shelf> shelves) {
		this.shelves = shelves;
	}

	
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	
	public ArrayList<Client> getClients() {
		return clients;
	}
	
	public void setCashiers(ArrayList<Cashier> cashiers) {
		this.cashiers = cashiers;
	}

	
	public ArrayList<Cashier> getCashiers() {
		return cashiers;
	}

	public void setAvailableCashiers(int availableCashiers) {
		this.availableCashiers = availableCashiers;
	}
	
	public int getAvailableCashiers() {
		return availableCashiers;
	}
	

	public void createCashier(int numberOfCashiers) {
		for(int i=0;i<numberOfCashiers;i++) {
			Cashier newCashier= new Cashier(i);//i es el numero de cajero que le será asignado
			cashiers.add(newCashier);
		}
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
		clients.add(newClient);
		newClient.createGames(lineSplit);	
		//printList(newClient,newClient.getGames().getFirst()); 
		

	}
	/*
	private void printList(Client client,Node<Game> game) {	
		if (game!=null) {
			System.out.println("CLIENT: "+client.getCode()+" ****Game: "+game.getElement().getId());
			printList(client,game.getNext());
		}
		
	
	}
	*/
	public Client findClient(String id) {
		Client client = null;
		boolean exit = false;
		
		for (int i=0;i<clients.size() && !exit;i++) {
			if (clients.get(i).getCode().equals(id)) {
				client = clients.get(i);
				exit = true;
			}
		}	
		
		return client;		
	}
	
	public Shelf findShelf(String id) {
		Shelf shelf = null;
		for (int i=0;i<shelves.size();i++) {
			if (shelves.get(i).getId().equals(id)) {
				shelf = shelves.get(i);
			}
		}
		
		return shelf;	
	}

	public void orderGames(String id, int numberMethod) {
		Client findClient = findClient(id);
		
		if (findClient!=null) {
			ArrayList<Game> gamesToOrder = fromMyLinkedListToArrayList(findClient.getGames());
			ArrayList<Game> gamesToTake = new ArrayList<>();
			switch (numberMethod) {
			case 1: 				
				gamesToTake = insertionSortOfGames(gamesToOrder);
				break;
				
			case 2:
				gamesToTake = bubbleSortOfGames(gamesToOrder);
				break;
			}
			
			printBestRoute(gamesToTake);
			addGamesToHamper(findClient,gamesToTake);
			
			
		}else {
			System.out.println("El cliente no existe");
		}
		
	}	
	
	
	//Este método guarda los juegos de la lista del cliente en un ArrayList
	public ArrayList<Game> fromMyLinkedListToArrayList(MyLinkedList<Game> clientsGames) {
		ArrayList<Game> orderGames = new ArrayList<>();
		Node<Game> findGame = clientsGames.getFirst();
		while(findGame!=null) {
			orderGames.add(findGame.getElement());
			findGame = findGame.getNext();			
		}	
		
		orderGames = assingShelvesNamesToGames(orderGames);
		return orderGames;
	}
	
	
	//Aquí con el arrayList anterior se busca cada juego con su código en cada Shelf, cuando lo encuentra 
	//al juego le asgina el nombre del estante donde se encuentra.
	private ArrayList<Game> assingShelvesNamesToGames(ArrayList<Game> games){
		for (int j=0;j<games.size();j++) {
			for (int i=0;i<shelves.size();i++) {				
				if (shelves.get(i).getTable().containsKey(games.get(j).getId())) {
					games.get(j).setNameShelf(String.valueOf(shelves.get(i).getId().charAt(0)));	
					games.get(j).setPrice(shelves.get(i).getTable().get(games.get(j).getId()).getPrice());
					games.get(j).setQuantity(shelves.get(i).getTable().get(games.get(j).getId()).getQuantity());
					//System.out.println("Estantería: "+orderGames.get(j).getNameShelf()+ "tiene el juego"+orderGames.get(j).getId());	
				}
			}
		}
		return games;		
	}

	//Método de ordenamiento insertionSort
	public ArrayList<Game> insertionSortOfGames(ArrayList<Game> clientsGames) {
		Game temp = null;
		//System.out.println("Vine al insertion");	
		
		for (int j=1;j<=clientsGames.size()-1;j++) {
			
			for (int k=j;k>0;k--) {
				
				//int value = clientsGames.get(k).compareTo(clientsGames.get(k-1));

				//System.out.println("value compare to: "+ value+" -->"+clientsGames.get(k).getNameShelf()+" vs "+clientsGames.get(k-1).getNameShelf());

				if ((clientsGames.get(k).compareTo(clientsGames.get(k-1)))<0) {
					temp = clientsGames.get(k);
					clientsGames.set(k, clientsGames.get(k-1));	
					clientsGames.set(k-1,temp);
					
				}			
			}							
		}	
		//printBestRoute(clientsGames);		
		return clientsGames;
	}
		

	
	//Método de ordenamiento bubbleSort
	public ArrayList<Game> bubbleSortOfGames(ArrayList<Game> clientsGames) {
		Game temp = null;
		for (int j=1;j<clientsGames.size();j++) {
			//int changes =0;
			for (int i=0;i<clientsGames.size()-j;i++) {
				
				if ((clientsGames.get(i).compareTo(clientsGames.get(i+1)))>0) {
					temp = clientsGames.get(i);
					clientsGames.set(i, clientsGames.get(i+1));	
					clientsGames.set(i+1,temp);					
				}	
				
			}
		}
		//printBestRoute(clientsGames);
		return clientsGames;

	}
	
	//Se añaden los juegos de cada cliente a una cesta (Esto sucede para cada uno)
	public void addGamesToHamper(Client client, ArrayList<Game> clientsGames) {		
		//Shelf shelf = null;
		for (int i=0;i<clientsGames.size();i++) {
			client.getGamesHamper().push(clientsGames.get(i));
			//shelf = findShelf(clientsGames.get(i).getNameShelf());
			
			//shelf.getTable().get(clientsGames.get(i).getId()).setQuantity(clientsGames.get(i).getQuantity()-1);
			//System.out.println("CANTIDAD DE JUEGOS: "+shelf.getTable().get(clientsGames.get(i).getId()).getQuantity());			
		}	
		
		System.out.println("\nJuegos en canaste del cliente "+client.getCode()+": "+client.getGamesHamper().toString());
		
		
		
		//System.out.println("METODO PEEK: "+client.getGamesHamper().peek().toString());
	}
	
	//Metodo para imprimir la ruta del cliente
	public void printBestRoute(ArrayList<Game> gamesToTake) {
		System.out.println("SECCION 2:"+"\nSu ruta para recoger sus videojuegos es la siguiente: "+"\nDiríjase primero al estante "+
				gamesToTake.get(0).getNameShelf()+" para retirar el juego con código: "+gamesToTake.get(0).getId());
		
		for (int h=1;h<=gamesToTake.size()-1;h++) {
			if (h!=gamesToTake.size()-1) {
				System.out.println("Luego, diríjase al estante "+gamesToTake.get(h).getNameShelf()+
						" para retirar el juego con código: "+gamesToTake.get(h).getId());
			}else {
				System.out.println("Finalmente, diríjase al estante "+gamesToTake.get(h).getNameShelf()+
						" para retirar el juego con código: "+gamesToTake.get(h).getId());
			}
		
		}

	}
	
	public void sortClientsByTime() {
		Collections.sort(clients);
	}

	public void updateTimeOfClients(){
		//Después de ordenar los juegos del cliente se actualizarán los tiempos ya que los recogerán
		for(int i=0;i<clients.size();i++) {//Para cada cliente de la tienda 
			int timeToAdd= clients.get(i).getGames().size(); //Obtiene la cantidad de juegos de cada cliente
			clients.get(i).setTime(clients.get(i).getTime()+timeToAdd);	
			//System.out.println("TIEMPO DEL CLIENTE "+i+" :"+clients.get(i).getTime());
		}
	}

	public void decreaseAmountOfEachGame(){	 	
		/*
		Despues de ordenar los juegos cada cliente queda con una lista de sus juegos, para cada cliente
		se recorrerá la lista y para cada juego que encuentre se le restará un ejemplar a los juegos del
		store
 		*/
		for(int i=0;i<clients.size();i++) {//Para cada cliente
			Client client=clients.get(i);//cliente i
			ArrayList<Game> clientGames=fromMyLinkedListToArrayList(client.getGames());//Los juegos del cliente en un arraylist

			for(int j=0;j<client.getGames().size();j++) {//Para cada juego de cada cliente
				Game game=clientGames.get(j);//juego j del cliente i

				for(int w=0;w<shelves.size();w++) {//Para cada estantería del store
					if(shelves.get(w).findGame(game)!=null) {//si la estantería contiene el juego
						Game gameToReduce=shelves.get(w).getTable().get(game.getId());
						gameToReduce.setQuantity(gameToReduce.getQuantity()-1);
					}
				}
			}
		}
	}
	public  void paymentProcess() {
		/*
		* 1. Coger la fila de los de clientes y la cantidad de cajeros
		* 2. Recorrer los cajeros disponibles (cajero.cliente==null) y asignarle los clientes en orden
		* cuando se llenan los cajeros disponibles se hace el proceso de pago.
		* 3. Cada vez que un cajero termine el proceso, la lista de cajeros debe ser ordenada desde el primero
		* que se desocupó hasta el último, cuando esto está así se repite el proceso hasta que la lista de clientes 
		* haya sido recorrida completamente
		*/
		int i=0;
		while(clients.size()>i) {//mientras que i(posicion actual) sea menor igual que la cantidad de clientes
			int p=cashiersCycle(i);
			Collections.sort(cashiers);
			for(int j=0;j<cashiers.size();j++) {
				cashiers.get(j).setClient(null);			
			}
			if(p==-1) {
				break;
			}else {
				i=p;
			}
		}
	}


	//tengo que hacer este metodo cada que los 3 cajeros se desocupen
	private  int cashiersCycle(int posInicio) {
		int i;

		for(i=posInicio;i<posInicio+cashiers.size();i++) {//cada 3 cajeros
			if(clients.size()>i) {
				Client client=clients.get(i);

				for(int j=0;j<cashiers.size();j++) {
					Cashier cashier=cashiers.get(j);

					if(cashier.getClient()==null) {
						cashier.setClient(client);
						cashier.setTime(cashier.getTime()+client.getNumberOfGames());
						client.setTime(client.getTime()+client.getNumberOfGames());//Creo que esto es lo que me pides
						//System.out.println("Cliente: "+client.getCode()+" Cajero: "+cashier.getCashierNumber()+" Tiempo: "+cashier.getTime());
						j=cashiers.size();
					}
				}
			}else {
				//System.out.println("Ha llegado al final de los clientes en i="+i);
				break;
			}

		}

		if(i<=clients.size()) {
			return i;
		}else {
			return -1;
		}

	}
	
	public void fromArrayListToMyQueue() {		 
		//System.out.println("TAMAÑO ARRAY DE CLIENTS: "+clients.size());
		for (int i=0;i<clients.size();i++) {
			clientsToQuit.enqueue(clients.get(i));
		}
		printOutput();
	}
	
	public void printOutput() {		
		while (clientsToQuit.size()>0) {
			Client client = clientsToQuit.dequeue();
			client.bill();
			System.out.println(client.getCode()+" "+client.getBillToPay()+"\n"+client.gamesIDs());		
		}
	}
	
	















}
