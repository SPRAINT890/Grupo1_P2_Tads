package uy.edu.um.prog2.adt.MyLinkedlistSimple;

import uy.edu.um.prog2.adt.Nodos.Node;

public class LinkedListSimpleImpl<V> implements LinkedListSimple<V> {
    public Node<V> head;
    public Node<V> tail;
    public Integer size = 0;
    

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
       size++;
    }
    @Override
    public void addFirst(V value) {
        Node<V> newNode = new Node<> (value);
        if (head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void removeForIndex(int index) {
        if (head == null || index > this.size){
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
        size--;
    }

    @Override
    public void removeForData(V value) {
        Node<V> tempNode = head;
        while (!tempNode.next.data.equals(value)){
            tempNode = tempNode.next;
        }
        Node<V> nodoBorrar = tempNode.next;
        if (nodoBorrar == tail){
            tail = tempNode;
        }
        tempNode.next = nodoBorrar.next;
        size--;
    }

    @Override
    public V get(int index) {
        if (head == null || index > this.size){
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
    @Override
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
