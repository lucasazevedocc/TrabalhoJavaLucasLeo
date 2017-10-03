package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import trabalhojavanp1.objetos.Curso;
import trabalhojavanp1.objetos.Disciplina;
import trabalhojavanp1.objetos.Professor;

public class CursoDisciplinaProfessorDao {

	public void inserir(Curso curso, Professor prof, Disciplina disc) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement(
				"INSERT INTO curso_disciplina_professor(id_curso, id_disciplina, id_professor) VALUES(?, ?, ?)");

		query.setInt(1, curso.getCodCurso());
		query.setInt(2, disc.getCodDisciplina());
		query.setInt(3, prof.getRegistro());

		query.executeUpdate();
		System.out.println("inser��o feita com sucesso");
		
		query.close();
	}

	public void deletaCurso(Curso curso) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("DELETE FROM curso_disciplina_professor WHERE id_curso = ?");

		query.setInt(1, curso.getCodCurso());

		query.execute();
		query.close();
	}

	public void deletaProfessor(Professor prof) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("DELETE FROM curso_disciplina_professor WHERE id_professor = ?");

		query.setInt(1, prof.getRegistro());

		query.execute();
		query.close();
	}

	public void deletaDisciplina(Disciplina disc) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("DELETE FROM curso_disciplina_professor WHERE id_disciplina = ?");

		query.setInt(1, disc.getCodDisciplina());

		query.execute();
		query.close();
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
}
