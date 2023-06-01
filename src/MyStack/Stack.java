package MyStack;

import Exceptions.EmptyStackException;

public interface Stack <V>{
    void push(V element);

    void pop () throws EmptyStackException;
    V top() throws EmptyStackException;

    boolean isEmpty ();
    void makeEmpty();
}
