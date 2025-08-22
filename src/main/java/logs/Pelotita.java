package logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Esta es la representacion de una pelota. El atributo principal es el radio
 * de la pelota. TAmbien tiene color pero el color solamente esta como string.
 * Utilizar esto:
 * <ul>
 *     <li>En programas sencillos</li>
 *     <li>En ejemplos de clase</li>
 * </ul>
 */
public class Pelotita extends Object {
    private static final Logger logger = LogManager.getRootLogger();
    private int radio;
    private String color;

    /**
     * COmo hay este constructor pareceria que el objeto es inmutable
     * @param r este es el radio
     * @param c este es el color
     */
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
