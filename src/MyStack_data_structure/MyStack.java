package MyStack_data_structure;

import java.util.*;

public class MyStack<T> implements MyStackInterface<T>{

	//Atributes
	private ArrayList<T> array; // Empty array list
	private int top; // Default value of top variable when stack is empty is -1

	//Constructor
	public MyStack(){
		this.array = new ArrayList<T>();// Creating array of Size = size
		this.top = -1;// Default value of top variable when stack is empty
	}

	public void setTop(int top) {
		this.top = top;
	}
	
	public int getTop() {
		return top;
	}

	//Method to push generic element into stack
	public void push(T element){
		array.add(element);
		top += 1;		
	}
	
	// Method to return the top of the stack without deleting it
	public T peek() {
		if(top>-1) {//Si el stack no está vacio
			return array.get(top);
		}else {
			return null;
		}

	}

	// Method to return and delete the top element of stack
	public T pop() {
		if (top == -1) {//No hay elementos en stack
			return null;
		}
		else {
			T object= array.get(top);//guardo el que era el top y el que se va a devolver
			array.remove(top);//borro el elemento que estaba en el top
			top -= 1;//muevo el top hacia abajo para indicar que el que le seguía ahora es el top
			//setTop(top-1);
			return object;
		}
	}

	// Method to check if stack is empty or not
	public boolean isEmpty() { 
		if(top==-1) {
			return true;
		}else {
			return false;
		}
	}

	
	//Method To print the stack
	// @Override
	public String toString(){
		String Ans = " ";
		for (int i = 0; i < array.size(); i++) {
			
			if (i== array.size()-1) {
				Ans += "Top: "+String.valueOf(array.get(i).toString());
			}else {
				Ans += String.valueOf(array.get(i).toString()) + "-> ";
			}
			
		}
		return Ans;
	}

	public ArrayList<T> getArray() {
		return array;
	}
}
