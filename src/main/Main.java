/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import IntermediarioBD.IntermedirioPersona;
import Modelo.Persona;
import java.util.List;

public class Main {

    public static void main(String[] args){
        
        System.out.println(new IntermedirioPersona().Guardar(new Persona("Javier", "Caballero", "Por ahi", 22)));
        List<Persona> ListarPersonas = new IntermedirioPersona().ListarPersonas();
        for (int i = 0; i < ListarPersonas.size(); i++) {
        //    System.out.println(ListarPersonas.get(i));
        }
        Persona persona = new IntermedirioPersona().Buscar(5);
        persona.setNombre("Martin");
        persona.setApellido("Garcia");
        persona.setEdad(8);
        new IntermedirioPersona().Guardar(persona);
        persona = new IntermedirioPersona().Buscar(5);
        System.out.println(persona);
        new IntermedirioPersona().Eliminar(new IntermedirioPersona().Buscar(1));
    }

}
