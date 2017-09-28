package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trabalhojavanp1.objetos.Disciplina;
import trabalhojavanp1.objetos.Professor;

public class DisciplinaProfessorDao {

	public void inserirProfessor(Disciplina disc, Professor prof) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("INSERT INTO disciplina_professor(id_disciplina, id_professor) VALUES(?, ?)");
		query.setInt(1, disc.getCodDisciplina());
		query.setInt(2, prof.getRegistro());

		query.executeUpdate();
		System.out.println("disciplina inserida com sucesso");
		
		query.close();
	}

	public void deletaDisciplina(Disciplina disc) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("DELETE FROM disciplina_professor WHERE id_disciplina = ?");
		query.setInt(1, disc.getCodDisciplina());

		query.execute();
		query.close();
	}

	public void deletaProfessor(Professor prof) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("DELETE FROM disciplina_professor WHERE id_professor = ?");
		query.setInt(1, prof.getRegistro());

		query.execute();
		query.close();
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
			d.setNome(resposta.getString(2));
			listaDisciplinas.add(d);
		}

		query.close();

		return listaDisciplinas;
	}

	public ArrayList<Professor> mostraProfessores(Professor prof) throws SQLException {

		ArrayList<Professor> listaProfessores = new ArrayList<Professor>();

		PreparedStatement query = new ConnectionFactory().getConnection().prepareStatement(
				"SELECT id, nome, formacao FROM professores JOIN disciplina_professor ON professores.id = disciplina_professor.id_disciplina WHERE id_professor = ?");

		query.setInt(1, prof.getRegistro());

		ResultSet resposta = query.executeQuery();

		while (resposta.next()) {
			Professor p = new Professor();
			p.setRegistro(resposta.getInt(1));
			p.setNome(resposta.getString(2));
			p.setFormacao(resposta.getString(3));
			listaProfessores.add(p);
		}

		query.close();

		return listaProfessores;
	}
}
