package listas.inicial;

public class PrimeraLista {
    public static void main(String[] args) {

        ListaPrimera lista = new ListaPrimera();
        lista.insertar("hugo");
        lista.insertar("paco");
        lista.insertar("luis");

        System.out.println(lista);
       /*
        int[] a = new int[10];
        a[0] = 5;

        // que hacer para que no haya problemas?
        int[] b = Arrays.copyOf(a, 10);
        a = new int[11];
        a = Arrays.copyOf(b, 11);
        a[10] = 23;
*/

    }
}
