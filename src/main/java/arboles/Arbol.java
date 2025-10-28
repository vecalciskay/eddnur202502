package arboles;

import listas.Lista;

public class Arbol<E> {

    protected Nodo<E> raiz;

    class Nodo<E> {
        private E contenido;
        private Lista<Nodo<E>> hijos;
    }
}
