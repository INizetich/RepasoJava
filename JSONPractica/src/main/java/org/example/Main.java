package org.example;

import org.example.JSON.GestionJSON;
import org.example.JSON.JSONUtilities;
import org.example.Models.Persona;
import org.json.JSONArray;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Persona persona = new Persona("ignacio",21,"45462201","m");
        Persona persona2 = new Persona("samy",26,"42102394","m");


        List<Persona> listaPersona = new ArrayList<>();
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(GestionJSON.SerializarPersona(persona));
        jsonArray.put(GestionJSON.SerializarPersona(persona2));

        JSONUtilities.grabarJSON(jsonArray,"personas.json");

        listaPersona = GestionJSON.deserializarJSON(jsonArray);

        System.out.println("\n-Lista de personas- \n");

        for(int i = 0; i < listaPersona.size(); i++){
            System.out.println(listaPersona.get(i));
        }


    }
}