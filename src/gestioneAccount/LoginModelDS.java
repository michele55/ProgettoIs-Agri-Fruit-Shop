package gestioneAccount;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;

import Database.DBConnectionPool;

import java.sql.Connection;


import utils.*;
public class LoginModelDS implements utenteModel<Utente>{

	
	private Connection ds;
	private DataSource ds3;
	private Connection ds2;
	public LoginModelDS(Connection ds) {
		this.ds=ds;
	}
	public LoginModelDS(DataSource ds3) {
		this.ds3=ds3;
	}
	
	
	public Utente doRetrieveByNome(String rags) throws SQLException {
		
		java.sql.Connection connection=null;
		PreparedStatement preparedStatement=null;
		Utente bean= new Utente();
		
		String sql="SELECT * FROM utente WHERE nome=?";
		
		
		
		try {

			connection= ds;
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1,rags);
			ResultSet rs=preparedStatement.executeQuery();
			
		
		
		while(rs.next()) {
			bean.setCap(rs.getString("cap"));
			bean.setCivico(rs.getString("ncivico"));
			
			bean.setNome(rs.getString("nome"));
			bean.setCognome(rs.getString("cognome"));
			bean.setIndirizzo(rs.getString("indirizzo"));
			bean.setCodice_fiscale(rs.getString("codice_fiscale"));
			bean.setPwd(rs.getString("pwd"));
			bean.setEmail(rs.getString("email"));
				
		}
		
		
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}
		/*finally {
		try {
		if(preparedStatement!=null)
		preparedStatement.close();
		}finally {
			
		
		
		if(connection!=null)
		connection.close();
		}
		
	}*/
		return bean;
		
		}

	
	@Override
	public Utente doRetrieveByKey(String email) throws SQLException {
	
	
		//java.sql.Connection connection=null;
		PreparedStatement preparedStatement=null;
		Utente bean= new Utente();
		
		String sql="SELECT * FROM utente WHERE email=?";
		
		
		
		try {
		
			preparedStatement= ds.prepareStatement(sql);
			preparedStatement.setString(1,email);
			ResultSet rs=preparedStatement.executeQuery();
			
		
		
		while(rs.next()) {
			bean.setCap(rs.getString("cap"));
			bean.setCivico(rs.getString("ncivico"));
			bean.setNome(rs.getString("nome"));
			bean.setCognome(rs.getString("cognome"));
			bean.setIndirizzo(rs.getString("indirizzo"));
			bean.setCodice_fiscale(rs.getString("codice_fiscale"));
			bean.setRuolo(rs.getString("ruolo"));
			bean.setPwd(rs.getString("pwd"));
			bean.setEmail(rs.getString("email"));
				
		}
		
		
		} catch(SQLException e){
			System.out.println("# UserService > Utente inesistente");
		}                             /*finally {
		try {
		if(preparedStatement!=null)
		preparedStatement.close();
		}finally {
			
		
		
		if(connection!=null)
		connection.close();
		}
		
	}*/
		return bean;
		
		}

	@Override
	public Collection<Utente> doRetrieveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doSave(Utente item) throws SQLException {
	//	Connection connection = null;
		PreparedStatement preparedStatement = null;
	
		String insertSQL = "INSERT INTO utente " + " (nome,cognome, indirizzo, ncivico, cap, codice_fiscale, email,pwd,ruolo) VALUES (?, ?, ?, ?, ?, ?, ?,sha1(?),?)";

		try {
			
		//	connection=ds;
		//	connection.setAutoCommit(false);
			preparedStatement = ds.prepareStatement(insertSQL);

			preparedStatement.setString(1,item.getNome());
			preparedStatement.setString(2,item.getCognome());
			preparedStatement.setString(3,item.getIndirizzo());
			preparedStatement.setString(4,item.getCivico());
			preparedStatement.setString(5,item.getCap());
			preparedStatement.setString(6,item.getCodice_fiscale());
			preparedStatement.setString(7,item.getEmail());
			preparedStatement.setString(8,item.getPwd());
			preparedStatement.setString(9,"Utente");
			
			utility.print("doSave: " + preparedStatement.toString());
			preparedStatement.executeUpdate();

			//ds.commit();

		}
		catch(SQLException e){
			e.printStackTrace();
			
		}
		
		
		/* finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null) {
					connection.close();
				}
			}
		}*/
		
		return true;
	}
		
	

	@Override
	public boolean doUpdate(Utente item) throws SQLException {
		// TODO Auto-generated method stub
		Connection 	connection=null;
		PreparedStatement preparedStatement=null;
		
		String SQL="UPDATE utente SET "+"  indirizzo= ? , ncivico=?, cap=? , codice_fiscale= ?, pwd=sha1(?) WHERE email=?";
		try {
			connection =  ds;
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SQL);

		//	preparedStatement.setString(1, item.getNome());
		//	preparedStatement.setString(2, item.getCognome());
			preparedStatement.setString(1, item.getIndirizzo());
			preparedStatement.setString(2, item.getCivico());
			preparedStatement.setString(3, item.getCap());
			preparedStatement.setString(4, item.getCodice_fiscale());
			preparedStatement.setString(5, item.getPwd());
			preparedStatement.setString(6, item.getEmail());
if( item.getIndirizzo()==null || item.getCivico()==null||
item.getCap()==null || item.getCodice_fiscale()==null || item.getPwd()==null ||item.getEmail()==null) {
	return false;
}
			utility.print("doUpdate: " + preparedStatement.toString());
			preparedStatement.executeUpdate();

			connection.commit();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null) {
					connection.close();
				}
			}
		}
	
	
	
	return true;
	
	
	
	}

	@Override
	public boolean doDelete(String item) throws SQLException {
		// TODO Auto-generated method stub
		Connection 	connection=null;
		PreparedStatement preparedStatement=null;
		
		
		try {
			String SQL="delete from utente where email=?";
			connection = ds;
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SQL);
			
			preparedStatement.setString(1, item);

				if(preparedStatement.executeUpdate()==0) {
					preparedStatement.executeUpdate();
					
					
				}
					
				
			utility.print("doDelete: " + preparedStatement.toString());
			
			
			connection.commit();
			
			

		}
		catch(SQLException e) {
			return false;
			//e.printStackTrace();
		}
		
		
		
		/* finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null) {
					connection.close();
				}
			}
		}*/
	
	return true;
		
	}


	
	
	
	
	
}
