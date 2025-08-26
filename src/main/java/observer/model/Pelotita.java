package observer.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Pelotita {
    private static final Logger logger = LogManager.getRootLogger();
    private int diametro;
    private Color color;
    private int x;
    private int y;
    private PropertyChangeSupport observado;

    public Pelotita() {
        logger.info("Se crea la pelotita con datos x defecto");
        diametro = 50;
        color = Color.black;
        x = 100;
        y = 100;
        observado = new PropertyChangeSupport(this);
    }

    public void addObservador(PropertyChangeListener observador) {
        logger.info("Enlaza el observador " + observador.toString() + " a la pelotita");
        observado.addPropertyChangeListener(observador);
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
        observado.firePropertyChange("CAMBIO", true, false);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        String oldColorStr = this.color.toString();
        String newColorStr = color.toString();
        this.color = color;
        observado.firePropertyChange("CAMBIO", oldColorStr, newColorStr);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosicion(int x, int y) {
        this.x = x;
        this.y = y;
        observado.firePropertyChange("CAMBIO", true, false);
    }

    @Override
    public String toString() {
        return "Pelotita: " +
                "d=" + diametro +
                ", color=" + color +
                ", pos=(" + x +
                ", " + y +
                ')';
    }
}
