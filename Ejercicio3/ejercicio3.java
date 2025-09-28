import java.util.Random;

public class ejercicio3 {
    public static void main(String[] args) {
        int tamaño = 100000;
        int[] arreglo = generarArregloAleatorio(tamaño);
        int elementoBuscado = arreglo[new Random().nextInt(tamaño)];

        int[] arregloOrdenado = new int[arreglo.length];


        for (int i = 0; i < arreglo.length; i++) {
            arregloOrdenado[i] = arreglo[i];
        }

        quicksort(arregloOrdenado, 0, arregloOrdenado.length - 1);

        int indiceBinaria = busquedaBinaria(arregloOrdenado, elementoBuscado);
    }

    public static int[] generarArregloAleatorio(int tamaño) {
        Random aleatorio = new Random();
        int[] arreglo = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = aleatorio.nextInt(tamaño * 10);
        }
        return arreglo;
    }

    public static void quicksort(int arr[], int inferior,int techo){
        if(inferior<techo){
            int pivot = partir(arr,inferior,techo);

            quicksort(arr, inferior, pivot);     
            quicksort(arr, pivot + 1, techo);
        }
    }
    public static int partir(int arr[], int inferior, int techo) {
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

    public static int busquedaBinaria(int[] arreglo, int objetivo) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;

            if (arreglo[medio] == objetivo) {
                return medio;
            } else if (arreglo[medio] < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return -1;
    }
}
