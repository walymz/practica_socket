package javaavd2;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMinimo {

    public static void main(String[] args) throws IOException {
        String mensaje="lunes";
               mensaje+="\nmartes";
               mensaje+="\nmiércoles";
               mensaje+="\njueves";
               mensaje+="\nviernes";
               mensaje+="\nsábado";
               mensaje+="\ndomingo";
        
       // mensaje ="HTTP/1.1 200 OK\n"+
         //       "Content-Lenght: "+mensaje.length()+"\n\n"+
         //       mensaje;
        try(ServerSocket ss = new ServerSocket(5000)){
            while(true){
                System.out.println("Esperando conexión al cliente...");
                try( Socket so = ss.accept();
                     OutputStream out =so.getOutputStream();
                   ){
                    System.out.println("Se conectó a "+so.getInetAddress());
                    out.write(mensaje.getBytes());
                }
            }
        }
    }
    
}
