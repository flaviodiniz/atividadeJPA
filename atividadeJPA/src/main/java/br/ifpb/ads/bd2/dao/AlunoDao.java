package br.ifpb.ads.bd2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ifpb.ads.bd2.modelos.Aluno;

public class AlunoDao extends DAO {

	public void create(Aluno aluno) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();

		try {
			em.persist(aluno);
			em.getTransaction().commit();
			System.out.println("Aluno Salvo!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao salvar aluno!");
		} finally {
			em.close();
			close();
		}
	}
	
	public Aluno find(Aluno aluno) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		int id = aluno.getIdPessoa();
		try {
			Aluno a = em.find(Aluno.class, id);
			System.out.println("Aluno recuperado!");
			return a;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao recuperar aluno!");
		} finally {
			em.close();
			close();
		}
		return null;		
	}
	
	public Aluno update (Aluno aluno) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		int id = aluno.getIdPessoa();
		try {
			Aluno a = em.find(Aluno.class, id);
			if(a != null) {
				a = aluno;
				em.merge(a);
				em.getTransaction().commit();
				System.out.println("Aluno atualizado!");
			} else {
				System.out.println("Aluno inexistente!");
			}				
			return a;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao atualizar!");
		} finally {
			em.close();
			close();
		}
		return null;		

	}
	
	public void remove(Aluno aluno) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			Aluno a = em.find(Aluno.class, aluno.getIdPessoa());
			if(a != null)
				em.remove(a);
			em.getTransaction().commit();
			System.out.println("Aluno removido!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao remover aluno!");
		} finally {
			em.close();
			close();
		}
	}
	
	public List<Aluno> ListAlunos(){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Aluno> alunos = em.createQuery("Select a from Aluno a").getResultList();
		em.close();
		close();
		return alunos;
	}

}
