package practica_cola_cprio_est2;

public class ColaConPrioridad implements ColaConPrioridadTDA {

    // Clase interna que representa un elemento con valor y prioridad.
    public class Elemento {
        int valor;
        int prioridad;
    }

    Elemento[] elementos; // Arreglo que almacena objetos de tipo Elemento.
    int indice; // Cantidad actual de elementos en la cola.

    @Override
    public void inicializarCola() {
        elementos = new Elemento[100];
        indice = 0;
    }

    @Override
    public void acolarPrioridad(int x, int prioridad) {
        // Inserta el nuevo elemento en la posición correcta según su prioridad.
        // Prioridades más bajas (ej: 1) tienen más prioridad que las más altas (ej: 5).
        int j = indice;
        for (; j > 0 && elementos[j - 1].prioridad >= prioridad; j--) {
            elementos[j] = elementos[j - 1]; // Desplaza elementos hacia la derecha.
        }

        // Creamos el nuevo elemento y lo insertamos en la posición encontrada.
        elementos[j] = new Elemento();
        elementos[j].valor = x;
        elementos[j].prioridad = prioridad;
        indice++;
    }

    @Override
    public void desacolar() {
        // Elimina el último elemento (el de mayor prioridad lógica).
        elementos[indice - 1] = null;
        indice--;
    }

    @Override
    public int primero() {
        // Devuelve el valor del elemento con mayor prioridad (último en el arreglo).
        return elementos[indice - 1].valor;
    }

    @Override
    public int prioridad() {
        // Devuelve la prioridad del elemento con mayor prioridad.
        return elementos[indice - 1].prioridad;
    }

    @Override
    public boolean colaVacia() {
        return indice == 0;
    }
}
