package imagenes.gui;

import imagenes.obj.Imagen;

import javax.swing.*;
import java.awt.*;

public class ImagenFrame extends JFrame {
    private final ImagenPanel panel;
    private Imagen modelo;
    public ImagenFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        modelo = new Imagen(600,400);
        modelo.lineaHorizontal(200, 129, 211, 124);
        modelo.setPixel(300, 250, 255, 0, 0);
        modelo.setPixel(301, 251, 255, 0, 0);
        modelo.setPixel(300, 251, 255, 0, 0);
        modelo.setPixel(301, 250, 255, 0, 0);
        panel = new ImagenPanel(modelo);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ImagenFrame();
    }
}
