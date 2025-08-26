package observer.gui;

import observer.model.Pelotita;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelPelotita extends JPanel implements PropertyChangeListener {
    private final Pelotita modelo;

    public PanelPelotita(Pelotita modelo) {
        this.modelo = modelo;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(modelo.getColor());
        g.fillOval(modelo.getX(), modelo.getY(),
                modelo.getDiametro(), modelo.getDiametro());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}
