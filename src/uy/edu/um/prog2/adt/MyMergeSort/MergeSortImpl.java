package uy.edu.um.prog2.adt.MyMergeSort;

public class MergeSortImpl <V extends Comparable<V>> {
    public void mergesort(V[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // El arreglo ya está ordenado o es vacío
        }

        V[] aux = (V[]) new Comparable[arr.length]; // Arreglo auxiliar para almacenar los valores combinados
        mergesort(arr, aux, 0, arr.length - 1);
    }

    private void mergesort(V[] arr, V[] aux, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergesort(arr, aux, low, mid); // Ordenar la mitad izquierda
            mergesort(arr, aux, mid + 1, high); // Ordenar la mitad derecha
            merge(arr, aux, low, mid, high); // Combinar las dos mitades ordenadas
        }
    }

    private void merge(V[] arr, V[] aux, int low, int mid, int high) {
        // Copiar los elementos a ordenar al arreglo auxiliar
        for (int i = low; i <= high; i++) {
            aux[i] = arr[i];
        }

        int i = low; // Índice para la mitad izquierda del arreglo auxiliar
        int j = mid + 1; // Índice para la mitad derecha del arreglo auxiliar
        int k = low; // Índice para el arreglo original

        // Combinar las dos mitades ordenadas en el arreglo original
        while (i <= mid && j <= high) {
            if (aux[i].compareTo(aux[j]) <= 0) {
                arr[k] = aux[i];
                i++;
            } else {
                arr[k] = aux[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes de la mitad izquierda (si los hay)
        while (i <= mid) {
            arr[k] = aux[i];
            i++;
            k++;
        }

        // No es necesario copiar los elementos restantes de la mitad derecha,
        // ya que si quedan, ya están en su posición correcta en el arreglo original
    }
}
