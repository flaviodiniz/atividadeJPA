package br.ifpb.ads.bd2.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ContatoTelefone {
	@Id
	private String numero;
	
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	public ContatoTelefone() {

	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
