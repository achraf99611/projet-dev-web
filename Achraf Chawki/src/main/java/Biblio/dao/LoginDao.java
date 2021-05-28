package Biblio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Biblio.model.Login;

public class LoginDao {
	 public boolean validate(Login login) throws ClassNotFoundException, SQLException {
	        boolean status = false;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://127.0.0.1:3306/biblio?serverTimezone=UTC", "root", "achraf");

	            PreparedStatement preparedStatement = connection.prepareStatement("select * from login where username = ? and password = ? ")) 
	        {
	            preparedStatement.setString(1, login.getUsername());
	            preparedStatement.setString(2, login.getPassword());

	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            status = rs.next();
	            
	        }
			return status;

}
}
	 
	        
