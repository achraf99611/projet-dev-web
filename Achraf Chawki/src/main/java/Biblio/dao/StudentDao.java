package Biblio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Biblio.model.Student;

public class StudentDao {
	public int registrystudent(Student student) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO student" + "(id , firstname, lastname, username, password) VALUES "
	+ "(?,?,?,?,?);";
		
		int result = 0; 
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/biblio?serverTimezone=UTC","root","achraf");
		PreparedStatement preparedStatement= connection.prepareStatement(INSERT_USERS_SQL)){
			preparedStatement.setInt(1, 2);
			preparedStatement.setString(2,student.getFirstname());
			preparedStatement.setString(3,student.getLastname());
			preparedStatement.setString(4,student.getUsername());
			preparedStatement.setString(5,student.getPassword());
			System.out.println(preparedStatement);
			result=preparedStatement.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result; 
		
	}
}
