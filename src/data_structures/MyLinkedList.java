package data_structures;

public class MyLinkedList<T extends Comparable<T>> {
	
	private Node<T> first;

	//Constructor
	public MyLinkedList() {
		
	}
	
	//Methods createNode
	public void createNode(T element) {
		Node<T> newNode = new Node<T>(element);
		
		if (first == null) {			
			first = newNode;
			
		}else {
			insertNode(newNode,first,first.getNext());			
		}						
	}
	
	//Method to add node in order
	public void insertNode(Node<T> newNode, Node<T>nodePrev, Node<T>nodeNext) {
		if (nodeNext == null) {
			nodePrev.setNext(newNode);
		}else {
			insertNode(newNode,nodeNext,nodeNext.getNext());
		}
		
		/*
		if (nodeNext == null) {
			if (nodePrev == first && newNode.getElement().compareTo(nodePrev.getElement())>0) {
				nodePrev.setNext(newNode);
			
			}else if (nodePrev == first && newNode.getElement().compareTo(nodePrev.getElement())<0 ) {
				nodePrev.setPrevious(newNode);
				first = newNode;
				first.setNext(nodePrev);			
			
			}else if (newNode.getElement().compareTo(nodePrev.getElement())==0 ) {
				nodePrev.setNext(newNode);
				newNode.setPrevious(nodePrev);
			
			}else if (newNode.getElement().compareTo(nodePrev.getElement())>0) {
				nodePrev.setNext(newNode);
				newNode.setPrevious(nodePrev);
				
			}			
			
		}else if (newNode.getElement().compareTo(nodePrev.getElement())>0 && newNode.getElement().compareTo(nodeNext.getElement())<0){
			nodePrev.setNext(newNode);
			nodeNext.setPrevious(newNode);
			newNode.setNext(nodeNext);
			newNode.setPrevious(nodePrev);
			
		}else {
			  insertNode(newNode,nodeNext,nodeNext.getNext());
		}	
		
			*/
	}
	
	//Method to know if the Linked List has elements or not
	public boolean isEmpty() {
		if(first==null) {
			return true;
		}else {
			return false;
		}
	}
	
	//Method to know if there is an existing node
	public boolean existingNode(Node<T> searchedNode, Node<T> actualNode) {	
		if(actualNode!=null) {
			if(actualNode==searchedNode) {
				return true;
			}else {
				if(actualNode.getNext()!=null) {
					return existingNode(searchedNode, actualNode.getNext());
				}else {
					return false;
				}
			}
		}else {
			return false;
		}		
	}
	
	//Method that delete an existing node
	public void deleteNode(Node<T> node) {
		if(existingNode(node, first)==true) {
			if(node.getPrevious()!=null) {//Si node tiene anterior
				if(node.getNext()!=null) {//Si node tiene anterior y siguiente
					node.getPrevious().setNext(node.getNext());
					node.getNext().setPrevious(node.getPrevious());
					node.setNext(null);
					node.setPrevious(null);
				}else {//Si node solo tiene anterior
					node.getPrevious().setNext(null);
				}
			}else {//No tiene previous es porque es el first
				if(node.getNext()!=null) {//Si node(el primero) tiene siguiente entonces que al siguiente le quite la relacion con node
					node.getNext().setPrevious(null);
					first=node.getNext();
					node.setNext(null);
				}else {//Si la lista ordenada solo tiene un elemento
					first=null;
				}			
			}
		}	
	}
	
	public Node<T> getNode(Node<T>searchedNode){
		if(first!=null) {
			return lookForNode(searchedNode, first);
		}else {
			return null;
		}	
	}
	
	private Node<T> lookForNode(Node<T>searchedNode, Node<T>actualNode){
		if(searchedNode==actualNode) {
			return actualNode;
		}
		else {
			if(actualNode.getNext()!=null) {
				return lookForNode(searchedNode, actualNode.getNext());
			}else {
				return null;
			}
		}
	}

	public void setFirst(Node<T> first) {
		this.first = first;
	}
	
	public Node<T> getFirst() {
		return first;
	}
	
	
}
