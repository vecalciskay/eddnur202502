package listas;

import listas.inicial.Nodo;

import java.util.Iterator;

public class Lista<E> implements Iterable<E> {
    protected Nodo<E> inicio;
    protected int tamano;

    public Lista() {
        inicio = null;tamano = 0;
    }

    public Iterator<E> iterator() {
        return new IteradorLista<>(inicio);
    }

    public void insertar(E c) {
        Nodo<E> nuevo = new Nodo(c);
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
        tamano++;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        Nodo<E> actual = inicio;
        while(actual != null) {
            resultado.append(actual);
            actual = actual.getSiguiente();
        }
        return resultado.toString();
    }


    public E buscar(E o) {
        Nodo<E> actual = inicio;
        while(actual != null) {
            if (o.equals(actual.getContenido()))
                return actual.getContenido();
            actual = actual.getSiguiente();
        }
        return null;
    }

    class Nodo<E> {
        private E contenido;
        private Nodo<E> siguiente;

        public Nodo(E contenido) {
            this.contenido = contenido;
            this.siguiente = null;
        }

        public E getContenido() {
            return contenido;
        }

        public void setContenido(E contenido) {
            this.contenido = contenido;
        }

        public Nodo<E> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }

        @Override
        public String toString() {
            return contenido.toString() + " --> ";
        }
    }

    class IteradorLista<E> implements Iterator<E> {

        private Nodo<E> actual;

        public IteradorLista(Nodo<E> inicio) {
            actual = inicio;
        }

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public E next() {
            E result = actual.getContenido();
            actual = actual.getSiguiente();
            return result;
        }
    }
}
