package javaavd2;

import java.io.InputStream;
import java.net.Socket;


public class ClentMinimo {
    public static void main(String[] args) {
        try (
                Socket so = new Socket("localhost", 5000);
                InputStream in = so.getInputStream();
                ){
            byte[] bytes = in.readAllBytes();
            for(Byte b:bytes) System.out.print(Character.toString(b));    
           
        } catch (Exception e) {e.printStackTrace();}
    }
    
}
