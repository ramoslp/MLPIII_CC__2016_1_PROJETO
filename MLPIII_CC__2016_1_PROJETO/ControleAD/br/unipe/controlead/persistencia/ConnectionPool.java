package br.unipe.controlead.persistencia;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.postgresql.jdbc2.optional.PoolingDataSource;

public class ConnectionPool {
	
	private DataSource dataSource;

	ConnectionPool(){
		PoolingDataSource pool = new PoolingDataSource();
		pool.setUrl("jdbc:postgresql://localhost:5433/controlead");
		pool.setUser("postgres");
		pool.setPassword("postgres");
		this.dataSource = pool;
	}
	
	Connection getConnection() throws SQLException {
		Connection connection = dataSource.getConnection();
		return connection;
	}

}