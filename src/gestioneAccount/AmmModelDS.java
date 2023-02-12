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
public class AmmModelDS implements AmmModel<Amministratore>{

	
	private Connection ds;
	private Connection ds2;
	public AmmModelDS(Connection ds) {
		this.ds=ds;
	}
	
	
	
	public Amministratore doRetrieveByNome(String rags) throws SQLException {
		
		java.sql.Connection connection=null;
		PreparedStatement preparedStatement=null;
		Amministratore bean= new Amministratore();
		
		String sql="SELECT * FROM amministratore WHERE nome=?";
		
		
		
		try {

			connection= ds;
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1,rags);
			ResultSet rs=preparedStatement.executeQuery();
			
		
		
		while(rs.next()) {
			bean.setNome(rs.getString("nome"));
			bean.setCognome(rs.getString("cognome"));
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
	public Amministratore doRetrieveByKey(String email) throws SQLException {
	
	
		//java.sql.Connection connection=null;
		PreparedStatement preparedStatement=null;
		Amministratore bean= null;
		
		String sql="SELECT * FROM amministratore WHERE email=?";
		
		
		
		try {
		
			preparedStatement= ds.prepareStatement(sql);
			preparedStatement.setString(1,email);
			ResultSet rs=preparedStatement.executeQuery();
			
		
		
		while(rs.next()) {
			bean=new Amministratore();
			bean.setNome(rs.getString("nome"));
			bean.setCognome(rs.getString("cognome"));
			bean.setPwd(rs.getString("pwd"));
			bean.setEmail(rs.getString("email"));
			bean.setRuolo(rs.getString("ruolo"));
			
			
			
			
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
	public Collection<Amministratore> doRetrieveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doSave(Amministratore item) throws SQLException {
	//	Connection connection = null;
		PreparedStatement preparedStatement = null;
	
		String insertSQL = "INSERT INTO amministratore " + " (nome,cognome,email,pwd, ruolo) VALUES (?,?, ?,sha1(?),?)";

		try {
			
		//	connection=ds;
		//	connection.setAutoCommit(false);
			preparedStatement = ds.prepareStatement(insertSQL);

			preparedStatement.setString(1,item.getNome());
			preparedStatement.setString(2,item.getCognome());
			preparedStatement.setString(3,item.getEmail());
			preparedStatement.setString(4,item.getPwd());
			preparedStatement.setString(5,item.getRuolo());
			
			
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
	public void doUpdate(Amministratore item) throws SQLException {
		// TODO Auto-generated method stub
		Connection 	connection=null;
		PreparedStatement preparedStatement=null;
		
		String SQL="UPDATE amministratore SET "+" ruolo=? pwd=? WHERE email=?";
		try {
			connection = ds;
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SQL);

			preparedStatement.setString(1, item.getRuolo());
			preparedStatement.setString(2, item.getPwd());
			preparedStatement.setString(3, item.getEmail());

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
	
	
	
	
	
	
	
	}

	@Override
	public boolean doDelete(String item) throws SQLException {
		// TODO Auto-generated method stub
		Connection 	connection=null;
		PreparedStatement preparedStatement=null;
		
		
		try {
			String SQL="delete from amministratore where email=?";
			connection = ds;
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SQL);
			
			preparedStatement.setString(1, item);

				if(preparedStatement.executeUpdate()==0) {
					preparedStatement.executeUpdate();
					
					
				}
					
				
			utility.print("doDelete: " + preparedStatement.toString());
			
			
			connection.commit();
			return true;
			

		}
		catch(SQLException e) {
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


	
	
	
	
	
}
