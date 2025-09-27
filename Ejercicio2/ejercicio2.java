import java.util.*;
public class ejercicio2 {
    public static void main(String[] args) {
        float arr [] = {5.12f,7.27f,9.14f,2.17f,6.12f,4.14f,4.13f,17.46f,17.01f};
        
        System.out.println("Pivot - Medio");
        quicksort(arr,0 ,arr.length-1);
        for (float num : arr) {
            System.out.print(num + " ");
        }
        
        float arr2 [] = {5.12f,7.27f,9.14f,2.17f,6.12f,4.14f,4.13f,17.46f,17.01f};
        System.out.println("\nPivot - aleatorio");
        quicksort2(arr2,0 ,arr.length-1);

        for (float num : arr2) {
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
        int indiceMedio = (inferior + techo)/2; //indice del medio
        float pivote = arr[indiceMedio];
        
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
}