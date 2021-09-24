package model;

public class Cashier implements Comparable<Cashier> {

	//Attributes
	private int cashierNumber;
	private int time;
	
	//Relations
	private Client client;

	//Constructor
	public Cashier(int cashierNumber) {
		this.cashierNumber=cashierNumber;
		this.time=0;
		client=null;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public int getTime() {
		return time;
	}

	public void setCashierNumber(int cashierNumber) {
		this.cashierNumber = cashierNumber;
	}

	public int getCashierNumber() {
		return cashierNumber;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
	public Client getClient() {
		return client;
	}


	@Override
	public int compareTo(Cashier o) {
		if(time<o.getTime()) {
			return -1;
		}else if(time<o.getTime()) {
			return 0;
		}else {
			return 1;
		}
	}

}

