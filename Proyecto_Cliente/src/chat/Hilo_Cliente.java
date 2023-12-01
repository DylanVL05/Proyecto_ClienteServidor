/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat;

/**
 *
 * @author andro
 */
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Hilo_Cliente implements Runnable {

    private String mensaje;
    private int puerto;

    public Hilo_Cliente(String mensaje, int puerto) {
        this.mensaje = mensaje;
        this.puerto = puerto;
    }

    @Override
    public void run() {
        // Host del servidor
        final String HOST = "127.0.0.1";

        try (Socket sc = new Socket(HOST, puerto)) {
            System.out.println("Conectado al servidor en " + HOST + ":" + puerto);

            // Obtener flujo de salida del socket
            try (DataOutputStream out = new DataOutputStream(sc.getOutputStream())) {
                // Enviar mensaje al servidor
                for (char caracter : mensaje.toCharArray()) {
                    out.writeByte((byte) caracter);
                }
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
