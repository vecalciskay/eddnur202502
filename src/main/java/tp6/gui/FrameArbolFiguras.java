package tp6.gui;

import tp6.obj.ArbolObservable;
import tp6.obj.Cuadrado;
import tp6.obj.Figura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameArbolFiguras extends JFrame {

    private ArbolObservable<Figura> modelo;

    public FrameArbolFiguras() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());

        modelo = new ArbolObservable<>();
        PAnelArbolFiguras panel = new PAnelArbolFiguras(modelo);
        
        this.getContentPane().add(panel, BorderLayout.CENTER);
        
        JMenuBar bar = new JMenuBar();
        
        JMenu menu = new JMenu("Archivo");
        JMenuItem item = new JMenuItem("Crear nodo raiz");
        item.addActionListener(e -> menuArchivo_itemCrearRaiz());
        menu.add(item);

        bar.add(menu);

        this.setJMenuBar(bar);

        this.pack();
        this.setVisible(true);
    }

    private void menuArchivo_itemCrearRaiz() {
        modelo.insertar(null, new Cuadrado(Color.blue));
    }
}
