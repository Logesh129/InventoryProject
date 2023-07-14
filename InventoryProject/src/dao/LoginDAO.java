package dao;

import java.sql.*;
import connectionManager.ConnectionManager;
import model.Login;

public class LoginDAO
{
	public boolean validate(Login login) throws ClassNotFoundException , SQLException
	{
		String username = login.getUsername();//user input
		String password = login.getPassword();
		
		ConnectionManager conm = new ConnectionManager();//connect java and jdbc
		Connection  con = conm.establishConnection();
		
		Statement st = con.createStatement();//statement class declare
		
		ResultSet rs = st.executeQuery("select * from login"); // write query
		
		//check username and password
		while(rs.next())
		{
		if(username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
		   {
			conm.closeConnection();
			return true;
		   }
		
		}
		conm.closeConnection();
		 return false;
	}
	

}
