package Main;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
	    ResultSet myRs = null;
	    try {
	    	
	    	
		
		myConn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/test1","postgres","Kyba");
		System.out.println("Conexion Exitosa");
		
		StoredProcedures SP = new StoredProcedures();
		SP.StoredPIn(myConn);
		
		myStmt= myConn.createStatement();
		
		myRs = myStmt.executeQuery("Select * from usuarios");
		
		while(myRs.next()) {
			
			System.out.println(myRs.getInt("id")+" , " + myRs.getString("nombre") );
			
			
		}
	    }
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		
	}

}
