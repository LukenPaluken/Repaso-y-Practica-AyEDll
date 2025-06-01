package practica_pila_est2;

public class Pila implements PilaTDA {
    int[] a;       // Arreglo que almacena los elementos de la pila.
    int indice;    // Cantidad de elementos en la pila.

    @Override
    public void inicializarPila() {
        a = new int[100];
        indice = 0; // Inicialmente la pila está vacía.
    }

    @Override
    public void apilar(int x) {
        // Desplaza todos los elementos una posición a la derecha
        for (int i = indice - 1; i >= 0; i--) {
            a[i + 1] = a[i];
        }
        a[0] = x;   // Inserta el nuevo elemento en la cima.
        indice++;   // Aumenta el contador.
    }

    @Override
    public void desapilar() {
        // Desplaza todos los elementos una posición a la izquierda
        for (int i = 0; i < indice - 1; i++) {
            a[i] = a[i + 1];
        }
        indice--; // Disminuye el contador.
    }

    @Override
    public int tope() {
    	// Devuelve el primer valor de la pila.
        return a[0];
    }

    @Override
    public boolean pilaVacia() {
        return indice == 0;
    }
}
