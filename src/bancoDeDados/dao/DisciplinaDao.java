package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import trabalhojavanp1.objetos.Disciplina;

public class DisciplinaDao {

	public boolean inserirDisciplina(Disciplina disc) {

		PreparedStatement query;
		try {
			query = new ConnectionFactory().getConnection()
					.prepareStatement("INSERT INTO disciplinas(id, nome) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			query.setInt(1, disc.getCodDisciplina());
			query.setString(2, disc.getNomeDisciplina());

			query.executeUpdate();
			ResultSet id = query.getGeneratedKeys();

			disc.setCodDisciplina(id.getInt(1));
			System.out.println("disciplina inserida com sucesso");

			query.close();
			
			return true;
		} catch (SQLException e) {
			return false;
		}

		
	}

	public boolean deletarDisciplina(Disciplina disc) {

		try {
			new CursoDisciplinaProfessorDao().deletaDisciplina(disc);
			
			new DisciplinaProfessorDao().deletaDisciplina(disc);

			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("DELETE FROM disciplinas WHERE id = ?");

			query.setInt(1, disc.getCodDisciplina());

			query.execute();
			query.close();
			
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}

	public boolean alteraNomeDisciplina(Disciplina disc) {

		PreparedStatement query;
		try {
			query = new ConnectionFactory().getConnection()
					.prepareStatement("UPDATE disciplinas SET nome = ? WHERE id = ?");
			
			query.setString(1, disc.getNomeDisciplina());
			query.setInt(2, disc.getCodDisciplina());

			query.execute();
			query.close();
			
			return true;
		} catch (SQLException e) {
			return false;
		}

		
	}

	public ArrayList<Disciplina> mostraDisciplinas() throws SQLException {

		ArrayList<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();

		PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement("SELECT * FROM disciplinas");

		ResultSet resposta = query.executeQuery();

		while (resposta.next()) {
			Disciplina a = new Disciplina();
			a.setCodDisciplina(resposta.getInt(1));
			a.setNome(resposta.getString(2));

			listaDisciplinas.add(a);
		}

		query.close();

		return listaDisciplinas;
	}

}
