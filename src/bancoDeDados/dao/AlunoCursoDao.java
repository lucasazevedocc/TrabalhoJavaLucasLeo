package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import trabalhojavanp1.objetos.Aluno;
import trabalhojavanp1.objetos.Curso;

public class AlunoCursoDao {

	void inseriAlunoCurso(Aluno aluno, Curso curso) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("INSERT INTO aluno_curso(id_aluno, id_curso) VALUES(?, ?)");
		query.setInt(1, aluno.getMatricula());
		query.setInt(2, curso.getCodCurso());

		if (query.execute()) {
			System.out.println("erro ao alterar");
		} else {
			System.out.println("usuario " + aluno.getMatricula() + " alterado com sucesso");
		}
		query.close();
	}
	
	void deletaCurso(Curso curso) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("DELETE FROM aluno_curso WHERE id_curso = ?");
		query.setInt(1, curso.getCodCurso());

		query.execute();
		query.close();
	}
	
	void deletaAluno(Aluno aluno) throws SQLException{
		
		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("DELETE FROM aluno_curso WHERE id_aluno = ?");
		query.setInt(1, aluno.getMatricula());

		query.execute();
		query.close();
	}

}
