package practica_cola_cprio_din;

public class ColaConPrioridad implements ColaConPrioridadTDA{
	private class NodoPrioridad{
		int info;
		int prioridad;
		NodoPrioridad sig;
	}
	
	NodoPrioridad mayorPrioridad;

	@Override
	public void inicializarCola() {
		mayorPrioridad = null;
	}

	@Override
	public void acolarPrioridad(int x, int prioridad) {
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.info = x;
		nuevo.prioridad = prioridad;
		// "Si la cola esta vacia o la nueva prioridad es menor (mas prioritario) que mayorPrioridad"...
		if (mayorPrioridad == null || prioridad < mayorPrioridad.prioridad) {
			nuevo.sig = mayorPrioridad; // ...el nodo nuevo se posiciona antes que mayorPrioridad.
			mayorPrioridad = nuevo; // Ahora, el nodo de mayor prioridad (mayorPrioridad) es el nodo nuevo.
		} else {
			// Como sabemos que la cola no esta vacia, usamos aux como un pivote para recorrer la cola.
			NodoPrioridad aux = mayorPrioridad;
			// Itera toda la cola desde el principio mientras que:
			// 1. No llegue al final.
			// 2. Encuentre un nodo cuyo siguiente tenga menor prioridad que el nuevo.
			while (aux.sig != null && aux.sig.prioridad < prioridad) {
				aux = aux.sig;
			}
			nuevo.sig = aux.sig; // Ahora, el nodo que le seguia a aux, es el mismo que le sigue a nuevo.
			aux.sig = nuevo; // Ahora, aux apunta a nuevo.
			// [A] -> [B (aux)] -> [nuevo] -> [null]
		}
	}

	@Override
	public void desacolar() {
		mayorPrioridad = mayorPrioridad.sig;
	}

	@Override
	public int primero() {
		return mayorPrioridad.info;
	}

	@Override
	public int prioridad() {
		return mayorPrioridad.prioridad;
	}

	@Override
	public boolean colaVacia() {
		return mayorPrioridad == null;
	}

}
