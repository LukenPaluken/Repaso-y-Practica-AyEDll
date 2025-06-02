package Ejercicio1;

public class ConjuntoEst implements ConjuntoTDA {
	int[] a;
	int cant;
	
	public void inicializarConjunto() {
		a = new int[100];
		cant = 0;
	}
	
	public void agregar(int x) {
		if (!this.pertence(x)) {
			a[cant] = x;
			cant++;
		}
	}
	
	public int elegir() {
		return a[cant-1];
	}
	
	public boolean pertence(int x) {
		int i = 0;
		while (i < cant && a[i] != x) {
			i++;
		}
		return (i < cant);
	}
	
	public void sacar(int x) {
		int i = 0;
		while (i < cant && a[i] != x) {
			i++;
		}
		
		if (i < cant) {
			a[i] = a[cant-1];
			cant--;
		}
	}
	
	public boolean conjuntoVacio() {
		return cant == 0;
	}

}
