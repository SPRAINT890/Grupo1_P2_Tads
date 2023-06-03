package uy.edu.um.prog2.adt.MyBinarySearchTree;

public class main {
    public static void main(String[] args) {
        BinarySearchTreeImpl<Integer, String> bst = new BinarySearchTreeImpl<>();
        bst.insert(5, "Apple");
        bst.insert(2, "Banana");
        bst.insert(7, "Orange");
        bst.insert(1, "Grape");
        bst.insert(4, "Mango");

        bst.delete(1);
        System.out.println();

    }
}
