package test;

import java.sql.SQLException;

import dao.AlunoDao;
import trabalhojavanp1.objetos.Aluno;

public class teste {

	
	public static void main(String[] args) throws SQLException {
		Aluno aluno = new Aluno("leo", "tantofaz", null);
		AlunoDao dao = new AlunoDao();
		dao.inserirAluno(aluno);
	}
}
