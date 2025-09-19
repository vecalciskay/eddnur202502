package redes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCalculadora {
    public static void main(String[] args) throws IOException {
        ServerSocket srv = new ServerSocket(7744);
        System.out.println("--- Esperando que alguien se conecte...");
        Socket clt  = srv.accept();
        System.out.println(" --- Recibida una conexion ...");

        ServicioCalculadora calculadora = new ServicioCalculadora(clt);
        calculadora.servicio();

        srv.close();
    }
}
