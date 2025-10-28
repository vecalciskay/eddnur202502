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
        tamano++;
    }

    @Override
    public E buscar(E c) {
        if (!(c instanceof Comparable)) {
            return super.buscar(c);
        }

        if (inicio == null) {
            return null;
        }

        return buscarEntre(inicio,0, tamano, c);
    }

    private E buscarEntre(Nodo<E> nodoInicial, int posInicial, int posFinal, E c) {
        int posMitadAbsoluta = posInicial + (posFinal - posInicial) / 2;
        int posMitadRelativa = (posFinal - posInicial) / 2;
        Nodo<E> actual = nodoInicial;
        int posicion = 0;
        while(posicion < posMitadRelativa) {
            actual = actual.getSiguiente();
            posicion++;
        }

        if (c.equals(actual.getContenido()))
            return actual.getContenido();

        Nodo<E> nuevoNodoInicial = actual;
        Comparable objComparable = (Comparable)c;
        if (objComparable.compareTo(actual.getContenido()) < 0) {
            return buscarEntre(nodoInicial, posInicial, posMitadAbsoluta, c);
        }
        return buscarEntre(nuevoNodoInicial, posMitadAbsoluta, posFinal, c);
    }
}
