package gestioneAccount;

import java.util.Collection;
import java.sql.SQLException;

public interface utenteModel <T>{

	
	public Utente doRetrieveByKey(String email) throws SQLException;
	public T doRetrieveByNome(String rags) throws SQLException;
	
	public Collection<T> doRetrieveAll(	String order) throws SQLException ;
	public boolean doSave(T item) throws SQLException ;
	public boolean doUpdate(T item) throws SQLException ;
	public boolean doDelete(String item) throws SQLException ;
	



	
}