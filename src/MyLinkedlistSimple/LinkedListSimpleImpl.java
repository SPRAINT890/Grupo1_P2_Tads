package MyLinkedlistSimple;

import Nodos.Node;

public class LinkedListSimpleImpl<V> implements LinkedListSimple<V> {
    public Node<V> head;
    public Node<V> tail;
    

    @Override
    public void addLast(V value) {
       Node<V> newNode = new Node<> (value);
       if (head == null){
           head = newNode;
           tail = newNode;
           return;
       }
       tail.next = newNode;
       tail = newNode;
    }

    public void addFirst(V value) {
        Node<V> newNode = new Node<> (value);
        if (head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    @Override
    public void remove(int index) {
        if (head == null){
            return;
        }
        if (index > this.length()){
            return;
        }
        if (index == 0){
            head = head.next;
            return;
        }
        Node<V> tempNode = head;
        for (int c = 0; c < index-1; c++){
            tempNode = tempNode.next;
        }
        Node<V> nodoBorrar = tempNode.next;
        if (nodoBorrar == tail){
            tail = tempNode;
        }
        tempNode.next = nodoBorrar.next;
    }

    public int length(){
        if (head == null){
            return -1;
        }
        Node<V> tempNode = head;
        int c = 0;
        while (tempNode.next != null){
            c++;
            tempNode = tempNode.next;
        }
        return c;
    }

    @Override
    public V get(int index) {
        if (head == null){
            return null;
        }
        if (index > this.length()){
            return null;
        }
        if (index == 0) {
            return head.data;
        }
        Node<V> tempNode = head;
        for (int c = 0; c < index; c++){
            tempNode = tempNode.next;
        }
        return tempNode.data;
    }

    public boolean exist(V data){
        Node <V> tempNode = head;
        if (tempNode == null){
            return false;
        }
        while (tempNode.next != null){
            if (tempNode.data == data){
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }
}
