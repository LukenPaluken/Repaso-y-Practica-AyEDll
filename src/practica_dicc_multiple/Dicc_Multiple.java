package practica_dicc_multiple;

import practica_conjunto.Conjunto;
import practica_conjunto.ConjuntoTDA;

public class Dicc_Multiple implements Dicc_Multiple_TDA {

    // Clase interna que representa un elemento del diccionario:
    // una clave asociada a un conjunto de valores.
    class Elemento {
        int clave;
        int[] valores;     // Lista de valores asociados a la clave.
        int cantValores;   // Cantidad actual de valores.
    }

    Elemento[] elementos;  // Arreglo que almacena las claves y sus valores.
    int cantClaves;        // Cantidad de claves actuales en el diccionario.

    @Override
    public void inicializarDiccionario() {
        elementos = new Elemento[100];
        cantClaves = 0;
    }

    @Override
    public void agregar(int clave, int valor) {
        int posC = clave2Indice(clave);
        
        // Si la clave no existe, se crea.
        if (posC == -1) {
            posC = cantClaves;
            elementos[posC] = new Elemento();
            elementos[posC].clave = clave;
            elementos[posC].cantValores = 0;
            elementos[posC].valores = new int[100];
            cantClaves++;
        }

        Elemento e = elementos[posC];

        // Si el valor no existe aún para esa clave, se agrega.
        int posV = valor2Indice(e, valor);
        if (posV == -1) {
            e.valores[e.cantValores] = valor;
            e.cantValores++;
        }
    }

    @Override
    public void eliminar(int clave) {
        int pos = clave2Indice(clave);
        if (pos != -1) {
            elementos[pos] = elementos[cantClaves - 1]; // Reemplaza con el último.
            cantClaves--;
        }
    }

    @Override
    public void eliminarValor(int clave, int valor) {
        int posC = clave2Indice(clave);
        if (posC != -1) {
            Elemento e = elementos[posC];
            int posV = valor2Indice(e, valor);

            if (posV != -1) {
                // Reemplaza el valor por el último y reduce la cantidad.
                e.valores[posV] = e.valores[e.cantValores - 1];
                e.cantValores--;

                // Si no quedan valores asociados a la clave, se elimina la clave.
                if (e.cantValores == 0) {
                    eliminar(clave);
                }
            }
        }
    }

    @Override
    public ConjuntoTDA recuperar(int clave) {
        ConjuntoTDA c = new Conjunto();
        c.inicializarConjunto();

        int pos = clave2Indice(clave);
        if (pos != -1) {
            Elemento e = elementos[pos];
            for (int i = 0; i < e.cantValores; i++) {
                c.agregar(e.valores[i]);
            }
        }

        return c;
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA c = new Conjunto();
        c.inicializarConjunto();

        for (int i = 0; i < cantClaves; i++) {
            c.agregar(elementos[i].clave);
        }

        return c;
    }

    // Retorna el índice de la clave en el arreglo o -1 si no existe.
    private int clave2Indice(int clave) {
        int i = cantClaves - 1;
        while (i >= 0 && elementos[i].clave != clave) {
            i--;
        }
        return i;
    }

    // Retorna el índice del valor dentro del arreglo de valores de un Elemento o -1 si no está.
    private int valor2Indice(Elemento e, int valor) {
        int i = e.cantValores - 1;
        while (i >= 0 && e.valores[i] != valor) {
            i--;
        }
        return i;
    }
}
