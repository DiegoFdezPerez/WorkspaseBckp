package Main;

import java.sql.*;

public class StoredProcedures {
	
	public void StoredPIn  (Connection myConn)  throws SQLException  {
//		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			
		 
			System.out.println("Database connection succesful\n");
			
			String nombre;
			int id = 1;

			
		System.out.println("\n \n Ejecutando procedimiento " + "\n \n");
		myStmt = myConn.prepareCall("{call dar_nombre_vendedor(?,?)}");
		myStmt.setInt(1, id);
	    myStmt.registerOutParameter(2, Types.VARCHAR);
		myStmt.execute();
		
		nombre = myStmt.getString(2);
		
		
		
		
		System.out.println("Nombre del vendedor numero " + id + " : " + nombre);
		
	
		}
		
		catch (Exception exc) {
			exc.printStackTrace();
		}
	finally {
	//if (myConn != null)
	//myConn.close();
	if (myStmt != null)
	myStmt.close();
	if (myRs != null)
	myRs.close();
	}
	}

}
