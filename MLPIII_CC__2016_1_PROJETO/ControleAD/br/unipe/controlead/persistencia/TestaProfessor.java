package br.unipe.controlead.persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.unipe.controlead.dao.ProfessorDAO;
import br.unipe.controlead.modelo.Professor;

public class TestaProfessor {

	public static void main(String[] args) throws SQLException {

		try (Connection con = new ConnectionPool().getConnection()) {
			ProfessorDAO dao = new ProfessorDAO(con);

			List<Professor> professores = dao.Lista();
			for (Professor professor : professores) {
				System.out.println(professor);
			}

			dao.delete(2);
		}
	}

}