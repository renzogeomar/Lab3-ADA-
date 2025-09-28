package Ejercicio4;

import java.util.Random;

public class ejercicio4 {
    public static void main(String[] args) {
        int tamaño= 10000;
        int[] arr = generarArreglo(tamaño);
        long inicio = System.nanoTime();
        selectionSort(arr);
        long fin = System.nanoTime();
        System.out.println("Selection Sort - Tamaño: " + tamaño + "  Tiempo: " + (fin - inicio) / 1_000_000.0 + " ms");
        arr = generarArreglo(tamaño);
        inicio = System.nanoTime();
        insertionSort(arr);
        fin = System.nanoTime();
        System.out.println("Insertion Sort - Tamaño: " + tamaño + "  Tiempo: " + (fin - inicio) / 1_000_000.0 + " ms");
        arr = generarArreglo(tamaño);
        inicio = System.nanoTime();
        mergeSort(arr, 0, arr.length - 1);
        fin = System.nanoTime();
        System.out.println("Merge Sort - Tamaño: " + tamaño + "  Tiempo: " + (fin - inicio) / 1_000_000.0 + " ms");
        arr = generarArreglo(tamaño);
        inicio = System.nanoTime();
        quicksort2(arr,0 ,arr.length-1);
        fin = System.nanoTime();
        System.out.println("Quick Sort - Tamaño: " + tamaño + "  Tiempo: " + (fin - inicio) / 1_000_000.0 + " ms");
    }
    public static void mergeSort(int[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2; // punto medio
            mergeSort(arr, izquierda, medio); // ordenando la primera mitad
            mergeSort(arr, medio + 1, derecha); // ordenando la segunda mitad
            merge(arr, izquierda, medio, derecha); // uniendo las dos mitades ordenadas
        }
    }

    public static void merge(int[] arr, int izquierda, int medio, int derecha) {
        int numeroElementosIzquierda = medio - izquierda + 1; // se incluye el elemento del medio
        int numeroElementosDerecha = derecha - medio;

        int[] L = new int[numeroElementosIzquierda]; // array temporal para la izquierda
        int[] R = new int[numeroElementosDerecha]; // array temporal para la derecha

        // copiando los elementos a los arrays temporales
        for (int i = 0; i < numeroElementosIzquierda; i++) 
            L[i] = arr[izquierda + i];
        for (int j = 0; j < numeroElementosDerecha; j++) 
            R[j] = arr[medio + 1 + j];

        int i = 0, j = 0;
        int k = izquierda;

        // fusionando mientras haya elementos en ambos arrays
        while (i < numeroElementosIzquierda && j < numeroElementosDerecha) {
            if (L[i] <= R[j]) { 
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // copiando los elementos restantes de L[], si es que hay
        while (i < numeroElementosIzquierda) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // copiando los elementos restantes de R[], si es que hay
        while (j < numeroElementosDerecha) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void quicksort2(int arr[], int inferior,int techo){
        if(inferior<techo){
            int pivot = partir2(arr,inferior,techo);

            quicksort2(arr, inferior, pivot);     
            quicksort2(arr, pivot + 1, techo);
        }
    }
    public static int partir2(int arr[], int inferior, int techo){
        int indiceAleatorio = (int) (Math.random()*(techo - inferior + 1)) + inferior; //indice aletorio
        int pivote = arr[indiceAleatorio];
        

        while (true) {
            while (arr[inferior] < pivote) {
                inferior++;
            }
            while (arr[techo] > pivote) {
                techo--;
            }

            if (inferior >= techo) {
                return techo;
            }

            // Intercambiar
            int temp = arr[inferior];
            arr[inferior] = arr[techo];
            arr[techo] = temp;

            inferior++;
            techo--;
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Intercambio
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static int[] generarArreglo(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100000); // números entre 0 y 99,999
        }
        return arr;
    }

}
