package p4.obj;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class ElementoGrafico {
    protected int posX;
    protected int posY;
    protected boolean seleccionado;
    protected int color;

    protected PropertyChangeSupport observado;

    public void addObservador(PropertyChangeListener observador) {
        observado.addPropertyChangeListener(observador);
    }

    public void setPosicion(int x, int y) {
        this.posX = x;
        this.posY = y;
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
        this.seleccionado = seleccionado;
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
}
