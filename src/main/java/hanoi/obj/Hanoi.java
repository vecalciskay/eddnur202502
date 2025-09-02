package hanoi.obj;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Hanoi {
    private Torre[] torres;
    private int cantidadDiscos;
    private PropertyChangeSupport observado;

    public Hanoi(int n) {
        this.cantidadDiscos = n;

        torres = new Torre[3];

        torres[0] = new Torre(cantidadDiscos);
        torres[1] = new Torre();
        torres[2] = new Torre();

        observado = new PropertyChangeSupport(this);
    }

    public void addObservador(PropertyChangeListener observador) {
        observado.addPropertyChangeListener(observador);
    }

    public void resolver() {
        hacerHanoi(0,2,cantidadDiscos);
    }

    private void hacerHanoi(int de, int a, int n) {
        if (n == 1) {
            Disco discoAMover = torres[de].sacar();
            torres[a].colocar(discoAMover);
            observado.firePropertyChange("HANOI", de, a);
            return;
        }
        int pp = 3 - (de + a);
        hacerHanoi(de, pp, n-1);
        hacerHanoi(de, a, 1);
        hacerHanoi(pp, a, n-1);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(torres[0]).append("\n");
        result.append(torres[1]).append("\n");
        result.append(torres[2]).append("\n");
        return result.toString();
    }
}
