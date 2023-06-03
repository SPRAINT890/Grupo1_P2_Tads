package uy.edu.um.prog2.adt.MyStack;

import uy.edu.um.prog2.adt.Exceptions.EmptyStackException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackImplTest {
    StackImpl<Integer> pila = new StackImpl<>();
    @Test
    void push() throws EmptyStackException {
        pila.push(1);
        assertFalse(pila.isEmpty());
        assertEquals(pila.top(), 1);
    }
    @Test
    void pushVariosElementos() throws EmptyStackException {
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        assertFalse(pila.isEmpty());
        assertEquals(pila.top(), 4);
    }

    @Test
    void popUnElemento() throws EmptyStackException {
        pila.push(1);
        pila.pop();
        assertTrue(pila.isEmpty());
    }
    @Test
    void popVariosElementos() throws EmptyStackException {
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        pila.pop();
        pila.pop();
        pila.pop();
        assertFalse(pila.isEmpty());
        assertEquals(pila.top(),2);
    }
    @Test
    void popVacio() throws EmptyStackException {
        try {
            pila.pop();
            assertTrue(false);
        }catch (EmptyStackException e){
            assertTrue(true);
        }
    }
    @Test
    void topVacio() throws EmptyStackException {
        try {
            pila.top();
            assertTrue(false);
        }catch (EmptyStackException e){
            assertTrue(true);
        }
    }
    @Test
    void makeEmpty() throws EmptyStackException {
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        pila.makeEmpty();
        assertTrue(pila.isEmpty());
    }
}