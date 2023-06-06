package uy.edu.um.prog2.adt.MyBinarySearchTree;

import uy.edu.um.prog2.adt.Exceptions.KeyNotFound;
import uy.edu.um.prog2.adt.MyLinkedlistSimple.LinkedListSimpleImpl;
import uy.edu.um.prog2.adt.Nodos.NodeBT;

public class BinarySearchTreeImpl<K extends Comparable<K>, V> implements BinarySearchTree <K, V> {
    private NodeBT root;
    private LinkedListSimpleImpl<NodeBT> order;

    @Override
    public void insert(K key, V value) {
        root = insertRecursive(root, key, value);
    }
    private NodeBT insertRecursive(NodeBT node, K key, V value) {
        if (node == null) {
            return new NodeBT(key, value);
        }

        int dif = key.compareTo((K) node.getKey());
        if (dif < 0) {
            node.setLeft(insertRecursive(node.getLeft(), key, value));
        } else if (dif > 0) {
            node.setRight(insertRecursive(node.getRight(), key, value));
        } else {
            node.setValue(value);
        }
        return node;
    }

    @Override
    public V find(K key) throws KeyNotFound {
        return (V) findRecursive(root, key).getValue();
    }
    private NodeBT findRecursive(NodeBT node, K key) throws KeyNotFound {
        if (node == null) {
            throw new KeyNotFound();
        }

        int cmp = key.compareTo((K) node.getKey());
        if (cmp < 0) {
            return findRecursive(node.getLeft(), key);
        } else if (cmp > 0) {
            return findRecursive(node.getRight(), key);
        } else {
            return node;
        }
    }

    @Override
    public void delete(K key) {
        root = deleteRecursive(root, key);
    }

    private NodeBT deleteRecursive(NodeBT node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo((K) node.getKey());
        if (cmp < 0) {
            node.setLeft(deleteRecursive(node.getLeft(), key));
        } else if (cmp > 0) {
            node.setRight(deleteRecursive(node.getRight(), key));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                NodeBT minNode = min(node.getRight());
                node.setKey(minNode.getKey());
                node.setValue(minNode.getValue());
                node.setRight(deleteMin(node.getRight()));
            }
        }
        return node;
    }

    private NodeBT min(NodeBT node) {
        if (node.getLeft() == null) {
            return node;
        }
        return min(node.getLeft());
    }

    private NodeBT deleteMin(NodeBT node) {
        if (node.getLeft() == null) {
            return node.getRight();
        }
        node.setLeft(deleteMin(node.getLeft()));
        return node;
    }
    @Override
    public LinkedListSimpleImpl<NodeBT> inOrder() {
        order = new LinkedListSimpleImpl<>();
        return inOrderRecursive(root);
    }
    private LinkedListSimpleImpl<NodeBT> inOrderRecursive(NodeBT node) {
        if (node == null) {
            return null;
        }
        inOrderRecursive(node.getLeft());
        order.addLast(node);
        inOrderRecursive(node.getRight());
        return order;
    }
    @Override
    public LinkedListSimpleImpl<NodeBT> preOrder() {
        order = new LinkedListSimpleImpl<>();
        return preOrderRecursive(root);
    }

    private LinkedListSimpleImpl<NodeBT> preOrderRecursive(NodeBT node) {
        if (node == null) {
            return null;
        }
        order.addLast(node);
        preOrderRecursive(node.getLeft());
        preOrderRecursive(node.getRight());
        return order;
    }
    @Override
    public LinkedListSimpleImpl<NodeBT> postOrder() {
        order = new LinkedListSimpleImpl<>();
        return postOrderRecursive(root);
    }

    private LinkedListSimpleImpl<NodeBT> postOrderRecursive(NodeBT node) {
        if (node == null) {
            return null;
        }
        postOrderRecursive(node.getLeft());
        postOrderRecursive(node.getRight());
        order.addLast(node);
        return order;
    }
}
