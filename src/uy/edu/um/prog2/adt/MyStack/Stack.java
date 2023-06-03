package uy.edu.um.prog2.adt.MyStack;

import uy.edu.um.prog2.adt.Exceptions.EmptyStackException;

public interface Stack <V>{
    void push(V element);

    void pop () throws EmptyStackException;
    V top() throws EmptyStackException;

    boolean isEmpty ();
    void makeEmpty();
}
