package tp6.gui;

import tp6.obj.ArbolObservable;
import tp6.obj.Figura;

import java.awt.*;

public class DibujadorArbol {
    private static final int ESPACIO_HORIZONTAL = 15;
    private static final int ESPACIO_VERTICAL = 90;

    private ArbolObservable<Figura> modelo;

    public DibujadorArbol(ArbolObservable<Figura> modelo) {
        this.modelo = modelo;
    }

    public void dibujar(Graphics g) {
        if (modelo.getRaiz() == null) {
            g.drawString("ARBOL VACIO!!!",50,50);
            return;
        }
        dibujarNodo(modelo.getRaiz(), 0, 0, g);
    }

    private void dibujarNodo(ArbolObservable.Nodo<Figura> nodo, int x, int y, Graphics g) {
        int anchoTotal = getAncho(nodo);

        int xNodo = x + anchoTotal / 2;
        int yNodo = y;

        int xHijo = x;
        int yHijo = y + ESPACIO_VERTICAL;
        int separador = 0;
        for (ArbolObservable.Nodo<Figura> hijo: nodo.getHijos()) {
            int anchoHijo = getAncho(hijo);
            int posicionNodoHijoX = xHijo + anchoHijo / 2;

            g.setColor(Color.black);

            int centroXNodo = xNodo + nodo.getContenido().getAncho() / 2;
            int centroYNodo = yNodo + nodo.getContenido().getAlto() / 2;
            int centroXHijo = posicionNodoHijoX + hijo.getContenido().getAncho() / 2;
            int centroYHijo = yHijo + hijo.getContenido().getAlto() / 2;
            g.drawLine(centroXNodo, centroYNodo, centroXHijo, centroYHijo);

            dibujarNodo(hijo, xHijo, yHijo, g);

            xHijo += (ESPACIO_HORIZONTAL + anchoHijo);
        }

        Figura f = nodo.getContenido();
        f.setX(xNodo);
        f.setY(yNodo);
        f.dibujar(g);
    }

    private int getAncho(ArbolObservable.Nodo<Figura> nodo) {
        if (nodo.getHijos().getTamano() == 0) {
            Figura f = nodo.getContenido();
            return f.getAncho();
        }

        int anchoTotal = 0;
        int separador = 0;
        for (ArbolObservable.Nodo<Figura> hijo: nodo.getHijos()) {
            anchoTotal = anchoTotal + separador + getAncho(hijo);
            separador = ESPACIO_HORIZONTAL;
        }
        return anchoTotal;
    }
}
