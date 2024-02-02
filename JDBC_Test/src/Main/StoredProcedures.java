package Main;

import java.sql.*;

public class StoredProcedures{

	public void StoredPIn  (Connection myConn)  throws SQLException  {
//	Connection myConn = null;
	CallableStatement myStmt = null;
	ResultSet myRs = null;
	
	try {
		//Conseguir conexion a la base de datos
		
//		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","DFP","Kyba");
	 
		System.out.println("Database connection succesful\n");
		
		String Dept = "Engineering";
		int SumaAIncrementar = -10000;
	//Mostrar salarios antes
		System.out.println("Salarios antes \n");
		mostrarSalarios(myConn, Dept);
		// Crear Statement
		
	//myStmt = myConn.createStatement();
		
	System.out.println("\n \n Ejecutando procedimiento en departamento: " + Dept + "\n \n");
	myStmt = myConn.prepareCall("{call increase_salaries_for_department (?,?)}");
	myStmt.setString(1, Dept);
	myStmt.setDouble(2,SumaAIncrementar);
	myStmt.execute();
	
	
	//Mostrar salarios despues
	System.out.println("Salarios despues \n");
	mostrarSalarios(myConn,Dept);
	//Ejecutar consulta SQL

	
//myRs = myStmt.executeQuery("select * from employees");
//Procesar el conjunto resultante

/*	while (myRs.next()) {
	System.out.println(myRs.getString("last_name")+", "+ myRs.getString("first_name")+", "+ myRs.getInt("id"));
}*/
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

public void mostrarSalarios(Connection Conn, String Dept) throws SQLException {
	
	
	try {
		Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "DFP", "Kyba");
		String Dp = "'".concat(Dept).concat("'");
	Statement myStmt = Conn.createStatement();
	ResultSet myRs = myStmt.executeQuery("Select * from employees where department = " + Dp);
	
	while(myRs.next()) 
		System.out.println(myRs.getString("first_name")+ " , " + myRs.getString("last_name") + " , " + myRs.getFloat("Salary"));
	
	}
	catch (Exception ex) {
		ex.printStackTrace();
	}
	
}

public void StoredPInOut  (Connection myConn)  throws SQLException  {
//	Connection myConn = null;
	CallableStatement myStmt = null;
	ResultSet myRs = null;
	
	try {
		//Conseguir conexion a la base de datos
		
//		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","DFP","Kyba");
	 
		System.out.println("Database connection succesful\n");
		
		String Dept = "Engineering";
		
	//Mostrar salarios antes

		// Crear Statement
		
	//myStmt = myConn.createStatement();
		
	System.out.println("\n \n Ejecutando procedimiento INOUT en departamento: " + Dept + "\n \n");
	myStmt = myConn.prepareCall("{call greet_the_department (?)}");
	myStmt.registerOutParameter(1, Types.VARCHAR);
	myStmt.setString(1, Dept);
	myStmt.execute();
	
	
	//Mostrar salarios despues
	String Result = myStmt.getString (1);
	System.out.println (Result);
	//Ejecutar consulta SQL

	
//myRs = myStmt.executeQuery("select * from employees");
//Procesar el conjunto resultante

/*	while (myRs.next()) {
	System.out.println(myRs.getString("last_name")+", "+ myRs.getString("first_name")+", "+ myRs.getInt("id"));
}*/
	}
	
	catch (Exception exc) {
		exc.printStackTrace();
	}
finally {
//f (myConn != null)
//myConn.close();
if (myStmt != null)
myStmt.close();
if (myRs != null)
myRs.close();
}
}
public void StoredPOut  (Connection myConn)  throws SQLException  {
//	Connection myConn = null;
	CallableStatement myStmt = null;
	ResultSet myRs = null;
	
	try {
		//Conseguir conexion a la base de datos
		
//		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","DFP","Kyba");
	 
		System.out.println("Database connection succesful\n");
		
		String Dept = "Engineering";
		
	//Mostrar salarios antes

		// Crear Statement
		
	//myStmt = myConn.createStatement();
		
	System.out.println("\n \n Ejecutando procedimiento OUT en departamento: " + Dept + "\n \n");
	myStmt = myConn.prepareCall("{call get_count_for_department (?,?)}");
	myStmt.setString(1, Dept);
	myStmt.registerOutParameter(2, Types.INTEGER);
	myStmt.execute();
	
	
	//Mostrar salarios despues
    int Result = myStmt.getInt(2);
	System.out.println("La cuenta = " + Result);
	//Ejecutar consulta SQL

	
//myRs = myStmt.executeQuery("select * from employees");
//Procesar el conjunto resultante

/*	while (myRs.next()) {
	System.out.println(myRs.getString("last_name")+", "+ myRs.getString("first_name")+", "+ myRs.getInt("id"));
}*/
	}
	
	catch (Exception exc) {
		exc.printStackTrace();
	}
finally {
//f (myConn != null)
//myConn.close();
if (myStmt != null)
myStmt.close();
if (myRs != null)
myRs.close();
}
}
}


