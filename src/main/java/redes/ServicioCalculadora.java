package redes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Este servicio tiene el siguiente protocolo
 *
 * Entradas posibles
 * suma 34
 * suma 33.32
 * suma       23.23
 *
 * Operaciones posibles
 * suma numero
 * resta numero
 * mult numero
 * div numero
 * fin
 *
 * Respuesta
 * R: numero
 * ERROR: No entiendo comando
 */
public class ServicioCalculadora {
    public static final String CMD_FIN = "fin";
    public static final String CMD_SUMA = "suma";
    public static final String CMD_RESTA = "resta";
    public static final String CMD_MULT = "mult";
    public static final String CMD_DIV = "div";
    private Socket clt;
    private double resultado;

    public ServicioCalculadora(Socket s) {
        clt = s;
    }

    public void servicio() throws IOException {
        BufferedReader lector =
                new BufferedReader(new InputStreamReader(clt.getInputStream()));
        PrintWriter escritor =
                new PrintWriter(clt.getOutputStream());

        String bienvenida = "Bienvenido al servicio Calculadora. R: " + resultado;
        escritor.println(bienvenida);
        escritor.flush();
        System.out.println(" >>> " + bienvenida);

        String linea = lector.readLine();

        while(!linea.equals(CMD_FIN)) {
            System.out.println(" <<< " + linea);
            String regex = "(" + CMD_SUMA + "|" + CMD_RESTA + "|" +
                    CMD_MULT + "|" + CMD_DIV + ")\\s+([0-9]+(\\.[0-9]+)?)";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(linea);

            String operacion = "";
            double numero = 0.0;
            if (matcher.find()) {
                operacion = matcher.group(1);
                numero = Double.parseDouble(matcher.group(2));

                hacerOperacion(operacion, numero);
                escritor.println("R: " + resultado);
                System.out.println(" >>> R: " + resultado);
            } else {
                escritor.println("ERROR: No entiendo comando");
                System.out.println("ERROR: No entiendo comando");
            }
            escritor.flush();

            linea = lector.readLine();
        }

        clt.close();
    }

    private void hacerOperacion(String operacion, double numero) {
        switch (operacion) {
            case CMD_SUMA -> resultado = resultado + numero;
            case CMD_RESTA -> resultado = resultado - numero;
            case CMD_MULT -> resultado = resultado * numero;
            case CMD_DIV -> resultado = resultado / numero;
        }
    }
}
