package MyBinarySearchTree;

public class main {
    public static void main(String[] args) {
        BinarySearchTreeImpl<Integer, String> bst = new BinarySearchTreeImpl<>();
        bst.insert(5, "Apple");
        bst.insert(2, "Banana");
        bst.insert(7, "Orange");
        bst.insert(1, "Grape");
        bst.insert(4, "Mango");

        System.out.println(bst.find(5));
        System.out.println("In-Order:");
        bst.inOrder();
        System.out.println("Pre-Order:");
        bst.preOrder();
        System.out.println("Post-Order:");
        bst.postOrder();

    }
}
