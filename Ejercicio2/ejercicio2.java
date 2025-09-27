import java.util.*;
public class ejercicio2 {
    public static void main(String[] args) {
        float arr [] = {5.12f,7.27f,9.14f,2.17f,6.12f,4.14f,4.13f,17.46f,17.01f};
        
        System.out.println("Pivot - Medio");
        quicksort(arr,0 ,arr.length-1);
        for (float num : arr) {
            System.out.print(num + " ");
        }

        System.out.println("Pivot - aleatorio");
        quicksort2(arr,0 ,arr.length-1);
    }

    public static void quicksort(float arr[], int inferior,int techo){
        if(inferior<techo){
            int pivot = partir(arr,inferior,techo);

            quicksort(arr, inferior, pivot);     
            quicksort(arr, pivot + 1, techo);
        }
    }
    public static int partir(float arr[], int inferior, int techo) {
        int medio = (inferior + techo)/2; //indice del medio
        float pivote = arr[medio];
        

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

    public static void quicksort2(float arr[], int inferior,int techo){

    }
    public static int partir2(float arr[], int inferior, int techo){
        return 1 ;
    }
}