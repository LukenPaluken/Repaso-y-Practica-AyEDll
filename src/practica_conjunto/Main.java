package practica_conjunto;

public class Main {
    public static void main(String[] args) {
        ConjuntoTDA conjunto = new Conjunto();
        conjunto.inicializarConjunto();

        conjunto.agregar(5);
        conjunto.agregar(10);
        conjunto.agregar(5); // No se agrega porque ya existe.

        System.out.println("¿Pertenece 10?: " + conjunto.pertenece(10)); // true
        System.out.println("¿Pertenece 7?: " + conjunto.pertenece(7));   // false

        System.out.println("Elemento elegido: " + conjunto.elegir());    // 10

        conjunto.sacar(10);
        System.out.println("¿Pertenece 10 luego de eliminar?: " + conjunto.pertenece(10)); // false

        System.out.println("¿Conjunto vacío?: " + conjunto.conjuntoVacio()); // false

        conjunto.sacar(5);
        System.out.println("¿Conjunto vacío?: " + conjunto.conjuntoVacio()); // true
    }
}
