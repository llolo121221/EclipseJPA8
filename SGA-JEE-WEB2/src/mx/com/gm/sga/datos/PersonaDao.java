package mx.com.gm.sga.datos;

import java.util.List;

import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;

public interface PersonaDao {

	public abstract List<Persona> listaPersona();
	public abstract Persona encontrarPersonaPorId(Persona persona);
	public abstract Persona encontrarPersonaPorEmail(Persona persona);
	public abstract void registrarPersona(Persona persona);
	public abstract void  modificarPersona(Persona persona);	
	public abstract void eliminarPersona(Persona persona);
	
	public abstract List<Usuario> listaUsuario();
	public abstract Usuario encontrarUsuarioPorId(Usuario persona);
	public abstract void registrarUsuario(Usuario persona);
	public abstract void  modificarUsuario(Usuario persona);	
	public abstract void eliminarUsuario(Usuario persona);
	
}
