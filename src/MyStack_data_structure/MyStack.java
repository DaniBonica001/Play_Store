package MyStack_data_structure;

import java.util.*;

public class MyStack<T> {

//Atributes
 ArrayList<T> A; // Empty array list
 int top; // Default value of top variable when stack is empty
 int size;// Variable to store size of array

//Constructor
 public MyStack(int size){
     this.size = size; // Storing the value of size into global variable
     this.A = new ArrayList<T>(size);// Creating array of Size = size
     this.top=-1;// Default value of top variable when stack is empty
 }

//Method to push generic element into stack
public void push(T element){
	top=top+1;
	A.set(top, element);
}

 // Method to return the top of the stack without deleting it
public T peek() {
	if(top>-1) {//Si el stack no está vacio
		return A.get(top);
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
    	 T object=A.get(top);//guardo el que era el top y el que se va a devolver
    	 A.remove(top);//borro el elemento que estaba en el top
    	 top=top-1;//muevo el top hacia abajo para indicar que el que le seguía ahora es el top
    	 return object;
     }
 }

 // Method to check if stack is empty or not
 boolean isEmpty() { 
	 if(top==-1) {
		 return true;
	 }else {
		 return false;
	 }
 }

 // Method 5
 // To print the stack
 // @Override
 public String toString(){
     String Ans = "";
     for (int i = 0; i < top; i++) {
         Ans += String.valueOf(A.get(i)) + "->";
     }
     Ans += String.valueOf(A.get(top));

     return Ans;
 }
}
