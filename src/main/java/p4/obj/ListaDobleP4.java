package p4.obj;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Iterator;

public class ListaDobleP4<E> implements Iterable<E>, PropertyChangeListener {
    protected Nodo<E> inicio;
    protected Nodo<E> cola;
    private PropertyChangeSupport observado;
    protected int cantidadObjetos;

    public ListaDobleP4() {
        inicio = null;
        cola = null;
        observado = new PropertyChangeSupport(this);
        cantidadObjetos = 0;
    }

    public void addObservador(PropertyChangeListener observador) {
        observado.addPropertyChangeListener(observador);
    }

    public Iterator<E> iterator() {
        return new IteradorLista<>(inicio);
    }
public Iterator<E> iteratorInverso() { return new IteradorInversoLista<>(cola); }

    public void insertar(E c) {
        Nodo<E> nuevo = new Nodo(c);
        nuevo.setSiguiente(inicio);
        if (inicio != null)
            inicio.setAnterior(nuevo);
        inicio = nuevo;
        if (cantidadObjetos == 0)
            cola = nuevo;
        cantidadObjetos++;

        enlazarConObserverSiElementoGrafico(c);
    }

    public void adicionar(E c) {
        Nodo<E> nuevo = new Nodo(c);
        nuevo.setAnterior(cola);
        if (cola != null)
            cola.setSiguiente(nuevo);
        cola = nuevo;
        if (cantidadObjetos == 0)
            inicio = nuevo;
        cantidadObjetos++;

        enlazarConObserverSiElementoGrafico(c);
    }

    /**
     * A - G - B - N - R - E - P
     * eliminar(5)
     * Debe eliminar el elemento E pero desde la cola
     * no es el elemento 5 sino el 1
     * @param posicion
     */
    public void eliminar(int posicion) {
        if (posicion < 0 || posicion >= cantidadObjetos)
            throw new IndexOutOfBoundsException("Posicion esta fuera de rango");

        if (posicion < (cantidadObjetos / 2)) {
            eliminarDesdeInicio(posicion);
        } else {
            eliminarDesdeCola(cantidadObjetos - 1 - posicion);
        }

    }

    private void eliminarDesdeCola(int posicion) {
        if (posicion == 0) {
            cola = cola.getAnterior();
            if (cola != null)
                cola.setSiguiente(null);
            else
                inicio = cola; // tambien se vuelve nulo

            cantidadObjetos--;
            return;
        }

        int index = 0;
        Nodo<E> actual = cola;
        while(index < (posicion - 1)) {
            actual = actual.getAnterior();
            index++;
        }

        Nodo<E> anteriorAEliminar = actual;
        Nodo<E> eliminar = actual.getAnterior();
        Nodo<E> siguienteDelEliminado = actual.getAnterior().getAnterior();

        anteriorAEliminar.setAnterior(siguienteDelEliminado);
        if (siguienteDelEliminado != null)
            siguienteDelEliminado.setSiguiente(anteriorAEliminar);

        cantidadObjetos--;
    }

    private void eliminarDesdeInicio(int posicion) {
        if (posicion == 0) {
            inicio = inicio.getSiguiente();
            if (inicio != null)
                inicio.setAnterior(null);
            else
                cola = inicio; // tambien se vuelve nulo

            cantidadObjetos--;
            return;
        }

        int index = 0;
        Nodo<E> actual = inicio;
        while(index < (posicion - 1)) {
            actual = actual.getSiguiente();
            index++;
        }

        Nodo<E> anteriorAEliminar = actual;
        Nodo<E> eliminar = actual.getSiguiente();
        Nodo<E> siguienteDelEliminado = actual.getSiguiente().getSiguiente();

        anteriorAEliminar.setSiguiente(siguienteDelEliminado);
        if (siguienteDelEliminado != null)
            siguienteDelEliminado.setAnterior(anteriorAEliminar);

        cantidadObjetos--;
    }

    private void enlazarConObserverSiElementoGrafico(E c) {
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

    public int tamano() {
        return cantidadObjetos;
    }

    /**
     * SI la lista tiene 5 elementos
     * 0 1 2 3 4
     * A G V N E
     *
     * -2 -1 0 1 2 3 4 5 6
     *  #  # A G V N E # #
     *
     *  -2 -1 0 1 2 3 4 5 6
     *   N  E A G V N E A G
     * @param posicion
     * @return
     */
    public E get(int posicion) {
        if (posicion < 0)
            throw new IndexOutOfBoundsException("No existen posiciones negativas");

        int posicionDentroDeArreglo = posicion % cantidadObjetos;

        Nodo<E> actual = inicio;
        int posicionActual = 0;
        while(posicionActual < posicionDentroDeArreglo && actual != null) {
            actual = actual.getSiguiente();
            posicionActual++;
        }
        if (actual == null)
            throw new IndexOutOfBoundsException("La posicion esta fuera del tamano de la lista");

        return actual.getContenido();
    }

    class Nodo<E> {
        private E contenido;
        private Nodo<E> siguiente;
        private Nodo<E> anterior;

        public Nodo(E contenido) {
            this.contenido = contenido;
            this.siguiente = null;
            this.anterior = null;
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

        public Nodo<E> getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo<E> anterior) {
            this.anterior = anterior;
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

    class IteradorInversoLista<E> implements Iterator<E> {

        private Nodo<E> actual;

        public IteradorInversoLista(Nodo<E> cola) {
            actual = cola;
        }

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public E next() {
            E result = actual.getContenido();
            actual = actual.getAnterior();
            return result;
        }
    }
}
