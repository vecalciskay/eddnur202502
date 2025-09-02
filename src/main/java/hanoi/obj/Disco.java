package hanoi.obj;

public class Disco {
    private int diametro;

    public Disco(int diametro) {
        this.diametro = diametro;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    @Override
    public String toString() {
        return String.valueOf( diametro);
    }
}
