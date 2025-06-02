package Ejercicio1;

public interface ConjuntoTDA {
	void inicializarConjunto();
	void agregar(int x);
	int elegir();
	boolean pertence(int x);
	void sacar(int x);
	boolean conjuntoVacio();
}
