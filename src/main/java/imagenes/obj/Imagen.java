package imagenes.obj;

import java.awt.*;

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
public class Imagen {
    private int pixeles[][];
    private int ancho;
    private int alto;

    public Imagen(int w, int h) {
        pixeles = new int[w][h];
        ancho = w;
        alto = h;
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

    public void lineaHorizontal(int altura, int r, int g, int b) {
        int color = (r << 16) | (g << 8) | b;
        for (int i = 0; i < ancho; i++) {
            pixeles[i][altura] = color;
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
}
