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
	

String nombreT = "Default pcs";	


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

	public void eliminarTemplateEtiqueta() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq();
		etiquetas.eliminarTempl(nombreT);
	}

//================================================================= REGLAS ================================================================		

	// CREAR REGLA
	@Test 
	public void creaReglaEtiquetas() throws IOException {
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
	 

	@Test 
	public void imprimirEtiqueta() throws IOException {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq();
		etiquetas.crearRegla();	
	}
	
	
	

	
	
	
	

	
	
	
	
	
	
	/*
	@Parameters
	public static List<String[]> getData(){
		return pages.Csv.get("C:\\Users\\31953658\\workspace\\FravegaProjectFer\\src\\docs\\ej1.txt");
	}
	*/
}
