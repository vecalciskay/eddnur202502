package imagenes.gui;

import imagenes.obj.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImagenFrame extends JFrame {
    private final ImagenPanel panel;
    private Imagen modelo;
    public ImagenFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FabricaImagen fabrica = new FabricaImagen();
        modelo = fabrica.fabricarDesdeArchivo("E:/prog3/protesta.jpg");
        /*modelo.lineaHorizontal(200, 129, 211, 124);
        modelo.setPixel(300, 250, 255, 0, 0);
        modelo.setPixel(301, 251, 255, 0, 0);
        modelo.setPixel(300, 251, 255, 0, 0);
        modelo.setPixel(301, 250, 255, 0, 0);*/
        panel = new ImagenPanel(modelo);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);

        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Transformaciones");
        JMenuItem item = new JMenuItem("Tonos de gris");
        item.addActionListener(e -> menuTransformaciones_tonosDeGris());
        menu.add(item);

        item = new JMenuItem("Achicar 50%");
        item.addActionListener(e -> menuTransformaciones_achicar50());
        menu.add(item);

        bar.add(menu);
        setJMenuBar(bar);

        this.pack();
        this.setVisible(true);
    }

    private void menuTransformaciones_achicar50() {
        IOperacionImagen operacion = new Achicar(modelo, 50);
        operacion.ejecutar();
        panel.repaint();
    }

    private void menuTransformaciones_tonosDeGris() {
        IOperacionImagen operacion = new TonosDeGris(modelo);
        operacion.ejecutar();
        panel.repaint();
    }

    public static void main(String[] args) {
        new ImagenFrame();
    }
}
