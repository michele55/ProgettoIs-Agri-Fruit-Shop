package GestioneCarrello;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;


import utils.utility;
import Database.DBConnectionPool;
import gestioneAcquisti.OrdineModel;

public class compostoModel implements compostoModelDS<composto>  {
private Connection ds= null;
OrdineModel ord=new OrdineModel(ds);

	public compostoModel(Connection ds) {
		this.ds=ds;
	}



	@Override
	public void doSave(composto item) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
	
		String insertSQL="INSERT INTO composto "+"( quantita , SSN , numero) VALUES ( ?, ?, ?)";    
		
		try {
			connection=ds;
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setInt(1,item.getQuantita());
			preparedStatement.setString(2,item.getSsn());
			preparedStatement.setInt(3,item.getNumero());
				
			preparedStatement.executeUpdate();

			connection.commit();

		}
		catch(SQLException e) {
			e.printStackTrace();
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


	}



	@Override
	public Collection<composto> doRetrieveByPiva(int numero) throws SQLException {
		Connection connection=null;
		PreparedStatement prepareStatement=null;
		
		String selectSQL="SELECT * FROM composto where numero= ?";
		Collection <composto> composto= new LinkedList<composto>();
	
		try {
		
			//connection= ds.getConnection();
			prepareStatement= ds.prepareStatement(selectSQL);
			prepareStatement.setInt(1, numero);
			ResultSet rs=prepareStatement.executeQuery();
			
			while(rs.next()) {
				composto bean=new composto();
				bean.setNumero(rs.getInt("numero"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setSsn(rs.getString("SSN"));
				composto.add(bean);			
			}
						
		}finally {
			try {
			if(prepareStatement!=null)
			prepareStatement.close();
			}finally {
				
			
			
			if(connection!=null)
			connection.close();
			}
			
		}
		
		return composto;
		
		
	}



	@Override
	public void doUpdate(composto item) throws SQLException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean doDelete(composto item) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM composto WHERE SSN = ?";

		try {
			connection = ds;
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(deleteSQL);
			if(item.getSsn()!="") {
				preparedStatement.setString(1, item.getSsn());
				utility.print("doDelete: " + preparedStatement.toString());
				preparedStatement.executeUpdate();

				connection.commit();
				
			}
			else if(item.getSsn().equals("")){
				return false;
				
			}
		
			
		} 
		catch(SQLException e) {
			
			e.printStackTrace();
			
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
		
		return true;
		
	}
	
	
}
