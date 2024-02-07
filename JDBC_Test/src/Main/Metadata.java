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
			System.out.println("Nombre del produto de la base de datos: "+ Pn + "\n");
			Thread.sleep(1000);
			
			String Pv= DBMD.getDatabaseProductVersion();
			System.out.println("Version del produto de la base de datos: "+ Pv + "\n");
			Thread.sleep(1000);
			
			String Dn= DBMD.getDriverName();
			System.out.println("Nombre del driver: "+ Dn + "\n");
			Thread.sleep(1000);
			
			 ResultSet myRs = DBMD.getTables("demo", schemaPattern,tablePattern,Types);
			 System.out.println("Lista de Tablas:");
			 System.out.println("---------------- ");
			 Thread.sleep(1000);
			 
			 while (myRs.next()) {
				System.out.println(myRs.getString("TABLE_NAME")+ "\n");
				Thread.sleep(500);
			 }
			 
			 myRs = DBMD.getColumns(catalog, schemaPattern, "Employees", tablePattern);
			 System.out.println("Lista de Columnas:");
			 System.out.println("---------------- ");
			 Thread.sleep(1000);
			 
			 while(myRs.next()) {
				 System.out.println(myRs.getString("COLUMN_NAME"));
				 Thread.sleep(500);
			 }
			 
			 //Result set metadata
			 
			 myStmt =myConn.createStatement();
			 myRs = myStmt.executeQuery("select id, last_name, first_name, email, salary, department, resume from employees");
			 Thread.sleep(500);
			 ResultSetMetaData rsMetadata = myRs.getMetaData();
			 int columnCount = rsMetadata.getColumnCount();
			 System.out.println("\n" + "Cantidad de columnas: " + columnCount + "\n");
			 Thread.sleep(1000);
			 System.out.println( "Metadatos de las columnas: "  + "\n");
			 Thread.sleep(1000);
			 
			 for (int column =1; column <= columnCount; column ++) {
				 System.out.println("Nombre de columna: " +rsMetadata.getColumnName(column));
				 Thread.sleep(500);
				 System.out.println("Tipo de columna: "+ rsMetadata.getColumnTypeName(column));
				 Thread.sleep(500);
				 System.out.println("Es nullable: "+ SiONo(rsMetadata.isNullable(column)));
				 Thread.sleep(500);
				 System.out.println("Es de auto incremento: "+ SiONo(rsMetadata.isAutoIncrement(column))+ "\n");
				 Thread.sleep(2000);
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
	private String SiONo(boolean bool){
		String respuesta;
	    int resp = (bool)?1:0;
		switch (resp) {
		case 0:
			respuesta = "no";
			break;
		case 1:
			respuesta = "si";
			break;
			default:
				respuesta = "no especificado";
				break;
		}
				return respuesta;
		}
	
	private String SiONo(int resp){
		String respuesta;
	
		switch (resp) {
		case 0:
			respuesta = "no";
			break;
		case 1:
			respuesta = "si";
			break;
			default:
				respuesta = "no especificado";
				break;
		}
				return respuesta;
		}
	}
	
	
