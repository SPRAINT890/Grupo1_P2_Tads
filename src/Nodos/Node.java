package Nodos;

public class Node <V> {
    public final V data;
    public Node<V> next;
    public Node<V> prev;
    public Node(V data){
        this.data = data;
        this.next = null;
    }
}
