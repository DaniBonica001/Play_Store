package MyQueue_data_structure;

import java.util.ArrayList;

public class MyQueue<T> implements MyQueueInterface<T> {	
	 
	//Attributes
	public int front;
	public int rear; 
    public ArrayList<T> A;
    
    //Constructor
    public MyQueue() {
    	A = new ArrayList<>();
    	front = 0;
    	rear = A.size()-1;
    }
        
 
    // Returns value of element at front
    public T front()  {
        // If it is not pointing to any element in queue
        if (front == -1) {
        	return null;
        }else {
        	return A.get(0);
        }
    }
   
    
    // Returns value of element at rear
    public T rear()    {
    	// If it is not pointing to any element in queue
    	if (rear == -1) {
    		return null;
    	}else {
    		return A.get(rear);
    	}
    }
    
    // Inserts element at the back of queue
    public void enqueue(T X)    {    	
    	A.add(X);
    	rear = A.size()-1;            
    }
    
    
    // Deletes elements from the front from queue
    public T dequeue()    {
    
        if (this.empty()) {
        	System.out.println("Queue is already empty");
        	return null;
        }else {
        	return  A.remove(0);
        	
        }
                
    }
 
    // Checks whether the queue is empty
    public boolean empty()   {
        if (A.size()==0) {
            return true;
        }else {
        	return false;
        }        
    }
    
    public int size() {
    	return A.size();
    }
    
     
    @Override
    public String toString()   {
    	String Ans = "";             
 
        for (int i = 0; i <A.size(); i++) {
        	if (i==0) {
        		Ans += "Primero en fila: "+String.valueOf(A.get(i))+"->";        		
        	}else if (i== A.size()-1){
        		Ans += String.valueOf(A.get(i))  ;
        	}else {
        		Ans += String.valueOf(A.get(i))+"->" ;
        	}
            
        }      
 
        return Ans;
    }


}


