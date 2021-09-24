package model;

import MyLinkedList_data_structure.MyLinkedList;
import MyLinkedList_data_structure.Node;
import MyStack_data_structure.MyStack;

public class Client implements Comparable<Client>{

	//Attributes
	private String code;
	private int time;
	private int billToPay;
	private int entryPosition;
	
	//Relations
	private MyLinkedList<Game> games;
	private MyStack<Game> gamesHamper;
	
	
	//Constructor
	public Client(String code) {
		this.code = code;
		games = new MyLinkedList<>();
		gamesHamper = new MyStack <>();
		setEntryPosition(0);
		this.setTime(0);
		setBillToPay(0);
	}

	
	public void createGames(String[] lineSplit) {
		for (int i=1;i<=lineSplit.length-1;i++) {
			Game newGame = new Game(Integer.parseInt(lineSplit[i]));
			games.createNode(newGame);
			System.out.println("New game: *"+newGame.getId());
	
			
		}
		
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setGames(MyLinkedList<Game> games) {
		this.games = games;
	}

	public MyLinkedList<Game> getGames() {
		return games;
	}

	public void setGamesHamper(MyStack<Game> gamesHamper) {
		this.gamesHamper = gamesHamper;
	}

	public MyStack<Game> getGamesHamper() {
		return gamesHamper;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public int getTime() {
		return time;
	}

	public void setBillToPay(int billToPay) {
		this.billToPay = billToPay;
	}

	public int getBillToPay() {
		return billToPay;
	}

	public int getNumberOfGames() {
		return games.size();
	}

	public void bill() {
		Node<Game> game  = games.getFirst();
		while(game!=null) {
			billToPay += game.getElement().getPrice();
			game = game.getNext();
		}
	}
	
	public String gamesIDs() {
		String message = "";
		Node<Game> game  = games.getFirst();
		while(game!=null) {
			message += game.getElement().getId()+" ";
			game = game.getNext();
		}
		return message;
	}


	@Override
	public int compareTo(Client o) {
		int value = 0;
		if(time<o.getTime()) {
			return -1;
		}else if(time==o.getTime()) {
			
			if (entryPosition<o.getEntryPosition()) {
				value = -1;
			}else if (entryPosition>o.getEntryPosition()) {
				value = 1;
			}
			
			return value;
			
		}else {
			return 1;
		}
	}
	
	public String toString() {
		return "Cliente:"+code+"- Tiempo:"+time;
	}


	public int getEntryPosition() {
		return entryPosition;
	}


	public void setEntryPosition(int entryPosition) {
		this.entryPosition = entryPosition;
	}






	

	
	
	
	
}
