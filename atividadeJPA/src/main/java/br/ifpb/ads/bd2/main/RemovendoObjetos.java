package br.ifpb.ads.bd2.main;

import br.ifpb.ads.bd2.dao.AlunoDao;
import br.ifpb.ads.bd2.modelos.Aluno;

public class RemovendoObjetos {

	public static void main(String[] args) {
		Aluno a = new Aluno();
		a.setIdPessoa(2);
		
		AlunoDao alunoDao = new AlunoDao();
		alunoDao.remove(a);

	}

}
