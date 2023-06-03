package uy.edu.um.prog2.adt.MyQueue;

import uy.edu.um.prog2.adt.Exceptions.EmptyQueueException;

public interface Queue<V> {
    void enqueue(V value);

    V dequeue() throws EmptyQueueException;

    boolean isEmpty();
}
