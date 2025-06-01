package practica_dicc_simple;

import practica_conjunto.Conjunto;
import practica_conjunto.ConjuntoTDA;

public class Dicc_Simple implements Dicc_Simple_TDA {

    // Clase interna que representa un par clave-valor.
    class Elemento {
        int clave;
        int valor;
    }

    Elemento[] elementos; // Arreglo de pares clave-valor.
    int cant;             // Cantidad de elementos actuales en el diccionario.

    @Override
    public void inicializarDiccionario() {
        elementos = new Elemento[100];
        cant = 0;
    }

    @Override
    public void agregar(int clave, int valor) {
        int pos = clave2Indice(clave);
        if (pos == -1) {
            // Si la clave no existe, agregamos un nuevo elemento.
            pos = cant;
            elementos[pos] = new Elemento(); // Instanciamos el nuevo objeto Elemento.
            elementos[pos].clave = clave;
            cant++;
        }

        // Si la clave ya existía o acabamos de crearla, actualizamos el valor.
        elementos[pos].valor = valor;
    }

    @Override
    public void eliminar(int clave) {
        int pos = clave2Indice(clave);
        if (pos != -1) {
            // Reemplazamos el elemento eliminado con el último para no dejar huecos.
            elementos[pos] = elementos[cant - 1];
            cant--;
        }
    }

    @Override
    public int recuperar(int clave) {
        int pos = clave2Indice(clave);
        return elementos[pos].valor;
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA c = new Conjunto();
        c.inicializarConjunto();
        for (int i = 0; i < cant; i++) {
            c.agregar(elementos[i].clave); // Agrega cada clave al conjunto.
        }
        return c;
    }

    private int clave2Indice(int clave) {
        int i = cant - 1;

        // Recorremos el arreglo de atrás hacia adelante hasta encontrar la clave buscada
        // o hasta llegar al inicio del arreglo (índice 0).
        while (i >= 0 && elementos[i].clave != clave) {
            i--;
        }

        return i;
    }

}
