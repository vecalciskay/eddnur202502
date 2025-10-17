package p4.obj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaP4Test {
    @Test
    void tamanoListaVacia() {
        // Arrange
        ListaP4<String> lista = new ListaP4<>();

        // Act
        int resultado = lista.tamano();

        // Assert
        int esperado = 0;
        assertEquals(esperado, resultado);
    }

    @Test
    void tamanoListaLlena() {
        // Arrange
        ListaP4<String> lista = new ListaP4<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");

        // Act
        int resultado = lista.tamano();

        // Assert
        int esperado = 3;
        assertEquals(esperado, resultado);
    }

    @Test
    void getPosicion_0() {
        // Arrange
        ListaP4<String> lista = new ListaP4<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");

        // Act
        String resultado = lista.get(0);

        // Assert
        String esperado = "Luis";
        assertEquals(esperado, resultado);
    }

    @Test
    void getPosicionValida() {
        // Arrange
        ListaP4<String> lista = new ListaP4<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");

        // Act
        String resultado = lista.get(2);

        // Assert
        String esperado = "Hugo";
        assertEquals(esperado, resultado);
    }


    @Test
    void getPosicionMasAllaDeLista() {
        // Arrange
        ListaP4<String> lista = new ListaP4<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");

        // Act
        String resultado = lista.get(17);

        // Assert
        String esperado = "Hugo";
        assertEquals(esperado, resultado);
    }
}
