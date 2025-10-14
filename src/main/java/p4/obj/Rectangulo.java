package p4.obj;

import java.beans.PropertyChangeSupport;

public class Rectangulo extends ElementoGrafico {

    private int ancho;
    private int alto;

    public Rectangulo(int x, int y, int ancho, int alto) {
        posX = x;
        posY = y;
        this.alto = alto;
        this.ancho = ancho;
        observado = new PropertyChangeSupport(this);
    }

    @Override
    public int getAlto() {
        return alto;
    }

    @Override
    public int getAncho() {
        return ancho;
    }

    @Override
    public void dibujar(ImagenP4 img) {
        img.lineaHorizontal(posX, posY, ancho, color);
        if (seleccionado) {
            img.lineaHorizontal(posX, posY + 2, ancho, color);
        }
        img.lineaHorizontal(posX, posY+alto,ancho, color);
        img.lineaVertical(posX, posY, alto, color);
        img.lineaVertical(posX + ancho, posY, alto, color);
    }
}
