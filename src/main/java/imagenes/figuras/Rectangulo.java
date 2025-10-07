package imagenes.figuras;

import imagenes.obj.Imagen;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Rectangulo implements IFigura {
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private boolean seleccionada;
    private PropertyChangeSupport observado;

    public Rectangulo(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        observado = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener listener) {
        observado.addPropertyChangeListener(listener);
    }

    public boolean isSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(boolean seleccionada) {
        this.seleccionada = seleccionada;
        observado.firePropertyChange("CUADRADO", true, false);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setTamano(int ancho, int alto) {
        this.alto = alto;
        this.ancho = ancho;
        observado.firePropertyChange("CUADRADO", true, false);
    }

    public void setPosicion(int x, int y) {
        this.x = x;
        this.y = y;
        observado.firePropertyChange("CUADRADO", true, false);
    }

    @Override
    public void dibujar(Imagen img) {
        img.lineaHorizontal(x, y, ancho);
        if (seleccionada) {
            img.lineaHorizontal(x, y + 2, ancho);
        }
        img.lineaHorizontal(x, y+alto,ancho);
        img.lineaVertical(x,y, alto);
        img.lineaVertical(x+ancho,y,alto);

        img.notificar();
    }

    public boolean puntoDentroDeFigura(int ox, int oy) {
        if (this.x < ox && (this.x + ancho) > ox &&
            this.y < oy && (this.y + alto) > oy)
            return true;
        return false;
    }
}
