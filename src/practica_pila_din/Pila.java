package practica_pila_din;

public class Pila implements PilaTDA{
	private class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo primero;

	@Override
	public void inicializarPila() {
		primero = null;
	}

	@Override
	public void apilar(int x) {
		// Se apilan elementos al principio de la pila.
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		nuevo.sig = primero;
		primero = nuevo;
	}

	@Override
	public void desapilar() {
		// Se saca el primero. El nuevo primero pasa a ser el que le sigue al primero actual.
		primero = primero.sig;
	}

	@Override
	public int tope() {
		return primero.info;
	}

	@Override
	public boolean pilaVacia() {
		return primero == null;
	}

}
