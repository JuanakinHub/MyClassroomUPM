package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bd.SQLite;

public class PObservador {

	
	
	public void create(String DNI, String aula) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into observador (dni, aula)"
				+ "VALUES (?, ?)";
		PreparedStatement statement = SQLite.connection().prepareStatement(sql);   
	    
		statement.setString(1, DNI);
		statement.setString(2, aula);
		statement.executeUpdate();
	}
	
	public List<String> getAulasNoSuscritas(String DNI) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select nombre from aulas where nombre NOT IN (select nombre from observador JOIN aulas ON observador.aula = aulas.nombre where dni = ?)";
		
		PreparedStatement statement = SQLite.connection().prepareStatement(sql);  
		
		
		statement.setString(1, DNI);
		ResultSet result = statement.executeQuery();
		
		List<String> aulas = new ArrayList<String>();
		while(result.next()) {
			 String nombre = result.getString("nombre");
			 
			aulas.add(nombre);
		}
		statement.close();
		return aulas;
	}
	
	public List<String> getAulasSuscritas(String DNI) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select nombre from observador JOIN aulas ON observador.aula = aulas.nombre"
				+ " where dni = ?";
		
		PreparedStatement statement = SQLite.connection().prepareStatement(sql);   
	    
		statement.setString(1, DNI);
		ResultSet result = statement.executeQuery();
		
		List<String> aulas = new ArrayList<String>();
		while(result.next()) {
			 String nombre = result.getString("nombre");
			 
			aulas.add(nombre);
		}
		statement.close();
		return aulas;
	}
	
}
