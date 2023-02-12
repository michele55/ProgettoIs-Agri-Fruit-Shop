package gestioneAcquisti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;

import gestioneAccount.Utente;
import utils.utility;

public class PagamentoModel implements PagamentoModelDS<pagamento> {

private Connection ds= null;
	
	public  PagamentoModel(Connection ds) {
		this.ds=ds;
	}
	
	
	@Override
	public boolean doRetrieveById(String code) throws SQLException {

		//java.sql.Connection connection=null;
		PreparedStatement preparedStatement=null;
		pagamento bean= new pagamento();
		
		String sql="SELECT * FROM pagamento WHERE id=?";
		
		
		
		try {
		
			preparedStatement= ds.prepareStatement(sql);
			preparedStatement.setString(1,code);
			ResultSet rs=preparedStatement.executeQuery();
			
		
		
		while(rs.next()) {
			bean.setId(rs.getInt("id"));
			bean.setNumeropagamento(rs.getInt("numeropagamento"));
			bean.setModalitapagamento(rs.getString("modalitapagamento"));
			
				
		}
		
		
		} catch(SQLException e){
			System.out.println("# UserService > Utente inesistente");
			return false;
		}                            
		return true;
	}

	@Override
	public boolean doSave(pagamento item) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL="INSERT INTO pagamento "+" (ID,num_pag,modalitapagamento) VALUES (?,?,?)";    
		
		try {
			connection=ds;
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setInt(1,item.getId());
			preparedStatement.setInt(2,item.getNumeropagamento());
			preparedStatement.setString(3,item.getModalitapagamento());
			
			
			utility.print("doSave: " + preparedStatement.toString());
			preparedStatement.executeUpdate();

			connection.commit();

		} 
		catch(SQLException e){
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
	public void doUpdate(pagamento item) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doDelete(pagamento item) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
