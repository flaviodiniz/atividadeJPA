package br.ifpb.ads.bd2.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.ifpb.ads.bd2.modelos.Aluno;
import br.ifpb.ads.bd2.modelos.Pessoa;
import br.ifpb.ads.bd2.modelos.Professor;

public class PessoaDao extends DAO {

	public void create(Pessoa pessoa) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();

		try {
			em.persist(pessoa);
			em.getTransaction().commit();
			System.out.println("Pessoa Salv!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao salvar Pessoa!");
		} finally {
			em.close();
		}
	}

	public Pessoa find(Pessoa pessoa) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		int id = pessoa.getIdPessoa();
		try {
			Pessoa p = em.find(Pessoa.class, id);
			System.out.println("Pessoa recuperado!");
			return p;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao recuperar Pessoa!");
		} finally {
			em.close();
		}
		return null;
	}

	public Pessoa update(Pessoa pessoa) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		int id = pessoa.getIdPessoa();
		try {
			Pessoa p = em.find(Pessoa.class, id);
			if (p != null) {
				p = pessoa;
				em.merge(p);
				em.getTransaction().commit();
				System.out.println("Pessoa atualizado!");
			} else {
				System.out.println("Pessoa inexistente!");
			}
			return p;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao atualizar!");
		} finally {
			em.close();
		}
		return null;

	}

	public void remove(Pessoa pessoa) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			Pessoa p = em.find(Pessoa.class, pessoa.getIdPessoa());
			if (p != null)
				em.remove(p);
			em.getTransaction().commit();
			System.out.println("Aluno removido!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao remover aluno!");
		} finally {
			em.close();
		}
	}
	
	public ArrayList<Pessoa> listPessoas(){
		AlunoDao aluno = new AlunoDao();
		ProfessorDao professor = new ProfessorDao();
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (Aluno a: aluno.ListAlunos()) {
			pessoas.add(a);
		}
		for (Professor p: professor.ListProfessores()) {
			pessoas.add(p);
		}
		return pessoas;
	}
	public ArrayList<Pessoa> listPessoasPorCidadeOuEstado(String cidade, String estado){
		AlunoDao aluno = new AlunoDao();
		ProfessorDao professor = new ProfessorDao();
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (Aluno a: aluno.ListAlunos()) {
			if(a.getEndereco().getCidade().equals(cidade) || a.getEndereco().getEstado().equals(estado))
				pessoas.add(a);
		}
		for (Professor p: professor.ListProfessores()) {
			if(p.getEndereco().getCidade().equals(cidade) || p.getEndereco().getEstado().equals(estado))
				pessoas.add(p);
		}
		return pessoas;
	}

}
