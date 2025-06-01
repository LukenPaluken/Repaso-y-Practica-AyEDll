package practica_cola_cprio_est2;

public class Main {
    public static void main(String[] args) {
        ColaConPrioridadTDA cola = new ColaConPrioridad();
        cola.inicializarCola();

        // Cargamos la cola con elementos de distintas prioridades
        cola.acolarPrioridad(50, 4);
        cola.acolarPrioridad(20, 2);
        cola.acolarPrioridad(70, 1); // Mayor prioridad
        cola.acolarPrioridad(90, 5); // Menor prioridad

        // Mostramos y eliminamos los elementos uno por uno
        System.out.println("Elementos en orden de prioridad (de mayor a menor):");
        while (!cola.colaVacia()) {
            System.out.println("Valor: " + cola.primero() + " | Prioridad: " + cola.prioridad());
            cola.desacolar();
        }
    }
}
