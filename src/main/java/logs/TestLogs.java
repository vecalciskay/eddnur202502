package logs;

public class TestLogs {
    public static void main(String[] args) {
        Pelotita p = new Pelotita(445, "Rojo");
        System.out.println(p);

        p.cambiarTamano(45);
        System.out.println(p);
    }
}
