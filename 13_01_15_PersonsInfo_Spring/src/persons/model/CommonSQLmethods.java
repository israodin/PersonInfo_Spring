package persons.model;

import java.sql.Connection;
import java.sql.Statement;

public abstract class CommonSQLmethods {

	protected Connection connection;
	protected Statement statement;

	public CommonSQLmethods(String URL, String USER, String PASSWORD) throws Exception{
		connection = DatabaseConnection.getDatabaseConnection(URL, USER, PASSWORD);
		statement=connection.createStatement();
		String sql="CREATE TABLE IF NOT EXISTS Person (id INTEGER," +
				"name VARCHAR(254), birthYear INTEGER, PRIMARY KEY(id)," +
				"INDEX(name), INDEX(birthYear))";
		statement.executeUpdate(sql);
	}


}
