package hanoi.gui;

import hanoi.obj.Disco;
import hanoi.obj.Hanoi;
import hanoi.obj.Torre;

import java.awt.*;

public class DibujoHanoi {
    private Hanoi modelo;
    public DibujoHanoi(Hanoi modelo) {
        this.modelo = modelo;
    }

    public void dibujar(Graphics g) {
        // dibujar base
        g.setColor(Color.blue);
        g.fillRect(50, 330, 500, 20);

        // Dibujar las 3 torres
        // La torre de la mitad
        g.fillRect(290, 50, 20, 300);
        // La torre de la izq
        g.fillRect(140, 50, 20, 300);
        // La torre de la mitad
        g.fillRect(450, 50, 20, 300);

        dibujarTorre(g, 0, 140);
        dibujarTorre(g, 1, 290);
        dibujarTorre(g, 2, 450);
    }

    private void dibujarTorre(Graphics g, int numeroTorre, int xTorre) {
        int yDisco = 310;
        Torre[] torres = modelo.getTorres();
        g.setColor(Color.green);
        for (Disco d: torres[numeroTorre].getDiscos()) {
            int anchoDisco = 20 + 30 * d.getDiametro();
            int centroDeTorreEnX = xTorre + 10;
            int discoComienzaEnX = centroDeTorreEnX - (anchoDisco / 2);

            g.fillRect(discoComienzaEnX, yDisco, anchoDisco, 20);

            yDisco -= 30;
        }
    }
}
