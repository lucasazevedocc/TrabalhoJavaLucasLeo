package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import com.mysql.jdbc.Statement;

import trabalhojavanp1.objetos.Aluno;

public class AlunoDao {

	public boolean inserirAluno(Aluno aluno) {

		PreparedStatement query;
		try {
			query = new ConnectionFactory().getConnection()
					.prepareStatement("INSERT INTO alunos(nome, endereco) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			query.setString(1, aluno.getNome());
			query.setString(2, aluno.getEndereco());

			query.executeUpdate();
			ResultSet id = query.getGeneratedKeys();

			aluno.setMatricula(id.getInt(1));
			System.out.println("aluno inserido com sucesso");

			query.close();
			
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}

	public boolean deletarAluno(Aluno aluno) {

		try {
			new AlunoCursoDao().deletaAluno(aluno);
			
			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("DELETE FROM alunos WHERE id=?");
			query.setInt(1, aluno.getMatricula());

			if (query.executeUpdate() != 0) {
				System.out.println("usuario excluido com sucesso");
			} else {
				System.out.println("erro");
			}

			query.close();

			new AlunoCursoDao().deletaAluno(aluno);
			
			return true;
		} catch (SQLException e) {
			return false;
		}

		
	}

	public boolean alterarAluno(Aluno aluno){

		PreparedStatement query;
		try {
			query = new ConnectionFactory().getConnection()
					.prepareStatement("UPDATE alunos SET nome = ?, endereco = ? WHERE id = ? ");
			
			query.setString(1, aluno.getNome());
			query.setString(2, aluno.getEndereco());
			query.setInt(3, aluno.getMatricula());

			if (query.execute()) {
				System.out.println("erro ao alterar");
			} else {
				System.out.println("usuario " + aluno.getMatricula() + " alterado com sucesso");
			}
			query.close();
			
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}

	public ArrayList<Aluno> mostraAlunos() throws SQLException {

		ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();

		PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement("SELECT * FROM alunos");

		ResultSet resposta = query.executeQuery();

		while (resposta.next()) {
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
