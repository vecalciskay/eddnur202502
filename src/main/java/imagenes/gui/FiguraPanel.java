package imagenes.gui;

import imagenes.figuras.Rectangulo;
import imagenes.obj.Imagen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FiguraPanel extends JPanel implements PropertyChangeListener,
        MouseListener {
    private Imagen resultado;
    private Rectangulo figura;

    public FiguraPanel(Imagen resultado, Rectangulo figura) {
        this.resultado = resultado;
        this.figura = figura;
        this.resultado.addObserver(this);
        this.addMouseListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        if (resultado == null)
            return new Dimension(500,500);
        return new Dimension(resultado.getAncho(), resultado.getAlto());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (resultado != null) {
            resultado.dibujar(g);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (figura.isSeleccionada()) {
            figura.setSeleccionada(false);
            figura.setPosicion(e.getX(), e.getY());
            return;
        }

        if (figura.puntoDentroDeFigura(e.getX(), e.getY())) {
            figura.setSeleccionada(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
