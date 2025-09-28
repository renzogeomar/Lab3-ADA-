#include <iostream>
#include "Producto.h"
#include <fstream>
#include <vector>
#include <string>
using namespace std;

int main(){

}

void mergeSort(vector<Producto>& arr, int izquierda, int derecha) {
    if (izquierda < derecha) {
        int medio = (izquierda + derecha) / 2;
        mergeSort(arr, izquierda, medio);
        mergeSort(arr, medio + 1, derecha);
        merge(arr, izquierda, medio, derecha);
    }
}

void merge(vector<Producto>& arr, int izquierda, int medio, int derecha) {
    int n1 = medio - izquierda + 1;
    int n2 = derecha - medio;

    vector<Producto> L(n1);
    vector<Producto> R(n2);

    for (int i = 0; i < n1; i++)
        L[i] = arr[izquierda + i];
    for (int j = 0; j < n2; j++)
        R[j] = arr[medio + 1 + j];

    int i = 0, j = 0, k = izquierda;

    while (i < n1 && j < n2) {
        // Orden descendente por precio
        if (L[i].precio >= R[j].precio) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

