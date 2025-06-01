package practica_pila_est1;

public class Pila implements PilaTDA {
    int[] a;       // Arreglo que almacena los elementos de la pila.
    int indice;    // Apunta a la próxima posición libre en la pila (también representa la cantidad de elementos).

    @Override
    public void inicializarPila() {
        a = new int[100];
        indice = 0; // Inicialmente no hay elementos en la pila.
    }

    @Override
    public void apilar(int x) {
        // Inserta el nuevo elemento en la posición actual de 'indice' y luego lo incrementa.
        a[indice] = x;
        indice++;
    }

    @Override
    public void desapilar() {
        // Elimina el último elemento agregado a la pila.
        // No es necesario borrar el valor del arreglo porque se sobrescribirá en la próxima inserción.
        indice--;
    }

    @Override
    public int tope() {
        // Devuelve el elemento en la cima de la pila (último agregado).
        return a[indice - 1];
    }

    @Override
    public boolean pilaVacia() {
        return indice == 0;
    }
}
