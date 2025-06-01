package practica_cola_est2;

public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola();
        cola.inicializarCola();

        System.out.println("🔵 Encolando elementos:");
        for (int i = 1; i <= 5; i++) {
            cola.acolar(i);
            System.out.println("→ Encolado: " + i);
            imprimirCola(cola);
        }

        System.out.println("\n🟡 Desacolar dos veces:");
        cola.desacolar();
        imprimirCola(cola);

        cola.desacolar();
        imprimirCola(cola);

        System.out.println("\n🔺 Primer elemento:");
        System.out.println("Primero en la cola: " + cola.primero());

        System.out.println("\n🟢 ¿Está vacía?");
        System.out.println("Cola vacía: " + cola.vacio());
    }

    public static void imprimirCola(Cola cola) {
        System.out.print("Cola actual: ");
        for (int i = 0; i < cola.inx; i++) {
            System.out.print(cola.arr[i] + " ");
        }
        System.out.println(" | Tamaño: " + cola.inx);
    }
}
