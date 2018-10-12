package br.ifpb.ads.bd2.dao;

import javax.persistence.EntityManager;

import br.ifpb.ads.bd2.modelos.Turma;

public class TurmaDao extends DAO {

	public void create(Turma turma) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();

		try {
			em.persist(turma);
			em.getTransaction().commit();
			System.out.println("Turma salva!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao salvar turma!");
		} finally {
			em.close();
			close();
		}
	}

	public Turma find(Turma turma) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		int id = turma.getCodigo_turma();
		try {
			Turma t = em.find(Turma.class, id);
			System.out.println("Turma recuperada!");
			return t;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao recuperar!");
		} finally {
			em.close();
			close();
		}
		return null;
	}

	public Turma update(Turma turma) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		int id = turma.getCodigo_turma();
		try {
			Turma t = em.find(Turma.class, id);
			if (t != null) {
				t = turma;
				em.merge(t);
				em.getTransaction().commit();
				System.out.println("Turma atualizada!");
			} else {
				System.out.println("Turma inexistente!");
			}
			return t;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao atualizar!");
		} finally {
			em.close();
			close();
		}
		return null;

	}

	public void remove(Turma turma) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			Turma t = em.find(Turma.class, turma.getCodigo_turma());
			if (t != null)
				em.remove(t);
			em.getTransaction().commit();
			System.out.println("Turma removida!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao remover turma!");
		} finally {
			em.close();
			close();
		}
	}

}
