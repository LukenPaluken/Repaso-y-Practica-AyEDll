package practica_dicc_simple_din;

import practica_conjunto.ConjuntoTDA;

public interface Dicc_Simple_TDA {
	void inicializarDiccionario();
	void agregar(int clave, int valor);
	void eliminar(int clave);
	int recuperar(int clave);
	ConjuntoTDA claves();
}
