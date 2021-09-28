package model;

import MyQueue_data_structure.MyQueue;
import org.junit.Assert;
import org.junit.Test;

public class MyQueueTest {

    private MyQueue<Client> queue;

    // Scenes
    public void sc1() {
        queue = new MyQueue<>();
    }

    public void sc2() {
        queue = new MyQueue<>();

        Client client1 = new Client("1234");
        Client client2 = new Client("4321");

        queue.enqueue(client1);
        queue.enqueue(client2);
    }

    // Enqueue Test
    @Test
    public void testEnqueue() {
        sc1();

        Client client = new Client("1234");

        queue.enqueue(client);

        Assert.assertEquals(queue.size()-1, queue.rear);
        Assert.assertFalse(queue.empty());
        Assert.assertEquals(client, queue.front());
    }

    // Dequeue Tests
    @Test
    public void testDequeue1() {
        sc2();

        Client initialFront = queue.front();
        Client dequeuedElement = queue.dequeue();

        Assert.assertEquals(initialFront, dequeuedElement);
        Assert.assertNotEquals(queue.front(), initialFront);
    }

    @Test
    public void testDequeue2() {
        sc1();

        Assert.assertNull(queue.dequeue());
    }

    // Is Empty Tests
    @Test
    public void testIsEmpty1() {
        sc2();

        Assert.assertFalse(queue.empty());
    }

    @Test
    public void testIsEmpty2() {
        sc1();

        Assert.assertTrue(queue.empty());
    }

    // Front Tests
    @Test
    public void testFront1() {
        sc2();

        Client front = queue.front();

        Assert.assertNotNull(queue.front());
        Assert.assertEquals(front, queue.front());
    }

    @Test
    public void testFront2() {
        sc1();

        Assert.assertNull(queue.front());
    }

    // Rear Tests
    @Test
    public void testRear1() {
        sc2();

        Client rear = queue.rear();

        Assert.assertNotNull(queue.rear());
        Assert.assertEquals(rear, queue.rear());
    }

    @Test
    public void testRear2() {
        sc1();

        Assert.assertNull(queue.rear());
    }

    // Size Tests
    @Test
    public void testSize1() {
        sc2();

        int size = queue.size();

        Assert.assertEquals(size, queue.size());
    }

    @Test
    public void testSize2() {
        sc1();

        int size = queue.size();

        Assert.assertEquals(size, 0);
    }

}
