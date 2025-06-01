package practica_pila_est2;

public class Main {
    public static void main(String[] args) {
        PilaTDA miPila = new Pila();
        miPila.inicializarPila();

        miPila.apilar(10);
        miPila.apilar(20);
        miPila.apilar(30);

        System.out.println("Tope: " + miPila.tope()); // Esperado: 30

        miPila.desapilar();
        System.out.println("Tope tras desapilar: " + miPila.tope()); // Esperado: 20

        while (!miPila.pilaVacia()) {
            System.out.println("Desapilando: " + miPila.tope());
            miPila.desapilar();
        }

        System.out.println("¿Pila vacía?: " + miPila.pilaVacia()); // Esperado: true
    }
}
