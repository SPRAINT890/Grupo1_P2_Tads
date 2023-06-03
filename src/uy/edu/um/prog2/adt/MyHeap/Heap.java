package uy.edu.um.prog2.adt.MyHeap;

public interface Heap <K, V> {
    void add (K key, V value);
    void delete (K key);
}
