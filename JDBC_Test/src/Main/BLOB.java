package Main;

import java.sql.*;
import java.io.*;

public class BLOB {
	
	
	public void CrearColumnaBLOB (Connection myConn) throws SQLException {
		
		Statement myStmt=null;
		
		try {
			
			//Crear columna resume si no existe
			
	         myStmt=myConn.createStatement();
	         
	         DatabaseMetaData DBMD = null;
	         String nombre;
	         boolean existeResume = false;
	          
	         DBMD = myConn.getMetaData();
	        
	         ResultSet myRs = DBMD.getColumns(null, null , "employees", null);
		     
	         while (myRs.next()&& !existeResume) {
				nombre = myRs.getString("COLUMN_NAME");
				
				if (nombre.equals("resume"))
					existeResume=true;
			 }
		     
		     if (!existeResume) {
	         int i= myStmt.executeUpdate("alter table employees add column resume BLOB");
				System.out.println(i);}
		     
		}
		
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	finally {}
		}
	
    //////////////////////////////////////////////////////////////////////////
	public void InsertBLOB  (Connection myConn)  throws SQLException  {

		try {
			
	     
	     // Insertar BLOB
	     //Preparar statement
	     String sql = "update employees set resume =?" + " where email='john.doe@foo.com'";
	     PreparedStatement myPStmt = myConn.prepareStatement(sql);
	     
	     // Setear parametro para el nombre de archivo de resume
	     //manejador para el archivo local
	     File TheFile = new File ("sample_resume.pdf");
	     FileInputStream input = new FileInputStream(TheFile);
	     
	     //Actualizar BD con informacion binaria  
	     myPStmt.setBinaryStream(1,input);
	     
	    // Ejecutar statement
         myPStmt.executeUpdate();
	     System.out.println("Insertado Correctamente el resumen de Juan Doe\n");
	     Thread.sleep(1000);
	  
	   
	    // myPStmt.executeUpdate("update employees set resume = null where email='john.doe@foo.com'");
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	finally {}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	public void ReadBLOB (Connection myConn) throws SQLException{
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
		//Seleccionar en Result Set
			myStmt=myConn.createStatement();
			myRs= myStmt.executeQuery("Select * from employees "+ "where email='john.doe@foo.com'");
			
		//Crear handle para archivo de salida
			File theFile = new File ("Resume_from_db.pdf");
			FileOutputStream output = new FileOutputStream (theFile);
			
		//Leer BLOB y almacenar en archivo de salida
			if (myRs.next()) {
				//Leer BLOB
				InputStream input = myRs.getBinaryStream("resume");
				
				//Escribir al archivo local
				byte[]buffer = new byte [1024];
				while (input.read(buffer)>0) {
					output.write(buffer);
				}
				
			System.out.println("Archivo correctamente guardado en el PC como: "+ theFile.getName() + "\n");
			Thread.sleep(1000);
			}
			output.close();
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	finally {}
		
	}

	
		
	}


