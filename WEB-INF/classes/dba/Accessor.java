package dba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;


public class Accessor{
	private Connection Connect;

	public void connect(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connect = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","info", "pro");
			System.out.println("ê⁄ë±ê¨å˜");
			Connect.setAutoCommit(false);
			
		}
		catch(ClassNotFoundException e){
			System.out.println("class:Accessor_method:connect() ClassNotFoundException");
		}
		catch(SQLException e){
			System.out.println("class:Accessor_method:connect() SQLException");
		}
		catch(Exception e){
			System.out.println("class:Accessor_method:connect() Exception");
		}
	}

	public ResultSet read(String sql){
		try{
			
			System.out.println("ÇËÅ[Ç«");
			
			//PreparedStatement st = Connect.prepareStatement(sql);
			Statement st = Connect.createStatement(/*ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY*/);
			
			ResultSet rs = st.executeQuery(sql);
			return rs;
		}
		catch(SQLException e){
			System.out.println("class:Accessor_method:read() SQLException");
		}
		catch(Exception e){
			System.out.println("class:Accessor_method:read() Exception");
		}
		return null;
	}

	public  void write(String sql){
		try{ 
			Statement st = Connect.createStatement();
			System.out.println(sql);
			st.executeUpdate(sql);
			commit();
		}
		catch(SQLException e){
			System.out.println("class:Accessor_method:write() SQLException");
		}
		catch(Exception e){
			System.out.println("class:Accessor_method:write() Exception");
		}
	}

	public void commit(){
		try{
			Connect.commit();
		}
		catch(SQLException e){}
		catch(Exception e){}
	}
	
	public void close(){
		try{
			Connect.close();
		}
		catch(SQLException e){}
		catch(Exception e){}
	}
}