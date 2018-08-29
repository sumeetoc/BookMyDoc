
package beans;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;


public class dBase {

	private Connection connection;
	private Statement statement;
	private ResultSet results = null;
	
	@SuppressWarnings("unused")
	private String query;

	public void createConn() throws ClassNotFoundException,SQLException {
		//System.getProperty("cisco.life");
		//String testvar=System.getProperty("cisco.life");
		//String testvar=System.getenv("cisco.life");
		//System.out.println("Cisco var "+testvar);
		
/*		Map<Object, Object> env = System.getProperties();
        for (Object envName : env.keySet()) {
            System.out.format("%s=%s%n",
                              (String) envName,
                              env.get((String) envName));
        }*/
				
		Class.forName("com.mysql.jdbc.Driver");
		
		/*//String URL = System.getProperty("URL");
		//String USER = System.getProperty("USER");
		//String PASS = System.getProperty("PASS");
		String URL = "jdbc:mysql://35.227.97.64:3306/book_my_doc";
		String USER = "root";
		String PASS = "root";
		System.out.println("Ne URL == "+URL);
		System.out.println("USER == "+USER);
		System.out.println("PASS == "+PASS);
                Connection connection  = DriverManager.getConnection(URL,USER,PASS);
//connection = DriverManager.getConnection(*/
		
		
		connection = DriverManager.getConnection(
				"jdbc:mysql://35.227.97.64:3306/book_my_doc", "root", "root");
		//System.out.println(DatabasePassword);
		
		System.out.println("ConnectionObject"+connection);

        statement = connection.createStatement();
		
		
	}

	public ResultSet executeQuery(String q) throws SQLException {
		results = statement.executeQuery(q);
		//System.out.println(results);
		return results;
	}
	
	public int executeUpdate(String q) throws SQLException {
	    int result=statement.executeUpdate(q);
		return result;
	}

	public int doUpdate(String query) throws Exception {
		int i = statement.executeUpdate(query);
		return i;
	}

	public ResultSet getData(String query) throws Exception {
		results = statement.executeQuery(query);
		return results;
	}

	public int getRowCount(String query) throws Exception {
		int count = 0;
		results = statement.executeQuery(query);
		while (results.next()) {
			count++;
		}
		return count;
	}

	public void closeConn() throws SQLException {
		statement.close();
		//connection.close();
		if (connection != null) {
			connection.close();
		}	
		}

	
}
