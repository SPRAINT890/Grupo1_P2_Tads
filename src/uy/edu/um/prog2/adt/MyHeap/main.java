package uy.edu.um.prog2.adt.MyHeap;

public class main {
    public static void main(String[] args) {
        HeapImpl<Integer, Integer> heap = new HeapImpl<>(1);
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
        System.out.println(heap.extractMax());
        System.out.println();
    }
}
