import java.util.*;
public class ejercicio2 {
    public static void main(String[] args) {
        float arr [] = {5.12f,7.27f,9.14f,2.17f,6.12f,4.14f,4.13f,17.46f,17.01f};
        
        quicksort(arr,0 ,arr.length-1);
        for (float num : arr) {
            System.out.print(num + " ");
        }
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
        

        }
    }
}