package sintactico;

class Nodo{

    int valor;
    Nodo siguiente;

    //Constructor de la Estructura

    Nodo (int valor) {

        this.valor = valor;
    }


}

public class Stack {

    Nodo pila; // Instancia de la clase de la estructura


    // Metodo para insertar un valor a la pila

    public void push(int valor){

        Nodo nuevo = new Nodo(valor);

        if (pila == null) { // Verificamos si la pila esta vacia

            pila = nuevo; // El tope de la pila es el nuevo elemento
            pila.siguiente = null; // apuntamos el siguiente a nulo para indicar el fondo de la pila

        } else { // si la pila ya tiene elementos

            nuevo.siguiente = pila; // apuntamos el siguiente TOPE de la pila
            pila = nuevo; // ahora el nuevo elemento pasa a ser el tope de la fila
        }

    }

    // Metodo para eliminar un elemento de la pila

    public void pop (){

        if (pila != null){ // Verificamos que la pila no este vacia

            pila = pila.siguiente; // el tope de la pila ahora es el siguiente elemento y
                                   // el tope se libera del espacio de memoria

        }

    }

    // Metodo para mostrar el primer elemento de la pila (retorna el valor)

    public int peek(){

        if (pila != null){ // Verificamos que la pila no este vacia

            return pila.valor; // retornamos el valor del tope


        }

        return 0; // en caso de estar vacia es 0

    }

    // metodo para mostrar todos los elementos de la pila

    public void mostrar(){

        Nodo aux = pila;

        while (aux != null){

            System.out.println(aux.valor);
            aux = aux.siguiente;

        }

    }

}
