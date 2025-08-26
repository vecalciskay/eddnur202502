package observer.gui;

import observer.model.Pelotita;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VentanaPelotita extends JFrame implements PropertyChangeListener {
    private final PanelPelotita panel;
    private final JLabel estado;
    private Pelotita modelo;

    public VentanaPelotita() {
        modelo = new Pelotita();
        modelo.addObservador(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        panel = new PanelPelotita(modelo);
        modelo.addObservador(panel);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        estado = new JLabel(modelo.toString());
        this.getContentPane().add(estado,BorderLayout.SOUTH);

        JMenuBar bar = new JMenuBar();
        JMenu cambios = new JMenu("Cambios");
        // Opcion de cambiar a color Rojo
        JMenuItem item = new JMenuItem("Color Rojo");
        item.addActionListener(e -> menuCambios_colorRojo());
        cambios.add(item);

        item = new JMenuItem("Aumentar tamano 10");
        item.addActionListener(e -> menuCambios_aumentarTamano());
        cambios.add(item);

        item = new JMenuItem("Mover 10 a la derecha");
        item.addActionListener(e -> menuCambios_moverDerecha10());
        cambios.add(item);

        bar.add(cambios);
        this.setJMenuBar(bar);

        this.pack();
        this.setVisible(true);
    }

    private void menuCambios_moverDerecha10() {
        modelo.setPosicion(modelo.getX()+10, modelo.getY());
    }

    private void menuCambios_aumentarTamano() {
        modelo.setDiametro(modelo.getDiametro() + 10);
    }

    private void menuCambios_colorRojo() {
        modelo.setColor(Color.red);
        /*panel.repaint();
        estado.setText(modelo.toString());*/
    }

    public static void main(String[] args) {
        new VentanaPelotita();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        estado.setText(modelo.toString());
    }
}
