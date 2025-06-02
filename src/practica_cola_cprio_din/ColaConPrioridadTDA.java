package practica_cola_cprio_din;

public interface ColaConPrioridadTDA {
	void inicializarCola();
	void acolarPrioridad(int x, int prioridad);
	void desacolar();
	int primero();
	int prioridad();
	boolean colaVacia();
}
