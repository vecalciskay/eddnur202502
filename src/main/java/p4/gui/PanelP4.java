package p4.gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import p4.obj.ElementoGrafico;
import p4.obj.ImagenP4;
import p4.obj.ListaP4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelP4 extends JPanel
        implements PropertyChangeListener, MouseListener, MouseMotionListener {

    private static final Logger logger = LogManager.getRootLogger();
    private ImagenP4 resultado;
    private ListaP4<ElementoGrafico> figuras;

    public PanelP4(ImagenP4 resultado, ListaP4<ElementoGrafico> figuras) {
        this.resultado = resultado;
        this.figuras = figuras;
        this.resultado.addObservador(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(resultado.getAncho(), resultado.getAlto());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (resultado != null) {
            logger.info("Dibuja el lienzo con sus pixeles");
            resultado.dibujar(g);
        } else {
            logger.error("No dibuja nada porque la imagen es nula");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        logger.info("MAneja el evento lanzado por la lista y repinta");
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    private void seleccionarObjetoEn(int x, int y) {
        for (ElementoGrafico elemento:
             figuras) {
            if (elemento.posicionDentroDeObjeto(x, y)) {
                int offsetX = x - elemento.getPosX();
                int offsetY = y - elemento.getPosY();
                elemento.setSeleccionado(true, offsetX, offsetY);

                break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        seleccionarObjetoEn(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        deseleccionarObjetos();
    }

    private void deseleccionarObjetos() {
        for (ElementoGrafico elemento:
             figuras) {
            elemento.setSeleccionado(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        for (ElementoGrafico elemento:
                figuras) {
            if (elemento.isSeleccionado()) {
                elemento.setPosicion(e.getX(), e.getY());
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
