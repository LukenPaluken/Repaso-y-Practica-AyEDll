package practica_dicc_multiple_din;

import practica_conjunto.Conjunto;

public class Dicc_Multiple implements Dicc_Multiple_TDA {

    // Nodo para las claves
    class NodoClave {
        int clave;
        NodoValor valores; // Lista de valores asociados a la clave
        NodoClave sigClave; // Siguiente nodo de clave
    }

    // Nodo para los valores
    class NodoValor {
        int valor;
        NodoValor sigValor; // Siguiente valor en la lista
    }

    NodoClave origen; // Puntero al primer nodo de clave

    // Inicializa el diccionario vacío
    public void inicializarDiccionario() {
        origen = null;
    }

    // Agrega un valor a una clave
    public void agregar(int clave, int valor) {
        NodoClave nc = clave2NodoClave(clave);

        // Si no existe la clave, se crea
        if (nc == null) {
            nc = new NodoClave();
            nc.clave = clave;
            nc.sigClave = origen;
            origen = nc;
        }

        // Verificar si el valor ya está
        NodoValor aux = nc.valores;
        while (aux != null && aux.valor != valor) {
            aux = aux.sigValor;
        }

        // Si no estaba, lo agregamos al inicio
        if (aux == null) {
            NodoValor nv = new NodoValor();
            nv.valor = valor;
            nv.sigValor = nc.valores;
            nc.valores = nv;
        }
    }

    // Elimina todos los valores de una clave (elimina la clave entera)
    public void eliminar(int clave) {
        if (origen != null) {
            if (origen.clave == clave) {
                origen = origen.sigClave;
            } else {
                NodoClave aux = origen;
                while (aux.sigClave != null && aux.sigClave.clave != clave) {
                    aux = aux.sigClave;
                }
                if (aux.sigClave != null) {
                    aux.sigClave = aux.sigClave.sigClave;
                }
            }
        }
    }

    // Elimina un valor específico de una clave
    public void eliminarValor(int clave, int valor) {
        if (origen != null) {
            if (origen.clave == clave) {
                EliminarValorEnNodo(origen, valor);
                if (origen.valores == null) {
                    origen = origen.sigClave;
                }
            } else {
                NodoClave aux = origen;
                while (aux.sigClave != null && aux.sigClave.clave != clave) {
                    aux = aux.sigClave;
                }
                if (aux.sigClave != null) {
                    EliminarValorEnNodo(aux.sigClave, valor);
                    if (aux.sigClave.valores == null) {
                        aux.sigClave = aux.sigClave.sigClave;
                    }
                }
            }
        }
    }

    // Recupera los valores asociados a una clave
    public Conjunto recuperar(int clave) {
        NodoClave n = clave2NodoClave(clave);
        Conjunto c = new Conjunto(); // Implementación de conjunto dinámico
        c.inicializarConjunto();

        if (n != null) {
            NodoValor aux = n.valores;
            while (aux != null) {
                c.agregar(aux.valor);
                aux = aux.sigValor;
            }
        }
        return c;
    }

    // Devuelve todas las claves existentes
    public Conjunto claves() {
        Conjunto c = new Conjunto();
        c.inicializarConjunto();
        NodoClave aux = origen;

        while (aux != null) {
            c.agregar(aux.clave);
            aux = aux.sigClave;
        }
        return c;
    }

    // Método auxiliar: busca el nodo que contiene una clave
    private NodoClave clave2NodoClave(int clave) {
        NodoClave aux = origen;
        while (aux != null && aux.clave != clave) {
            aux = aux.sigClave;
        }
        return aux;
    }

    // Método auxiliar: elimina un valor dentro de la lista de valores de un nodo clave
    private void EliminarValorEnNodo(NodoClave nc, int valor) {
        if (nc.valores != null) {
            // Si el valor está al inicio
            if (nc.valores.valor == valor) {
                nc.valores = nc.valores.sigValor;
            } else {
                NodoValor aux = nc.valores;
                while (aux.sigValor != null && aux.sigValor.valor != valor) {
                    aux = aux.sigValor;
                }
                if (aux.sigValor != null) {
                    aux.sigValor = aux.sigValor.sigValor;
                }
            }
        }
    }
}
