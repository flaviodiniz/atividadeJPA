package br.ifpb.ads.bd2.modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Pr")
public class Professor extends Pessoa {
	
	private String titulo;
	
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
	private List<Turma> turmas;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Professor() {

	}

}
