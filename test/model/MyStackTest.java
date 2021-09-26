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

    public void sc3() {
        stack = new MyStack<>();

        Game game1 = new Game("A", 1, 50, 2);
        Game game2 = new Game("B", 2, 25, 4);

        stack.push(game1);
        stack.push(game2);
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
        Assert.assertEquals(game, stack.peek());
    }

    @Test
    public void testPush2() {
        sc3();

        Game game = new Game("Shelf A", 10, 50, 1);

        int oldTop = stack.getTop();
        stack.push(game);

        Assert.assertEquals(game, stack.peek());
        Assert.assertEquals(oldTop+1, stack.getTop());
    }

    // Peek Tests

    @Test
    public void testPeek1() {
        sc3();

        int topValue = stack.getTop();
        Game peekResult = stack.peek();

        Assert.assertEquals(topValue, stack.getTop());
        Assert.assertNotNull(peekResult);
    }

    @Test
    public void testPeek2() {
        sc2();

        Game peekResult = stack.peek();

        Assert.assertNull(peekResult);
    }

    // Pop Tests

    @Test
    public void testPop1() {
        sc3();

        int topValue = stack.getTop();
        Game topElement = stack.peek();
        Game removedElement = stack.pop();

        Assert.assertEquals(topElement, removedElement);
        Assert.assertEquals(topValue-1, stack.getTop());
    }

    @Test
    public void testPop2() {
        sc2();

        int topValue = stack.getTop();
        Game removedElement = stack.pop();

        Assert.assertNull(removedElement);
        Assert.assertEquals(topValue, stack.getTop());
    }

    // IsEmpty Tests

    @Test
    public void testIsEmpty1() {
        sc2();

        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmpty2() {
        sc3();

        Assert.assertFalse(stack.isEmpty());
    }

}
