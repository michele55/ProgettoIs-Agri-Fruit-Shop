package gestioneAccount;

import java.util.Collection;
import java.sql.SQLException;

public interface AmmModel <T>{

	
	public Amministratore doRetrieveByKey(String email) throws SQLException;
	public T doRetrieveByNome(String rags) throws SQLException;
	
	public Collection<T> doRetrieveAll(	String order) throws SQLException ;
	public boolean doSave(T item) throws SQLException ;
	public void doUpdate(T item) throws SQLException ;
	public boolean doDelete(String item) throws SQLException ;
	



	
}