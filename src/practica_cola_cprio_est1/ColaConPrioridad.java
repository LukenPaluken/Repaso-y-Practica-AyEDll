package practica_cola_cprio_est1;

public class ColaConPrioridad implements ColaConPrioridadTDA {
    int[] elementos;
    int[] prioridades;
    int indice;

    @Override
    public void inicializarCola() {
        // 'elementos' guarda los valores reales.
        // 'prioridades' guarda las prioridades asociadas a cada valor.
        // Ambos arreglos están sincronizados por índice: elementos[i] tiene la prioridad prioridades[i].
        // 'indice' representa la cantidad actual de elementos en la cola.
        elementos = new int[100];
        prioridades = new int[100];
        indice = 0;
    }

    @Override
    public void acolarPrioridad(int x, int prioridad) {
        // Inserta el nuevo valor 'x' en la posición correcta según su prioridad (orden ascendente).
        // Prioridades menores significan mayor prioridad (1 es más prioritario que 5).
        int j = indice;
        for (; j > 0 && prioridades[j - 1] >= prioridad; j--) {
            elementos[j] = elementos[j - 1];
            prioridades[j] = prioridades[j - 1];
            ;
        }
        elementos[j] = x;            // Inserta el valor en la posición ordenada.
        prioridades[j] = prioridad;  // Inserta su prioridad correspondiente.
        indice++;                    // Aumenta el contador total de elementos.
    }

    @Override
    public void desacolar() {
        // Elimina el elemento con mayor prioridad (último en el arreglo).
        indice--;
    }

    @Override
    public int primero() {
        // Devuelve el elemento con mayor prioridad (el que está más al final).
        return elementos[indice - 1];
    }

    @Override
    public int prioridad() {
        // Devuelve la prioridad del elemento con mayor prioridad.
        return prioridades[indice - 1];
    }

    @Override
    public boolean colaVacia() {
        return indice == 0;
    }
}
