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

        //orden + busqueda binaria
        long inicioOrdenamiento = System.nanoTime();
        quicksort(arregloOrdenado, 0, arregloOrdenado.length - 1);
        long finOrdenamiento = System.nanoTime();

        long inicioBinaria = System.nanoTime();
        int indiceBinaria = busquedaBinaria(arregloOrdenado, elementoBuscado);
        long finBinaria = System.nanoTime();

        //busqueda secuencial
        long inicioSecuencial = System.nanoTime();
        int indiceSecuencial = busquedaSecuencial(arreglo, elementoBuscado);
        long finSecuencial = System.nanoTime();

        System.out.println("Elemento a buscar: " + elementoBuscado);
        System.out.println("Índice encontrado -> binaria: " + indiceBinaria);
        System.out.println("Índice encontrado -> secuencial: " + indiceSecuencial);

        //tiempo
        double tiempoOrdenamiento = (finOrdenamiento - inicioOrdenamiento) / 1e6;
        double tiempoBinaria = (finBinaria - inicioBinaria) / 1e6;
        double tiempoSecuencial = (finSecuencial - inicioSecuencial) / 1e6;

        System.out.println("\n--- Tiempos ---");
        System.out.printf("Ordenamiento (QuickSort): %.3f ms%n", tiempoOrdenamiento);
        System.out.printf("Búsqueda binaria: %.3f ms%n", tiempoBinaria);
        System.out.printf("Tiempo total (ordenamiento + binaria): %.3f ms%n", (tiempoOrdenamiento + tiempoBinaria));
        System.out.printf("Búsqueda secuencial (sin ordenar): %.3f ms%n", tiempoSecuencial);


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

    public static int busquedaSecuencial(int[] arreglo, int objetivo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }
}
