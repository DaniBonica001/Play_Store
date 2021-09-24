package MyLinkedList_data_structure;

public interface MyLinkedListInter <T extends Comparable<T>> {	
	
	public void createNode(T element); 
	public void insertNode(Node<T> newNode, Node<T>nodePrev, Node<T>nodeNext);
	public boolean isEmpty();
	public boolean existingNode(Node<T> searchedNode, Node<T> actualNode);
	public void deleteNode(Node<T> node);
	public Node<T> getNode(Node<T>searchedNode);
	public Node<T> lookForNode(Node<T>searchedNode, Node<T>actualNode);
	public int size() ;

}
