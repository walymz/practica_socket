package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;

public class ServerChat implements Runnable {
   private JTextArea txa;
   private static String ip;
   private static String user;

    public ServerChat(JTextArea txa) {
        this.txa = txa;
    }
      
    @Override
    public void run() {
        try (ServerSocket ss = new ServerSocket(6000))  //Crea un ServerSocket en el puerto 6000
        {  while (true){  //Se queda en el bucle escuchando
                  try (Socket so = ss.accept(); //Closeable, se abre un Socket para conectarse con el cliente
                        BufferedReader in = new BufferedReader(new InputStreamReader(so.getInputStream())); 
                          /*Se crea un BufferedReader pasándo por parámetro una implementación de BufferedReader (InputStreamReader,
                           que a su vez pasa por parámetro el inputStream del socket aceptado
                          */
                         ){
                      //Se limpian las variables para evitar valores basura de otras conexiones
                      ip=""; 
                      user="";
                      try {
                          /*Se requiere averiguar la ip del cliente que se conectó, con la finalidad de obtener el nombre del usuario
                          a través del mapa. Se rodea con try catch para contener la posible excepción en el caso de que no se 
                          devuelva una ip, sea inexistente
                          */
                          
                          ip= so.getInetAddress().getHostAddress();
                      } catch (Exception e) { e.printStackTrace();}
                      
                    String mensaje = in.readLine();
                    
                    MapaDireccion.getMapa().forEach((k, v)->{
                             if(v.equals(ip)) {user= k;}
                        });
                    txa.append(user+": "+mensaje+"\n");
                  } catch (Exception e) { e.printStackTrace();}
        }
            
        } catch (Exception e) {e.printStackTrace(); }
    }
    
}
