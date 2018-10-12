package br.ifpb.ads.bd2.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.ifpb.ads.bd2.modelos.Curso;
import br.ifpb.ads.bd2.modelos.Tipo;

public class CursoDao extends DAO {

	public void create(Curso curso) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();

		try {
			em.persist(curso);
			em.getTransaction().commit();
			System.out.println("Curso salvo!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro a salvar Curso!");
		} finally {
			em.close();
			close();
		}
	}

	public Curso find(Curso curso) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		int id = curso.getCod_curso();
		try {
			Curso c = em.find(Curso.class, id);
			System.out.println("Curso recuperada!");
			return c;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Curso não recuperado!");
		} finally {
			em.close();
			close();
		}
		return null;
	}

	public Curso update(Curso curso) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		int id = curso.getCod_curso();
		try {
			Curso c = em.find(Curso.class, id);
			if (c != null) {
				c = curso;
				em.merge(c);
				em.getTransaction().commit();
				System.out.println("Curso atualizada!");
			} else {
				System.out.println("Curso inexistente!");
			}
			return c;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao atualizar!");
		} finally {
			em.close();
			close();
		}
		return null;

	}

	public void remove(Curso curso) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			Curso c = em.find(Curso.class, curso.getCod_curso());
			if (c != null)
				em.remove(c);
			em.getTransaction().commit();
			System.out.println("Curso Removido!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao remover!");
		} finally {
			em.close();
			close();
		}
	}

	public ArrayList<Curso> listaDisciplinasNortunas() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Curso> cursos = em.createQuery("Select c from Curso c").getResultList();
		ArrayList<Curso> cursosNortunos = new ArrayList<Curso>();
		for (Curso c : cursos) {
			if (c.getTipo() == Tipo.NOITE) {
				cursosNortunos.add(c);
			}
		}
		em.close();
		close();
		return cursosNortunos;
	}

}
