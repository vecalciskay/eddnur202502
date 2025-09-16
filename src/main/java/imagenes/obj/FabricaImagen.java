package imagenes.obj;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FabricaImagen {

    public FabricaImagen() {}

    public Imagen fabricarDesdeArchivo(String filename) {
        BufferedImage bi = null;
        try {
            File f = new File(filename);
            bi = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int w = bi.getWidth();
        int h = bi.getHeight();

        Imagen resultado = new Imagen(w,h);
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                resultado.setPixel(i, j, bi.getRGB(i, j));
            }
        }

        return resultado;
    }
}
