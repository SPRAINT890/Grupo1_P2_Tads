package uy.edu.um.prog2.adt.MyMergeSort;

public class main {
    public static void main(String[] args) {
        Integer[] arr = {5, 2, 9, 1, 3, 6};
        MergeSortImpl<Integer> mergesort = new MergeSortImpl<>();
        mergesort.mergesort(arr);
        for (Integer num : arr) {
            System.out.println(num);
        }
    }
}
