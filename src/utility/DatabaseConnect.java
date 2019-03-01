package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnect {

	static Properties dbProperties = null;
	static Connection jdbcConnection = null;
	static FileInputStream fis = null;

	public static void jdbcProperties() throws IOException {
		dbProperties = new Properties();
		fis = new FileInputStream("F:\\java niit\\CRUD operation\\MAHATourism\\src\\utility\\dbproperties.properties");
		dbProperties.load(fis);
		fis.close();
	}
	
	public static Connection connect() throws ClassNotFoundException, SQLException, IOException {
		jdbcProperties();
		String driver = dbProperties.getProperty("myJDBC.driver");
		String url = dbProperties.getProperty("myJDBC.url");
		String username = dbProperties.getProperty("myJDBC.username");
		String password = dbProperties.getProperty("myJDBC.password");
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}

		}
		return jdbcConnection = DriverManager.getConnection(url, username, password);
	}
}


