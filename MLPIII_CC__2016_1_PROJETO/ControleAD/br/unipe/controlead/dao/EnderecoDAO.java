package br.unipe.controlead.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.unipe.controlead.modelo.Endereco;

public class EnderecoDAO {

	private final Connection con;

	public EnderecoDAO(Connection con) {
		this.con = con;
	}

	public void create(Endereco endereco) throws SQLException {
		String sql = "INSERT INTO Endereco (rua, cep, numero, estado, pais) values (?,?,?,?,?)";

		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, endereco.getRua());
			stmt.setString(2, endereco.getCep());
			stmt.setString(3, endereco.getNumero());
			stmt.setString(4, endereco.getEstado());
			stmt.setString(5, endereco.getPais());
			stmt.execute();

			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int id = rs.getInt("id");
					endereco.setId(id);
				}
			}
		}
	}

	public List<Endereco> Lista() throws SQLException {
		List<Endereco> enderecos = new ArrayList<>();
		String sql = "SELECT * FROM Endereco";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();

			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String rua = rs.getString("rua");
					String cep = rs.getString("cep");
					String numero = rs.getString("numero");
					String estado = rs.getString("estado");
					String pais = rs.getString("pais");
					Endereco endereco = new Endereco(rua, cep, numero, estado, pais);
					endereco.setId(id);
					enderecos.add(endereco);
				}
			}
		}
		return enderecos;
	}

	public void update(Endereco endereco) throws SQLException {
		String sql = "UPDATE Endereco SET rua = ?, periodo = ?, ementa = ?, estado = ?, pais = ? WHERE id = ?)";

		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, endereco.getRua());
			stmt.setString(2, endereco.getCep());
			stmt.setString(3, endereco.getNumero());
			stmt.setString(4, endereco.getEstado());
			stmt.setString(5, endereco.getPais());
			stmt.setInt(6, endereco.getId());
			stmt.execute();

			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int id = rs.getInt("id");
					endereco.setId(id);
				}
			}
		}
	}

	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM Endereco where id=?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.execute();
			int count = stmt.getUpdateCount();
			System.out.println(count + " linhas atualizadas");
		}

	}

}