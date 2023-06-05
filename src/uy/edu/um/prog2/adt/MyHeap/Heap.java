package uy.edu.um.prog2.adt.MyHeap;

public interface Heap <K, V> {
    void insert (K key, V value);
    V extractMax ();
    void heapifyUp();
    void heapifyDown();
    int size();
    boolean is_empty();
}
