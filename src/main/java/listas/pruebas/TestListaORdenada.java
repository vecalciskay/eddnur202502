package listas.pruebas;

import listas.ListaOrdenada;
import objetos.Persona;

import java.time.LocalDate;

public class TestListaORdenada {
    public static void main(String[] args) {
        LocalDate fecha1 = LocalDate.of(1990, 5, 15);
        LocalDate fecha2 = LocalDate.of(1993, 5, 15);
        Persona p1 = new Persona("Hugo", 2342332, fecha1);
        Persona p2 = new Persona("Paco", 1742332, fecha2);

        if (p1.compareTo(p2) < 0) {
            System.out.println(p1.getNombre() + " viene antes que " + p2);
        }

        ListaOrdenada<Persona> listaPersonas = new ListaOrdenada<>();
        listaPersonas.insertar(p2);
        listaPersonas.insertar(p1);

        System.out.println("ORdenado?");
        for (Persona p: listaPersonas) {
            System.out.println(p);
        }
    }
}
