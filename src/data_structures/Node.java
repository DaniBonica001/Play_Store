package data_structures;

public class Node<T extends Comparable<T>> {
	
	//Attribute
	private T element;
	
	//Relations
	private Node<T>previous;
	private Node<T>next;
	
	//Constructor
	public Node(T element) {
		this.element = element;
		previous = null;
		next = null;		
	}

	
	//Getters and Setters
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public Node<T> getNext() {
		return next;
	}

	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}

	public Node<T> getPrevious() {
		return previous;
	}
	
	public void setElement(T element) {
		this.element = element;
	}

	public T getElement() {
		return element;
	}
	







 












}
