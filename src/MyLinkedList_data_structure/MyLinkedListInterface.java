package MyLinkedList_data_structure;

public interface MyLinkedListInterface<T extends Comparable<T>> {
	
	Node<T> createNode(T element);
	void insertNode(Node<T> newNode, Node<T>nodePrev, Node<T>nodeNext);
	boolean isEmpty();
	boolean existingNode(Node<T> searchedNode, Node<T> actualNode);
	void deleteNode(Node<T> node);
	Node<T> getNode(Node<T>searchedNode);
	Node<T> lookForNode(Node<T>searchedNode, Node<T>actualNode);
	int size() ;

}
