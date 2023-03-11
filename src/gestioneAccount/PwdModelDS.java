package gestioneAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;

import utils.utility;

public class PwdModelDS implements utenteModel<Utente>{
	
private DataSource ds= null;
	
	public PwdModelDS(DataSource ds) {
		this.ds=ds;
	}
	

	@Override
	public Utente doRetrieveByKey(String email) throws SQLException {
		java.sql.Connection connection=null;
		PreparedStatement preparedStatement=null;
		Utente bean= new Utente();
		
		String sql="SELECT * FROM utente WHERE email=?";
		
		
		
		try {

			connection= ds.getConnection();
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1,email);
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
		
		
		}finally {
		try {
		if(preparedStatement!=null)
		preparedStatement.close();
		}finally {
			
		
		
		if(connection!=null)
		connection.close();
		}
		
	}
		return bean;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utente doRetrieveByNome(String rags) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Utente> doRetrieveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	/*public void doSave(Utente item) throws SQLException {
		// TODO Auto-generated method stub
		
	}
*/
	@Override
	public boolean doUpdate(Utente item) throws SQLException {
		// TODO Auto-generated method stub
		Connection 	connection=null;
		PreparedStatement preparedStatement=null;
		
		String SQL="UPDATE utente SET "+"  pwd=sha1(?) WHERE email=?";
		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SQL);

					preparedStatement.setString(1, item.getPwd());
			preparedStatement.setString(2, item.getEmail());

			utility.print("doUpdate: " + preparedStatement.toString());
			preparedStatement.executeUpdate();

			connection.commit();

		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		finally {
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
		Connection 	connection=null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM utente WHERE email = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, item);

			result = preparedStatement.executeUpdate();
			if(result==0) {
				return false;
			}
			return true;

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}


	@Override
	public boolean doSave(Utente item) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	

	
}
