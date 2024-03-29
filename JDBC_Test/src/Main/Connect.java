package Main;

import java.sql.*;
import java.util.*;
import java.io.*;

public class Connect {
	
	public Connection getConnManual() throws SQLException {
		Connection myConn = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","DFP","Kyba");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return myConn;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Connection getConnProperties() throws SQLException  {
		Connection myConn=null;
		Properties props=new Properties();
		try {
			props=getProperties();
			
			String theDBURL = props.getProperty("dburl");
			String theUser = props.getProperty("user");
			String thePasword = props.getProperty("pasword");
			
			myConn = DriverManager.getConnection(theDBURL,theUser,thePasword);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return myConn;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Properties getProperties() throws SQLException  {
		Properties prop=new Properties();
		try {
			File file =new File("demo.properties.txt");
			if(!file.exists()) {
				FileWriter fw = new FileWriter("demo.properties.txt");
				fw.write("dburl =jdbc:mysql://localhost:3306/demo"+ "\r\n"
						+ "user = DFP"+"\r\n"
						+ "pasword = Kyba");
				fw.close();
			}
			
			prop.load(new FileInputStream("demo.properties.txt"));
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return prop;
	}
}
