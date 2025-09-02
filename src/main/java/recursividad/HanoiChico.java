package recursividad;

public class HanoiChico {
    public static void main(String[] args) {
        hacerHanoi(1,3,3);
    }

    public static void hacerHanoi(int de, int a, int n) {
        if (n == 1) {
            System.out.println("De " + de + " a " + a);
            return;
        }
        int pp = 6 - (de + a);
        hacerHanoi(de, pp, n-1);
        hacerHanoi(de, a, 1);
        hacerHanoi(pp, a, n-1);
    }
}
