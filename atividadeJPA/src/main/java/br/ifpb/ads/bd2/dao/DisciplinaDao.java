package br.ifpb.ads.bd2.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.ifpb.ads.bd2.modelos.Disciplina;

public class DisciplinaDao extends DAO {
	
	public void create(Disciplina disciplina) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();

		try {
			em.persist(disciplina);
			em.getTransaction().commit();
			System.out.println("Disciplina salva!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro a salvar disciplina!");
		} finally {
			em.close();
			close();
		}
	}

	public Disciplina find(Disciplina disciplina) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		int id = disciplina.getCodDisciplina();
		try {
			Disciplina d = em.find(Disciplina.class, id);
			System.out.println("Disciplina recuperada!");
			return d;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Disciplina não recuperada!");
		} finally {
			em.close();
			close();
		}
		return null;
	}

	public Disciplina update(Disciplina disciplina) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		int id = disciplina.getCodDisciplina();
		try {
			Disciplina d = em.find(Disciplina.class, id);
			if (d != null) {
				d = disciplina;
				em.merge(d);
				em.getTransaction().commit();
				System.out.println("Disciplina atualizada!");
			} else {
				System.out.println("Disciplina inexistente!");
			}
			return d;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao atualizar!");
		} finally {
			em.close();
			close();
		}
		return null;

	}

	public void remove(Disciplina disciplina) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			Disciplina d = em.find(Disciplina.class, disciplina.getCodDisciplina());
			if (d != null)
				em.remove(d);
			em.getTransaction().commit();
			System.out.println("Disciplina Removida!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao remover!");
		} finally {
			em.close();
			close();
		}
	}
	
	public ArrayList<Disciplina> listaPessoasPorCurso(String curso) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Disciplina> disciplinas = em.createQuery("Select d from Disciplina d").getResultList();
		ArrayList<Disciplina> disPorCurso = new ArrayList<Disciplina>();
		for(Disciplina d: disciplinas) {
			if(d.getCurso().getNome().equals(curso)) {
				disPorCurso.add(d);
			}
		}
		em.close();
		close();
		return disPorCurso;
	}

}
