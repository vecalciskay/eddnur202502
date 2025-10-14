package p4.obj;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Iterator;

public class ListaP4<E> implements Iterable<E>, PropertyChangeListener {
    private Nodo<E> inicio;
    private PropertyChangeSupport observado;

    public ListaP4() {
        inicio = null;
        observado = new PropertyChangeSupport(this);
    }

    public void addObservador(PropertyChangeListener observador) {
        observado.addPropertyChangeListener(observador);
    }

    public Iterator<E> iterator() {
        return new IteradorLista<>(inicio);
    }

    public void insertar(E c) {
        Nodo<E> nuevo = new Nodo(c);
        nuevo.setSiguiente(inicio);
        inicio = nuevo;

        if (c instanceof ElementoGrafico) {
            ElementoGrafico objElementoGrafico = (ElementoGrafico) c;
            objElementoGrafico.addObservador(this);
        }
        observado.firePropertyChange("LISTA", true, false);
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        observado.firePropertyChange("LISTA", true, false);
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
