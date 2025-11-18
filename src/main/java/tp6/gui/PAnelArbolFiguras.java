package tp6.gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tp6.obj.ArbolObservable;
import tp6.obj.Cuadrado;
import tp6.obj.Figura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PAnelArbolFiguras extends JPanel implements PropertyChangeListener, MouseListener {
    private static Logger logger = LogManager.getRootLogger();
    protected ArbolObservable<Figura> modelo;

    public PAnelArbolFiguras(ArbolObservable<Figura> modelo) {
        this.modelo = modelo;
        this.modelo.addObservador(this);
        this.addMouseListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(700,500);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (modelo != null) {
            logger.info("Dibujando el arbol");
            DibujadorArbol dibujador = new DibujadorArbol(modelo);
            dibujador.dibujar(g);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x1 = e.getX();
        int y1 = e.getY();

        ArbolObservable.Nodo<Figura> nodo = modelo.clicEnPosicion(x1, y1);
        if (nodo == null) {
            logger.info("No hizo clic en ningun lugar");
            return;
        }
        Figura f = nodo.getContenido();
        if (f.getEvento().equals("ARRIBA")) {
            logger.info("Eliminar el nodo con id " + f.getId());
        }
        if (f.getEvento().equals("ABAJO")) {
            logger.info("Adicionar nodo debajo de id " + f.getId());
            modelo.insertar(f.getId(), new Cuadrado(Color.green));
        }
        f.limpiarEvento();
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
