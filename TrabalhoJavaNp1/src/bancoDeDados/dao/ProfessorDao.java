package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import trabalhojavanp1.objetos.Curso;
import trabalhojavanp1.objetos.Materia;
import trabalhojavanp1.objetos.Professor;

public class ProfessorDao {

	public boolean inserirProfessor(Professor prof) {

		try {
			PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement(
					"INSERT INTO professores(id, nome, formacao) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			query.setInt(1, prof.getRegistro());
			query.setString(2, prof.getNome());
			query.setString(3, prof.getFormacao());

			query.executeUpdate();
			ResultSet id = query.getGeneratedKeys();

			id.next();

			prof.setRegistro(id.getInt(1));
			System.out.println("professor inserido com sucesso");

			query.close();

			new DisciplinaProfessorDao().inserir(prof);

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

		try {
			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("UPDATE professores SET nome = ?, formacao = ? WHERE id = ?");

			query.setString(1, prof.getNome());
			query.setString(2, prof.getFormacao());
			query.setInt(3, prof.getRegistro());

			query.execute();
			query.close();

			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public List<Object> mostraProfessores() {

		try {
			ArrayList<Object> listaProfessores = new ArrayList<Object>();

			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("SELECT * FROM professores");

			ResultSet resposta = query.executeQuery();

			while (resposta.next()) {
				Professor a = new Professor();
				a.setRegistro(resposta.getInt(1));
				a.setNome(resposta.getString(2));
				a.setFormacao(resposta.getString(3));
				a.setDisciplinas(new DisciplinaProfessorDao().mostraDisciplinasPorPorfessor(a));
				a.setLecionando(new CursoDisciplinaProfessorDao().mostraMateriaPorProfessor(a));

				listaProfessores.add(a);
			}

			query.close();

			return listaProfessores;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean deletarProfessorProId(int id) {

		try {
			new CursoDisciplinaProfessorDao().deletaProfessorPorId(id);

			new DisciplinaProfessorDao().deletaProfessorPorId(id);

			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("DELETE FROM professores WHERE id = ?");

			query.setInt(1, id);

			query.execute();
			query.close();

			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public Object mostrarProfessorPorId(int id) {

		try {

			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("SELECT id, nome, formacao FROM professores WHERE id = ?");

			query.setInt(1, id);

			ResultSet resposta = query.executeQuery();

			resposta.next();

			Professor a = new Professor();
			a.setRegistro(resposta.getInt(1));
			a.setNome(resposta.getString(2));
			a.setFormacao(resposta.getString(3));
			a.setDisciplinas(new DisciplinaProfessorDao().mostraDisciplinasPorPorfessor(a));

			query.close();

			return a;
		} catch (SQLException e) {
			return null;
		}
	}

	public Object mostrarProfessorProIdComMateria(Materia materia) {

		try {

			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("SELECT id, nome, formacao FROM professores WHERE id = ?");

			query.setInt(1, materia.getProfessor().getRegistro());

			ResultSet resposta = query.executeQuery();

			resposta.next();

			Professor a = new Professor();
			a.setRegistro(resposta.getInt(1));
			a.setNome(resposta.getString(2));
			a.setFormacao(resposta.getString(3));
			a.setDisciplinas(new DisciplinaProfessorDao().mostraDisciplinasPorPorfessor(a));
			a.setLecionando(new CursoDisciplinaProfessorDao().mostraMateriaPorProfessor(a));

			query.close();

			return a;
		} catch (SQLException e) {
			return null;
		}
	}

	public Object mostrarProfessorDoCurso(int i) {

		try {

			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("SELECT id, nome, formacao FROM professores WHERE id = ?");

			query.setInt(1, i);

			ResultSet resposta = query.executeQuery();

			resposta.next();

			Professor a = new Professor();
			a.setRegistro(resposta.getInt(1));
			a.setNome(resposta.getString(2));
			a.setFormacao(resposta.getString(3));
			a.setDisciplinas(new DisciplinaProfessorDao().mostraDisciplinasPorPorfessor(a));
			a.setLecionando(new CursoDisciplinaProfessorDao().mostraMateriaPorProfessor(a));

			query.close();

			return a;
		} catch (SQLException e) {
			return null;
		}
	}

	public ArrayList<Professor> mostraProfessorDaDisciplina(int id) {
		try {
			ArrayList<Professor> listaProfessor = new ArrayList<>();

			PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement(
					"SELECT id, nome, formacao FROM professores JOIN disciplina_professor ON disciplina_professor.id_professor = professores.id WHERE disciplina_professor.id_disciplina = ?");

			query.setInt(1, id);

			ResultSet resposta = query.executeQuery();

			while (resposta.next()) {

				Professor a = new Professor();
				a.setRegistro(resposta.getInt(1));
				a.setNome(resposta.getString(2));
				a.setFormacao(resposta.getString(3));
				a.setDisciplinas(new DisciplinaProfessorDao().mostraDisciplinasPorPorfessor(a));
				a.setLecionando(new CursoDisciplinaProfessorDao().mostraMateriaPorProfessor(a));
				listaProfessor.add(a);
			}

			query.close();

			return listaProfessor;
		} catch (SQLException e) {
			return null;
		}
	}
}
