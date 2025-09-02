package hanoi.gui;

import hanoi.obj.Hanoi;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HAnoiPanel extends JPanel implements PropertyChangeListener {

    private Hanoi modelo;

    public HAnoiPanel(Hanoi m) {
        this.modelo = m;
        modelo.addObservador(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        DibujoHanoi dibujo = new DibujoHanoi(modelo);
        dibujo.dibujar(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,400);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}
