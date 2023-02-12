package gestioneAcquisti;


import java.util.Collection;
import java.sql.SQLException;

public interface SpedizioneModelDS<T>{

		public boolean doRetrieveByNumero(String code) throws SQLException;
		
		public int doSave(T item) throws SQLException ;
		
		public void doUpdate(T item) throws SQLException ;
		public boolean doDelete(int item) throws SQLException ;
		

}
