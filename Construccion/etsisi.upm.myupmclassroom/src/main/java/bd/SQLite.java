package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLite {
	
	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		 
		String jdbcUrl = "jdbc:sqlite:./myclassroom.db";
		Connection connection = DriverManager.getConnection(jdbcUrl);
	    

	    
	    /*
	    String sql = "create table usuarios (nombre varchar(30), apellido1 varchar(20), apellido2 varchar(20), correo varchar(100), pwd varchar(100), DNI varchar(9), rol varchar(15))";
	    Statement statement = connection.createStatement();
	    statement.executeUpdate(sql);
	    System.out.println("La tabla se ha creado correctamente.");
	    */
		/*
		String sql = "DROP TABLE IF EXISTS usuarios";
	    Statement statement = connection.createStatement();
	    statement.executeUpdate(sql);
	    System.out.println("La tabla se ha borrado correctamente.");
	    */
	    /*
	    String sql = "insert into usuarios values ('Alderson', 'Caero', 'Acosta', 'alderson.caero@alumnos.upm.es', '123456789', '12345678Z', 'ALUMNO')";
	    String sql1 = "insert into usuarios values ('Oscar', 'Latorre', 'Latorre', 'oscar.latorre@upm.es', '123456789', '12345678X', 'PAS')";
	    String sql2 = "insert into usuarios values ('Maria', 'Asfas', 'Asfas', 'maria.Asfas@upm.es', '123456789', '12345678C', 'PDI')";
	    Statement statement = connection.createStatement();
	    int rows = statement.executeUpdate(sql2);
	    if (rows > 0){
	     System.out.println("Se ha creado una fila nueva.");
	    }
	    */
		
		prueba();
	    
	}

	public static void prueba() throws SQLException{
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:sqlite:./myclassroom.db";
		Connection connection = DriverManager.getConnection(jdbcUrl);
		String sql = "select * from usuarios";
		//String sql = "alter table usuarios add primary key (DNI)";
	    Statement statement = connection.createStatement();
	    
	    ResultSet result = statement.executeQuery(sql);
	    
		while(result.next()) {
		 String nombre = result.getString("nombre");
		 String apellido1 = result.getString("apellido1");
		 String apellido2 = result.getString("apellido2");
		 String correo = result.getString("correo");
		 String pwd = result.getString("pwd");
		 String DNI = result.getString("DNI");
		 String rol = result.getString("rol");
		    	
		  System.out.println(nombre + " | " + apellido1 + " | " + apellido2 + " | " + correo + " | " + pwd + " | " + DNI + " | " + rol );
		}    
	}
	
	public static Connection connection() throws SQLException {
		String jdbcUrl = "jdbc:sqlite:./myclassroom.db";
		Connection connection = DriverManager.getConnection(jdbcUrl);
		
		return connection;
		
	}
}
