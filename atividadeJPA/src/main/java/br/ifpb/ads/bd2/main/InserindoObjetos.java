package br.ifpb.ads.bd2.main;

import java.util.ArrayList;

import br.ifpb.ads.bd2.dao.AlunoDao;
import br.ifpb.ads.bd2.dao.ContatoTelefoneDao;
import br.ifpb.ads.bd2.dao.CursoDao;
import br.ifpb.ads.bd2.dao.DisciplinaDao;
import br.ifpb.ads.bd2.dao.ProfessorDao;
import br.ifpb.ads.bd2.dao.TurmaDao;
import br.ifpb.ads.bd2.modelos.Aluno;
import br.ifpb.ads.bd2.modelos.ContatoTelefone;
import br.ifpb.ads.bd2.modelos.Curso;
import br.ifpb.ads.bd2.modelos.Disciplina;
import br.ifpb.ads.bd2.modelos.Endereco;
import br.ifpb.ads.bd2.modelos.Professor;
import br.ifpb.ads.bd2.modelos.Tipo;
import br.ifpb.ads.bd2.modelos.Turma;

public class InserindoObjetos {

	public static void main(String[] args) {
		System.out.println("Inserindo Objetos!");
		System.out.println("*****************************************");
		System.out.println("Inserindo Aluno 1");
		Endereco e = new Endereco();
		e.setRua("rua manuel noberto");
		e.setBairro("Ze Tranquilino");
		e.setCep("58580000");
		e.setCidade("Serra Branca");
		e.setEstado("Paraiba");

		Aluno a = new Aluno();
		a.setIdPessoa(1);
		a.setNome("Flavio");
		a.setEmail("flvdiniz91@gmail.com");
		a.setMatricula(123);
		a.setEndereco(e);

		ContatoTelefone fone = new ContatoTelefone();
		fone.setNumero("99945-0664");
		fone.setPessoa(a);	

		System.out.println("*****************************************");
		System.out.println("Inserindo Aluno 2");
		Endereco e2 = new Endereco();
		e2.setRua("rua travessia quiteria");
		e2.setBairro("centro");
		e2.setCep("58500000");
		e2.setCidade("Monteiro");
		e2.setEstado("Paraiba");

		Aluno a2 = new Aluno();
		a2.setIdPessoa(2);
		a2.setNome("Flavio Santos");
		a2.setEmail("f-s.b@gmail.com");
		a2.setMatricula(123);
		a2.setEndereco(e);

		ContatoTelefone fone2 = new ContatoTelefone();
		fone2.setNumero("99941-0359");
		fone2.setPessoa(a2);

		System.out.println("*****************************************");
		System.out.println("Inserindo Professor 1");
		Endereco e3 = new Endereco();
		e3.setRua("BR");
		e3.setBairro("Trevo");
		e3.setCep("58500000");
		e3.setCidade("Monteiro");
		e3.setEstado("Paraiba");

		Professor p = new Professor();
		p.setIdPessoa(3);
		p.setNome("Anderson");
		p.setEmail("anderson@gmail.com");
		p.setTitulo("BD2");
		p.setEndereco(e3);

		ContatoTelefone fone3 = new ContatoTelefone();
		fone3.setNumero("99999-8888");
		fone3.setPessoa(p);

		System.out.println("*****************************************");
		System.out.println("Inserindo Aluno 3");
		Endereco e4 = new Endereco();
		e4.setRua("");
		e4.setBairro("cavaleiros");
		e4.setCep("58000000");
		e4.setCidade("Recife");
		e4.setEstado("Pernambuco");

		Aluno a3 = new Aluno();
		a3.setIdPessoa(4);
		a3.setNome("Luciano Azevedo");
		a3.setEmail("lucianocomputador@gmail.com");
		a3.setMatricula(788);
		a3.setEndereco(e4);

		ContatoTelefone fone4 = new ContatoTelefone();
		fone4.setNumero("99910-5795");
		fone4.setPessoa(a3);

		System.out.println("*****************************************");
		System.out.println("Criando lista de alunos");
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(a);
		alunos.add(a2);
		alunos.add(a3);

		System.out.println("*****************************************");
		System.out.println("Criando turma 1");
		Turma turma = new Turma();
		turma.setProfessor(p);
		turma.setAlunos(alunos);
		turma.setNome("2018-2");

		System.out.println("*****************************************");
		System.out.println("Criando Disciplina");
		Disciplina disciplina = new Disciplina();
		disciplina.setNome("Bd2");
		disciplina.setEmenta("JDBC, JPA, XML, Semi-estruturados, GRAFOS, etc.");
		ArrayList<Turma> turmas = new ArrayList<Turma>();
		turmas.add(turma);
		disciplina.setTurma(turmas);
		turma.setDisciplina(disciplina);
		
		System.out.println("*****************************************");
		System.out.println("Criando Curso");
		Curso curso = new Curso();
		curso.setNome("ADS");
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas.add(disciplina);
		curso.setDisciplinas(disciplinas);
		curso.setTipo(Tipo.NOITE);
		disciplina.setCurso(curso);

		System.out.println("*****************************************");
		System.out.println("SALVANDO OBJETOS");
		ContatoTelefoneDao foneDao = new ContatoTelefoneDao();
		AlunoDao alunoDao = new AlunoDao();
		alunoDao.create(a);
		foneDao.create(fone);
		alunoDao.create(a2);
		foneDao.create(fone2);
		ProfessorDao profDao = new ProfessorDao();
		profDao.create(p);
		foneDao.create(fone3);
		alunoDao.create(a3);
		foneDao.create(fone4);
		TurmaDao turmaDao = new TurmaDao();
		turmaDao.create(turma);
		DisciplinaDao disDao = new DisciplinaDao();
		disDao.create(disciplina);
		CursoDao cursoDao = new CursoDao();
		cursoDao.create(curso);
	}

}
