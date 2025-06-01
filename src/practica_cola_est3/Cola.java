package practica_cola_est3;

public class Cola implements ColaTDA {
    int[] arr;

    @Override
    public void inicializarCola() {
        // Esta implementación guarda la cantidad de elementos de la cola en arr[0].
        // Los datos reales comienzan desde arr[1].
        arr = new int[100];
        arr[0] = 0;
    }

    @Override
    public void acolar(int x) {
        // Desplaza todos los elementos una posición a la derecha (de arr[1] a arr[n])
        // para hacer lugar al nuevo valor en arr[1].
        for (int i = arr[0]; i > 0; i--) {
            arr[i + 1] = arr[i];
        }

        arr[1] = x; // Inserta el nuevo valor en el frente de la cola.
        arr[0]++;   // Incrementa el contador de elementos (guardado en arr[0]).
    }

    @Override
    public void desacolar() {
        // Simplemente reduce el contador. El valor al final (último en entrar) se ignora.
        arr[0]--;
    }

    @Override
    public int primero() {
        // El primer valor ingresado siempre queda al final lógico de la cola,
        // que es arr[arr[0]], ya que los valores se van "empujando" hacia la derecha.

        // NOTA: ¿Por qué no es arr[arr[0] - 1]?
        // Porque los datos comienzan desde arr[1], no desde arr[0],
        // así que cuando hay 'n' elementos en la cola, el primero (más antiguo)
        // termina en arr[n], no en arr[n - 1].
        return arr[arr[0]];
    }

    @Override
    public boolean vacio() {
        return arr[0] == 0;
    }
}
