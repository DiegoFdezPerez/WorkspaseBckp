package Main;
//import com.mysql.*;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {
			Connection myConn = null;
			/*Statement myStmt = null;
			ResultSet myRs = null;*/
			try {
				myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","DFP","Kyba");
				StoredProcedures SP = new StoredProcedures();
				/*SP.StoredPIn(myConn);
				SP.StoredPInOut(myConn);
				SP.StoredPOut(myConn);
				*/
				// Transacciones
				/*Transaction Trans =new Transaction ();
				Trans.Execute(myConn);*/
				//BLOB
				BLOB BL= new BLOB();
				BL.InsertBLOB(myConn);
				BL.ReadBLOB(myConn);
				
				//CLOB
				 CLOB CL = new CLOB();
				 CL.CrearColumnaCLOB(myConn);
				 CL.InsertCLOB(myConn);
			     CL.ReadCLOB(myConn);
				//Metadata
				/*Metadata MD= new Metadata();
				MD.GetMetadata(myConn);*/
			}
		/*	try {
				//Conseguir conexion a la base de datos
				
				myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","DFP","Kyba");
			 
				System.out.println("Database connection succesful\n");
				
				// Crear Statement
				
			myStmt = myConn.createStatement();
			
			//Ejecutar consulta SQL
			
    /*  int r = myStmt.executeUpdate("insert into employees (last_name,first_name,email,department,salary) values ('Diego','Fernández','diego@gmail.com','Engineering','17000')");
		if (r==1)
		System.out.println("Se logro introducir correctamente");*/
	/*	myRs = myStmt.executeQuery("select * from employees");*/
		//Procesar el conjunto resultante
		
	/*	while (myRs.next()) {
			System.out.println(myRs.getString("last_name")+", "+ myRs.getString("first_name")+", "+ myRs.getInt("id"));
		}
			}*/
			
			catch (Exception exc) {
				exc.printStackTrace();
			}
/*finally {
	if (myConn != null)
myConn.close(); 
	if (myStmt != null)
myStmt.close();
	if (myRs != null)
myRs.close();
}*/
	}

}
