package br.ifpb.ads.bd2.main;

import java.util.ArrayList;
import java.util.Iterator;

import br.ifpb.ads.bd2.dao.CursoDao;
import br.ifpb.ads.bd2.dao.DisciplinaDao;
import br.ifpb.ads.bd2.dao.PessoaDao;
import br.ifpb.ads.bd2.modelos.Aluno;
import br.ifpb.ads.bd2.modelos.ContatoTelefone;
import br.ifpb.ads.bd2.modelos.Curso;
import br.ifpb.ads.bd2.modelos.Disciplina;
import br.ifpb.ads.bd2.modelos.Pessoa;
import br.ifpb.ads.bd2.modelos.Turma;

public class ListandoObjetos {

	public static void main(String[] args) {
		PessoaDao p = new PessoaDao();
		System.out.println("Listando todas as pessoas:");
		ArrayList<Pessoa> pessoas = p.listPessoas();
		for (Pessoa pe : pessoas) {
			System.out.println("Pessoa: Nome= " + pe.getNome() + ", id= " + pe.getIdPessoa());
		}

		System.out.println("Listando todas as pessoas por cidade ou estado:");
		ArrayList<Pessoa> pessoas2 = p.listPessoasPorCidadeOuEstado("Monteiro", "Pernambuco");
		for (Pessoa pe : pessoas2) {
			System.out.println("Pessoa: Nome= " + pe.getNome() + ", id= " + pe.getIdPessoa());
		}

		System.out.println("Listando todas as disciplinas nortunas:");
		CursoDao c = new CursoDao();
		ArrayList<Curso> cursos = c.listaDisciplinasNortunas();
		for (Curso curso : cursos) {
			System.out.println("Curso: " + curso.getNome());
			for (Disciplina d : curso.getDisciplinas()) {
				System.out.println("Disciplina =  " + d.getNome());
			}
		}

		System.out.println("Listando todas pessoas das disciplinas por curso:");
		DisciplinaDao disDao = new DisciplinaDao();
		ArrayList<Disciplina> disciplinas = disDao.listaPessoasPorCurso("ADS");
		ArrayList<Turma> turmas = new ArrayList<Turma>();
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		for (Disciplina d : disciplinas) {
			turmas = (ArrayList<Turma>) d.getTurma();
			for (Turma t : turmas) {
				alunos = (ArrayList<Aluno>) t.getAlunos();
			}
			for (Aluno a : alunos) {
				System.out.println(
						"Aluno: Nome= " + a.getNome() + " matricula= " + a.getMatricula() + "email=" + a.getEmail());
				for (ContatoTelefone t : a.getTelefones()) {
					if (t.getPessoa().getIdPessoa() == a.getIdPessoa())
						System.out.println("Telefone: " + t.getNumero());
				}
			}
		}

	}

}
