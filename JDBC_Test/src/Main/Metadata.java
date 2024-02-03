package Main;
import java.sql.*;

public class Metadata {

	public void GetMetadata (Connection myConn) throws SQLException {
		Statement myStmt = null;
		String catalog = null;
		String schemaPattern = null;
		String tablePattern = null;
		String [] Types = null;
		
		try {
			DatabaseMetaData DBMD = myConn.getMetaData();
			
			String Pn= DBMD.getDatabaseProductName();
			System.out.println("Nombre del produto de la base de datos :"+ Pn + "\n");
			Thread.sleep(1000);
			
			String Pv= DBMD.getDatabaseProductVersion();
			System.out.println("Version del produto de la base de datos :"+ Pv + "\n");
			Thread.sleep(1000);
			
			String Dn= DBMD.getDriverName();
			System.out.println("Nombre del driver :"+ Dn + "\n");
			Thread.sleep(1000);
			
			 ResultSet myRs = DBMD.getTables("demo", schemaPattern,tablePattern,Types);
			 System.out.println("Lista de Tablas:");
			 System.out.println("---------------- ");
			 Thread.sleep(1000);
			 
			 while (myRs.next()) {
				System.out.println(myRs.getString("TABLE_NAME")+ "\n");
				Thread.sleep(500);
			 }
			 
			 ResultSet myRs2 = DBMD.getColumns(catalog, schemaPattern, "Employees", tablePattern);
			 System.out.println("Lista de Columnas:");
			 System.out.println("---------------- ");
			 Thread.sleep(1000);
			 
			 while(myRs2.next()) {
				 System.out.println(myRs2.getString("COLUMN_NAME"));
				 Thread.sleep(500);
			 }
			 
			 
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
finally {
	if (myStmt != null)
		myStmt.close();
}
}
	}
