package arboles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstructorArbol {


    /**
     * A
     * A(B,C)
     * A(B(C,D,E),F(G,H),I)
     * BB(U,V,M)
     * HUGO(PACO,LUIS)
     *
     * @return
     */
    public Arbol<StringIdentifiable> construirArbol(String expresionSinTrim) {

        Arbol<StringIdentifiable> resultado = new Arbol<>();
        leerNodos(resultado, null, expresionSinTrim);
        return resultado;
    }

    public void leerNodos(Arbol<StringIdentifiable> resultado,
                          StringIdentifiable nodoPadre,
                          String expresionSinTrim) {
        String expresion = expresionSinTrim.trim();
        if (expresion.startsWith("(") && expresion.endsWith(")")) {
            leerNodos(resultado, nodoPadre,
                    expresion.substring(1, expresion.length() - 1));
            return;
        }
        int posicion = 0;
        int contadorParentesis = 0;
        StringBuilder posibleNodo = new StringBuilder();
        while (posicion < expresion.length()) {
            char c = expresion.charAt(posicion);
            posicion++;
            // Mayusculas
            if (contadorParentesis == 0 &&
                    c >= 65 && c <= 90) {
                posibleNodo.append(c);
                continue;
            }
            if (c == '(') {
                contadorParentesis++;
                continue;
            }
            if (c == ')') {
                contadorParentesis--;
                if (contadorParentesis == 0) {
                    // rescatar el posible nodo y crear los hijos
                    String nodoHijo = posibleNodo.toString();
                    StringIdentifiable padre =
                            new StringIdentifiable(nodoHijo);
                    posibleNodo.delete(0, posibleNodo.length());

                    resultado.insertar((nodoPadre == null ?
                                        null :
                                        nodoPadre.getId()),
                            new StringIdentifiable(nodoHijo));

                    leerNodos(resultado, padre,
                            expresion.substring(nodoHijo.length(), posicion));
                }
            }
            if (contadorParentesis == 0 && c == ',') {
                String nodoHijo = posibleNodo.toString();
                posibleNodo.delete(0, posibleNodo.length());
                resultado.insertar((nodoPadre == null ?
                                null :
                                nodoPadre.getId()),
                        new StringIdentifiable(nodoHijo));
                continue;
            }
            continue;
        }

        // 1er caso: expresion es A, entonces el arbol solo tiene un nodo
        if (!posibleNodo.isEmpty()) {
            if (nodoPadre == null)
                resultado.insertar(null,
                        new StringIdentifiable(posibleNodo.toString()));
            else
                resultado.insertar(nodoPadre.getId(),
                        new StringIdentifiable(posibleNodo.toString()));
        }
    }
}
