package tp6.obj;

import arboles.Identifiable;

import java.awt.*;

public abstract class Figura implements Identifiable {
    protected static int proximoId = 1;
    protected String nombre;
    protected String id;
    protected int x;
    protected int y;
    protected int ancho;
    protected int alto;
    protected Color color;
    protected String evento;
    @Override
    public String getId() {
        return id;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void dibujar(Graphics g);

    public boolean puntoDentroDeFigura(int x1, int y1) {
        if (x1 > x && x1 < (x + ancho) &&
            y1 > y && y1 < (y + alto)) {
            return true;
        }
        return false;
    }

    public boolean puntoParteArribaFigura(int x1, int y1) {
        int arriba = alto / 3;
        if (x1 > x && x1 < (x + ancho) &&
                y1 > y && y1 < (y + arriba)) {
            evento = "ARRIBA";
            return true;
        }
        return false;
    }

    public boolean puntoParteAbajoFigura(int x1, int y1) {
        int abajoComienza = 2 * alto / 3;
        if (x1 > x && x1 < (x + ancho) &&
                y1 > (y + abajoComienza) && y1 < (y + alto)) {
            evento = "ABAJO";
            return true;
        }
        return false;
    }

    public String getEvento() {
        return evento;
    }

    public void limpiarEvento() {
        evento = "";
    }
}
