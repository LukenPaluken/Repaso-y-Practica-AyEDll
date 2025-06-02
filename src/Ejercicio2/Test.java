package Ejercicio2;

public class Test {

	public static void main(String[] args) {
		int[][] valoresPrueba = {{1,2}, {1,3}, {2,1},{4,1}};
		ColaPrioridad colaPrueba = new ColaPrioridad();
		colaPrueba.inicializarCola();
		
		for (int i = 0; i < valoresPrueba.length ; i++) {
			colaPrueba.acolarPrioridad(valoresPrueba[i][0], valoresPrueba[i][1]);
		}
		
		System.out.println(colaPrueba.maximoValor());
		System.out.println(colaPrueba.suma());
	}

}
