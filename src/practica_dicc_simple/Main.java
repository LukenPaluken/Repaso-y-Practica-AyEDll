package practica_dicc_simple;

import practica_conjunto.ConjuntoTDA;

public class Main {
    public static void main(String[] args) {
        Dicc_Simple_TDA dicc = new Dicc_Simple();
        dicc.inicializarDiccionario();

        // Agregamos algunas claves con sus respectivos valores
        dicc.agregar(10, 100);
        dicc.agregar(20, 200);
        dicc.agregar(30, 300);

        // Modificamos el valor de una clave existente
        dicc.agregar(20, 250);

        // Recuperamos y mostramos valores
        System.out.println("Valor asociado a la clave 10: " + dicc.recuperar(10));
        System.out.println("Valor asociado a la clave 20: " + dicc.recuperar(20));
        System.out.println("Valor asociado a la clave 30: " + dicc.recuperar(30));

        // Eliminamos una clave
        dicc.eliminar(10);

        // Mostramos claves restantes
        System.out.println("Claves restantes en el diccionario:");
        ConjuntoTDA claves = dicc.claves();
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            System.out.println("Clave: " + clave);
            claves.sacar(clave);
        }
    }
}
