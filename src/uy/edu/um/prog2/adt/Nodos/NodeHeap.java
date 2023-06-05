package uy.edu.um.prog2.adt.Nodos;

public class NodeHeap<K extends Comparable<K>, V> {
    private K key;

    private V value;

    public NodeHeap(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }
}
