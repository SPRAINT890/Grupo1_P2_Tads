package uy.edu.um.prog2.adt.Nodos;

public class NodeHash<K extends Comparable<K>, V> extends NodeHeap <K, V>{
    boolean activo = true;

    public NodeHash(K key, V value) {
        super(key, value);
    }

    public boolean isActivo() {
        return activo;
    }
    public void borrar() {
        this.activo = false;
    }
}
