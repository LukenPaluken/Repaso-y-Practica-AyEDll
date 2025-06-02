package practica_dicc_simple_din;

import practica_conjunto.Conjunto;

public class Dicc_Simple implements Dicc_Simple_TDA {

	// Nodo que representa una entrada en el diccionario (clave-valor)
	private class NodoClave {
		int clave; // La clave del diccionario
		int valor; // El valor asociado a esa clave
		NodoClave sigClave; // Puntero al siguiente nodo (clave-valor)
	}

	NodoClave origen; // Puntero al primer nodo de la lista

	@Override
	public void inicializarDiccionario() {
		// Inicializo el diccionario dejándolo vacío
		origen = null;
	}

	@Override
	public void agregar(int clave, int valor) {
		// Busco si ya existe un nodo con esa clave
		NodoClave nc = clave2NodoClave(clave);
		
		if (nc == null) {
			// Si no existe, creo un nuevo nodo
			nc = new NodoClave();
			nc.clave = clave;
			// Inserto al principio de la lista (orden no importa)
			nc.sigClave = origen;
			origen = nc;
		}
		
		// Si ya existía o lo acabo de crear, actualizo el valor
		nc.valor = valor;
	}

	@Override
	public void eliminar(int clave) {
		// Verifico si la lista no está vacía
		if (origen != null) {
			// Caso especial: la clave a eliminar está en el primer nodo
			if (origen.clave == clave) {
				origen = origen.sigClave; // Elimino el primer nodo
			} else {
				// Busco el nodo anterior al que quiero eliminar
				NodoClave aux = origen;
				while (aux.sigClave != null && aux.sigClave.clave != clave) {
					aux = aux.sigClave;
				}
				// Si encontré el nodo, lo salteo
				if (aux.sigClave != null) {
					aux.sigClave = aux.sigClave.sigClave;
				}
			}
		}
	}

	@Override
	public int recuperar(int clave) {
		// Busco el nodo con la clave y devuelvo su valor
		NodoClave n = clave2NodoClave(clave);
		return n.valor;
	}

	@Override
	public Conjunto claves() {
		// Creo un conjunto para guardar todas las claves
		Conjunto claves = new Conjunto();
		claves.inicializarConjunto();
		
		NodoClave aux = origen;
		while (aux != null) {
			claves.agregar(aux.clave); // Agrego cada clave al conjunto
			aux = aux.sigClave; // Avanzo al siguiente nodo
		}
		return claves;
	}
	
	// Función auxiliar que busca un nodo por su clave
	private NodoClave clave2NodoClave(int clave) {
		NodoClave aux = origen;
		while (aux != null && aux.clave != clave) {
			aux = aux.sigClave;
		}
		return aux; // Si lo encuentra lo devuelve, si no, devuelve null
	}
}
