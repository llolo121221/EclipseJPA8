package ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mx.com.gm.sga.domain.Persona;

public class PersistirObjeto {

	static Logger log = LogManager.getRootLogger();
		
	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		//Crear persona
		Persona persona1 = new Persona("Persitido","Persitido","prueb21a@g.com","999");
		
		tx.begin(); 
		em.persist(persona1);		
		
		log.debug("Persona creada - aun sin commit " + persona1);
		
		tx.commit();
		
		log.debug("Persona creada - estado detached " + persona1);
	}
	
	
	
}
