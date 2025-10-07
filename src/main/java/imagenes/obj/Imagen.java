package imagenes.obj;

import imagenes.figuras.IFigura;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * El color de un pixel es formado por la combinacion de un valor de rojo,
 * uno de verde, y uno de azul.
 * El total de combianciones posibles es 256 x 256 x 256 = 16M
 * Un entero en Java es cubierto por una estructura de 4 bytes
 * El primer byte desde la derecha sera asignado al azul
 * El segundo byte desde la derecha sera asignado al verde
 * El tercer byte desde la derecha sera asignado al rojo
 *
 * 0000 0000 0000 0000 0000 0000
 *
 * Verde agua = 129, 211, 124
 * 129 -> Hexadecimal 81 -> Binario 1000 0001
 * 211 -> D3 -> 1101 0011
 * 124 -> 7C -> 0111 1100
 * 100000011101001101111100 = 129 *256^2 + 211*256 + 124
 *
 *    1000 0001 0000 0000 0000 0000
 *  | 0000 0000 1101 0011 0000 0000
 *    -----------------------------
 *    1000 0001 1101 0011 0000 0000
 *    0000 0000 0000 0000 0111 1100
 *    -----------------------------
 *    1000 0001 1101 0011 0111 1100
 */
public class Imagen implements PropertyChangeListener {
    private int pixeles[][];
    private int ancho;
    private int alto;

    private PropertyChangeSupport observado;

    public Imagen(int w, int h) {
        pixeles = new int[w][h];
        ancho = w;
        alto = h;
        observado = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener listener) {
        observado.addPropertyChangeListener(listener);
    }

    public void notificar() {
        observado.firePropertyChange("IMAGEN", true, false);
    }

    /**
     * Cambia el color de la imagen en la posicion x, y al color dado
     * por la combinacion de r, g, b
     * @param x posicion x
     * @param y posicion y
     * @param r rojo
     * @param g verde
     * @param b azul
     */
    public void setPixel(int x, int y, int r, int g, int b) {
        pixeles[x][y] = (r << 16) | (g << 8) | b;
    }

    public void setPixel(int x, int y, int c) {
        pixeles[x][y] = c;
    }

    public void setPixeles(int w, int h, int[][] nuevosPixeles) {
        pixeles = nuevosPixeles;
        ancho = w;
        alto = h;
    }

    public int get(int x, int y) {
        return pixeles[x][y];
    }

    public int getR(int x, int y) {
        return pixeles[x][y] >> 16;
    }
    public int getG(int x, int y) {
        return (0x0000FFFF & pixeles[x][y]) >> 8;
    }
    public int getB(int x, int y) {
        return (0x000000FF & pixeles[x][y]);
    }


    public void lineaHorizontal(int altura, int r, int g, int b) {
        int color = (r << 16) | (g << 8) | b;
        for (int i = 0; i < ancho; i++) {
            pixeles[i][altura] = color;
        }
    }

    public void lineaHorizontal(int x, int y, int distancia) {
        int r =255;
        int g=255;
        int b = 255;
        int color = (r << 16) | (g << 8) | b;
        for (int i = 0; i < distancia; i++) {
            pixeles[x+i][y] = color;
        }
    }
    public void lineaVertical(int x, int y, int distancia) {
        int r =255;
        int g=255;
        int b = 255;
        int color = (r << 16) | (g << 8) | b;
        for (int j = 0; j < distancia; j++) {
            pixeles[x][y+j] = color;
        }
    }

    public int[][] getPixeles() {
        return pixeles;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void dibujar(Graphics g) {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                g.setColor(new Color(pixeles[i][j]));
                g.drawLine(i, j, i, j);
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        pixeles = new int[ancho][alto];

        IFigura figura = (IFigura)(evt.getSource());
        figura.dibujar(this);
    }

}
