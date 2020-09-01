package test;


import javax.persistence.*;
import org.apache.logging.log4j.*;

import mx.com.gm.sga.domain.Persona;

public class ClienteEntidadTest {

	static Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Persona per1 = new Persona("Maria", "Gutierrez", "m332@gmail.com", "68686");
		log.debug("Objeto a persistir" + per1);
		em.persist(per1);
		tx.commit();
		log.debug("Objeto persistido");
		em.close();
	}
	
}