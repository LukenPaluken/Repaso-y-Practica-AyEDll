package Ejercicio2;

public class ColaPrioridad implements ColaPrioridadTDA {
	private class Elemento {
		int valor; //igual que int valor, prioridad; 
		int prioridad;
	}
	
	private Elemento[] elementos;
	private int indice;
	
	public void inicializarCola() {
		indice = 0;
		elementos = new Elemento[100];
	}
	
	public void acolarPrioridad(int x, int prio) {
		int index = indice;
		
		while (index > 0 && elementos[index - 1].prioridad >= prio) {
			elementos[index] = elementos[index - 1];
			index--;
		}
		
		elementos[index] = new Elemento();
		elementos[index].valor = x;
		elementos[index].prioridad = prio;
		indice++;
	}
	
	public void desacolar() {
		//elementos[indice - 1] = null;
		indice--;
	}
	
	public int primero() {
		return elementos[indice-1].valor;
	}
	
	public int prioridad() {
		return elementos[indice-1].prioridad;
	}
	
	public boolean colaVacia() {
		return (indice == 0);
	}
	
	public int maximoValor() {
		//Complejidad O(1) en el mejor caso, O(n) en el peor caso
		int index = indice;
		int maximo = elementos[index - 1].valor;
		index--; //decremento porque ya estoy tomando el ultimo elemento
		
		while (index > 0) {
			if (elementos[index - 1].valor > maximo) {
				maximo = elementos[index - 1].valor;
			}
			index--;
		}
		
		return maximo;
	}
	
	public int suma() {
		// Complejidad O(1) en el mejor caso, O(n) en el peor caso
		int index = indice;
		int suma = 0;
		
		while (index > 0) {
			suma += elementos[index - 1].valor;
			index--;
		}
		
		return suma;
	}
}