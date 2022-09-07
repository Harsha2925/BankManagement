package banking;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
	static Connection con;
	 public static Connection getConnection()
	    {
	        try {               
	            String mysqlJDBCDriver = "oracle.jdbc.driver.OracleDriver"; 
	            String url = "jdbc:oracle:thin:@localhost:1521/orcl.iiht.tech";
	            String user = "scott";       
	            String pass = "tiger"; 
	            Class.forName(mysqlJDBCDriver);
	            con = DriverManager.getConnection(url, user, pass);
	        }
	        catch (Exception e) {
	            System.out.println("Connection Failed!");
	        }
	        return con;
	    }
}