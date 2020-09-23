package serializado;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerializado {
    public static void main(String[] args) {
        File file = new File("datos.dat");
        /*
        Serializado: Toma el estado de un objeto y lo pasa a un stream,
        en este caso será a un stream de archivo
        */
        
//Serializar
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(new Persona("Juan", "Moron", 32));
            out.writeObject(new Persona("Ana", "López", 50));
            out.writeObject(new Persona("Richard", "Pérez", 24));
            out.writeObject(new Persona("Roberto", "Lara", 35));
            
        } catch (Exception e) { e.printStackTrace();   }
//Deserializar
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            while(true){
                Persona p = (Persona)in.readObject();
                System.out.println(p);
            }
        } catch (EOFException e) { System.out.println("Fin del archivo");
        } catch (Exception e){  }
        
    }
}
