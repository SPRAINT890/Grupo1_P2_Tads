package MyBinarySearchTree;

import Nodos.NodeBST;

public class BinarySearchTreeImpl<K extends Comparable<K>, V> {
    private NodeBST root;

    public void insert(K key, V value) {
        root = insertN(root, key, value);
    }

    private NodeBST insertN(NodeBST node, K key, V value) {
        if (node == null) {
            return new NodeBST(key, value);
        }

        int cmp = key.compareTo((K) node.getKey());
        if (cmp < 0) {
            node.setLeft(insertN(node.getLeft(), key, value));
        } else if (cmp > 0) {
            node.setRight(insertN(node.getRight(), key, value));
        } else {
            node.setValue(value);
        }
        return node;
    }

    public V find(K key) {
        return (V) findN(root, key).getValue();
    }

    private NodeBST findN(NodeBST node, K key) {
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

    private NodeBST deleteN(NodeBST node, K key) {
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
                NodeBST minNode = min(node.getRight());
                node.setKey(minNode.getKey());
                node.setValue(minNode.getValue());
                node.setRight(deleteMin(node.getRight()));
            }
        }
        return node;
    }

    private NodeBST min(NodeBST node) {
        if (node.getLeft() == null) {
            return node;
        }
        return min(node.getLeft());
    }

    private NodeBST deleteMin(NodeBST node) {
        if (node.getLeft() == null) {
            return node.getRight();
        }
        node.setLeft(deleteMin(node.getLeft()));
        return node;
    }

    public void inOrder() {
        inOrderN(root);
    }

    private void inOrderN(NodeBST node) {
        if (node != null) {
            inOrderN(node.getLeft());
            System.out.println(node.getKey() + ": " + node.getValue());
            inOrderN(node.getRight());
        }
    }

    public void preOrder() {
        preOrderN(root);
    }

    private void preOrderN(NodeBST node) {
        if (node != null) {
            System.out.println(node.getKey() + ": " + node.getValue());
            preOrderN(node.getLeft());
            preOrderN(node.getRight());
        }
    }

    public void postOrder() {
        postOrderN(root);
    }

    private void postOrderN(NodeBST node) {
        if (node != null) {
            postOrderN(node.getLeft());
            postOrderN(node.getRight());
            System.out.println(node.getKey() + ": " + node.getValue());
        }
    }
}
