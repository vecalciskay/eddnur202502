package hanoi.obj;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class JuegoHanoi implements PropertyChangeListener {
    private Hanoi juego;
    public static void main(String[] args) {
        JuegoHanoi a = new JuegoHanoi();
        a.jugar();
    }

    public JuegoHanoi() {
        juego = new Hanoi(3);
        juego.addObservador(this);
    }

    public void jugar() {
        juego.resolver();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(juego);
    }
}
