package practica_cola_din;

public class Cola implements ColaTDA{
	private class Nodo{
		int info;
		Nodo sig;
	}
	
	private Nodo primero;
	private Nodo ultimo;

	@Override
	public void inicializarCola() {
		primero = null;
		ultimo = null;
	}

	@Override
	public void acolar(int x) {
		Nodo nuevo = new Nodo(); // Creo el nodo nuevo.
		nuevo.info = x; // Le asigno un valor.
		nuevo.sig = null; // Apunto al nodo que le sigue.
		if (ultimo != null) { // "Si la cola no esta vacia"...
			ultimo.sig = nuevo; // ...hago que el nodo que le sigue al ultimo actual, sea el nodo nuevo.
		}
		ultimo = nuevo; // El ultimo nodo ahora es el nodo nuevo.
		if (primero == null) { // "Si la cola esta vacia"...
			primero = nuevo; // ...el primer nodo es el nuevo.
		}
		
	}

	@Override
	public void desacolar() {
		// Como es FIFO, el primero que sale es el primero que entro. 
		primero = primero.sig; // El nuevo primer nodo sera el que le sigue al primero.
		if (primero ==  null) { // "Si la cola esta vacia"...
			ultimo = null; // ...actualizo el valor del ultimo nodo.
		}
	}

	@Override
	public int primero() {
		return primero.info;
	}

	@Override
	public boolean vacio() {
		return (ultimo == null);
	}
	
}