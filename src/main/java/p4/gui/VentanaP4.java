package p4.gui;

import imagenes.gui.FiguraPanel;
import imagenes.obj.Imagen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.css.Rect;
import p4.obj.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaP4 extends JFrame {
    private static final Logger logger = LogManager.getRootLogger();
    private ListaP4<ElementoGrafico> figuras;
    private ImagenP4 resultado;
    public VentanaP4() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        figuras = new ListaP4<>();
        resultado = new ImagenP4(600,400);
        figuras.addObservador(resultado);
        PanelP4 panel = new PanelP4(resultado, figuras);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);

        construirMenu();

        this.pack();
        this.setVisible(true);
    }

    private void construirMenu() {
        JMenuBar bar = new JMenuBar();

        JMenu menu = new JMenu("Archivo");
        JMenuItem item = new JMenuItem("Refrescar");
        item.addActionListener(e -> menuArchivo_itemRefrescar());
        menu.add(item);
        bar.add(menu);

        menu = new JMenu("Figuras");
        item = new JMenuItem("Imagen");
        item.addActionListener(e -> menuFiguras_itemImagen());
        menu.add(item);

        item = new JMenuItem("Rectangulo");
        item.addActionListener(e -> menuFiguras_itemRectangulo());
        menu.add(item);
        bar.add(menu);


        this.setJMenuBar(bar);
    }

    private void menuFiguras_itemImagen() {
        logger.info("Carga una imagen desde el archivo protesta small");
        FabricaImagenP4 fabrica = new FabricaImagenP4();
        ImagenP4 img =
                fabrica.fabricarDesdeArchivo("E:/prog3/protestasmall.jpg");
        img.setPosicion(30,30);
        figuras.insertar(img);
    }

    private void menuFiguras_itemRectangulo() {
        logger.info("Nuevo reactangulo en pos 50,50 dimensiones 100,200");
        figuras.insertar(new Rectangulo(50,50,100,200));
    }

    private void menuArchivo_itemRefrescar() {
        logger.info("Llama al item refrescar");
        resultado.notificar();
    }
}
