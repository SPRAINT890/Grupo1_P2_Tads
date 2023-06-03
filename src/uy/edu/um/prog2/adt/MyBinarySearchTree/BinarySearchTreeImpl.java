package uy.edu.um.prog2.adt.MyBinarySearchTree;

import uy.edu.um.prog2.adt.Nodos.NodeBT;

public class BinarySearchTreeImpl<K extends Comparable<K>, V> {
    private NodeBT root;

    public void insert(K key, V value) {
        root = insertN(root, key, value);
    }

    private NodeBT insertN(NodeBT node, K key, V value) {
        if (node == null) {
            return new NodeBT(key, value);
        }

        int dif = key.compareTo((K) node.getKey());
        if (dif < 0) {
            node.setLeft(insertN(node.getLeft(), key, value));
        } else if (dif > 0) {
            node.setRight(insertN(node.getRight(), key, value));
        } else {
            node.setValue(value);
        }
        return node;
    }

    public V find(K key) {
        return (V) findN(root, key).getValue();
    }

    private NodeBT findN(NodeBT node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo((K) node.getKey());
        if (cmp < 0) {
            return findN(node.getLeft(), key);
        } else if (cmp > 0) {
            return findN(node.getRight(), key);
        } else {
            return node;
        }
    }

    public void delete(K key) {
        root = deleteN(root, key);
    }

    private NodeBT deleteN(NodeBT node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo((K) node.getKey());
        if (cmp < 0) {
            node.setLeft(deleteN(node.getLeft(), key));
        } else if (cmp > 0) {
            node.setRight(deleteN(node.getRight(), key));
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

    public void inOrder() {
        inOrderN(root);
    }

    private void inOrderN(NodeBT node) {
        if (node != null) {
            inOrderN(node.getLeft());
            System.out.println(node.getKey() + ": " + node.getValue());
            inOrderN(node.getRight());
        }
    }

    public void preOrder() {
        preOrderN(root);
    }

    private void preOrderN(NodeBT node) {
        if (node != null) {
            System.out.println(node.getKey() + ": " + node.getValue());
            preOrderN(node.getLeft());
            preOrderN(node.getRight());
        }
    }

    public void postOrder() {
        postOrderN(root);
    }

    private void postOrderN(NodeBT node) {
        if (node != null) {
            postOrderN(node.getLeft());
            postOrderN(node.getRight());
            System.out.println(node.getKey() + ": " + node.getValue());
        }
    }

    public NodeBT getRoot() {
        return root;
    }
}
