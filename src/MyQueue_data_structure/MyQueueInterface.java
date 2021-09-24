package MyQueue_data_structure;

public interface MyQueueInterface<T> {
	public T front() ;
	public T rear() ;
	public void enqueue(T X);
	public T dequeue();
	public boolean empty();
	public int size();
	public String toString();

}
