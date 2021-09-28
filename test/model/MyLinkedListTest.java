package model;

import MyLinkedList_data_structure.MyLinkedList;
import MyLinkedList_data_structure.Node;
import org.junit.Assert;
import org.junit.Test;

public class MyLinkedListTest {

    private MyLinkedList<Game> linkedList;
    private Node<Game> node1;
    private Node<Game> node2;

    // Scenes
    public void sc1() {
        linkedList = new MyLinkedList<>();
    }

    public void sc2() {
        linkedList = new MyLinkedList<>();
        linkedList.createNode(null);
    }

    public void sc3() {
        linkedList = new MyLinkedList<>();

        Game game1 = new Game("A", 1, 20, 3);
        Game game2 = new Game("B", 2, 25, 1);
        Game game3 = new Game("C", 4, 10, 5);

        node1 = linkedList.createNode(game1);
        node2 = linkedList.createNode(game2);
        linkedList.createNode(game3);
    }

    // Create Node Test
    @Test
    public void testCreateNode() {
        sc1();

        Game game1 = new Game("A", 8, 12, 2);

        linkedList.createNode(game1);

        Assert.assertFalse(linkedList.isEmpty());
        Assert.assertNotNull(linkedList.getFirst());
    }

    // Insert Node Test
    @Test
    public void testInsertNode1() {
        sc3();

        Game game4 = new Game("D", 7, 16, 4);
        Node<Game> newNode = new Node<>(game4);

        linkedList.insertNode(newNode, node1, node2);

        Assert.assertNotNull(linkedList.getNode(newNode));
    }

    // Existing Node Tests
    @Test
    public void testExistingNode1() {
        sc3();

        Assert.assertTrue(linkedList.existingNode(node1, linkedList.getFirst()));
    }

    @Test
    public void testExistingNode2() {
        sc2();

        Game game = new Game("Z", 2, 11, 2);
        Node<Game> searchedNode = new Node<>(game);

        Assert.assertFalse(linkedList.existingNode(searchedNode, linkedList.getFirst()));
    }

    // Delete Tests
    @Test
    public void testDeleteNode1() {
        sc3();

        linkedList.deleteNode(node1);

        Assert.assertFalse(linkedList.existingNode(node1, linkedList.getFirst()));
    }

    @Test
    public void testDeleteNode2() {
        sc1();

        int initialSize = linkedList.size();
        linkedList.deleteNode(null);

        Assert.assertEquals(initialSize, linkedList.size());
    }

    // Get Node Tests
    @Test
    public void testGetNode1() {
        sc3();

        Node<Game> returnedNode = linkedList.getNode(node2);

        Assert.assertEquals(node2, returnedNode);
    }

    @Test
    public void testGetNode2() {
        sc2();

        Node<Game> returnedNode = linkedList.getNode(null);

        Assert.assertNull(returnedNode);
    }

}
