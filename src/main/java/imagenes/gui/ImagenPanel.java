package imagenes.gui;

import imagenes.obj.Imagen;

import javax.swing.*;
import java.awt.*;

public class ImagenPanel extends JPanel {
    private final Imagen modelo;

    public ImagenPanel(Imagen modelo) {
        this.modelo = modelo;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(modelo.getAncho(), modelo.getAlto());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        modelo.dibujar(g);
    }
}
