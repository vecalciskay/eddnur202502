package listas;

public class ListaOrdenada<E> extends Lista<E> {
    @Override
    public void insertar(E c) {
        if (!(c instanceof Comparable)) {
            super.insertar(c);
            return;
        }

        Comparable objComparable = (Comparable) c;

        if (inicio == null) {
            super.insertar(c);
            return;
        }

        if (objComparable.compareTo(inicio.getContenido()) < 0) {
            super.insertar(c);
            return;
        }

        Nodo<E> actual = inicio;
        while(actual.getSiguiente() != null &&
              objComparable.compareTo(actual.getSiguiente().getContenido()) > 0) {
            actual = actual.getSiguiente();
        }

        Nodo<E> nuevo = new Nodo<E>(c);
        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);
    }
}
