package jp.co.mycpompany.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;

public class ConnectionUtil {
	public static Connection getConnection(String lookupString)
			throws SQLException, ServletException {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(lookupString);

			Connection connection = ds.getConnection();
			connection.setAutoCommit(false);
			return connection;
		} catch (NamingException e) {
			throw new ServletException(e);
		}

	}

}
