package listas.inicial;

public class ListaPrimera {
    private Nodo inicio;

    public ListaPrimera() {
        this.inicio = null;
    }

    public void insertar(Object c) {
        Nodo nuevo = new Nodo(c);
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        Nodo actual = inicio;
        while(actual != null) {
            resultado.append(actual);
            actual = actual.getSiguiente();
        }
        return resultado.toString();
    }
}
