package interfaces;

import java.util.List;

import javax.ejb.Local;

import dto.Persona;

@Local
public interface PersonaService {

	public abstract List<Persona> listaPersona();

	public abstract Persona encontrarPersonaPorId(Persona persona);

	public abstract Persona encontrarPersonaPorEmail(Persona persona);

	public abstract Persona registrarPersona(Persona persona);

	public abstract Persona modificarPersona(Persona persona);

	public abstract Persona eliminarPersona(Persona persona);

}
