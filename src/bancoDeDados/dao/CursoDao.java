package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import trabalhojavanp1.objetos.Curso;

public class CursoDao {

	public boolean inserirCurso(Curso curso) {

		PreparedStatement query;
		try {
			query = new ConnectionFactory().getConnection()
					.prepareStatement("INSERT INTO cursos(id, nome) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			query.setInt(1, curso.getCodCurso());
			query.setString(2, curso.getNomeDoCurso());
			
			query.executeUpdate();
			ResultSet id = query.getGeneratedKeys();
			
			curso.setCodCurso(id.getInt(1));
			System.out.println("curso inserido com sucesso");
			
			query.close();
			
			return true;
		} catch (SQLException e) {
			return false;
		}

		
	}

	public boolean deletarCurso(Curso curso) {
		
		try {
			new AlunoCursoDao().deletaCurso(curso);
			
			new CursoDisciplinaProfessorDao().deletaCurso(curso);

			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("DELETE FROM cursos WHERE id = ?");

			query.setInt(1, curso.getCodCurso());

			query.execute();
			query.close();

			new AlunoCursoDao().deletaCurso(curso);
			
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}

	public boolean alteraNomeCurso(Curso curso) {

		PreparedStatement query;
		try {
			query = new ConnectionFactory().getConnection()
					.prepareStatement("UPDATE cursos SET nome = ? WHERE id = ?");
			
			query.setString(1, curso.getNomeDoCurso());
			query.setInt(2, curso.getCodCurso());

			query.execute();
			query.close();
			
			return true;
		} catch (SQLException e) {
			return false;
		}

		
	}

	public ArrayList<Object> mostraCursos() {

		
		try {
			ArrayList<Object> listaCursos = new ArrayList<Object>();
			
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
		} catch (SQLException e) {
			return null;
		}

		
	}

	public boolean deletarCursoProId(int id) {
		
		try {
			new AlunoCursoDao().deletaCursoPorId(id);
			
			new CursoDisciplinaProfessorDao().deletaCursoProId(id);

			PreparedStatement query = new ConnectionFactory().getConnection()
					.prepareStatement("DELETE FROM cursos WHERE id = ?");

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
					.prepareStatement("SELECT * FROM cursos WHERE id = ?");
			
			query.setInt(1, id);
			
			ResultSet resposta = query.executeQuery();

			Curso a = new Curso();
			
			while (resposta.next()) {
				
				a.setCodCurso(resposta.getInt(1));
				a.setNomeDoCurso(resposta.getString(2));
			}

			query.close();

			return a;
		} catch (SQLException e) {
			return null;
		}
	}
}
