package hanoi.gui;

import hanoi.obj.Hanoi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HAnoiFrame extends JFrame {
    private final Hanoi modelo;
    private final HAnoiPanel panel;

    public HAnoiFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        modelo = new Hanoi(4);
        modelo.setMsEntreMovimiento(500);

        panel = new HAnoiPanel(modelo);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        JButton btn = new JButton("Comenzar");
        this.getContentPane().add(btn, BorderLayout.SOUTH);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comenzarHanoi();
            }
        });

        this.pack();
        this.setVisible(true);
    }

    private void comenzarHanoi() {
        Runnable worker = new Runnable() {
            @Override
            public void run() {
                modelo.resolver();
            }
        };

        Thread t = new Thread(worker);
        t.start();
    }

    public static void main(String[] args) {
        new HAnoiFrame();
    }
}
