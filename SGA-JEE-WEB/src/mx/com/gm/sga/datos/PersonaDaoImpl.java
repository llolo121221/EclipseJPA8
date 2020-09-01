package mx.com.gm.sga.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import mx.com.gm.sga.domain.Persona;

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

}