package junit.MODEL;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSON {

  //Leer el JSON y devolverlo
  public JSONObject readJSON(){
    String info = "";
    try {
      BufferedReader file = new BufferedReader(new FileReader("database.json"));
      info = file.readLine();
      file.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    JSONObject json = new JSONObject(info);
    return json;
  }

  //Guardar el nombre de usuario y puntuacion en el archivo database.json
  public void saveJSON(String username, int puntuacio) throws IOException {

    JSONObject json = readJSON();
    if(json.isNull(username)){
      json.put(username,puntuacio);
    }else if((int)json.get(username) < puntuacio){
      json.put(username,puntuacio);
    }
    FileWriter file = new FileWriter("database.json");
    file.write(json.toString());
    file.flush();
  }


}
