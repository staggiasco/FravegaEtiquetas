package test;

import java.io.IOException;
import java.util.Enumeration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import junit.framework.TestFailure;
import junit.framework.TestResult;
import pages.Reglas;

public class Controlador {
	

String nomTempl = "Default pcs";	


//================================================================= INICIO ================================================================			


	public void loginEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq();
		etiquetas.verNuevasActualizaciones();
	}

//================================================================= HOJAS ================================================================		
	
	// CREAR HOJAS
	
	public void creaHojaEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq();
		etiquetas.crearHoja();
	}
	
     //ELIMINAR HOJAS
	@Test
	public void eliminarHojaEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq();
		etiquetas.eliminarHoja();
	}
	
//================================================================= MARCOS ================================================================	

	// CREAR MARCOS

	public void creaMarcoEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(); //Login
		etiquetas.crearMarco();
}
	// ELIMINAR MARCO

	public void eliminarMarcoEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq();
		etiquetas.eliminarMarco();
	}

//================================================================= TEMPLATE ================================================================	
	
	// CREAR TEMPLATES
	
	public void creaTemplateEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq();
		etiquetas.crearTempl();
	}

	// ELIMINAR TEMPLATES
	
	public void eliminarTemplateEtiqueta() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq();
		etiquetas.eliminarTempl(nomTempl);
	}

//================================================================= REGLAS ================================================================		

	// CREAR REGLA

	public void creaReglaEtiquetas() throws IOException  {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq();
		etiquetas.crearRegla();
	}
	
	
	public void eliminarReglaEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq();
		etiquetas.eliminarRegla();
	}

	
//================================================================= IMPRESION ================================================================	
	 


	public void imprimirEtiqueta() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq();
		etiquetas.imprimirProducto();	
	}
	
	
	
	

}
