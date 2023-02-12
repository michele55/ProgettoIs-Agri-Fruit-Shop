package GestioneCarrello;

import java.sql.SQLException;
import java.util.Collection;



public interface compostoModelDS<T> {
	
	public Collection< T> doRetrieveByPiva(int code) throws SQLException;
	
	public void doSave(T item) throws SQLException ;
	
	public void doUpdate(T item) throws SQLException ;
	public void doDelete(T item) throws SQLException ;
	
}
