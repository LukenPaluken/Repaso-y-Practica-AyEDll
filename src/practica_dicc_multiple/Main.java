package practica_dicc_multiple;

import practica_conjunto.ConjuntoTDA;

public class Main {
    public static void main(String[] args) {
        Dicc_Multiple_TDA dicc = new Dicc_Multiple();
        dicc.inicializarDiccionario();

        // Agregamos claves con varios valores
        dicc.agregar(10, 1);
        dicc.agregar(10, 2);
        dicc.agregar(10, 3);
        dicc.agregar(20, 5);
        dicc.agregar(30, 100);
        dicc.agregar(30, 200);

        // Mostramos los valores asociados a la clave 10
        System.out.println("Valores para la clave 10:");
        imprimirConjunto(dicc.recuperar(10)); // Esperado: 1, 2, 3

        // Eliminamos un valor de la clave 10
        dicc.eliminarValor(10, 2);

        System.out.println("Valores para la clave 10 después de eliminar el 2:");
        imprimirConjunto(dicc.recuperar(10)); // Esperado: 1, 3

        // Eliminamos todos los valores de la clave 20 (queda vacía y se elimina la clave)
        dicc.eliminarValor(20, 5);

        // Verificamos claves actuales
        System.out.println("Claves actuales en el diccionario:");
        imprimirConjunto(dicc.claves()); // Esperado: 10, 30

        // Eliminamos la clave 30 completa
        dicc.eliminar(30);

        System.out.println("Claves después de eliminar la clave 30:");
        imprimirConjunto(dicc.claves()); // Esperado: 10
    }

    // Método auxiliar para imprimir un conjunto
    public static void imprimirConjunto(ConjuntoTDA conjunto) {
        while (!conjunto.conjuntoVacio()) {
            int elem = conjunto.elegir();
            System.out.print(elem + " ");
            conjunto.sacar(elem);
        }
        System.out.println();
    }
}
