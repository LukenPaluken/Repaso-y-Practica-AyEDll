package practica_cola_est1;

public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola();
        cola.inicializarCola();

        System.out.println("🔵 Encolando elementos:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("→ Encolando: " + i);
            cola.acolar(i);
            imprimirCola(cola);
        }

        System.out.println("\n🟡 Desacolar dos veces:");
        cola.desacolar();
        imprimirCola(cola);

        cola.desacolar();
        imprimirCola(cola);

        System.out.println("\n🔴 Intentar llenar la cola:");
        try {
            for (int i = 6; i <= 105; i++) {
                cola.acolar(i);
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // Método auxiliar para ver el estado interno del arreglo
    public static void imprimirCola(Cola cola) {
        System.out.print("Cola actual: ");
        for (int i = 0; i < cola.inx; i++) {
            System.out.print(cola.arr[i] + " ");
        }
        System.out.println("\nCantidad de elementos: " + cola.inx + "\n");
    }
}
