package model;

public class Client {

	//Attributes
	private String code;
	
	//Relations
	private Game first;
	
	//Constructor
	public Client(String code) {
		this.code = code;
		first = null;
	}

	
	public void createGames(String[] lineSplit) {
		for (int i=1;i<=lineSplit.length-1;i++) {
			Game newGame = new Game(Integer.parseInt(lineSplit[i]));
			if (first == null) {
				first = newGame;
			}else {
				insertGame(newGame,first,first.getNext());
			}
			
			
		}
		
	}
	
	
	private void insertGame(Game newGame, Game gamePrev, Game gameNext) {
		if (gameNext == null) {
			gamePrev.setNext(newGame);
		}else {
			insertGame(newGame,gameNext,gameNext.getNext());
		}		
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

	public void setFirst(Game first) {
		this.first = first;
	}
	
	public Game getFirst() {
		return first;
	}

	

	
	
	
	
}
