package tp6.obj;

import arboles.Identifiable;
import listas.Lista;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ArbolObservable <E extends Identifiable>  {
private static Logger logger = LogManager.getRootLogger();
    protected Nodo<E> raiz;
    protected PropertyChangeSupport observado;

    public ArbolObservable() {
        raiz = null;
        observado = new PropertyChangeSupport(this);
    }

    public Nodo<E> getRaiz() {
        return raiz;
    }

    public void addObservador(PropertyChangeListener listener) {
        this.observado.addPropertyChangeListener(listener);
    }

    public void insertar(String idPadre, E o) {
        Nodo<E> nuevo = new Nodo<>(o);

        if (idPadre == null)
        {
            raiz = nuevo;
            this.observado.firePropertyChange("ARBOL", true, false);
            return;
        }

        Nodo<E> padre = buscar(idPadre);
        padre.insertarHijo(nuevo);
        this.observado.firePropertyChange("ARBOL", true, false);
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

    public ArbolObservable.Nodo<E> clicEnPosicion(int x1, int y1) {
        return raiz.clicEnPosicion(x1,y1);
    }

    public static class Nodo<E extends Identifiable> {
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

        public E getContenido() {
            return contenido;
        }

        public Lista<Nodo<E>> getHijos() {
            return hijos;
        }

        public void insertarHijo(Nodo<E> nuevo) {
            hijos.insertar(nuevo);
        }

        public Nodo<E> clicEnPosicion(int x1, int y1) {
            if (!(contenido instanceof Figura))
                return null;

            Nodo<E> resultado = null;

            Figura f = (Figura)contenido;
            if (f.puntoDentroDeFigura(x1, y1)) {
                if (f.puntoParteAbajoFigura(x1, y1)) {
                    return this;
                } else if (f.puntoParteArribaFigura(x1, y1)) {
                    return this;
                } else {
                    logger.info("Clic en figura " + f.getId() + " pero ni arriba ni abajo");
                }
            } else {
                for (Nodo<E> hijo: this.getHijos()) {
                    resultado = hijo.clicEnPosicion(x1, y1);
                    if (resultado != null)
                        return resultado;
                }
            }
            return null;
        }
    }
}
