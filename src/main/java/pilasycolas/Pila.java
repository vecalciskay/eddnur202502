package pilasycolas;

import p4.obj.ListaDobleP4;

public class Pila<E> extends ListaDobleP4<E> {
    public void push(E o) {
        insertar(o);
    }

    public E pop() {
        E o = get(0);
        eliminar(0);
        return o;
    }
}
