package uy.edu.um.prog2.adt.MyHash;

import uy.edu.um.prog2.adt.Exceptions.KeyNotFound;
import uy.edu.um.prog2.adt.MyLinkedlistSimple.LinkedListSimpleImpl;
import uy.edu.um.prog2.adt.Nodos.NodeHash;

public class HashTableCerradoImpl<K extends Comparable<K>,V> implements HashTableCerrado<K, V> {

    private NodeHash<K, V>[] list;
    private LinkedListSimpleImpl<K> keys = new LinkedListSimpleImpl<>();
    private int size = 0;
    private static final int DEFAULT = 200;

    public HashTableCerradoImpl(int len) {
        this.list = new NodeHash[len];
    }
    public HashTableCerradoImpl() {
        this.list = new NodeHash[DEFAULT];
    }
    public NodeHash<K, V>[] getList() {
        return list;
    }

    public int getSize() {
        return size;
    }
    @Override
    public void insert(K key, V value) {
        NodeHash<K, V> newNode = new NodeHash<>(key, value);
        int index = calculateHash(key);
        while (true){
            if (index == list.length){
                index = 0;
            }
            if (list[index] == null || list[index] != null && !list[index].isActivo()){
                list[index] = newNode;
                size++;
                break;
            }
            index++;
        }
        keys.addLast(key);
        if ((double) ( (size*100) / list.length) > 70.0){
            increaseCapacity();
        }
    }

    @Override
    public V search(K key) {
        int keyIndex, keyIndexAux = calculateHash(key);
        keyIndex = keyIndexAux;
        boolean vueltaCompleta = false;
        while (true){
            if (keyIndexAux >= list.length){
                keyIndexAux = 0;
                vueltaCompleta = true;
            }
            if (keyIndex == keyIndexAux && vueltaCompleta || list[keyIndexAux] == null){
                return null;
            }
            if (list[keyIndexAux].getKey().compareTo(key) == 0 && list[keyIndexAux].isActivo()){
                return list[keyIndexAux].getValue();
            }
            if (list[keyIndexAux].getKey() == key && !list[keyIndexAux].isActivo()){
                return null;
            }
            keyIndexAux++;
        }
    }
    public void setValue(K key, V newVal){
        int keyIndex, keyIndexAux = calculateHash(key);
        keyIndex = keyIndexAux;
        boolean vueltaCompleta = false;

        while (true){
            if (keyIndexAux >= list.length){
                keyIndexAux = 0;
                vueltaCompleta = true;
            }
            if (keyIndex == keyIndexAux && vueltaCompleta || list[keyIndexAux] == null){
               break;
            }
            if (list[keyIndexAux].getKey().compareTo(key) == 0 && list[keyIndexAux].isActivo()){
                list[keyIndexAux].setValue(newVal);
            }
            if (list[keyIndexAux].getKey() == key && !list[keyIndexAux].isActivo()){
                break;
            }
            keyIndexAux++;
        }
    }
    @Override
    public void delete(K key) throws KeyNotFound {
        int keyIndex, keyIndexAux = calculateHash(key);
        keyIndex = keyIndexAux;
        while (true){
            if (keyIndexAux > list.length){
                keyIndex = 0;
            }
            if (list[keyIndexAux] != null){
                if (list[keyIndexAux].getKey() == key){
                    list[keyIndexAux].borrar();
                    size--;
                    break;
                }
            }
            keyIndexAux++;
            if (keyIndex == keyIndexAux){
                throw new KeyNotFound();
            }
        }
        keys.removeForData(key);
    }
    private int calculateHash(K key) {
        int hash = 0;
        if (key instanceof Long) {
            hash = (int) (((Long) key).longValue() % list.length);
        }
        if (key instanceof Integer) {
            hash = ((Integer) key).intValue() % list.length;
        }
        if (key instanceof String){
            hash = Math.floorMod(key.hashCode(), list.length);
        }
        return hash;
    }

    private long calcString(String str){
        int count = 10;
        if (str.contains("a") || str.contains("A")){
            count *= 10;
        }
        if (str.contains("e") || str.contains("E")){
            count *= 20;
        }
        if (str.contains("i") || str.contains("I")){
            count *= 30;
        }
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                count ++;
            }
        }
        return count;
    }

    private void increaseCapacity() {
        int newCapacity = (list.length * 2);
        NodeHash<K, V>[] oldList = list;

        HashTableCerradoImpl<K, V> newHash = new HashTableCerradoImpl(newCapacity+1);

        for (NodeHash<K, V> nodo : oldList){
            if (nodo == null){
                continue;
            }
            newHash.insert(nodo.getKey(), nodo.getValue());
        }
        list = newHash.getList();
    }

    public LinkedListSimpleImpl<K> getKeys() {
        return keys;
    }
}
