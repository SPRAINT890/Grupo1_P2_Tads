package uy.edu.um.prog2.adt.MyBinarySearchTree;

import uy.edu.um.prog2.adt.Exceptions.KeyNotFound;
import uy.edu.um.prog2.adt.MyLinkedlistSimple.LinkedListSimpleImpl;
import uy.edu.um.prog2.adt.Nodos.NodeBT;

public interface BinarySearchTree<K, V> {
    void insert(K key, V value);
    V find(K key) throws KeyNotFound;
    void delete(K key);

    LinkedListSimpleImpl<NodeBT> inOrder();
    LinkedListSimpleImpl<NodeBT> preOrder();
    LinkedListSimpleImpl<NodeBT> postOrder();


}
