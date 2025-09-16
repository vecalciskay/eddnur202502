package imagenes.obj;

public class Achicar implements IOperacionImagen {

    private Imagen target;
    private int porcentaje;

    /**
     * Crea un objeto para achicar la imagen al porcentaje indicado.
     * Es decir, si la imagen tiene 200x200 y le decimos 70 en el porcentaje
     * la imagen final tendra 140x140
     * @param target
     * @param porcentaje
     */
    public Achicar(Imagen target, int porcentaje) {
        this.porcentaje = porcentaje;
        this.target = target;
    }

    /**
     * Una linea de 18 pixeles
     * 65 34 78 34 56 67 89 21 43 54 67 89 56 52 58 35 89 45
     *
     * Necesitamos transformar a 50%, una linea 9 pixeles
     * 65 78 56 89 43 67 56 58 89
     */
    @Override
    public void ejecutar() {
        int wf = (target.getAncho() * this.porcentaje) / 100;
        int hf = (target.getAlto() * this.porcentaje) / 100;

        Imagen resultado = new Imagen(wf, hf);
        for (int i = 0; i < wf; i++) {
            for (int j = 0; j < hf; j++) {
                int xImagenOriginal = i * 100 / porcentaje;
                int yImagenOriginal = j * 100 / porcentaje;

                resultado.setPixel(i, j, target.get(xImagenOriginal, yImagenOriginal));
            }
        }

        target.setPixeles(wf, hf, resultado.getPixeles());
    }
}
