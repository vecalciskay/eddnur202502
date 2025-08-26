package recursividad;

public class EjemploSimple {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Suma de los primeros " + n  + " numeros es:" + suma(n));
    }

    /**
     * suma(3) =
     *   3 + suma(2)
     *       2 + suma(1)
     *           1        = 3 + 2 + 1
     * @param n
     * @return
     */
    public static int suma(int n) {
        if (n == 1)
            return n;
        return n + suma(n-1);
    }
}
