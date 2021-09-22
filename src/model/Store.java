package model;

import java.util.ArrayList;


import MyLinkedList_data_structure.MyLinkedList;
import MyLinkedList_data_structure.Node;

public class Store {
	
	//Relations
	private ArrayList<Client> clients;
	private ArrayList<Shelf> shelves;
	
	public Store() {
		clients = new ArrayList<>();
		shelves= new ArrayList<>();
	}

	public void createCashier() {
		// TODO Auto-generated method stub
		
	}
	
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	
	public ArrayList<Client> getClients() {
		return clients;
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
	
	public void printList(Client client,Node<Game> game) {	
		if (game!=null) {
			System.out.println("CLIENT: "+client.getCode()+" ****Game: "+game.getElement().getId());
			printList(client,game.getNext());
		}
		
	
	}
	
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

	public void orderGames(String id, int numberMethod) {
		Client findClient = findClient(id);
		
		if (findClient!=null) {
			ArrayList<Game> gamesToOrder = fromMyLinkedListToArrayList(findClient.getGames());
			switch (numberMethod) {
			case 1: 				
				insertionSortOfGames(gamesToOrder);
				break;
				
			case 2:
				bubbleSortOfGames(gamesToOrder);
				break;
			}
		}else {
			System.out.println("El cliente no existe");
		}
		
	}	
	
	
	//Este método guarda los juegos de la lista del cliente en un ArrayList
	private ArrayList<Game> fromMyLinkedListToArrayList(MyLinkedList<Game> clientsGames) {
		ArrayList<Game> orderGames = new ArrayList<>();
		Node<Game> findGame = clientsGames.getFirst();
		while(findGame!=null) {
			orderGames.add(findGame.getElement());
			findGame = findGame.getNext();			
		}	
		
		orderGames = assingShelvesNamesToGames(orderGames);
		return orderGames;
	}
	
	//Aquí con el arrayList anterior se busca cada juego con su código en casa Shelf, cuando lo encuentra 
	//al juego le asgina el nombre del estante donde se encuentra.
	private ArrayList<Game> assingShelvesNamesToGames(ArrayList<Game> games){
		for (int j=0;j<games.size();j++) {
			for (int i=0;i<shelves.size();i++) {				
				if (shelves.get(i).getTable().containsKey(games.get(j).getId())) {
					games.get(j).setNameShelf(String.valueOf(shelves.get(i).getId().charAt(0)));	
					//System.out.println("Estantería: "+orderGames.get(j).getNameShelf()+ "tiene el juego"+orderGames.get(j).getId());	
				}
			}
		}
		return games;		
	}

	//Método de ordenamiento insertionSort
	public void insertionSortOfGames(ArrayList<Game> clientsGames) {
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
		printBestRoute(clientsGames);
	}
		
	//Método de ordenamiento bubbleSort
	public void bubbleSortOfGames(ArrayList<Game> clientsGames) {
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
		printBestRoute(clientsGames);

	}
	
	//Metodo para imprimir la ruta del cliente
	public void printBestRoute(ArrayList<Game> gamesToTake) {
		System.out.println("Su ruta para recoger sus videojuegos es la siguiente: "+"\nDiríjase primero al estante "+
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
	
	

	


	

	

}
