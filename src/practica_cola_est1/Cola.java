package practica_cola_est1;

public class Cola implements ColaTDA {
    int[] arr;
    int inx;

    @Override
    public void inicializarCola() {
        arr = new int[100];
        inx = 0;
    }

    @Override
    public void acolar(int x) {
        // Nota: esta implementación inserta los elementos nuevos al principio del arreglo (posición 0),
        // lo que provoca que el primer elemento agregado quede al final (en arr[inx - 1]).
        
        // Desplaza todos los elementos una posición a la derecha para hacer lugar en arr[0]
        for (int i = inx - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        
        arr[0] = x; // Inserta el nuevo elemento en el inicio (posición 0)
        inx++; // Incrementa la cantidad de elementos en la cola
    }

    @Override
    public void desacolar() {
        // Como los elementos más antiguos están al final del arreglo,
        // solo se reduce 'inx' para ignorar el último valor (arr[inx - 1])
        inx--;
    }

    @Override
    public int primerElemento() {
        // El primer elemento en orden FIFO está al final del arreglo (posición inx - 1)
        return arr[inx - 1];
    }

    @Override
    public boolean colaVacia() {
        return (inx == 0);
    }
}
