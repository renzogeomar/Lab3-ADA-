package Ejercicio1;

public class ejercicio1{
    public static void main(String[] args) {
        Estudiante estudiates[] = new Estudiante[8];
        estudiates[0] = new Estudiante("Renzo", 18.5f, "A001");
        estudiates[1] = new Estudiante("Ana", 19.0f, "A002");
        estudiates[2] = new Estudiante("Luis", 17.5f, "A003");
        estudiates[3] = new Estudiante("Maria", 20.0f, "A004");
        estudiates[4] = new Estudiante("Carlos", 16.0f, "A005");
        estudiates[5] = new Estudiante("Sofia", 18.0f, "A006");
        estudiates[6] = new Estudiante("Jorge", 15.5f, "A007");
        estudiates[7] = new Estudiante("Lucia", 19.5f, "A008");

    }
    public static void mergeSort(Estudiante[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;
            mergeSort(arr, izquierda, medio);
            mergeSort(arr, medio + 1, derecha);
            merge(arr, izquierda, medio, derecha);
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
        while (i < numeroElementosIzquierda && j < numeroElementosDerecha) {
            if (L[i].getPromedio() <= R[j].getPromedio()) {
                arr[k] = L[i];
                i++;
            } 
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < numeroElementosIzquierda) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < numeroElementosDerecha) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


}