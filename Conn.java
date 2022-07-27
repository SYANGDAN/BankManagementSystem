import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
	
	Connection con;
	Statement st;
	
	public Conn(){

		try {
			//Class.forName(com.mysql.cj.jdbc.Driver);
			con = DriverManager.getConnection("jdbc:mysql:///bankManagementSystem", "root","Syangdan2052");
			st = con.createStatement();
					
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
}
