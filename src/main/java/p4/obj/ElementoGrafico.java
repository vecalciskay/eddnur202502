package p4.obj;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class ElementoGrafico {
    protected int posX;
    protected int posY;
    protected  int offsetX;
    protected  int offsetY;
    protected boolean seleccionado;
    protected int color;

    protected PropertyChangeSupport observado;

    public void addObservador(PropertyChangeListener observador) {
        observado.addPropertyChangeListener(observador);
    }

    public void setPosicion(int x, int y) {
        this.posX = x - offsetX;
        this.posY = y - offsetY;
        observado.firePropertyChange("POSICION", true, false);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        boolean oldSeleccionado = this.seleccionado;
        this.seleccionado = seleccionado;
        if (oldSeleccionado != seleccionado) {
            observado.firePropertyChange("SELECCION", true, false);
        }
    }

    public void setSeleccionado(boolean seleccionado, int offsetX, int offsetY) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        boolean oldSeleccionado = this.seleccionado;
        this.seleccionado = seleccionado;
        if (oldSeleccionado != seleccionado) {
            observado.firePropertyChange("SELECCION", true, false);
        }
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public abstract int getAlto();
    public abstract int getAncho();

    public abstract void dibujar(ImagenP4 img);

    public boolean posicionDentroDeObjeto(int x, int y) {
        if (x > posX && x < (posX + getAncho()) &&
        y > posY && y < (posY + getAlto())) {
            return true;
        }
        return false;
    }
}
