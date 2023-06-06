package uy.edu.um.prog2.adt.MyHash;

import uy.edu.um.prog2.adt.Exceptions.KeyNotFound;

public interface HashTableCerrado<K, V> {
    void insert (K key, V value);
    V search (K key) throws KeyNotFound;
    void delete (K key) throws KeyNotFound;
}
