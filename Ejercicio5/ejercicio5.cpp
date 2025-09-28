#include <iostream>
#include "Producto.h"
#include <fstream>
#include <vector>
#include <string>
using namespace std;

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

void mergeSort(vector<Producto>& arr, int izquierda, int derecha) {
    if (izquierda < derecha) {
        int medio = (izquierda + derecha) / 2;
        mergeSort(arr, izquierda, medio);
        mergeSort(arr, medio + 1, derecha);
        merge(arr, izquierda, medio, derecha);
    }
}

int particion(vector<Producto>& arr, int inferior, int techo) {
    // Escoger índice aleatorio entre inferior y techo
    int indiceAleatorio = rand() % (techo - inferior + 1) + inferior;
    double pivote = arr[indiceAleatorio].precio;

    while (true) {
        // Mover puntero izquierdo hacia la derecha mientras el precio sea MAYOR al pivote (descendente)
        while (arr[inferior].precio > pivote) {
            inferior++;
        }
        // Mover puntero derecho hacia la izquierda mientras el precio sea MENOR al pivote
        while (arr[techo].precio < pivote) {
            techo--;
        }

        // Si los punteros se cruzan o se encuentran, devolvemos techo
        if (inferior >= techo) {
            return techo;
        }

        // Intercambiar elementos en posiciones inferior y techo
        swap(arr[inferior], arr[techo]);

        // Seguir moviendo
        inferior++;
        techo--;
    }
}

void quickSort(vector<Producto>& arr, int bajo, int alto) {
    if (bajo < alto) {
        int pi = particion(arr, bajo, alto);
        quickSort(arr, bajo, pi - 1);
        quickSort(arr, pi + 1, alto);
    }
}

int main(){
    ifstream archivo("../productos.txt");
    if (!archivo.is_open()) { 
        cerr << "Error al abrir el archivo!" << endl;
        return 1;
    }

    vector<Producto> productos;
    Producto p;

    while (archivo >> p.codigo >> p.nombre >> p.precio) { // Leer hasta EOF
        productos.push_back(p);
    }
    archivo.close();

    // Copias del mismo vector para probar ambos algoritmos
    vector<Producto> productosMerge = productos;
    vector<Producto> productosQuick = productos;

    // Ordenar con MergeSort
    mergeSort(productosMerge, 0, productosMerge.size() - 1);

    // Ordenar con QuickSort
    quickSort(productosQuick, 0, productosQuick.size() - 1);

    cout << "=== Ordenado con MergeSort ===" << endl; // Mostrar resultados
    for (auto& prod : productosMerge) {
        cout << prod.codigo << " " << prod.nombre << " " << prod.precio << endl;
    }

    cout << "\n=== Ordenado con QuickSort ===" << endl;
    for (auto& prod : productosQuick) {
        cout << prod.codigo << " " << prod.nombre << " " << prod.precio << endl;
    }

    return 0;

}



