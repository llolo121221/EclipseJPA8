package Impl;

import java.util.List;

import javax.naming.*;

import dto.Persona;
import interfaces.PersonaServiceRemote;



public class ClientePersonaService {
	public static void main(String[] args) {
		System.out.println("Prueba de EJB desde el cliente");
		System.out.println("Iniciando \n");
		
		try {
			
			Context jndi = new InitialContext();
			PersonaServiceRemote personaServiceRemote =
					(PersonaServiceRemote) jndi.lookup("java:global/EjbSesionRemoto/PersonaServiceImpl!interfaces.PersonaServiceRemote");
			List<Persona> persona = personaServiceRemote.listaPersona();
			
			for(Persona e : persona) {
				System.out.println(e);
			}
			
		} catch (NamingException e) {
			e.printStackTrace(System.out);
		}
	}
}
