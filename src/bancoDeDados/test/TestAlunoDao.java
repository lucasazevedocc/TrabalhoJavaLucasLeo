package test;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.AlunoDao;
import trabalhojavanp1.objetos.Aluno;

public class TestAlunoDao {

	
	public static void main(String[] args) throws SQLException {
		
		AlunoDao dao = new AlunoDao();
		ArrayList<Aluno> resposta = dao.mostraAlunos();
		
		System.out.println(resposta.get(1).getNome());
		
	}
}
