package uy.edu.um.prog2.adt.MyBinarySearchTree;

import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.Exceptions.KeyNotFound;
import uy.edu.um.prog2.adt.MyLinkedlistSimple.LinkedListSimpleImpl;
import uy.edu.um.prog2.adt.Nodos.NodeBT;

import static org.junit.jupiter.api.Assertions.*;
class BinarySearchTreeImplTest {
    BinarySearchTreeImpl<Integer, String> bst = new BinarySearchTreeImpl<>();
    @Test
    void insertUnValor() throws KeyNotFound {
        bst.insert(1,"1");
        assertEquals(bst.find(1),1);
    }
    @Test
    void insertVariosValores(){
        bst.insert(30, "1");
        bst.insert(20, "2");
        bst.insert(39, "3");
        bst.insert(10, "4");
        bst.insert(15, "5");
        bst.insert(25, "6");
        bst.insert(23, "7");
        bst.insert(35, "8");
        bst.insert(42, "9");
        assertEquals(bst.preOrder().get(0).getKey(),30);
        assertEquals(bst.preOrder().get(1).getKey(),20);
        assertEquals(bst.preOrder().get(2).getKey(),10);
        assertEquals(bst.preOrder().get(3).getKey(),15);
        assertEquals(bst.preOrder().get(4).getKey(),25);
        assertEquals(bst.preOrder().get(5).getKey(),23);
        assertEquals(bst.preOrder().get(6).getKey(),39);
        assertEquals(bst.preOrder().get(7).getKey(),35);
        assertEquals(bst.preOrder().get(8).getKey(),42);
    }
    @Test
    void deleteUnElemento() throws KeyNotFound {
        bst.insert(1, "1");
        bst.delete(1);
        try {
            bst.find(1);
            assertTrue(false);
        }catch (KeyNotFound e){
            assertTrue(true);
        }
    }

    @Test
    void deleteVariosElementos() throws KeyNotFound {
        bst.insert(1, "10");
        bst.insert(30, "1");
        bst.insert(20, "2");
        bst.insert(39, "3");
        bst.insert(10, "4");
        bst.insert(15, "5");
        bst.insert(2, "11");
        bst.insert(25, "6");
        bst.insert(23, "7");
        bst.insert(35, "8");
        bst.insert(42, "9");
        bst.delete(1);
        bst.delete(2);
        assertEquals(bst.postOrder().get(0).getKey(),15);
        assertEquals(bst.postOrder().get(1).getKey(),10);
        assertEquals(bst.postOrder().get(2).getKey(),23);
        assertEquals(bst.postOrder().get(3).getKey(),25);
        assertEquals(bst.postOrder().get(4).getKey(),20);
        assertEquals(bst.postOrder().get(5).getKey(),35);
        assertEquals(bst.postOrder().get(6).getKey(),42);
        assertEquals(bst.postOrder().get(7).getKey(),39);
        assertEquals(bst.postOrder().get(8).getKey(),30);
    }
}