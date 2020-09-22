package chat;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapaDireccion {
   public static  Map<String, String> getMapa(){
       Map<String, String> mapa = new LinkedHashMap();
       mapa.put("Waleska", "127.0.0.1");
       return mapa;
   }
}
