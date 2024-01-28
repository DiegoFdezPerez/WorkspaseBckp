import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;



import org.junit.jupiter.api.Test;

class OperacionesCadenaTest {

	@ParameterizedTest
	@CsvFileSource (recursos="misArgumentos.csv")
	void Retorno (String original, String resultadoAComprobar,String mensajeEnCasoDeError) {
		OperacionesCadena tct = new OperacionesCadena ();
		
		System.out.println("Ejecucion del retorno.");
		String resultado ="";
		try {
			resultado = tct.Retorno(original);
			assertTrue ((original==null)||resultado.equals(resultadoAComprobar), mensajeEnCasoDeError);
		}
		catch(Exception ex) {
			fail ("Excepcion"+ mensajeEnCasoDeError);
		}
		System.out.println("Resultado del retorno de "+ original+ ": "+ resultado);
	}
	

}
