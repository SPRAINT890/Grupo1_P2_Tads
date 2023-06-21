package uy.edu.um.prog2.adt.MyBinarySearchTree;

import uy.edu.um.prog2.adt.MyLinkedlistSimple.LinkedListSimpleImpl;
import uy.edu.um.prog2.adt.Nodos.NodeBT;

public class main {
    public static void main(String[] args) {
        BinarySearchTreeImpl<Integer, String> bst = new BinarySearchTreeImpl<>();
        bst.insert(30, "1");
        bst.insert(20, "2");
        bst.insert(39, "3");
        bst.insert(10, "4");
        bst.insert(15, "5");
        bst.insert(25, "6");
        bst.insert(23, "7");
        bst.insert(35, "8");
        bst.insert(42, "9");

        LinkedListSimpleImpl<NodeBT> order = new LinkedListSimpleImpl<>();
        order = bst.postOrder();
        for (int i = 0; i<order.size; i++){
            System.out.println(order.get(i).getKey() + " " + order.get(i).getValue() );
        }
        System.out.println(" ");
        order = bst.preOrder();
        for (int i = 0; i<order.size; i++){
            System.out.println(order.get(i).getKey() + " " + order.get(i).getValue() );
        }
        /*
        * Pre-order traversal
        * 30, 20, 10, 15, 25, 23, 39, 35, 42.
        *
        * In-order traversal
        * 10, 15, 20, 23, 25, 30, 35, 39, 42.
        *
        * Post-order traversal
        * 15, 10, 23, 25, 20, 35, 42, 39, 30
        * */

    }
}
