package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trabalhojavanp1.objetos.Curso;

public class CursoDao {

	public void inserirCurso(Curso curso) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("INSERT INTO cursos(id, nome) VALUES(?, ?)");

		query.setInt(1, curso.getCodCurso());
		query.setString(2, curso.getNomeDoCurso());

		query.execute();
		query.close();
	}

	public void deletarCurso(Curso curso) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("DELETE FROM cursos WHERE id = ?");

		query.setInt(1, curso.getCodCurso());

		query.execute();
		query.close();

		new AlunoCursoDao().deletaCurso(curso);
	}

	public void alteraNomeCurso(Curso curso) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("UPDATE cursos SET nome = ? WHERE id = ?");

		query.setString(1, curso.getNomeDoCurso());
		query.setInt(2, curso.getCodCurso());

		query.execute();
		query.close();
	}

	public ArrayList<Curso> mostraCursos() throws SQLException {

		ArrayList<Curso> listaCursos = new ArrayList<Curso>();

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("SELECT * FROM cursos");

		ResultSet resposta = query.executeQuery();

		while (resposta.next()) {
			Curso a = new Curso();
			a.setCodCurso(resposta.getInt(1));
			a.setNomeDoCurso(resposta.getString(2));
			listaCursos.add(a);
		}

		query.close();

		return listaCursos;
	}
}
