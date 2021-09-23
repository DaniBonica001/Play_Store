package model;

import MyStack_data_structure.MyStack;
import junit.framework.TestCase;

public class MyStackTest extends TestCase {

    public void sc1() {
    }

    public void testMyStack(){ //Test MyStack constructor.
        sc1();

        MyStack<Integer> stack = new MyStack<>();

        assertNotNull(stack.getArray()); //Checks if the arraylist is created.
        assertTrue(stack.getArray().isEmpty()); //Checks if the arraylist is empty.
        assertEquals(-1, stack.getTop()); //Checks if top value is -1.
    }

}
