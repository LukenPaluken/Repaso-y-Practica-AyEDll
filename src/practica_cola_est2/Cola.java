package practica_cola_est2;

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
        // Inserta el nuevo elemento al final lógico de la cola (posición inx).
        // Este método no sobreescribe ningún valor ya existente (salvo que superes la capacidad).
        arr[inx] = x;
        inx++;
    }

    @Override
    public void desacolar() {
        // Desplaza todos los elementos una posición hacia la izquierda,
        // eliminando así el primer elemento (arr[0]) de la cola.
        for (int i = 0; i < inx - 1; i++) {
            arr[i] = arr[i + 1];
        }
        inx--; // Decrementa la cantidad de elementos.
    }

    @Override
    public int primero() {
        // El primer elemento de la cola está siempre en arr[0].
        return arr[0];
    }

    @Override
    public boolean vacio() {
        return inx == 0;
    }
}
