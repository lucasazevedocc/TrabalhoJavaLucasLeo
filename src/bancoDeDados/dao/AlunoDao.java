package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trabalhojavanp1.objetos.Aluno;

public class AlunoDao {


	public void inserirAluno(Aluno aluno) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("INSERT INTO alunos(nome, endereco) VALUES(?, ?)");
		query.setString(1, aluno.getNome());
		query.setString(2, aluno.getEndereco());
		
		if(query.execute()) {
			System.out.println("erro ao inserir aluno");
		}else {
			System.out.println("aluno criado com sucesso");
		}
		query.close();
	}

	public void deletarAluno(Aluno aluno) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("DELETE FROM alunos WHERE id=?");
		query.setInt(1, aluno.getMatricula());
			
		if(query.executeUpdate() != 0) {
			System.out.println("usuario excluido com sucesso");
		}else {
			System.out.println("erro");
		}
		
		query.close();
		
		new AlunoCursoDao().deletaAluno(aluno);
	}

	public void alterarAluno(Aluno aluno) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("UPDATE alunos SET nome = ?, endereco = ? WHERE id = ? ");
		query.setString(1, aluno.getNome());
		query.setString(2, aluno.getEndereco());
		query.setInt(3, aluno.getMatricula());
		
		if(query.execute()) {
			System.out.println("erro ao alterar");
		}else {
			System.out.println("usuario " + aluno.getMatricula() + " alterado com sucesso");
		}
		query.close();
	}
	
	public ArrayList<Aluno> mostraAlunos() throws SQLException{
		
		ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
		
		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("SELECT * FROM alunos");
		
		ResultSet resposta = query.executeQuery();
		
		while(resposta.next()) {
			Aluno a = new Aluno();
			a.setMatricula(resposta.getInt(1));
			a.setNome(resposta.getString(2));
			a.setEndereco(resposta.getString(3));
			listaAlunos.add(a);
		}	
		
		query.close();
		
		return listaAlunos;
	}

}
