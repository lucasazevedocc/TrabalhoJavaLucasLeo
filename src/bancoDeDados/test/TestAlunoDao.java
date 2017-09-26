package test;

import java.sql.SQLException;

import dao.AlunoDao;
import trabalhojavanp1.objetos.Aluno;

public class TestAlunoDao {

	
	public static void main(String[] args) throws SQLException {
		
		Aluno aluno = new Aluno("admin", "admin", "tantofaz", null);
		AlunoDao dao = new AlunoDao();
		
		dao.inserirAluno(aluno);
	}
}
