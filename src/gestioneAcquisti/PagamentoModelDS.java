package gestioneAcquisti;


import java.util.Collection;
import java.sql.SQLException;

public interface PagamentoModelDS<T>{

		public boolean doRetrieveById(String code) throws SQLException;
		
		public boolean doSave(T item) throws SQLException ;
		
		public void doUpdate(T item) throws SQLException ;
		public void doDelete(T item) throws SQLException ;
		

}
