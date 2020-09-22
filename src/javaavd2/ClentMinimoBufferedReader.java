package javaavd2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class ClentMinimoBufferedReader {
    public static void main(String[] args) throws IOException {
        try (
                // Socket so = new Socket("localhost", 5000);
                // InputStream in = so.getInputStream();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new Socket("localhost", 5000).getInputStream()));
                ){
           // byte[] bytes = in.readAllBytes();
            //for(Byte b:bytes) System.out.print(Character.toString(b));    
            in.lines().forEach(System.out::println);
            in.lines().filter(l->l.toLowerCase().contains("lu")).forEach(System.out::println);
        } catch (Exception e) {e.printStackTrace();}
    }
    
}
