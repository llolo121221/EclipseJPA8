package interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import mx.com.gm.sga.datos.PersonaDao;
import mx.com.gm.sga.domain.Persona;



@Stateless
public class PersonaServiceImpl implements PersonaService {
	
	@Inject
	private PersonaDao dao;
	
	
	List<Persona> personas = new ArrayList<>();
	
	@Override
	public List<Persona> listaPersona() {
		return dao.listaPersona();
	}

	@Override
	public Persona encontrarPersonaPorId(Persona persona) {
		return dao.encontrarPersonaPorId(persona);
	}

	@Override
	public Persona encontrarPersonaPorEmail(Persona persona) {
		return dao.encontrarPersonaPorEmail(persona);
	}

	@Override
	public void registrarPersona(Persona persona) {
		dao.registrarPersona(persona);
	}

	@Override
	public void modificarPersona(Persona persona) {
		dao.modificarPersona(persona);
	}

	@Override
	public void eliminarPersona(Persona persona) {
		dao.eliminarPersona(persona);
	}

}
