package Main;

import java.io.*;
import java.sql.*;


public class CLOB {

	public void CrearColumnaCLOB (Connection myConn) throws SQLException {
		
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
				
				if (nombre.equals("resume_text"))
					existeResume=true;
			 }
		     
		     if (!existeResume) {
	         myStmt.executeUpdate("alter table employees add column resume_text LONGTEXT");
			
		       }
		     
		}
		
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	finally {}
		}
	///////////////////////////////////////////////////////////////////////////////////////
	
	public void InsertCLOB (Connection myConn) throws SQLException {
		
		try {
			//Preparar statement
			String sql = "update employees set resume_text = ? " + "where email = 'john.doe@foo.com'";
			PreparedStatement myPStmt = myConn.prepareStatement(sql);
			
			//Handler para resume file name
			
		File theFile = new File ("sample_resume.txt");
		FileReader input = new FileReader(theFile);	
		
		//Actualizar BD con info del CLOB
	    myPStmt.setCharacterStream(1, input);
	    myPStmt.executeUpdate();
		
	    System.out.println("Insertado correctamente el la BD el archivo dfe texto: "+ theFile.getName()+ "\n");
		}
	
	catch (Exception exc) {
		exc.printStackTrace();
	}
	
	finally {}
}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void ReadCLOB (Connection myConn) throws SQLException{
		
		try {
			
			Statement myStmt = myConn.createStatement();
			String sql = "Select resume_text from employees where email = 'john.doe@foo.com'";
			ResultSet myRs = myStmt.executeQuery(sql);
			
			File theFile = new File("Resume_text_from_db.txt");
			FileOutputStream output = new FileOutputStream (theFile);
			
			if (myRs.next()) {
				Reader input =myRs.getCharacterStream("resume_text");
				
				int theChar;
				while ((theChar=input.read())>0) {
					output.write(theChar);
				}
				
				System.out.println("Archivo de texto correctamente guardado en el PC como: "+ theFile.getName() + "\n");
				output.close();
				
				}
		}
	
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		finally {}
	}
}
