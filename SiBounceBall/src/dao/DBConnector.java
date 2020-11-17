package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	private static DBConnector dbc;
	
	private DBConnector() {}
	
	public static DBConnector getInstance() {
		if(dbc == null) {
			dbc = new DBConnector();
		}
		return dbc;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = DriverManager.getConnection(url, "scott", "tiger");
		return conn;
	}
	
}
