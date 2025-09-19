package expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionSimple {
    public static void main(String[] args) {
        String regex = "([A-Z][a-zA-Z\\s]+),\\s*([0-9]+)";
        String texto = "Julio Cesar Eguez, 33, 2000-05-12, 77654897";

        String nombre = "";
        int edad = 0;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        if (matcher.find()) {
            nombre = matcher.group(1);
            edad = Integer.parseInt(matcher.group(2));
        } else {
            System.out.println("No match found.");
            System.exit(0);
        }

        System.out.println("El nombre es: " + nombre + " y la edad es: " + edad);
    }
}
