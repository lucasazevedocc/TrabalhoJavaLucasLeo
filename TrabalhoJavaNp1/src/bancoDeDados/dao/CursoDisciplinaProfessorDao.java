package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import trabalhojavanp1.objetos.Curso;
import trabalhojavanp1.objetos.Disciplina;
import trabalhojavanp1.objetos.Materia;
import trabalhojavanp1.objetos.Professor;

public class CursoDisciplinaProfessorDao {

	public boolean inserir(Materia materia) {

		PreparedStatement query;
		try {
			query = new ConnectionFactory().getConnection().prepareStatement(
					"INSERT INTO curso_disciplina_professor(id_curso, id_disciplina, id_professor) VALUES(?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			query.setInt(1, materia.getCurso().getCodCurso());
			query.setInt(2, materia.getDisciplina().getCodDisciplina());
			query.setInt(3, materia.getProfessor().getRegistro());

			query.executeUpdate();
			ResultSet id = query.getGeneratedKeys();

			id.next();
			materia.setCodMateria(id.getInt(1));

			query.close();

			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public boolean deletaCurso(Curso curso) {

		try {
			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("DELETE FROM curso_disciplina_professor WHERE id_curso = ?");

			query.setInt(1, curso.getCodCurso());

			query.execute();
			query.close();

			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean deletaProfessor(Professor prof) {

		try {
			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("DELETE FROM curso_disciplina_professor WHERE id_professor = ?");

			query.setInt(1, prof.getRegistro());

			query.execute();
			query.close();

			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public boolean deletaDisciplina(Disciplina disc) {

		try {
			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("DELETE FROM curso_disciplina_professor WHERE id_disciplina = ?");

			query.setInt(1, disc.getCodDisciplina());

			query.execute();
			query.close();

			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public boolean deletaCursoProId(int id) {

		try {
			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("DELETE FROM curso_disciplina_professor WHERE id_curso = ?");

			query.setInt(1, id);

			query.execute();
			query.close();

			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean deletaDisciplinaPorId(int id) {

		try {
			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("DELETE FROM curso_disciplina_professor WHERE id_disciplina = ?");

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
					.prepareStatement("DELETE FROM curso_disciplina_professor WHERE id_professor = ?");

			query.setInt(1, id);

			query.execute();
			query.close();

			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Object buscarPorIdCurso(Curso curso) {

		try {
			ArrayList<Object> listaCursos = new ArrayList<Object>();

			PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement(
					"SELECT id_curso, id_disciplina, id_professor, id_materia FROM curso_disciplina_professor WHERE id_curso = ?");

			query.setInt(1, curso.getCodCurso());

			ResultSet resposta = query.executeQuery();

			while (resposta.next()) {

				listaCursos.add(new Materia(resposta.getInt(4),
						(Disciplina) new DisciplinaDao().mostrarPorId(resposta.getInt(2)),
						(Professor) new ProfessorDao().mostrarProfessorPorId(resposta.getInt(3)),
						(Curso) new CursoDao().mostrarPorId(resposta.getInt(1))));
			}

			query.close();

			return listaCursos;

		} catch (SQLException e) {
			return null;
		}
	}

	public Object buscarPorIdProfessor(Professor prof) {

		try {
			ArrayList<Object> listaCursos = new ArrayList<Object>();

			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("SELECT * FROM curso_disciplina_professor WHERE id_professor = ?");

			query.setInt(1, prof.getRegistro());

			ResultSet resposta = query.executeQuery();

			while (resposta.next()) {
				Materia m = new Materia(resposta.getInt(1), (Disciplina) new DisciplinaDao().mostrarPorId(resposta.getInt(3)),
						(Professor) new ProfessorDao().mostrarProfessorPorId(resposta.getInt(4)),
						(Curso) new CursoDao().mostrarPorId(resposta.getInt(2)));
				listaCursos.add(m);
			}

			query.close();

			return listaCursos;

		} catch (SQLException e) {
			return null;
		}
	}

	public Object buscarPorIdDisciplina(Disciplina disc) {

		try {
			ArrayList<Object> listaCursos = new ArrayList<Object>();

			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("SELECT * FROM curso_disciplina_professor WHERE id_disciplina = ?");

			query.setInt(1, disc.getCodDisciplina());

			ResultSet resposta = query.executeQuery();

			while (resposta.next()) {
				Materia a = new Materia();
				a.setCurso((Curso) new CursoDao().mostrarPorId(resposta.getInt(1)));
				a.setDisciplina((Disciplina) new DisciplinaDao().mostrarPorId(resposta.getInt(2)));
				a.setProfessor((Professor) new ProfessorDao().mostrarProfessorPorId(resposta.getInt(3)));
				listaCursos.add(a);
			}

			query.close();

			return listaCursos;

		} catch (SQLException e) {
			return null;
		}
	}

	public HashMap<Integer, Materia> mostraMateriaPorProfessor(Professor prof) {

		try {
			HashMap<Integer, Materia> listaMaterias = new HashMap<Integer, Materia>();

			PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement(
					"SELECT id_materia, id_curso, id_disciplina, id_professor FROM curso_disciplina_professor WHERE id_professor = ?");

			query.setInt(1, prof.getRegistro());

			ResultSet resposta = query.executeQuery();

			while (resposta.next()) {
				listaMaterias.put(resposta.getInt(1),
						new Materia(resposta.getInt(1),
								(Disciplina) new DisciplinaDao().mostrarPorId(resposta.getInt(3)),
								(Professor) new ProfessorDao().mostrarProfessorPorId(resposta.getInt(4)),
								(Curso) new CursoDao().mostrarPorId(resposta.getInt(2))));
			}

			query.close();

			return listaMaterias;

		} catch (SQLException e) {
			return null;
		}
	}

	public List<Materia> mostraMateriasDoCurso(Curso curso) {
		try {
			ArrayList<Materia> listaMaterias = new ArrayList<Materia>();

			PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement(
					"SELECT id_materia, id_curso, id_disciplina, id_professor FROM curso_disciplina_professor WHERE id_curso = ?");

			query.setInt(1, curso.getCodCurso());

			ResultSet resposta = query.executeQuery();

			while (resposta.next()) {
				listaMaterias.add(new Materia(resposta.getInt(1),
						(Disciplina) new DisciplinaDao().mostrarPorId(resposta.getInt(3)),
						(Professor) new ProfessorDao().mostrarProfessorPorId(resposta.getInt(4)),
						(Curso) new CursoDao().mostrarPorId(resposta.getInt(2))));
			}

			query.close();

			return listaMaterias;

		} catch (SQLException e) {
			return null;
		}

	}

	public Object buscarPorMateria(int codMateria) {
		try {
			PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement(
					"SELECT id_materia, id_curso, id_disciplina, id_professor FROM curso_disciplina_professor WHERE id_materia = ?");

			query.setInt(1, codMateria);

			ResultSet resposta = query.executeQuery();

			resposta.next();
			Materia m = new Materia(resposta.getInt(1), (Disciplina) new DisciplinaDao().mostrarPorId(resposta.getInt(3)),
					(Professor) new ProfessorDao().mostrarProfessorPorId(resposta.getInt(4)),
					(Curso) new CursoDao().mostrarPorId(resposta.getInt(2)));

			query.close();
			
			System.out.println(m.getCurso().getCodCurso());

			return m;

		} catch (SQLException e) {
			return null;
		}
	}
	
	public ArrayList<Materia> buscarProIdCurso(int id){
		try {
			ArrayList<Materia> listaMaterias = new ArrayList<>();
			
			PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement(
					"SELECT id_materia, id_curso, id_disciplina, id_professor FROM curso_disciplina_professor WHERE id_curso = ?");

			query.setInt(1, id);

			ResultSet resposta = query.executeQuery();

			resposta.next();
			listaMaterias.add(new Materia(resposta.getInt(1), (Disciplina) new DisciplinaDao().mostrarPorId(resposta.getInt(3)),
					(Professor) new ProfessorDao().mostrarProfessorPorId(resposta.getInt(4)),
					(Curso) new CursoDao().mostrarPorId(resposta.getInt(2))));

			query.close();
			
			return listaMaterias;

		} catch (SQLException e) {
			return null;
		}
	}
}
