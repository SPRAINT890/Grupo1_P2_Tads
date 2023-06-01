package MyQueue;

import Exceptions.EmptyQueueException;
import Nodos.Node;

public class QueueImpl <V> implements Queue<V>{
    private Node<V> head;

    private Node<V> tail;
    private int size;

    @Override
    public void enqueue(V value) {
        Node<V> newNode = new Node<> (value);
        if (isEmpty()){
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public V dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        Node<V> temp = head;
        size--;
        head = head.next;
        if (isEmpty()){
            tail = null;
        }
        return temp.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public Node<V> getHead() {
        return head;
    }

    public Node<V> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }
}
