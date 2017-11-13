package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.DialogTypeSelection;

import trabalhojavanp1.objetos.Curso;
import trabalhojavanp1.objetos.Disciplina;

public class DisciplinaDao {

	public boolean inserirDisciplina(Disciplina disc) {

		PreparedStatement query;
		try {
			query = new ConnectionFactory().getConnection().prepareStatement(
					"INSERT INTO disciplinas(id, nome) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);

			query.setInt(1, disc.getCodDisciplina());
			query.setString(2, disc.getNomeDisciplina());

			query.executeUpdate();
			ResultSet id = query.getGeneratedKeys();

			id.next();

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

	public List<Object> mostraDisciplinas() {

		try {
			ArrayList<Object> listaDisciplinas = new ArrayList<Object>();

			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("SELECT * FROM disciplinas");

			ResultSet resposta;

			resposta = query.executeQuery();

			while (resposta.next()) {
				Disciplina a = new Disciplina();
				a.setCodDisciplina(resposta.getInt(1));
				a.setNomeDisciplina(resposta.getString(2));

				listaDisciplinas.add(a);
			}

			query.close();

			return listaDisciplinas;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean deletarDisciplinaPorId(int id) {

		try {
			new CursoDisciplinaProfessorDao().deletaDisciplinaPorId(id);

			new DisciplinaProfessorDao().deletaDisciplinaProId(id);

			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("DELETE FROM disciplinas WHERE id = ?");

			query.setInt(1, id);

			query.execute();
			query.close();

			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public Object mostrarPorId(int id) {

		try {

			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("SELECT id, nome FROM disciplinas WHERE id = ?");

			query.setInt(1, id);

			ResultSet resposta = query.executeQuery();

			resposta.next();

			Disciplina a = new Disciplina();
			a.setCodDisciplina(resposta.getInt(1));
			a.setNomeDisciplina(resposta.getString(2));

			query.close();

			return a;
		} catch (SQLException e) {
			return null;
		}
	}

	public Disciplina mostraUmaDisciplina(int id) {

		try {

			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("SELECT * FROM disciplinas WHERE id = ?");

			query.setInt(1, id);

			ResultSet resposta = query.executeQuery();

			Disciplina disciplina = new Disciplina();

			while (resposta.next()) {
				disciplina.setCodDisciplina(resposta.getInt(1));
				disciplina.setNomeDisciplina(resposta.getString(2));
			}

			query.close();

			return disciplina;
		} catch (SQLException e) {
			return null;
		}

	}

	public ArrayList<Disciplina> mostraDisciplinaProfessor(int id) {

		try {

			ArrayList<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();

			PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement(
					"SELECT disciplinas.id, disciplinas.nome FROM disciplinas JOIN curso_disciplina_professor ON disciplinas.id = curso_disciplina_professor.id_disciplina WHERE curso_disciplina_professor.id_professor = ? ");

			query.setInt(1, id);

			ResultSet resposta = query.executeQuery();

			while (resposta.next()) {
				Disciplina disciplina = new Disciplina();
				disciplina.setCodDisciplina(resposta.getInt(1));
				disciplina.setNomeDisciplina(resposta.getString(2));
				listaDisciplinas.add(disciplina);
			}

			query.close();

			return listaDisciplinas;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ArrayList<Disciplina> mostraDisciplinaDoCurso(int id) {
		try {

			ArrayList<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();

			PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement(
					"SELECT disciplinas.id, disciplinas.nome FROM disciplinas JOIN curso_disciplina_professor ON disciplinas.id = curso_disciplina_professor.id_disciplina WHERE curso_disciplina_professor.id_curso = ? ");

			query.setInt(1, id);

			ResultSet resposta = query.executeQuery();

			while (resposta.next()) {
				Disciplina disciplina = new Disciplina();
				disciplina.setCodDisciplina(resposta.getInt(1));
				disciplina.setNomeDisciplina(resposta.getString(2));
				listaDisciplinas.add(disciplina);
			}

			query.close();

			return listaDisciplinas;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
