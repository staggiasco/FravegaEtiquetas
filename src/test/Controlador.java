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
	

String nombreT = "TemplFer222";	
	
	
	
	// Aca colocas las pruebas de lo que estes por probar. Ejemplo Producto
	public void pruebaIngresarEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq();
		etiquetas.verNuevasActualizaciones();
	}

	
	// CREAR HOJAS
	public void creaHojaEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq();
		etiquetas.crearHoja();
	}
	
      //BORRAR HOJAS
	public void borraHojaEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq();
		etiquetas.borrarHoja();
	}
	
	

	// CREAR MARCOS
	public void creaMarcoEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(); //Login
		etiquetas.creaMarco();
}
	
	// CREAR TEMPLATES
	public void creaTemplateEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq();
		etiquetas.crearTempl();
	}


	// CREAR REGLA
	public void creaReglaEtiquetas() throws IOException {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq();
		etiquetas.creaRegla();	
	}
	

	
	
	public void imprimirEtiquetaProducto() {
	    LoginTest etiquetas = new LoginTest();
	    etiquetas.MingresarEtiq();
	    System.out.println("hasta aca llega");
	    etiquetas.MingresoImpresion();
	    etiquetas.MparaImp();
	    etiquetas.MimpProd();
	}
	
	
	
	@Test 
	public void borrarTemplateEtiqueta() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq();
		etiquetas.borrarTempl(nombreT);
	}
	
	
	/*
	@Parameters
	public static List<String[]> getData(){
		return pages.Csv.get("C:\\Users\\31953658\\workspace\\FravegaProjectFer\\src\\docs\\ej1.txt");
	}
	*/
}
