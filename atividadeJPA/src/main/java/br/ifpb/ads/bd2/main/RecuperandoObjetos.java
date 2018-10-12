package br.ifpb.ads.bd2.main;

import br.ifpb.ads.bd2.dao.AlunoDao;
import br.ifpb.ads.bd2.modelos.Aluno;

public class RecuperandoObjetos {

	public static void main(String[] args) {
		Aluno a = new Aluno();
		a.setIdPessoa(1);
		
		AlunoDao alunoDao = new AlunoDao();
		Aluno a2 = alunoDao.find(a);
		System.out.println(a2.getNome());
		System.out.println(a2.getMatricula());

	}

}
