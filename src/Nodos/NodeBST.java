package Nodos;

public class NodeBST<K extends Comparable<K>, V>{

    private K key;

    private V value;
    private NodeBST left;
    private NodeBST right;
    public NodeBST(K key, V value) {
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

    public NodeBST getLeft() {
        return left;
    }

    public void setLeft(NodeBST left) {
        this.left = left;
    }

    public NodeBST getRight() {
        return right;
    }

    public void setRight(NodeBST right) {
        this.right = right;
    }
}
