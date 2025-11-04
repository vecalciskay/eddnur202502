package arboles;

import listas.Lista;
import listas.ListaOrdenada;

public class Arbol<E extends Identifiable>  {

    protected Nodo<E> raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertar(String idPadre, E o) {
        Nodo<E> nuevo = new Nodo<>(o);

        if (idPadre == null)
        {
            raiz = nuevo;
            return;
        }

        Nodo<E> padre = buscar(idPadre);
        padre.insertarHijo(nuevo);
    }

    private Nodo<E> buscar(String idPadre) {
        return raiz.buscar(idPadre);
    }

    @Override
    public String toString() {
        // A(B(E),C(F,G(K,L)),D(H,I,J))
        if (raiz == null)
            return "VACIO";
        return raiz.toString();
    }

    class Nodo<E extends Identifiable> {
        private E contenido;
        private Lista<Nodo<E>> hijos;

        public Nodo(E o) {
            contenido = o;
            hijos = new Lista<>();
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append(contenido);
            if(hijos.getTamano() == 0) {
                return result.toString();
            }

            result.append("(");
            String separator = "";
            for (Nodo<E> hijo:hijos) {
                result.append(separator).append(hijo.toString());
                separator = ",";
            }
            result.append(")");

            return  result.toString();
        }

        public Nodo<E> buscar(String id) {
            if (contenido.getId().equals(id)) {
                return this;
            }

            for (Nodo<E> hijo:hijos) {
                Nodo<E> encontrado = hijo.buscar(id);
                if (encontrado != null) {
                    return encontrado;
                }
            }

            return null;
        }

        public void insertarHijo(Nodo<E> nuevo) {
            hijos.insertar(nuevo);
        }
    }
}
