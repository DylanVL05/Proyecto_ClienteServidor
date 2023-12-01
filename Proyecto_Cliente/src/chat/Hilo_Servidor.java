/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat;

/**
 *
 * @author andro
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Hilo_Servidor implements Runnable {

    private Socket clienteSocket;

    public Hilo_Servidor(Socket clienteSocket) {
        this.clienteSocket = clienteSocket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Cliente conectado desde: " + clienteSocket.getInetAddress());

            // Obtener flujo de entrada del socket
            InputStream inputStream = clienteSocket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            // Escuchar mensajes del cliente
            while (true) {
                // Leer cadena UTF-8 del cliente
                String mensaje = dataInputStream.readUTF();

                // Imprimir el mensaje en la consola del servidor
                System.out.println("Cliente: " + mensaje);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Cerrar el socket cuando se completa la comunicación
                clienteSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}