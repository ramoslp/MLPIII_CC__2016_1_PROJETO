package br.unipe.controlead.persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.unipe.controlead.dao.EnderecoDAO;
import br.unipe.controlead.modelo.Endereco;

public class TestaEndereco {

	public static void main(String[] args) throws SQLException {

		try (Connection con = new ConnectionPool().getConnection()) {
			EnderecoDAO dao = new EnderecoDAO(con);

			List<Endereco> enderecos = dao.Lista();
			for (Endereco endereco : enderecos) {
				System.out.println(endereco);
			}

			dao.delete(4);
		}
	}

}