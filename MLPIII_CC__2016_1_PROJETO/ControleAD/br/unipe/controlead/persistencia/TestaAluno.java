package br.unipe.controlead.persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.unipe.controlead.dao.AlunoDAO;
import br.unipe.controlead.modelo.Aluno;

public class TestaAluno {

	public static void main(String[] args) throws SQLException {

		try (Connection con = new ConnectionPool().getConnection()) {
			AlunoDAO dao = new AlunoDAO(con);

			List<Aluno> alunos = dao.Lista();
			for (Aluno aluno : alunos) {
				System.out.println(aluno);
			}
			
			dao.delete(2);
		}
	}

}