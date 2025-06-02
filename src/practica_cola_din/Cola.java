package practica_cola_din;

public class Cola implements ColaTDA{
	private class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo primero;
	Nodo ultimo;

	@Override
	public void inicializarCola() {
		primero = null;
		ultimo = null;
	}

	@Override
	public void acolar(int x) {
		Nodo aux = new Nodo();
		aux.info = x;
		aux.sig = null;
		if (ultimo != null) {
			ultimo.sig = aux;
			ultimo = aux;
		}
		if (primero == null) {
			primero = ultimo;
		}
	}

	@Override
	public void desacolar() {
		primero = primero.sig;
		if (primero == null) {
			ultimo = null;
		}
	}

	@Override
	public int primerElemento() {
		return primero.info;
	}

	@Override
	public boolean colaVacia() {
		return ultimo == null;
	}

}
