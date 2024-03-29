package gestioneAcquisti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import javax.sql.DataSource;

import utils.utility;

public class SpedizioneModel implements SpedizioneModelDS<spedizione> {

	
private Connection ds= null;
public int  autoGeneratedID2;
	
	public  SpedizioneModel(Connection ds) {
		this.ds=ds;
	}
	
	
	@Override
	public boolean doRetrieveByNumero(String code) throws SQLException {
		PreparedStatement preparedStatement=null;
		spedizione bean= new spedizione();
		
		String sql="SELECT * FROM spedizione WHERE numero=?";
		
		
		
		try {
		
			preparedStatement= ds.prepareStatement(sql);
			preparedStatement.setString(1,code);
			ResultSet rs=preparedStatement.executeQuery();
			
		
		
		while(rs.next()) {
		
			bean.setNumeroordine(rs.getInt("numero"));
		
			
				
		}
		
		
		} catch(SQLException e){
			e.printStackTrace();
			return false;
		}                            
		return true;
	}

	@SuppressWarnings("finally")
	@Override
	public int doSave(spedizione item) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL="INSERT INTO spedizione "+" (numero,modalitaspedizione,costospedizione,citta,provincia,cap,via,civico) VALUES (?,?,?,?,?,?,?,?)";    
		
		try {
			connection=ds;
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertSQL,Statement.RETURN_GENERATED_KEYS);

			//preparedStatement.setInt(1,item.getId());
			preparedStatement.setInt(1,item.getNumeroordine());
			preparedStatement.setString(2,item.getModalitaspedizione());
			preparedStatement.setInt(3,item.getCostospedizione());
			preparedStatement.setString(4,item.getCitta());
			preparedStatement.setString(5,item.getProvincia());
			preparedStatement.setInt(6,item.getCap());
			preparedStatement.setString(7,item.getVia());
			preparedStatement.setInt(8,item.getCivico());
			

			
			
			utility.print("doSave: " + preparedStatement.toString());
			preparedStatement.executeUpdate();
			ResultSet tableKeys = preparedStatement.getGeneratedKeys();
			tableKeys.next();
				 autoGeneratedID2 = tableKeys.getInt(1);
				System.out.println(autoGeneratedID2);
				

			connection.commit();

		} 
		catch(SQLException e){
			
			e.printStackTrace();
		
			
		}
		
	/*	finally {
			return autoGeneratedID2;
		}
		/*finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null) {
					connection.close();
				}
			}
		}*/
	return autoGeneratedID2;
	
	}
		
	

	@Override
	public void doUpdate(spedizione item) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean doDelete(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteSQL="DELETE FROM spedizione where numero=? ";    
		
		try {
			connection=ds;
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(deleteSQL);

		
			preparedStatement.setInt(1,code);
		
			
		
			preparedStatement.executeUpdate();
		
				

			connection.commit();

		} 
		catch(SQLException e){
			
			e.printStackTrace();
		return false;
			
		}
		
		return true;
	}

}
