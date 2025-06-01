package practica_pila_est1;

public class Main {
    public static void main(String[] args) {
        PilaTDA pila = new Pila();
        pila.inicializarPila();

        // Apilamos algunos valores
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);

        // Mostramos y desapilamos los elementos
        System.out.println("Elementos desapilados (de último a primero):");
        while (!pila.pilaVacia()) {
            System.out.println("Tope: " + pila.tope());
            pila.desapilar();
        }
    }
}
