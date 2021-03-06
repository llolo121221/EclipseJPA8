package mx.com.gm.sga.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;

@Stateless
public class PersonaDaoImpl implements PersonaDao {

	@PersistenceContext(unitName = "PersonaPU")
	EntityManager em;
	
	@Override
	public List<Persona> listaPersona() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Persona.findAll").getResultList();
	}

	@Override
	public Persona encontrarPersonaPorId(Persona persona) {
		// TODO Auto-generated method stub
		return em.find(Persona.class, persona.getIdPersona());
	}

	@Override
	public Persona encontrarPersonaPorEmail(Persona persona) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Persona p where p.email =: email").setParameter("email", persona.getEmail());
		return (Persona) query.getSingleResult();
	}

	@Override
	public void registrarPersona(Persona persona) {		
		em.persist(persona);		
	}

	@Override
	public void modificarPersona(Persona persona) {
		em.merge(persona);		
	}

	@Override
	public void eliminarPersona(Persona persona) {
		em.remove(em.merge(persona));		
	}
	
	//usuarios

	@Override
	public List<Usuario> listaUsuario() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Usuario.findAll").getResultList();	
	}

	@Override
	public Usuario encontrarUsuarioPorId(Usuario usuario) {
		// TODO Auto-generated method stub
		return em.find(Usuario.class, usuario.getIdUsuario());
	}
	

	@Override
	public void registrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		em.persist(usuario);
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		em.merge(usuario);
	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		em.remove(em.merge(usuario));
	}

	

}
