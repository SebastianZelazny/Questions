package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

	public Connection Connection() throws SQLException, ClassNotFoundException {

		//System.out.println("z klasy db");
		 Class.forName("com.mysql.jdbc.Driver");
		 //System.out.println("dodany sterownik");
         return DriverManager.getConnection("jdbc:mysql://localhost:3306/pytania?useSSL=false","root","Seb@stian1.");

	}
}
