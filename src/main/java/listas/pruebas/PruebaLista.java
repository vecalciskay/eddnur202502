package listas.pruebas;

import listas.Lista;

import java.util.Iterator;

public class PruebaLista {
    public static void main(String[] args) {
        Lista<String> lista = new Lista<>();

        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");

        System.out.println(lista);

        Iterator<String> i = lista.iterator();
        while(i.hasNext()) {
            String elemento = i.next();
            System.out.println("Elemento: " + elemento);
        }

        for (String s:lista) {
            System.out.println("ELemento con For: " + s);
        }

    }
}
