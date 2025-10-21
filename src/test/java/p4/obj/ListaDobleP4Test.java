package p4.obj;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaDobleP4Test {
    @Test
    void adicionar3Elementos() {
        // Arrange
        ListaDobleP4<String> lista = new ListaDobleP4<>();
        lista.adicionar("Hugo");
        lista.adicionar("Paco");
        lista.adicionar("Luis");

        // Act
        String resultado = lista.toString();

        // Assert
        String esperado = "Hugo --> Paco --> Luis --> ";
        assertEquals(esperado, resultado);
    }

    @Test
    void iterarInversa3Elementos() {
        // Arrange
        ListaDobleP4<String> lista = new ListaDobleP4<>();
        lista.adicionar("Hugo");
        lista.adicionar("Paco");
        lista.adicionar("Luis");

        // Act
        StringBuilder resultado = new StringBuilder();
        Iterator<String> iterador = lista.iteratorInverso();
        while(iterador.hasNext()) {
            String s = iterador.next();
            resultado.append(s).append(" - ");
        }

        // Assert
        String esperado = "Luis - Paco - Hugo - ";
        assertEquals(esperado, resultado.toString());
    }

    @Test
    void eliminarDesdeAtras7Elementos() {
        ListaDobleP4<String> lista = new ListaDobleP4<>();
        lista.adicionar("A");
        lista.adicionar("G");
        lista.adicionar("B");
        lista.adicionar("N");
        lista.adicionar("R");
        lista.adicionar("E");
        lista.adicionar("P");

        lista.eliminar(5);

        int resultado = lista.tamano();
        int esperado = 6;
        assertEquals(esperado, resultado);
    }
}
