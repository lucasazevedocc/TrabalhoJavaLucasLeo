package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trabalhojavanp1.objetos.Curso;
import trabalhojavanp1.objetos.Disciplina;
import trabalhojavanp1.objetos.Professor;

public class DisciplinaDao {
	
	public void inserirDisciplina(Disciplina disc) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("INSERT INTO disciplinas(id, nome) VALUES(?, ?)");

		query.setInt(1, disc.getCodDisciplina());
		query.setString(2, disc.getNomeDisciplina());

		query.execute();
		query.close();
	}

	public void deletarDisciplina(Disciplina disc) throws SQLException {

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("DELETE FROM disciplinas WHERE id = ?");

		query.setInt(1, disc.getCodDisciplina());

		query.execute();
		query.close();
	}
	
	public void alteraNomeDisciplina(Disciplina disc) throws SQLException {
		
		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("UPDATE disciplinas SET nome = ? WHERE id = ?");

		query.setString(1, disc.getNomeDisciplina());
		query.setInt(2, disc.getCodDisciplina());

		query.execute();
		query.close();
	}
	
	public ArrayList<Disciplina> mostraDisciplinas() throws SQLException {

		ArrayList<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();

		PreparedStatement query = new ConnectionFactory().getConnection()
				.prepareStatement("SELECT * FROM disciplinas");

		ResultSet resposta = query.executeQuery();

		while (resposta.next()) {
			Disciplina a = new Disciplina();
			a.setCodDisciplina(resposta.getInt(1));
			a.setNome(resposta.getString(2));

			listaDisciplinas.add(a);
		}

		query.close();

		return listaDisciplinas;
	}

}
