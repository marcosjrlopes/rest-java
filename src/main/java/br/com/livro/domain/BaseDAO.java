package br.com.livro.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BaseDAO {
	
	public BaseDAO() {		
		try {			
			Class.forName("com.mysql.jdbc.Driver");			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();			
		}
	}
	
	protected Connection getConnection() throws SQLException {		
		//String de conexão para o driver.
		String url = "jdbc:mysql://localhost/livro";		
		return DriverManager.getConnection(url,"livro","livro123");
	}
	
	public static void main(String[] args) throws SQLException {
		
		BaseDAO db = new BaseDAO();
		
		Connection con = db.getConnection();
		
		System.out.println(con);
		
	}
	
}
