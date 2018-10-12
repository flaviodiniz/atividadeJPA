package br.ifpb.ads.bd2.main;

import br.ifpb.ads.bd2.dao.AlunoDao;
import br.ifpb.ads.bd2.dao.ProfessorDao;
import br.ifpb.ads.bd2.modelos.Aluno;
import br.ifpb.ads.bd2.modelos.ContatoTelefone;
import br.ifpb.ads.bd2.modelos.Endereco;
import br.ifpb.ads.bd2.modelos.Professor;

public class AtualizandoObjetos {

	public static void main(String[] args) {
		System.out.println("Atualizando Objetos!");
		System.out.println("*****************************************");
		System.out.println("Atualizando Aluno 1");
		Endereco e = new Endereco();
		e.setRua("rua manuel noberto");
		e.setBairro("Ze Tranquilino");
		e.setCep("58580000");
		e.setCidade("Serra Branca");
		e.setEstado("Paraiba");
		e.setComplemento("Residencia");
		
		Aluno a = new Aluno();
		a.setIdPessoa(1);
		a.setNome("Flavio Diniz");
		a.setEmail("flvdiniz91@gmail.com");
		a.setMatricula(123);
		a.setEndereco(e);
		
		AlunoDao alunoDao = new AlunoDao();
		alunoDao.update(a);
		
		System.out.println("*****************************************");
		System.out.println("Atualizando Aluno 2");
		Endereco e2 = new Endereco();
		e2.setRua("Av travessia quiteria");
		e2.setBairro("centro");
		e2.setCep("58500000");
		e2.setCidade("Monteiro");
		e2.setEstado("Paraiba");

		Aluno a2 = new Aluno();
		a2.setIdPessoa(2);
		a2.setNome("Flavio  dos Santos");
		a2.setEmail("f-s.b@gmail.com");
		a2.setMatricula(456);
		a2.setEndereco(e);

		ContatoTelefone fone2 = new ContatoTelefone();
		fone2.setNumero("99941-0359");
		fone2.setPessoa(a2);

		alunoDao.update(a2);

		System.out.println("*****************************************");
		System.out.println("Atualizando Professor 1");
		Endereco e3 = new Endereco();
		e3.setRua("BR - IFPV");
		e3.setBairro("Trevo");
		e3.setCep("58500000");
		e3.setCidade("Monteiro");
		e3.setEstado("Paraiba");

		Professor p = new Professor();
		p.setIdPessoa(3);
		p.setNome("Anderson");
		p.setEmail("anderson@gmail.com");
		p.setTitulo("BD2");
		p.setEndereco(e);

		ContatoTelefone fone3 = new ContatoTelefone();
		fone3.setNumero("99988-8888");
		fone3.setPessoa(p);
		
		ProfessorDao profDao = new ProfessorDao();
		profDao.update(p);


	}

}
