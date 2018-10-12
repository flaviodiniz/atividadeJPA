package br.ifpb.ads.bd2.modelos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco  {

	@Column(length = 50)
	private String rua;

	@Column(length = 50)
	private String cidade;

	@Column(length = 50)
	private String bairro;

	@Column(length = 50)
	private String estado;

	@Column(length = 50)
	private String complemento;

	@Column(length = 8)
	private String cep;

	public Endereco() {

	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
