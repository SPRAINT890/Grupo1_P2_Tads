package uy.edu.um.prog2.adt.MyQueue;

import uy.edu.um.prog2.adt.Exceptions.EmptyQueueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueImplTest {
    QueueImpl<Integer> cola = new QueueImpl<>();
    @Test
    void enqueueUnElemento(){
        cola.enqueue(1);
        assertEquals(cola.getHead().data, 1);
        assertEquals(cola.getTail().data, 1);
        assertFalse(cola.isEmpty());
        assertEquals(cola.getSize(), 1);
    }
    @Test
    void enqueueVariosElementos(){
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.enqueue(4);
        assertEquals(cola.getHead().data, 1);
        assertEquals(cola.getTail().data, 4);
        assertFalse(cola.isEmpty());
        assertEquals(cola.getSize(), 4);
    }

    @Test
    void dequeueNormal() throws EmptyQueueException {
        cola.enqueue(1);
        assertEquals(cola.dequeue(), 1);
        assertNull(cola.getHead());
        assertNull(cola.getTail());
        assertTrue(cola.isEmpty());
        assertEquals(cola.getSize(), 0);
    }
    @Test
    void dequeueVariosElementos() throws EmptyQueueException {
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.enqueue(4);
        assertEquals(cola.dequeue(), 1);
        assertEquals(cola.dequeue(), 2);
        assertEquals(cola.dequeue(), 3);
        assertEquals(cola.getHead().data,4);
        assertEquals(cola.getTail().data,4);
        assertFalse(cola.isEmpty());
        assertEquals(cola.getSize(), 1);
    }
    @Test
    void dequeueVacio() throws EmptyQueueException {
        try {
            cola.dequeue();
            assertTrue(false);
        }catch (EmptyQueueException e){
            assertTrue(true);
        }
    }

}