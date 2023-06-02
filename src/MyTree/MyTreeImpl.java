package MyTree;

import Nodos.NodeBT;


public class MyTreeImpl <K extends Comparable<K>, V> implements MyTree<K, V> {
    NodeBT root;

    @Override
    public void insert(K key, V data, K parentKey) {
        if (root == null){
            root = new NodeBT(key, data);
            return;
        }
        insertRecursive(root, new NodeBT(key, data), parentKey);
    }

    private boolean insertRecursive(NodeBT tempNode, NodeBT newNode, K parentKey){
        if (tempNode != null){
            if (parentKey == tempNode.getKey()){
                if (tempNode.getLeft() == null){
                    tempNode.setLeft(newNode);
                } else if (tempNode.getRight() == null) {
                    tempNode.setRight(newNode);
                }
                return true;
            }
            if (insertRecursive(tempNode.getLeft(), newNode, parentKey)){
                return true;
            }
            if (insertRecursive(tempNode.getRight(), newNode, parentKey)){
                return true;
            }
        }
        return false;
    }

    @Override
    public V find(K key) {
        if (root == null){
            return null;
        }

        NodeBT res = findRecursive(root, key);

        if (res == null) {
            return null;
        }

        return (V) res.getValue();
    }

    private NodeBT findRecursive(NodeBT tempNode, K key) {
        if (tempNode != null){
            if (tempNode.getKey() == key){
                return tempNode;
            }
            NodeBT left = findRecursive(tempNode.getLeft(), key);
            if (left != null){
                return left;
            }
            NodeBT right = findRecursive(tempNode.getRight(), key);
            if (right != null){
                return right;
            }
        }
        return null;
    }

    @Override
    public void delete(K key) {
        root = deleteRecursive(root, key);
    }

    private NodeBT deleteRecursive(NodeBT root, K key) {
        if (root == null) {
            return null;
        }

        int cmp = key.compareTo((K) root.getKey());
        if (cmp < 0) {
            root.setLeft(deleteRecursive(root.getLeft(), key));
        } else if (cmp > 0) {
            root.setRight(deleteRecursive(root.getRight(), key));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }

            NodeBT minNode = findMinNode(root.getRight());
            root.setKey(minNode.getKey());
            root.setValue(minNode.getValue());
            root.setRight(deleteRecursive(root.getRight(), (K) minNode.getKey()));
        }

        return root;
    }
    private NodeBT findMinNode(NodeBT node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }
    @Override
    public void inOrder() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(NodeBT node) {
        if (node != null) {
            inOrderRecursive(node.getLeft());
            System.out.println(node.getKey() + ": " + node.getValue());
            inOrderRecursive(node.getRight());
        }
    }
    @Override
    public void preOrder() {
        preOrderRecursive(root);
    }

    private void preOrderRecursive(NodeBT node) {
        if (node != null) {
            System.out.println(node.getKey() + ": " + node.getValue());
            preOrderRecursive(node.getLeft());
            preOrderRecursive(node.getRight());
        }
    }
    @Override
    public void postOrder() {
        postOrderRecursive(root);
    }

    private void postOrderRecursive(NodeBT node) {
        if (node != null) {
            postOrderRecursive(node.getLeft());
            postOrderRecursive(node.getRight());
            System.out.println(node.getKey() + ": " + node.getValue());
        }
    }
}
