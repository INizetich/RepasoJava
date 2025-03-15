package org.example.JSON;

import org.example.Models.Persona;
import org.json.JSONArray;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;

public class GestionJSON {


    public static JSONObject SerializarPersona(Persona persona){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("nombre", persona.getNombre());
            jsonObject.put("edad", persona.getEdad());
            jsonObject.put("dni", persona.getDni());
            jsonObject.put("sexo", persona.getSexo());
        }catch (JSONException e){
            e.printStackTrace();
        }finally {
            return jsonObject;
        }

    }


    public static List<Persona> deserializarJSON(JSONArray jsonArray){
        JSONTokener jsonTokener = JSONUtilities.leerArchivo("personas.json");
        List<Persona> listaPersonas = new ArrayList<>();
          try{
              jsonArray = new JSONArray(jsonTokener);
              for(int i = 0; i<jsonArray.length();i++){
                  JSONObject jsonObject = jsonArray.getJSONObject(i);
                  Persona persona = GestionJSON.deserializarAjava(jsonObject);
                  listaPersonas.add(persona);
              }
          }catch (JSONException e){
              e.printStackTrace();
          }finally {
              return listaPersonas;
          }

    }



    public static Persona deserializarAjava(JSONObject jsonObject){
        Persona persona = new Persona();

        try {
            persona.setNombre(jsonObject.getString("nombre"));
            persona.setEdad(jsonObject.getInt("edad"));
            persona.setDni(jsonObject.getString("dni"));
            persona.setSexo(jsonObject.getString("sexo"));
        }catch (JSONException e){
            e.printStackTrace();
        }finally {
            return persona;
        }
    }
}