package uy.edu.um.prog2.adt.MyLinkedlistSimple;

public interface LinkedListSimple<V>{
    void addLast(V value);

    void remove (int index);

    V get (int index);
}
