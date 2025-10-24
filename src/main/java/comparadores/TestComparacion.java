package comparadores;

import objetos.Persona;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class TestComparacion {
    public static void main(String[] args) {
        int a = 10;
        int b = 39;

        if (a < b)
            System.out.println(a + " es menor que " + b);

        String n1 = "Daniel";
        String n2 = "Gonzalo";

        if (n1.compareTo(n2) < 0) {
            System.out.println(n1 + " viene antes que " + n2);
        }

        LocalDate fecha1 = LocalDate.of(1990, 5, 15);
        LocalDate fecha2 = LocalDate.of(1993, 5, 15);
        Persona p1 = new Persona("Hugo", 2342332, fecha1);
        Persona p2 = new Persona("Paco", 1742332, fecha2);

        if (p1.compareTo(p2) < 0) {
            System.out.println(p1.getNombre() + " viene antes que " + p2);
        }

        Persona[] arregloPErsonas = new Persona[2];
        arregloPErsonas[0] = p2;
        arregloPErsonas[1] = p1;

        System.out.println("Sin ordenar");
        for (Persona p: arregloPErsonas) {
            System.out.println(p);
        }

        System.out.println();

        Arrays.sort(arregloPErsonas);
        System.out.println("ORdenado");
        for (Persona p: arregloPErsonas) {
            System.out.println(p);
        }

    }
}
