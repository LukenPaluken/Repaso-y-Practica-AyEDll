package practica_conjunto_din;

public class Conjunto implements ConjuntoTDA{
	private class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo primero;

	@Override
	public void inicializarConjunto() {
		primero = null;
	}

	@Override
	public void agregar(int x) {
		// Agrega el nodo nuevo al principio del conjunto.
		if (!this.pertenece(x)) {
			Nodo nuevo = new Nodo();
			nuevo.info = x;
			nuevo.sig = primero;
			primero = nuevo;
		}
	}

	@Override
	public void sacar(int x) {
	    // Si el conjunto no está vacío
	    if (primero != null) {
	        // Si el valor a eliminar está en el primer nodo
	        if (primero.info == x) {
	            primero = primero.sig;
	        } else {
	            // Usamos aux para recorrer la lista desde el primer nodo
	            Nodo aux = primero;
	            // Recorremos mientras no lleguemos al final y el siguiente nodo no contenga el valor
	            while (aux.sig != null && aux.sig.info != x) {
	                aux = aux.sig;
	            }
	            // Si encontramos un nodo siguiente que contiene el valor
	            if (aux.sig != null) {
	                aux.sig = aux.sig.sig; // Saltamos el nodo que queremos eliminar
	            }
	        }
	    }
	}

	@Override
	public int elegir() {
		return primero.info;
	}

	@Override
	public boolean pertenece(int x) {
		// Usamos aux como un pivote para recorrer el conjunto.
		Nodo aux = primero;
		// Itera todo el conjunto desde el principio hasta el final mientras que:
		// 1. No llegue al final.
		// 2. No encuentre un nodo con el mismo valor que el que estamos buscando.
		while (aux != null && aux.info != x) {
			aux = aux.sig;
		}
		// Si aux no llega al final, retorna true porque significa que encontro el valor buscado.
		return aux != null;
	}

	@Override
	public boolean conjuntoVacio() {
		return primero == null;
	}

}
