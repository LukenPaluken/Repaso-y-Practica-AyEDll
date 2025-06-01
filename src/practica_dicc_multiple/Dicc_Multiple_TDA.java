package practica_dicc_multiple;

import practica_conjunto.ConjuntoTDA;

public interface Dicc_Multiple_TDA {
	void inicializarDiccionario();
	void agregar(int clave, int valor);
	void eliminar(int clave);
	void eliminarValor(int clave, int valor);
	ConjuntoTDA recuperar(int clave);
	ConjuntoTDA claves();
}
