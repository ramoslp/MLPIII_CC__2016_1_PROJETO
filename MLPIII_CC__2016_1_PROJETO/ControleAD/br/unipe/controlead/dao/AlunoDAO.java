package br.unipe.controlead.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.unipe.controlead.modelo.Aluno;

public class AlunoDAO {

	private final Connection con;

	public AlunoDAO(Connection con) {
		this.con = con;
	}

	public void create(Aluno aluno) throws SQLException {
		String sql = "INSERT INTO Aluno (nome, matricula, identidade, cpf, curso, cre, telefone, disciplina, endereco) values (?,?,?,?,?,?,?,?,?)";

		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getMatricula());
			stmt.setString(3, aluno.getIdentidade());
			stmt.setString(4, aluno.getCpf());
			stmt.setString(5, aluno.getCurso());
			stmt.setString(6, aluno.getCre());
			stmt.setString(7, aluno.getTelefone());
			stmt.setInt(8, aluno.getDisciplina());
			stmt.setInt(9, aluno.getEndereco());
			stmt.execute();

			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int id = rs.getInt("id");
					aluno.setId(id);
				}
			}
		}
	}

	public List<Aluno> Lista() throws SQLException {
		List<Aluno> alunos = new ArrayList<>();
		String sql = "SELECT * FROM Aluno";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();

			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String nome = rs.getString("nome");
					String matricula = rs.getString("matricula");
					String identidade = rs.getString("identidade");
					String cpf = rs.getString("cpf");
					String curso = rs.getString("curso");
					String cre = rs.getString("cre");
					String telefone = rs.getString("telefone");
					int disciplina = rs.getInt("disciplina");
					int endereco = rs.getInt("endereco");
					Aluno aluno = new Aluno(nome, matricula, identidade, cpf, curso, cre, telefone, disciplina,
							endereco);
					aluno.setId(id);
					alunos.add(aluno);
				}
			}
		}
		return alunos;
	}

	public void update(Aluno aluno) throws SQLException {
		String sql = "UPDATE Aluno SET nome = ?, matricula = ?, identidade = ?, cpf = ?, curso = ?, cre = ?, telefone = ?,"
				+ " disciplina = ?, endereco = ? WHERE id = ?)";

		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getMatricula());
			stmt.setString(3, aluno.getIdentidade());
			stmt.setString(4, aluno.getCpf());
			stmt.setString(5, aluno.getCurso());
			stmt.setString(6, aluno.getCre());
			stmt.setString(7, aluno.getTelefone());
			stmt.setInt(8, aluno.getDisciplina());
			stmt.setInt(9, aluno.getEndereco());
			stmt.setInt(10, aluno.getId());
			stmt.execute();

			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int id = rs.getInt("id");
					aluno.setId(id);
				}
			}
		}
	}

	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM Aluno where id=?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.execute();
			int count = stmt.getUpdateCount();
			System.out.println(count + " linhas atualizadas");
		}

	}

}