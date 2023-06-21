package uy.edu.um.prog2.adt.MyLinkedlistSimple;

public interface LinkedListSimple<V>{
    void addLast(V value);
    void addFirst(V value);

    void removeForIndex (int index);
    void removeForData (V value);

    V get (int index);
    boolean exist(V data);
}
