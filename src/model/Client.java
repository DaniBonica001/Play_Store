package model;

import MyLinkedList_data_structure.MyLinkedList;

public class Client {

	//Attributes
	private String code;
	
	//Relations
	private MyLinkedList<Game> games;
	
	
	//Constructor
	public Client(String code) {
		this.code = code;
		games = new MyLinkedList<>();		
	}

	
	public void createGames(String[] lineSplit) {
		for (int i=1;i<=lineSplit.length-1;i++) {
			Game newGame = new Game(Integer.parseInt(lineSplit[i]));
			games.createNode(newGame);
			//System.out.println("New game: *"+newGame.getId());
			
			/*
			if (first == null) {
				first = newGame;
				games.
			}else {
				insertGame(newGame,first,first.getNext());
			}
			*/
			
		}
		
	}
	
	/*
	private void insertGame(Game newGame, Game gamePrev, Game gameNext) {
		if (gameNext == null) {
			gamePrev.setNext(newGame);
		}else {
			insertGame(newGame,gameNext,gameNext.getNext());
		}		
	}
	*/

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




	

	
	
	
	
}
