package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import trabalhojavanp1.objetos.Disciplina;
import trabalhojavanp1.objetos.Professor;

public class DisciplinaProfessorDao {

	public boolean inserir(Professor prof) {
		boolean resposta = false;
		for (Integer key : prof.getDisciplinas().keySet()) {

			try {
				PreparedStatement query = new ConnectionFactory().getConnection()
						.prepareStatement("INSERT INTO disciplina_professor(id_disciplina, id_professor) VALUES(?, ?)");

				query.setInt(1, key);

				query.setInt(2, prof.getRegistro());

				query.executeUpdate();
				System.out.println("disciplina inserida com sucesso");

				query.close();

				resposta = true;
			} catch (SQLException e) {
				resposta = false;
			}
		}
		return resposta;
	}

	public void deletaDisciplina(Disciplina disc) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("DELETE FROM disciplina_professor WHERE id_disciplina = ?");
		query.setInt(1, disc.getCodDisciplina());

		query.execute();
		query.close();
	}

	public void deletaProfessor(Professor prof) {

		try {
			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("DELETE FROM disciplina_professor WHERE id_professor = ?");
			query.setInt(1, prof.getRegistro());

			query.execute();
			query.close();
		} catch (Exception e) {

		}
	}

	public ArrayList<Disciplina> mostraDisciplinas(Disciplina disc) throws SQLException {

		ArrayList<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();

		PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement(
				"SELECT id, nome FROM disciplinas JOIN disciplina_professor ON disciplinas.id = disciplina_professor.id_disciplina WHERE id_disciplina = ?");

		query.setInt(1, disc.getCodDisciplina());

		ResultSet resposta = query.executeQuery();

		while (resposta.next()) {
			Disciplina d = new Disciplina();
			d.setCodDisciplina(resposta.getInt(1));
			d.setNomeDisciplina(resposta.getString(2));
			listaDisciplinas.add(d);
		}

		query.close();

		return listaDisciplinas;
	}

	public HashMap<Integer, Disciplina> mostraDisciplinasPorPorfessor(Professor prof) {

		try {
			HashMap<Integer, Disciplina> listaProfessores = new HashMap<Integer, Disciplina>();

			PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement(
					"SELECT id FROM disciplinas JOIN disciplina_professor ON disciplinas.id = disciplina_professor.id_disciplina WHERE id_professor = ?");

			query.setInt(1, prof.getRegistro());

			ResultSet resposta = query.executeQuery();

			while (resposta.next()) {
				listaProfessores.put(resposta.getInt(1), new DisciplinaDao().mostraUmaDisciplina(resposta.getInt(1)));
			}

			query.close();

			return listaProfessores;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean deletaDisciplinaProId(int id) {

		try {
			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("DELETE FROM disciplina_professor WHERE id_disciplina = ?");

			query.setInt(1, id);

			query.execute();
			query.close();

			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean deletaProfessorPorId(int id) {

		try {
			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("DELETE FROM disciplina_professor WHERE id_professor = ?");

			query.setInt(1, id);

			query.execute();
			query.close();

			return true;
		} catch (SQLException e) {
			return false;
		}

	}
}
