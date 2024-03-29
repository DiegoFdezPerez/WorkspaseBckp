package Main;
import java.sql.*;
import java.util.*;

public class Transaction {
	
	public void Execute(Connection myConn) throws SQLException {
		
		try {
			//Apagar Auto Commit
			myConn.setAutoCommit(false);
			
			//Realizar diversas declaraciones
			Statement myStmt = null;
			
		    
		    myStmt= myConn.createStatement();
		    System.out.println("Insertando en tabla a Isabel"+ "\n");
		    Thread.sleep(2000);
		    int rowsAffected = myStmt.executeUpdate("Insert into employees" + "(last_name,first_name,email, department, salary)" + "values ('Sanchez','Isabel','isablegarcia@gmail.com','Engineering',17000)");
			if (rowsAffected!=0)
				System.out.println("Insertado correctamente"+ "\n");
			else 
				System.out.println("Fallo al insertar"+ "\n");
			
			Thread.sleep(2000);
			
			MostrarDepIng(myConn);
			
			myStmt=null;
			int aumento= 20000;
			myStmt= myConn.createStatement();
			System.out.println("Actualizando en salario de Isabel a 20000"+ "\n");
			Thread.sleep(2000);
			rowsAffected= myStmt.executeUpdate("update employees " + "set salary = "+ aumento + " where first_name = 'Isabel'");
			if (rowsAffected!=0)
				System.out.println("Actualizado correctamente"+ "\n");
			else 
				System.out.println("Fallo al actualizar"+ "\n");
			
			Thread.sleep(2000);
			
			System.out.println("Lista Actualizada: \n");
			
			MostrarDepIng(myConn);
			//fin declaraciones
			
			boolean ok=askUserIfOkToSave();   
			
			if(ok)
				myConn.commit();
			else
				myConn.rollback();
			
		System.out.println("Lista final: \n");
		Thread.sleep(2000);
		
		    MostrarDepIng(myConn);	
			
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if (myConn!=null)
				myConn.close();
			
			myConn.setAutoCommit(true);
		}
	}

	private void MostrarDepIng(Connection myConn) throws SQLException
	{
		try {
		Statement myStmt= myConn.createStatement();
		ResultSet Rs=myStmt.executeQuery("select * from employees where department = 'Engineering' " );
		
		System.out.println("Lista de trabajadores de ingeniería: \n");
		Thread.sleep(2000);
		while(Rs.next()) {
			System.out.println(Rs.getString("first_name")+ " , " + Rs.getString("last_name")+ " , "+ Rs.getString("department")+ " , " + Rs.getInt("salary")+ "\n");
			Thread.sleep(500);
		}}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	private boolean askUserIfOkToSave() {
		boolean respuesta=false;
		boolean repeat=true;
		Scanner scn =new Scanner(System.in);
		String linea;
		
		
		
		while (repeat) {
			System.out.println("Desea guardar los cambios (S o N):\n");
			linea = scn.nextLine();
			
		 switch(linea) {
		 case ("S"):
			 respuesta=true;
		     repeat=false;
		     System.out.println("Guardando cambios...\n");
		     break;
		     
		 case ("s"):
			 respuesta=true;
		     repeat=false;
		     System.out.println("Guardando cambios...\n");
		     break;
		 
		 case("N"):
			 respuesta=false;
		 	 repeat=false;
		 	 System.out.println("Revirtiendo cambios...\n");
		 	 break;
		 
		 case("n"):
			 respuesta=false;
		 	 repeat=false;
		 	 System.out.println("Revirtiendo cambios...\n");
		 	 break;
		  
		 default :
			 System.out.println("Por favor repita la respuesta, debe responder con una S o una N");
		    }}
		 
		scn.close();
		 return respuesta;
		 
		 }
		
		
		
	}
