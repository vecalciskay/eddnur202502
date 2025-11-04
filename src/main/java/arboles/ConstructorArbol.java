package arboles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstructorArbol {



    public Arbol<StringIdentifiable> construirArbol(String expresion) {
        String formatoExpresion = "\\s*([A-Z]+)\\s*([\\(.+\\)]?)";
        Pattern pattern = Pattern.compile(formatoExpresion);
        Matcher matcher = pattern.matcher(expresion);

        String contenidoNodo;
        String hijosNodo;

        if (matcher.find()) {
            contenidoNodo = matcher.group(1);
            hijosNodo = matcher.group(2);
            if (hijosNodo.equals("(")) {
                int hijosComienza = matcher.start(2);
                hijosNodo = expresion.substring(hijosComienza+1, expresion.length()-1);
            }
            construirArbol(hijosNodo);

            System.out.println(contenidoNodo + " -> " + hijosNodo);
        } else {
            System.out.println("No match found.");
        }

        return null;
    }
}
