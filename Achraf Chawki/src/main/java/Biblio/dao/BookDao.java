package Biblio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Biblio.model.Book;

public class BookDao {
	public int registrybook(Book book) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO book" + "(idbk , title, author, category) VALUES "
	+ "(?,?,?,?);";
		
		int result = 0; 
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/biblio?serverTimezone=UTC","root","achraf");
		PreparedStatement preparedStatement= connection.prepareStatement(INSERT_USERS_SQL)){
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2,book.getTitle());
			preparedStatement.setString(3,book.getAuthor());
			preparedStatement.setString(4,book.getCategory());
			
			System.out.println(preparedStatement);
		
			result=preparedStatement.executeUpdate();
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return result; 
		
	}
}
