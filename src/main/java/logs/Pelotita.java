package logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Pelotita extends Object {
    private static final Logger logger = LogManager.getRootLogger();
    private int radio;
    private String color;

    public Pelotita(int r, String c) {
        radio = r;
        color = c;
    }

    @Override
    public String toString() {
        return "Pelotita de color " + color + " y tamano " + radio;
    }

    public void cambiarTamano(int radio) {
        int viejoRadio = this.radio;
        this.radio = radio;
        logger.info("Ha cambiado de " + viejoRadio + " a " + radio);
    }
}
