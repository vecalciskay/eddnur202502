package imagenes.obj;

public class TonosDeGris implements IOperacionImagen {
    private Imagen target;

    public TonosDeGris(Imagen img) {
        target = img;
    }

    @Override
    public void ejecutar() {
        Imagen resultado = new Imagen(target.getAncho(), target.getAlto());

        for (int i = 0; i < target.getAncho(); i++) {
            for (int j = 0; j < target.getAlto(); j++) {
                int r = target.getR(i,j);
                int g = target.getG(i,j);
                int b = target.getB(i,j);
                // ej1: 50, 50, 50 --> color en gris = 50,50,50
                // ej2: 0, 0, 0 --> color en gris = 0,0,0
                // ej3: 0, 100, 200 --> 100,100,100
                // ej4: 38, 239, 38 -->
                int gris = (r + g + b) / 3;
                resultado.setPixel(i,j, gris, gris, gris);
            }
        }

        target.setPixeles(resultado.getAncho(), resultado.getAlto(),
                resultado.getPixeles());
    }
}
