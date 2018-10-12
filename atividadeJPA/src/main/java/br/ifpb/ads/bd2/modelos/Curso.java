package br.ifpb.ads.bd2.modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso {

	private String nome;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_curso;

	@Enumerated
	private Tipo tipo;

	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
	private List<Disciplina> disciplinas;

	public Curso() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCod_curso() {
		return cod_curso;
	}

	public void setCod_curso(int cod_curso) {
		this.cod_curso = cod_curso;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
