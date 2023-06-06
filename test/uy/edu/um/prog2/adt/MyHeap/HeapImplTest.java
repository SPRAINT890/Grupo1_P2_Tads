package uy.edu.um.prog2.adt.MyHeap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapImplTest {
    HeapImpl<Integer, Integer> heap = new HeapImpl<>(1);
    @Test
    void insertUnValor(){
        heap.insert(1, 1);
        assertFalse(heap.is_empty());
        assertEquals(heap.extractMax(), 1);
        assertEquals(heap.size(), 0);
    }

    @Test
    void insertVariosVal(){
        heap.insert(1, 1);
        heap.insert(5, 5);
        heap.insert(3, 3);
        heap.insert(2, 2);
        heap.insert(4, 4);
        heap.insert(6, 6);
        heap.insert(7, 7);
        heap.insert(9, 9);
        heap.insert(10, 10);
        heap.insert(8, 8);
        assertEquals(heap.extractMax(), 10);
        assertEquals(heap.extractMax(), 9);
        assertEquals(heap.extractMax(), 8);
        assertEquals(heap.extractMax(), 7);
        assertEquals(heap.extractMax(), 6);
        assertEquals(heap.extractMax(), 5);
        assertEquals(heap.extractMax(), 4);
        assertEquals(heap.extractMax(), 3);
        assertEquals(heap.extractMax(), 2);
        assertEquals(heap.extractMax(), 1);
        assertTrue(heap.is_empty());
    }

}