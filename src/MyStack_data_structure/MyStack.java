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

// Method to push generic element into stack
 public void push(T X){
     if (top + 1 == size) {// Checking if array is full
         System.out.println("Stack Overflow");         // Display message when array is full
     }
     else {

         // Increment top to go to next position
         top = top + 1;

         // Over-writing existing element
         if (A.size() > top)
             A.set(top, X);

         else

             // Creating new element
             A.add(X);
     }
 }
 // Method 2
 // To return topmost element of stack
public T top() {
     // If stack is empty
     if (top == -1) {

         // Display message when there are no elements in
         // the stack
         System.out.println("Stack Underflow");

         return null;
     }

     // else elements are present so
     // return the topmost element
     else
         return A.get(top);
 }

 // Method 3
 // To delete last element of stack
 public void pop() {
     // If stack is empty
     if (top == -1) {//No hay elementos en stack
         System.out.println("Stack Underflow");
     }

     else
         top--;
 }

 // Method to check if stack is empty or not
 boolean empty() { 
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
