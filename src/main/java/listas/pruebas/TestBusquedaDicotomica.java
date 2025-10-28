package listas.pruebas;

import listas.ListaOrdenada;

public class TestBusquedaDicotomica {
    public static void main(String[] args) {
        ListaOrdenada<String> lista = new ListaOrdenada<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");
        lista.insertar("Daisy");
        lista.insertar("Donald");
        lista.insertar("Mickey");
        lista.insertar("Pluto");
        lista.insertar("Goofy");

        String s = lista.buscar("Pluto");

        if (s == null)
            System.out.println("No encontro nada");
        else
            System.out.println("Objeto encontrado: " + s);
    }
}
