package br.ifpb.ads.bd2.dao;

import javax.persistence.EntityManager;

import br.ifpb.ads.bd2.modelos.ContatoTelefone;

public class ContatoTelefoneDao extends DAO{
	
	public void create(ContatoTelefone fone) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();

		try {
			em.persist(fone);
			em.getTransaction().commit();
			System.out.println("ContatoTelefone Salvo!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao salvar ContatoTelefone!");
		} finally {
			em.close();
			close();
		}
	}
	
	public ContatoTelefone find(ContatoTelefone fone) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		int id = fone.getPessoa().getIdPessoa();
		try {
			ContatoTelefone ct = em.find(ContatoTelefone.class, id);
			System.out.println("ContatoTelefone recuperado!");
			return ct;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao recuperar ContatoTelefone!");
		} finally {
			em.close();
			close();
		}
		return null;		
	}
	
	public ContatoTelefone update (ContatoTelefone fone) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		int id = fone.getPessoa().getIdPessoa();
		try {
			ContatoTelefone ct = em.find(ContatoTelefone.class, id);
			if(ct != null) {
				ct = fone;
				em.merge(ct);
				em.getTransaction().commit();
				System.out.println("ContatoTelefone atualizado!");
			} else {
				System.out.println("ContatoTelefone inexistente!");
			}				
			return ct;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao atualizar!");
		} finally {
			em.close();
			close();
		}
		return null;		

	}
	
	public void remove(ContatoTelefone fone) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			ContatoTelefone a = em.find(ContatoTelefone.class, fone.getPessoa().getIdPessoa());
			if(a != null)
				em.remove(a);
			em.getTransaction().commit();
			System.out.println("ContatoTelefone removido!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao remover ContatoTelefone!");
		} finally {
			em.close();
			close();
		}
	}


}
