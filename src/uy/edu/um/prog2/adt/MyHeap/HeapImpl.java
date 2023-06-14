package uy.edu.um.prog2.adt.MyHeap;
import uy.edu.um.prog2.adt.Nodos.NodeHeap;


public class HeapImpl <K extends Comparable<K>, V> implements Heap <K, V>{
    private NodeHeap<K, V>[] list;

    private int size = 0;
    public HeapImpl(int len) {
        list = new NodeHeap [len];
    }

    public int getSize() {
        return size;
    }

    public NodeHeap<K, V>[] getList() {
        return list;
    }

    @Override
    public void insert(K key, V value) {
        list[size] = new NodeHeap<>(key, value);
        size++;
        if (size == list.length) {
            increaseCapacity();
        }
        heapifyUp();
    }

    @Override
    public V extractMax() {
        if (size == 0) {
            return null;
        }
        V max = list[0].getValue();
        list[0] = list[size-1];
        list[size-1] = null;
        size--;
        heapifyDown();
        //heapifyUp();
        return max;
    }

    @Override
    public void heapifyUp() {
        for (int i = size-1; i>0; i--){
            int padre = (i-1)/2;
            if (padre<0){
                return;
            }
            if (list[i].getKey().compareTo(list[padre].getKey()) > 0){
                swap(i, padre);
            }
        }
    }

    @Override
    public void heapifyDown() {
        for (int i = 0; i<size; i++){
            int hijoIzquierdo = (2 * i) + 1;
            int hijoDerecho = (2 * i) + 2;
            Integer nuevoPadre = null;
            if (hijoIzquierdo < size && list[i].getKey().compareTo(list[hijoIzquierdo].getKey()) < 0){
                nuevoPadre = hijoIzquierdo;
                if (hijoDerecho < size && list[i].getKey().compareTo(list[hijoDerecho].getKey()) < 0 && list[nuevoPadre].getKey().compareTo(list[hijoDerecho].getKey()) < 0){
                    nuevoPadre = hijoDerecho;
                }
            } else if (hijoDerecho < size && list[i].getKey().compareTo(list[hijoDerecho].getKey()) < 0) {
                nuevoPadre = hijoDerecho;
            }
            if (nuevoPadre != null){
                swap(i, nuevoPadre);
            }
        }
    }

    private void swap(int menorInt, int mayorInt) {
        NodeHeap<K, V> mayorNode = list[menorInt];
        NodeHeap<K, V> menorNode = list[mayorInt];

        list[menorInt] = menorNode;
        list[mayorInt] = mayorNode;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean is_empty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    private void increaseCapacity() {
        int newCapacity = (int) (list.length * 1.5);
        if (newCapacity == list.length){// si se elige un valor muy chico, puede que redondee el mismo numero
            list = copyArray(list, newCapacity+1);
            return;
        }
        list = copyArray(list, newCapacity);
    }

    private NodeHeap<K, V>[] copyArray(NodeHeap<K, V>[] oldList, int capacity){
        HeapImpl<K, V> newHeap = new HeapImpl<>(capacity+1);
        for (int i = 0; i<oldList.length; i++){
            if (oldList[i] != null){
                newHeap.insert(oldList[i].getKey(), oldList[i].getValue());
            }
        }
        return newHeap.getList();
    }
}
