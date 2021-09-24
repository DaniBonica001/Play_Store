package model;

import MyLinkedList_data_structure.MyLinkedList;
import MyLinkedList_data_structure.Node;
import MyStack_data_structure.MyStack;

public class Client implements Comparable<Client>{

	//Attributes
	private String code;
	private int time;
	private int billToPay;
	
	//Relations
	private MyLinkedList<Game> games;
	private MyStack<Game> gamesHamper;
	
	
	//Constructor
	public Client(String code) {
		this.code = code;
		games = new MyLinkedList<>();
		gamesHamper = new MyStack <>();
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

	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}
	
	public int getNumberOfGames() {
		return games.size();
	}

	public void setBillToPay(int billToPay) {
		this.billToPay = billToPay;
	}


	public int getBillToPay() {
		return billToPay;
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
			
			if (games.size()<o.getGames().size()) {
				value = -1;
			}else if (games.size()>o.getGames().size()) {
				value = 1;
			}
			
			return value;
			
		}else {
			return 1;
		}
	}
	
	public String toString() {
		return "code: "+code+"- Time: "+time;
	}






	

	
	
	
	
}
