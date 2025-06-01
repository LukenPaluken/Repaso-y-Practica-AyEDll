package practica_conjunto;

public class Conjunto implements ConjuntoTDA {
    int[] a;    // Arreglo donde se almacenan los elementos del conjunto.
    int cant;   // Cantidad actual de elementos en el conjunto.

    @Override
    public void inicializarConjunto() {
        a = new int[100];
        cant = 0;
    }

    @Override
    public void agregar(int x) {
        // Agrega un elemento solo si no pertenece al conjunto (evita duplicados).
        if (!this.pertenece(x)) {
            a[cant] = x; // Se agrega el nuevo valor al final del conjunto.
            cant++;
        }
    }

    @Override
    public void sacar(int x) {
        // Busca el elemento x en el arreglo.
        int i = 0;
        while (i < cant && a[i] != x) {
            i++;
        }

        // Si se encuentra, se reemplaza con el último elemento para evitar dejar huecos.
        if (i < cant) {
            a[i] = a[cant - 1]; // Mueve el último elemento a la posición eliminada.
            cant--;             // Disminuye la cantidad de elementos.
        }
    }

    @Override
    public int elegir() {
        // Devuelve un elemento arbitrario del conjunto (en este caso, el último).
        return a[cant - 1];
    }

    @Override
    public boolean pertenece(int x) {
        // Recorre el arreglo buscando el elemento x.
        int i = 0;
        while (i < cant && a[i] != x) {
            i++;
        }
        
        return i < cant; // Retorna true si se encontró, false en caso contrario.
    }

    @Override
    public boolean conjuntoVacio() {
        return cant == 0;
    }
}
