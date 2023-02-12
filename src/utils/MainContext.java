package utils;


import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import java.sql.*;


@WebListener
public class MainContext implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		utility.print("Startup web application");

		ServletContext context = sce.getServletContext();
		DataSource ds = null;

		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/azienda1");
			
			Connection con = null;

			try {
				
					con = ds.getConnection();
					DatabaseMetaData metaData = con.getMetaData();
					utility.print("DBMS Name" + metaData.getDatabaseProductName());

				} finally {
					if (con != null)
						con.close();
						}

			} catch (SQLException | NamingException e) {
				utility.print(e);
			}

		context.setAttribute("DataSource", ds);
		utility.print("data source creazione" + ds.toString());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		utility.print("Shutdown web application");
	}

}
