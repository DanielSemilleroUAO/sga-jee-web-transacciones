/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daniel.sga.cliente;

import com.daniel.sga.domain.Persona;
import com.daniel.sga.service.PersonaServiceRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author adseglocdom
 */
public class PruebaManejoTransacciones {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web-transacciones/PersonaServiceImpl!com.daniel.sga.service.PersonaServiceRemote");
            log.debug("Iniciando prueba manejo transaccional Persona service");
            
            // Buscar persona por id
            Persona persona = personaService.encontrarPersonaPorId(new Persona(1));
            
            log.debug(persona);
            
            // Cambiar apellido
            
            persona.setApellido("Perez");
            
            personaService.modificarPersona(persona);
            log.debug("Objeto modificado: " + persona);
            
        } catch (NamingException ex) {
            log.debug(ex.getMessage());
        }
    }
    
}
