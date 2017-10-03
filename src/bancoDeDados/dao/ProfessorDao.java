package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import trabalhojavanp1.objetos.Professor;

public class ProfessorDao {

	public boolean inserirProfessor(Professor prof) {

		PreparedStatement query;
		try {
			query = new ConnectionFactory().getConnection().prepareStatement(
					"INSERT INTO professores(id, nome, formacao) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			query.setInt(1, prof.getRegistro());
			query.setString(2, prof.getNome());
			query.setString(3, prof.getFormacao());

			query.executeUpdate();
			ResultSet id = query.getGeneratedKeys();

			prof.setRegistro(id.getInt(1));
			System.out.println("professor inserido com sucesso");

			query.close();
			
			return true;
		} catch (SQLException e) {
			return false;
		}

		
	}

	public boolean deletarProfessor(Professor prof) {

		try {
			new CursoDisciplinaProfessorDao().deletaProfessor(prof);
			
			new DisciplinaProfessorDao().deletaProfessor(prof);

			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("DELETE FROM professores WHERE id = ?");

			query.setInt(1, prof.getRegistro());

			query.execute();
			query.close();
			
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}

	public boolean alteraNomeCurso(Professor prof) {

		PreparedStatement query;
		try {
			query = new ConnectionFactory().getConnection()
					.prepareStatement("UPDATE professores SET nome = ?, formacao = ? WHERE id = ?");
			
			query.setString(1, prof.getNome());
			query.setString(2, prof.getFormacao());
			query.setInt(2, prof.getRegistro());

			query.execute();
			query.close();
			
			return true;
		} catch (SQLException e) {
			return false;
		}

		
	}

	public ArrayList<Professor> mostraProfessores() throws SQLException {

		ArrayList<Professor> listaProfessores = new ArrayList<Professor>();

		PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement("SELECT * FROM professores");

		ResultSet resposta = query.executeQuery();

		while (resposta.next()) {
			Professor a = new Professor();
			a.setRegistro(resposta.getInt(1));
			a.setNome(resposta.getString(2));
			a.setFormacao(resposta.getString(3));

			listaProfessores.add(a);
		}

		query.close();

		return listaProfessores;
	}
}
