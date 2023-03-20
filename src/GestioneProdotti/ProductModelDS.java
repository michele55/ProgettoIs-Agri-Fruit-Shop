package GestioneProdotti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import javax.sql.DataSource;

import utils.utility;

public class ProductModelDS implements ProductModel<prodotto>{

	private Connection ds= null;
	
	public ProductModelDS(Connection ds) {
		this.ds=ds;
	}
	
	
	@Override
	public Collection<prodotto> doRetrieveAll(String order) throws SQLException {
		Connection connection=null;
		PreparedStatement prepareStatement=null;
		
		String selectSQL="SELECT * FROM prodotto";
		
		if(order!=null&&!order.equals("")) {
			selectSQL +="ORDER BY" +order;
		}
		
		Collection <prodotto> prodotti= new LinkedList<prodotto>(); 
		
		
		try {
			
			connection= ds;
			prepareStatement= connection.prepareStatement(selectSQL);
			
			ResultSet rs=prepareStatement.executeQuery();
			
			while(rs.next()) {
				prodotto bean= new prodotto();
				bean.setPrezzo(rs.getInt("prezzo"));
				bean.setNome(rs.getString("nomep"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setQuantita(rs.getInt("disponibilità"));
				bean.setSsn(rs.getString("ssn"));
				bean.setCtegoria(rs.getString("categ"));
				bean.setIdfoto(rs.getString("idfoto"));
				prodotti.add(bean);
							
			}
						
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		/*finally {
			try {
			if(prepareStatement!=null)
			prepareStatement.close();
			}finally {
				
			
			
			if(connection!=null)
			connection.close();
			}
			
		}*/
		
		return prodotti;
	}

	

	@Override
	public Collection<prodotto>  doRetrieveByKey(String code) throws SQLException {
		
		Connection connection=null;
		PreparedStatement prepareStatement=null;
		
		String selectSQL="SELECT * FROM prodotto WHERE categ = ?";
	
		
		Collection <prodotto> prodotti= new LinkedList<prodotto>(); 
		
		
		try {
			
			connection= ds;
			prepareStatement= connection.prepareStatement(selectSQL);
			prepareStatement.setString(1, code);

			ResultSet rs=prepareStatement.executeQuery();
			
			while(rs.next()) {
				prodotto bean= new prodotto();
				bean.setPrezzo(rs.getInt("prezzo"));
				bean.setNome(rs.getString("nomep"));
				bean.setDescrizione(rs.getString("descrizione"));
				
				bean.setSsn(rs.getString("ssn"));
				bean.setQuantita(rs.getInt("disponibilità"));
				bean.setCtegoria(rs.getString("categ"));
				bean.setIdfoto(rs.getString("idfoto"));
			
				prodotti.add(bean);
				
		
				
			}
			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		/*finally {
			try {
			if(prepareStatement!=null)
			prepareStatement.close();
			}finally {
				
			
			
			if(connection!=null)
			connection.close();
			}
			
		}*/
		
		return  prodotti;
	}
		
		
		
	@Override
	public prodotto doRetrieveByNome(String code) throws SQLException {
		
		Connection connection=null;
		PreparedStatement prepareStatement=null;
		
		String selectSQL="SELECT * FROM prodotto WHERE nomep = ?";
	
		
		prodotto bean= new prodotto();
		
		
		try {
			
			connection= ds;
			prepareStatement= connection.prepareStatement(selectSQL);
			prepareStatement.setString(1, code);

			ResultSet rs=prepareStatement.executeQuery();
		
			while(rs.next()) {
				
				bean.setPrezzo(rs.getInt("prezzo"));
				bean.setNome(rs.getString("nomep"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setQuantita(rs.getInt("disponibilità"));
				bean.setSsn(rs.getString("ssn"));
				bean.setCtegoria(rs.getString("categ"));
				bean.setIdfoto(rs.getString("idfoto"));
			
				
						
			}
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		/*finally {
			try {
			if(prepareStatement!=null)
			prepareStatement.close();
			}finally {
				
			
			
			if(connection!=null)
			connection.close();
			}
			
		}*/
		
		return  bean;
	}
		
		
	
	
	
	@Override
	public boolean doSave(prodotto item) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO prodotto" + " (prezzo, nomep, SSN,disponibilità, descrizione, categ, idfoto) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			connection=ds;
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setFloat(1,item.getPrezzo());
			preparedStatement.setString(2,item.getNome());
			preparedStatement.setString(3,item.getSsn());
			preparedStatement.setInt(4,item.getQuantita());
			preparedStatement.setString(5,item.getDescrizione());
			preparedStatement.setString(6,item.getCategoria());
			preparedStatement.setString(7,item.getIdfoto());
			
			utility.print("doSave: " + preparedStatement.toString());
			preparedStatement.executeUpdate();

			connection.commit();

		}catch(SQLException e) {
			e.printStackTrace();
			return false;
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
	@Override
	public void doUpdate(prodotto item) throws SQLException {
		Connection 	connection=null;
		PreparedStatement preparedStatement=null;
		
		String SQL="UPDATE prodotto SET prezzo=?,nomep=?, disponibilità=?, descrizione=?, categ=?,idfoto=? WHERE SSN=?";
		try {
			connection = ds;
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SQL);

			preparedStatement.setFloat(1, item.getPrezzo());
			preparedStatement.setString(2, item.getNome());
			preparedStatement.setInt(3, item.getQuantita());
			preparedStatement.setString(4, item.getDescrizione());
			
			preparedStatement.setString(5, item.getCategoria());
			preparedStatement.setString(6, item.getIdfoto());
			preparedStatement.setString(7, item.getSsn());

			utility.print("doUpdate: " + preparedStatement.toString());
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
	public boolean doDelete(prodotto item) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM prodotto WHERE nomep = ?";

		try {
			connection = ds;
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(deleteSQL);
			if(item.getNome()!="") {
				preparedStatement.setString(1, item.getNome());
				utility.print("doDelete: " + preparedStatement.toString());
				preparedStatement.executeUpdate();

				connection.commit();
				
			}
			else if(item.getNome().equals("")){
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
	
	


	@Override
	public prodotto doRetrieveByprodotto(String code) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<prodotto> doRetrieveByparametro(String parametro) throws SQLException {
		Connection connection=null;
		PreparedStatement prepareStatement=null;
		
		String selectSQL="SELECT * FROM prodotto WHERE descrizione LIKE  '%' ? '%'  ";
	
		
		Collection <prodotto> prodotti= new LinkedList<prodotto>(); 
		
		
		try {
			
			connection= ds;
			prepareStatement= connection.prepareStatement(selectSQL);
			prepareStatement.setString(1, parametro);

			ResultSet rs=prepareStatement.executeQuery();
			
			while(rs.next()) {
				prodotto bean= new prodotto();
				bean.setPrezzo(rs.getInt("prezzo"));
				bean.setNome(rs.getString("nomep"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setQuantita(rs.getInt("disponibilità"));
				bean.setSsn(rs.getString("ssn"));
				bean.setCtegoria(rs.getString("categ"));
				bean.setIdfoto(rs.getString("idfoto"));
			
				prodotti.add(bean);
				
		
				
			}
			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		/*finally {
			try {
			if(prepareStatement!=null)
			prepareStatement.close();
			}finally {
				
			
			
			if(connection!=null)
			connection.close();
			}
			
		}*/
		
		return  prodotti;
	}
	
	
	

	@Override

	public prodotto doRetrieveByscelta(String scelta) throws SQLException {
		
		Connection connection=null;
		PreparedStatement prepareStatement=null;
		
		String selectSQL="SELECT * FROM prodotto WHERE nomep = ? ";
		prodotto bean= new prodotto();
		
		
		try {
			
			connection= ds;
			prepareStatement= connection.prepareStatement(selectSQL);
			prepareStatement.setString(1, scelta);
			
			
			ResultSet rs=prepareStatement.executeQuery();
			while(rs.next()) {
				bean.setPrezzo(rs.getInt("prezzo"));
				bean.setNome(rs.getString("nomep"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setQuantita(rs.getInt("disponibilità"));
				bean.setSsn(rs.getString("ssn"));
				bean.setCtegoria(rs.getString("categ"));
				bean.setIdfoto(rs.getString("idfoto"));
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		/*finally {
			try {
			if(prepareStatement!=null)
			prepareStatement.close();
			}finally {
				
			
			
			if(connection!=null)
			connection.close();
			}
			
		}*/
		
		return  bean;
		
		
	}

	
	
	
	

	@Override
	public prodotto doRetrieveBySSN(String parametro) throws SQLException {
		Connection connection=null;
		PreparedStatement prepareStatement=null;
		
		String selectSQL="SELECT * FROM prodotto WHERE SSN= ?";
	
		prodotto bean= new prodotto();
		
		
		
		try {
			
			connection= ds;
			prepareStatement= connection.prepareStatement(selectSQL);
			prepareStatement.setString(1, parametro);
			
			ResultSet rs=prepareStatement.executeQuery();
			
		
			while(rs.next()) {
				bean.setPrezzo(rs.getInt("prezzo"));
				bean.setNome(rs.getString("nomep"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setQuantita(rs.getInt("disponibilità"));
				bean.setSsn(rs.getString("ssn"));
				bean.setCtegoria(rs.getString("categ"));
				bean.setIdfoto(rs.getString("idfoto"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		/*finally {
			try {
			if(prepareStatement!=null)
			prepareStatement.close();
			}finally {
				
			
			
			if(connection!=null)
			connection.close();
			}
			
		}*/
		
		return  bean;
	}

	
	
	

	
}
