package Ejercicio4;

import Ejercicio1.Estudiante;

public class ejercicio4 {
    public static void main(String[] args) {
        
    }
    public static void mergeSort(Estudiante[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2; //punto medio
            mergeSort(arr, izquierda, medio); //ordenando la primera mitad
            mergeSort(arr, medio + 1, derecha); //ordenando la segunda mitad
            merge(arr, izquierda, medio, derecha); //uniendo las dos mitades ordenadas
        }
    }
    public static void merge(Estudiante[] arr, int izquierda, int medio, int derecha) {
        int numeroElementosIzquierda = medio - izquierda + 1; //se incluye el elemento del medio
        int numeroElementosDerecha = derecha - medio;

        Estudiante[] L = new Estudiante[numeroElementosIzquierda]; //array temporal
        Estudiante[] R = new Estudiante[numeroElementosDerecha]; //array temporal

        for (int i = 0; i < numeroElementosIzquierda; i++) //llenando los arrays temporales
            L[i] = arr[izquierda + i];
        for (int j = 0; j < numeroElementosDerecha; j++) //llenando los arrays temporales
            R[j] = arr[medio + 1 + j];

        int i = 0, j = 0;
        int k = izquierda;
        while (i < numeroElementosIzquierda && j < numeroElementosDerecha) { //Mientras haya elementos en ambos arrays
            if (L[i].getPromedio() <= R[j].getPromedio()) { //comparando los elementos de ambos arrays
            // Si L[i] tiene promedio menor o igual, se copia L[i] en arr[k] y se avanza i.
            // Si R[j] tiene promedio menor, se copia R[j] y se avanza j.
                arr[k] = L[i];
                i++;
            } 
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < numeroElementosIzquierda) { //copiando los elementos restantes de L[], si es que hay
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < numeroElementosDerecha) { // copiando los elementos restantes de R[], si es que hay
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void quicksort2(float arr[], int inferior,int techo){
        if(inferior<techo){
            int pivot = partir2(arr,inferior,techo);

            quicksort2(arr, inferior, pivot);     
            quicksort2(arr, pivot + 1, techo);
        }
    }
    public static int partir2(float arr[], int inferior, int techo){
        int indiceAleatorio = (int) (Math.random()*(techo - inferior + 1)) + inferior; //indice aletorio
        float pivote = arr[indiceAleatorio];
        

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
            float temp = arr[inferior];
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

}
