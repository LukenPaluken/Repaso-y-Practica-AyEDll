package practica_conjunto;

public interface ConjuntoTDA {
	void inicializarConjunto();
	void agregar(int x);
	void sacar(int x);
	int elegir();
	boolean pertenece(int x);
	boolean conjuntoVacio();
}
