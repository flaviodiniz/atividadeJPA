package br.ifpb.ads.bd2.modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Turma {
	private String nome;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_turma;

	@ManyToOne
	@JoinColumn(name = "titulo")
	private Professor professor;

	@ManyToMany
	private List<Aluno> alunos;

	@ManyToOne
	@JoinColumn(name = "codDisciplina")
	private Disciplina disciplina;

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo_turma() {
		return codigo_turma;
	}

	public void setCodigo_turma(int codigo_turma) {
		this.codigo_turma = codigo_turma;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Turma() {

	}

}
