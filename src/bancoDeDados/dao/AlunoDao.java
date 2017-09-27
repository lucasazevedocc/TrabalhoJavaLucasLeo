package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import trabalhojavanp1.objetos.Aluno;

public class AlunoDao {

	private Connection connection;

	public AlunoDao() {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}

	public void inserirAluno(Aluno aluno) throws SQLException {

		PreparedStatement query = this.connection
				.prepareStatement("INSERT INTO alunos(nome, endereco) VALUES(?, ?)");
		query.setString(1, aluno.getNome());
		query.setString(2, aluno.getEndereco());
		
		if(query.execute()) {
			System.out.println("erro ao inserir aluno");
		}else {
			System.out.println("aluno criado com sucesso");
		}
		query.close();
		this.connection.close();
	}

	public void deletarAluno(Aluno aluno) throws SQLException {

		PreparedStatement query = this.connection
				.prepareStatement("DELETE FROM alunos WHERE id = ?");
		query.setString(1, aluno.getMatricula());
			
		query.executeUpdate();
		
		query.close();
		this.connection.close();
	}

	public void alterarAluno(Aluno aluno) throws SQLException {

		PreparedStatement query = this.connection
				.prepareStatement("UPDATE alunos SET nome = ?, endereco = ? WHERE id = ? ");
		query.setString(1, aluno.getNome());
		query.setString(2, aluno.getEndereco());
		query.setString(3, aluno.getMatricula());
		
		query.execute();
		query.close();
		this.connection.close();
	}

}
