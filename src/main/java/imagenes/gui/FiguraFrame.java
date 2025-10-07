package imagenes.gui;

import imagenes.figuras.Rectangulo;
import imagenes.obj.Imagen;

import javax.swing.*;
import java.awt.*;

public class FiguraFrame extends JFrame {
    private Rectangulo figura;
    private Imagen resultado;
    public FiguraFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        figura = new Rectangulo(100,100,200,100);
        resultado = new Imagen(600,400);
        figura.addObserver(resultado);
        figura.setPosicion(120,120);
        FiguraPanel panel = new FiguraPanel(resultado, figura);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FiguraFrame();
    }
}
