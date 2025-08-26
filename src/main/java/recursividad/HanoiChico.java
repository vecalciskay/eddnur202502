package recursividad;

public class HanoiChico {
    public static void main(String[] args) {
        hacerHanoi(1,3,2,3);
    }

    public static void hacerHanoi(int de, int a, int pp, int n) {
        if (n == 1) {
            System.out.println("De " + de + " a " + a);
            return;
        }
        hacerHanoi(de, pp, a, n-1);
        hacerHanoi(de, a, pp, 1);
        hacerHanoi(pp, a, de, n-1);
    }
}
