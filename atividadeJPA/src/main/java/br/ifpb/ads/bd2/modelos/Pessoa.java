package br.ifpb.ads.bd2.modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorValue("Pe")
public class Pessoa {

	@Id
	private int idPessoa;

	@Column(length = 50)
	private String nome;

	@Column(length = 50)
	private String email;

	@Embedded
	private Endereco endereco;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<ContatoTelefone> telefones;

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<ContatoTelefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<ContatoTelefone> telefones) {
		this.telefones = telefones;
	}

	public Pessoa() {

	}

}
