package br.unipe.controlead.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.unipe.controlead.modelo.Disciplina;

public class DisciplinaDAO {

	private final Connection con;

	public DisciplinaDAO(Connection con) {
		this.con = con;
	}

	public void create(Disciplina disciplina) throws SQLException {
		String sql = "INSERT INTO Disciplina (nome, periodo, ementa, professor) values (?,?,?,?)";

		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, disciplina.getNome());
			stmt.setString(2, disciplina.getPeriodo());
			stmt.setString(3, disciplina.getEmenta());
			stmt.setInt(4, disciplina.getProfessor());
			stmt.execute();

			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int id = rs.getInt("id");
					disciplina.setId(id);
				}
			}
		}
	}

	public List<Disciplina> Lista() throws SQLException {
		List<Disciplina> disciplinas = new ArrayList<>();
		String sql = "SELECT * FROM Disciplina";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();

			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String nome = rs.getString("nome");
					String periodo = rs.getString("periodo");
					String ementa = rs.getString("ementa");
					int professor = rs.getInt("professor");
					Disciplina disciplina = new Disciplina(nome, periodo, ementa, professor);
					disciplina.setId(id);
					disciplinas.add(disciplina);
				}
			}
		}
		return disciplinas;
	}

	public void update(Disciplina disciplina) throws SQLException {
		String sql = "UPDATE Disciplina SET nome = ?, periodo = ?, ementa = ?, professor = ? WHERE id = ?)";

		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, disciplina.getNome());
			stmt.setString(2, disciplina.getPeriodo());
			stmt.setString(3, disciplina.getEmenta());
			stmt.setInt(4, disciplina.getProfessor());
			stmt.setInt(5, disciplina.getId());
			stmt.execute();

			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int id = rs.getInt("id");
					disciplina.setId(id);
				}
			}
		}
	}

	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM Disciplina where id=?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.execute();
			int count = stmt.getUpdateCount();
			System.out.println(count + " linhas atualizadas");
		}

	}

}