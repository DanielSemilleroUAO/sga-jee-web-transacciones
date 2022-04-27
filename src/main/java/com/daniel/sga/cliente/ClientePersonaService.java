/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daniel.sga.cliente;

import com.daniel.sga.domain.Persona;
import com.daniel.sga.service.PersonaServiceRemote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.*;

/**
 *
 * @author adseglocdom
 */
public class ClientePersonaService {
    
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente");
        try {
            Context jdni = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jdni.lookup("java:global/sga-jee/PersonaServiceImpl!com.daniel.sga.service.PersonaServiceRemote");
            List<Persona> personas = personaService.listarPersonas();
            for (Persona persona : personas) {
                System.out.println(persona.toString());
            }
            System.out.println("Fin llamada al ejb del cliente");
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
