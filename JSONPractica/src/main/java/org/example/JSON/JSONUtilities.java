package org.example.JSON;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONUtilities {


    public static void grabarJSON(JSONArray jsonArray, String fileName){

        try (FileWriter fileWriter = new FileWriter(fileName)){
            fileWriter.write(jsonArray.toString(4));
            fileWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public static void mostrarArchivoJSON(String archivo){
        JSONTokener jsonTokener = leerArchivo(archivo);

        if(jsonTokener != null){
            try{
                JSONArray jsonArray = new JSONArray(jsonTokener);
                System.out.printf(jsonArray.toString(2));
            }catch (JSONException e){
                e.printStackTrace();
            }

        }else {
            System.out.println("no se pudo abrir el archivo.");
        }
    }


    public static void grabarJSON(JSONObject jsonObject, String fileName){

        try (FileWriter fileWriter = new FileWriter(fileName)){
            fileWriter.write(jsonObject.toString());
            fileWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }



    public static JSONTokener leerArchivo(String fileName){
        JSONTokener jsonTokener = null;

        try{
            jsonTokener = new JSONTokener(new FileReader(fileName));

        }catch (IOException e){
            e.printStackTrace();
        }
        return jsonTokener;
    }
}