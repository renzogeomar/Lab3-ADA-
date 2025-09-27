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
    public static void mergeSort(Estudiante[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }


}