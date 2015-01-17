package persons.model;
import java.sql.*;
public class DatabaseConnection {
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String URL_DEFAULT = "jdbc:mysql://localhost/test";
	static DatabaseConnection dbc=null;
	Connection connection;
	
	private DatabaseConnection(String url,String username, String password)
			throws Exception{
		//Loading driver into JVM
		Class.forName(DRIVER_NAME);
		if(url==null)
			url=URL_DEFAULT;
		connection=DriverManager.getConnection(url, username, password);
	}
	
	static public Connection getDatabaseConnection
	(String username, String password) throws Exception{
		if(dbc==null){
			dbc=new DatabaseConnection(null, username, password);
		}
		return dbc.connection;
	}
	static public Connection getDatabaseConnection
	(String url,String username, String password) throws Exception{
		if(dbc==null){
			dbc=new DatabaseConnection(url, username, password);
		}
		return dbc.connection;
	}

}
