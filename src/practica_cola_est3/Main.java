package practica_cola_est3;

public class Main {
    public static void main(String[] args) {
        ColaTDA cola = new Cola();
        cola.inicializarCola();

        System.out.println("¿Cola vacía? " + cola.vacio());

        System.out.println("\nAcolando valores: 10, 20, 30");
        cola.acolar(10);
        mostrarCola((Cola) cola); // Casteo para poder acceder al arreglo interno

        cola.acolar(20);
        mostrarCola((Cola) cola);

        cola.acolar(30);
        mostrarCola((Cola) cola);

        System.out.println("\nPrimer elemento (FIFO): " + cola.primero());

        System.out.println("\nDesacolando un elemento...");
        cola.desacolar();
        mostrarCola((Cola) cola);

        System.out.println("\nPrimer elemento (FIFO): " + cola.primero());

        System.out.println("\n¿Cola vacía? " + cola.vacio());
    }

    // Función auxiliar para mostrar el estado interno de la cola
    public static void mostrarCola(Cola cola) {
        System.out.print("Cola actual (de arr[1] a arr[arr[0]]): [ ");
        for (int i = 1; i <= cola.arr[0]; i++) {
            System.out.print(cola.arr[i] + " ");
        }
        System.out.println("]");
        System.out.println("Cantidad de elementos (arr[0]): " + cola.arr[0]);
        System.out.println("Primer elemento lógico (FIFO): " + cola.arr[cola.arr[0]]);
        System.out.println("---");
    }
}
