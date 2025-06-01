package practica_cola_cprio_est1;

public class Main {
    public static void main(String[] args) {
        ColaConPrioridadTDA cola = new ColaConPrioridad();
        cola.inicializarCola();

        cola.acolarPrioridad(100, 3);  // menor prioridad
        cola.acolarPrioridad(200, 1);  // mayor prioridad
        cola.acolarPrioridad(300, 2);

        System.out.println("Elementos en orden de prioridad (de menor a mayor):");
        while (!cola.colaVacia()) {
            System.out.println("Valor: " + cola.primero() + " | Prioridad: " + cola.prioridad());
            cola.desacolar();
        }
    }

}