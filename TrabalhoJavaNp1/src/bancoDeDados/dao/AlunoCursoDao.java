package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import trabalhojavanp1.objetos.Aluno;
import trabalhojavanp1.objetos.Curso;

public class AlunoCursoDao {

	public boolean inserirAlunoCurso(Aluno aluno) {

		boolean resposta = false;
		for (Integer key : aluno.getCursando().keySet()) {

			try {
				PreparedStatement query = new ConnectionFactory().getConnection()
						.prepareStatement("INSERT INTO aluno_curso(id_curso, id_aluno) VALUES(?, ?)");

				query.setInt(1, key);

				query.setInt(2, aluno.getMatricula());

				query.executeUpdate();
				query.close();

				resposta = true;
			} catch (SQLException e) {
				resposta = false;
			}
		}
		return resposta;
	}

	public void deletaCurso(Curso curso) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("DELETE FROM aluno_curso WHERE id_curso = ?");
		query.setInt(1, curso.getCodCurso());

		query.execute();
		query.close();
	}

	public void deletaAluno(Aluno aluno) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("DELETE FROM aluno_curso WHERE id_aluno = ?");
		query.setInt(1, aluno.getMatricula());

		query.execute();
		query.close();
	}

	public ArrayList<Aluno> mostraAlunos(Curso curso) throws SQLException {

		ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();

		PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement(
				"SELECT id, nome, endereco FROM alunos JOIN aluno_curso ON alunos.id = aluno_curso.id_aluno WHERE id_curso = ?");

		query.setInt(1, curso.getCodCurso());

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

	public ArrayList<Curso> mostraCursos(Aluno aluno) {

		try {
			ArrayList<Curso> listaCursos = new ArrayList<Curso>();

			PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement(
					"SELECT id, nome FROM cursos JOIN aluno_curso ON cursos.id = aluno_curso.id_curso WHERE id_aluno = ?");

			query.setInt(1, aluno.getMatricula());

			ResultSet resposta = query.executeQuery();

			while (resposta.next()) {
				Curso c = new Curso();
				c.setCodCurso(resposta.getInt(1));
				c.setNomeDoCurso(resposta.getString(2));
				listaCursos.add(c);
			}

			query.close();

			return listaCursos;
		} catch (SQLException e) {
			return null;
		}
	}

	public boolean deletaAlunoPorId(int id) {

		try {
			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("DELETE FROM aluno_curso WHERE id_aluno = ?");

			query.setInt(1, id);

			query.execute();
			query.close();

			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean deletaCursoPorId(int id) {
		try {
			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("DELETE FROM aluno_curso WHERE id_curso = ?");

			query.setInt(1, id);

			query.execute();
			query.close();

			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public HashMap<Integer, Curso> mostraPorAluno(Aluno aluno) {
		try {

			HashMap<Integer, Curso> listaCursos = new HashMap<Integer, Curso>();

			PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement(
					"SELECT id FROM cursos JOIN aluno_curso ON aluno_curso.id_curso = cursos.id WHERE id_aluno = ?");

			query.setInt(1, aluno.getMatricula());

			ResultSet resposta = query.executeQuery();

			while (resposta.next()) {
				listaCursos.put(resposta.getInt(1), (Curso) new CursoDao().mostrarPorId(resposta.getInt(1)));
			}
			query.close();

			return listaCursos;
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean inserirProId(int curso, int aluno) {
		try {
			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("INSERT INTO aluno_curso(id_curso, id_aluno) VALUES(?, ?)");

			query.setInt(1, curso);

			query.setInt(2, aluno);

			query.executeUpdate();
			query.close();
			
			return true;

		} catch (SQLException e) {
			return false;
		}
	}

}
