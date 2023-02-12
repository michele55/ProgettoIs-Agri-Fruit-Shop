package gestioneAcquisti;


import java.util.Collection;
import java.sql.SQLException;

public interface OrdineModelDS<T>{

		public Collection <T> doRetrieveByCodice_fiscale(String code) throws SQLException;
		public Collection <T> doRetrieveByAll() throws SQLException;
		
		public int doSave(T item) throws SQLException ;
		
		public void doUpdate(T item) throws SQLException ;
	//	public void doDelete(T item) throws SQLException ;
		boolean doDelete(int num) throws SQLException;
		

}

 