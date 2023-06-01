package MyStack;

import Exceptions.EmptyStackException;
import Nodos.Node;

public class StackImpl<V> implements Stack<V>{
    private Node<V> head;

    @Override
    public void push(V element) {
        Node<V> newNode = new Node<>(element);
        if (isEmpty()){
            head = newNode;
            return;
        }
        head.next = newNode;
        newNode.prev = head;
        head = newNode;
    }

    @Override
    public void pop() throws EmptyStackException {
        if (isEmpty()){
            throw new EmptyStackException();
        }

        head = head.prev;

        if (head == null){
            return;
        }
        head.next = null;
    }

    @Override
    public V top() throws EmptyStackException {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        if (head == null){
            return true;
        }
        return false;
    }

    @Override
    public void makeEmpty() {
        head = null;
    }
}
