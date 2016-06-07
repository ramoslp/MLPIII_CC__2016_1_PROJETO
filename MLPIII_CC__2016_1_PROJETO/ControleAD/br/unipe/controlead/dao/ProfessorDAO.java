package br.unipe.controlead.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.unipe.controlead.modelo.Professor;

public class ProfessorDAO {

	private final Connection con;

	public ProfessorDAO(Connection con) {
		this.con = con;
	}

	public void create(Professor professor) throws SQLException {
		String sql = "INSERT INTO Professor (nome, cpf, identidade, telefone, endereco) values (?,?,?,?,?)";

		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getCpf());
			stmt.setString(3, professor.getIdentidade());
			stmt.setString(4, professor.getTelefone());
			stmt.setInt(5, professor.getEndereco());
			stmt.execute();

			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int id = rs.getInt("id");
					professor.setId(id);
				}
			}
		}
	}

	public List<Professor> Lista() throws SQLException {
		List<Professor> professores = new ArrayList<>();
		String sql = "SELECT * FROM Professor";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();

			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String nome = rs.getString("nome");
					String cpf = rs.getString("cpf");
					String identidade = rs.getString("identidade");
					String telefone = rs.getString("telefone");
					int endereco = rs.getInt("endereco");
					Professor professor = new Professor(nome, cpf, identidade, telefone, endereco);
					professor.setId(id);
					professores.add(professor);
				}
			}
		}
		return professores;
	}

	public void update(Professor professor) throws SQLException {
		String sql = "UPDATE Professor SET nome = ?, cpf = ?, identidade = ?, telefone = ?, endereco = ? WHERE id = ?)";

		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getCpf());
			stmt.setString(3, professor.getIdentidade());
			stmt.setString(4, professor.getTelefone());
			stmt.setInt(5, professor.getEndereco());
			stmt.setInt(6, professor.getId());
			stmt.execute();

			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int id = rs.getInt("id");
					professor.setId(id);
				}
			}
		}
	}

	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM Professor where id=?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.execute();
			int count = stmt.getUpdateCount();
			System.out.println(count + " linhas atualizadas");
		}

	}

}