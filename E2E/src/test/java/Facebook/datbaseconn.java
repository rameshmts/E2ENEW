package Facebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class datbaseconn {
	String host = "localhost";
	
	@Test
	public void connection() throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + 3306 + "/qaclick", "root", "Ra@809480");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from Employeeinfo where ID = '320711'");
		rs.next();
		System.out.println(rs.getString("FirstName"));
		System.out.println(rs.getString("Location"));
	}

}
