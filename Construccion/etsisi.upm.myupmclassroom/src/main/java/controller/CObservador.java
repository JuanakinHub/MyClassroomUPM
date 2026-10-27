package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import CITSIM21_06.etsisi.upm.myupmclassroom.App;
import persistence.PObservador;

public class CObservador {
	
	private PObservador observadorPers;
	
	public CObservador() {
		this.observadorPers = new PObservador();
	}
	
	
	public String crear(String aula) throws SQLException, ClassNotFoundException, IOException {
		try {
			if(buscarNombreListaAulasNoSus(aula)) {
				observadorPers.create(App.GLOBAL_USUARIO.getDNI(), aula);
				return aula;
			}else {
				return null;
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return null;
	}
	
	public List<String> verlistaAulasNoSus(){
		try {
			return observadorPers.getAulasNoSuscritas(App.GLOBAL_USUARIO.getDNI());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<String> verlistaAulasSus(){
		try {
			return observadorPers.getAulasSuscritas(App.GLOBAL_USUARIO.getDNI());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	
	public boolean buscarNombreListaAulasNoSus(String nombre) throws SQLException {
		
		return observadorPers.getAulasNoSuscritas(App.GLOBAL_USUARIO.getDNI()).contains(nombre);
	}
}
