package tp6.obj;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public class Cuadrado extends Figura {
    private static Logger logger = LogManager.getRootLogger();
    private static final int ANCHO_POR_DEFECTO = 50;
    public Cuadrado(Color c) {
        x = -1;
        y = -1;
        ancho = ANCHO_POR_DEFECTO;
        alto = ANCHO_POR_DEFECTO;
        nombre = Cuadrado.class.getName();
        id = "F" + String.valueOf(proximoId);
        proximoId++;
        color = c;
    }


    @Override
    public void dibujar(Graphics g) {
        if (x < 0 || y < 0) {
            logger.warn("No va a dibujar este cuadrado porque no tiene x,y");
            return;
        }

        g.setColor(Color.white);
        g.fillRect(x, y, ancho, alto);
        g.setColor(color);
        g.drawRect(x, y, ancho, alto);
    }
}
