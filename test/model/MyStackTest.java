package model;

import MyStack_data_structure.MyStack;
import org.junit.Assert;
import org.junit.Test;

public class MyStackTest {

    private MyStack<Game> stack;

    // Scenes
    public void sc1() {
    }

    public void sc2() {
        stack = new MyStack<>();
    }

    // Constructor Test
    @Test
    public void testMyStack(){ //Tests MyStack constructor.
        sc1();

        MyStack<Game> stack = new MyStack<>();

        Assert.assertNotNull(stack.getArray()); //Checks if the arraylist is created.
        Assert.assertTrue(stack.getArray().isEmpty()); //Checks if the arraylist is empty.
        Assert.assertEquals(-1, stack.getTop()); //Checks if top value is -1.
    }

    // Push Tests
    @Test
    public void testPush1() {
        sc2();

        Game game = new Game("Shelf A", 10, 50, 1);
        stack.push(game);

        Assert.assertEquals(0, stack.getTop());
        Assert.assertFalse(stack.isEmpty());
    }

}
