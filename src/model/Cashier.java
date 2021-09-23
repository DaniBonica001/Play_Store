package model;

public class Cashier implements Comparable<Cashier> {
	//Relations
	Client client;
	int cashierNumber;
	int time;
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getCashierNumber() {
		return cashierNumber;
	}

	public void setCashierNumber(int cashierNumber) {
		this.cashierNumber = cashierNumber;
	}

	public Cashier(int cashierNumber) {
		this.cashierNumber=cashierNumber;
		this.time=0;
		client=null;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

