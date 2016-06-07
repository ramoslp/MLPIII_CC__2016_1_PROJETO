package br.unipe.controlead.persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.unipe.controlead.dao.DisciplinaDAO;
import br.unipe.controlead.modelo.Disciplina;

public class TestaDisciplina {

	public static void main(String[] args) throws SQLException {

		try (Connection con = new ConnectionPool().getConnection()) {
			DisciplinaDAO dao = new DisciplinaDAO(con);

			List<Disciplina> disciplinas = dao.Lista();
			for (Disciplina disciplina : disciplinas) {
				System.out.println(disciplina);
			}

			dao.delete(2);
		}
	}

}