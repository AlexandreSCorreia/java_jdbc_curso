package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	//Recuperar dados
	public static void main(String[] args) {
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		
		try {
			conn = DB.getConnection();
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from department");
			
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("Id") + ", "+ resultSet.getString("Name"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeResultSet(resultSet);
			DB.closeStatement(statement);
			DB.closeConnection();
		}

	}
	
	

}
