package listas.inicial;

/**
 * Esta es la clase que representa un vagon (de la explicacion de clase)
 */
public class Nodo {
    private Object contenido;
    private Nodo siguiente;

    public Nodo(Object contenido) {
        this.contenido = contenido;
        this.siguiente = null;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return contenido.toString() + " --> ";
    }
}
