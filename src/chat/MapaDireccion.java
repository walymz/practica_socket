package chat;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapaDireccion {
   public static  Map<String, String> getMapa(){
       Map<String, String> mapa = new LinkedHashMap();
       mapa.put("Waleska", "192.168.0.7"); 
       mapa.put("Kristian", "192.168.0.5");
       return mapa;
   }
}
