package Nodos;

public class NodeBT<K extends Comparable<K>, V>{

    private K key;

    private V value;
    private NodeBT left;
    private NodeBT right;
    public NodeBT(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
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

    public NodeBT getLeft() {
        return left;
    }

    public void setLeft(NodeBT left) {
        this.left = left;
    }

    public NodeBT getRight() {
        return right;
    }

    public void setRight(NodeBT right) {
        this.right = right;
    }
}
