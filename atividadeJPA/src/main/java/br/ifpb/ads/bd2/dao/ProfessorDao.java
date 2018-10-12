package br.ifpb.ads.bd2.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifpb.ads.bd2.modelos.Professor;

public class ProfessorDao extends DAO {

	public void create(Professor professor) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();

		try {
			em.persist(professor);
			em.getTransaction().commit();
			System.out.println("Professor Salvo!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao salvar Professor!");
		} finally {
			em.close();
			close();
		}
	}

	public Professor find(Professor professor) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		int id = professor.getIdPessoa();
		try {
			Professor p = em.find(Professor.class, id);
			System.out.println("Professor Recuperado!");
			return p;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao recuperar professor!");
		} finally {
			em.close();
			close();
		}
		return null;
	}

	public Professor update(Professor aluno) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		int id = aluno.getIdPessoa();
		try {
			Professor p = em.find(Professor.class, id);
			if (p != null) {
				p = aluno;
				em.merge(p);
				em.getTransaction().commit();
				System.out.println("Professor atualizado!");
			} else {
				System.out.println("Professor inexistente!");
			}
			return p;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao atualizar!");
		} finally {
			em.close();
			close();
		}
		return null;

	}

	public void remove(Professor professor) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			Professor a = em.find(Professor.class, professor.getIdPessoa());
			if (a != null)
				em.remove(a);
			em.getTransaction().commit();
			System.out.println("Professor removido!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("erro ao remover professor!");
		} finally {
			em.close();
			close();
		}
	}
	
	public List<Professor> ListProfessores(){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Professor> professores = em.createQuery("Select p from Professor p").getResultList();
		em.close();
		close();
		return professores;
	}

}
