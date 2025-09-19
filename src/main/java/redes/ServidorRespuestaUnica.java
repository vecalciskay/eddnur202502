package redes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorRespuestaUnica {
    public static void main(String[] args) throws IOException {
        ServerSocket srv = new ServerSocket(8493);
        System.out.println("--- Esperando que alguien se conecte...");
        Socket clt  = srv.accept();

        BufferedReader lector =  new BufferedReader(
                new InputStreamReader(clt.getInputStream()));

        String lectura = lector.readLine();

        System.out.println("Del socket llego: " + lectura);

        System.out.println("--- Cerrando conexion ...");
        clt.close();
        srv.close();
    }
}
