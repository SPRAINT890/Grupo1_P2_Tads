package MyQueue;

import Exceptions.EmptyQueueException;

public interface Queue<V> {
    void enqueue(V value);

    V dequeue() throws EmptyQueueException;

    boolean isEmpty();
}
