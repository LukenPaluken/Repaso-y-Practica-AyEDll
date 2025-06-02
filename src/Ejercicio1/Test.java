package Ejercicio1;

public class Test {
	public static void main(String[] args) {
		int[][] valoresPrueba = {{1,2}, {1,3}, {2,1},{4,1}};
		ColaPrioridad colaPrueba = new ColaPrioridad();
		colaPrueba.inicializarCola();
		
		for (int i = 0; i < valoresPrueba.length ; i++) {
			colaPrueba.acolarPrioridad(valoresPrueba[i][0], valoresPrueba[i][1]);
		}
		
		DiccionarioSimpleDin diccionarioPrueba = ColaPrio2DiccionarioSimple(colaPrueba);
		System.out.println(diccionarioPrueba.recuperar(1));
		System.out.println(diccionarioPrueba.recuperar(3));
		System.out.println(diccionarioPrueba.recuperar(2));
	}
	
	public static DiccionarioSimpleDin ColaPrio2DiccionarioSimple(ColaPrioridad cola) {
		DiccionarioSimpleDin dict = new DiccionarioSimpleDin();
		dict.inicializarDiccionario();
		while (!cola.colaVacia()) {
			dict.agregar(cola.prioridad(), cola.primero());
			cola.desacolar();
		}
		
		return dict;
	}
}
