package MyStack_data_structure;

public interface MyStackInterface<T> {
	public void push(T element);
	public T peek();
	public T pop();
	public boolean isEmpty();
	public String toString();

}
