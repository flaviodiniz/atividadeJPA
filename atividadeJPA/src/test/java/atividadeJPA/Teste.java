package atividadeJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class Teste {
	
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("atvjpa");
	
	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.getTransaction().commit();
			
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
			emf.close();
		}
		System.out.println("Saiu!");	
		
	}


}
