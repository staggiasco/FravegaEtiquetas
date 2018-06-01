package test;

import java.io.IOException;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import junit.framework.TestFailure;
import junit.framework.TestResult;
import pages.Reglas;

public class Controlador {
	
String perfil = "admin";

String nombreT = "Default pcs";	



//================================================================= INICIO ================================================================			

	
	public void loginEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		
		if (perfil.equalsIgnoreCase("admin")) {
			etiquetas.verNuevasActualizaciones();
		}
		
	}

//================================================================= HOJAS ================================================================		
	
	// CREAR HOJAS

	public String creaHojaEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		String hojaCreada = etiquetas.crearHoja();
		
		return hojaCreada;
	}
	
     //ELIMINAR HOJAS
	
	public void eliminarHojaEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.eliminarHoja();
	}
	

	public void creaHojaIncorrecta() throws InterruptedException {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.crearHojaIncorrecta();
		
	}
	
//================================================================= MARCOS ================================================================	

	// CREAR MARCOS

	public void creaMarcoEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil); //Login

	//	etiquetas.crearMarco(hojaCreada);
}
	// ELIMINAR MARCO

	public void eliminarMarcoEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.eliminarMarco();
	}

//================================================================= TEMPLATE ================================================================	
	
	// CREAR TEMPLATES

	public void creaTemplateEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.crearTempl(nombreT);
	}

	// ELIMINAR TEMPLATES
	
	public void eliminarTemplateEtiqueta() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.eliminarTempl(nombreT);
	}

//================================================================= REGLAS ================================================================		

	// CREAR REGLA

	public void creaReglaEtiquetas() throws IOException, InterruptedException  {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
	//	etiquetas.crearRegla();
	}
	
	
	//
	public void eliminarReglaEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.eliminarRegla();
	}

	
//================================================================= IMPRESION ================================================================	
	 

	
	public void imprimirEtiqueta() throws InterruptedException {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		//etiquetas.imprimirProducto();	
	}
	

	public void buscarImpr() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.buscarImpr();
	}
	
	
//================================================================= PUNTA A PUNTA ================================================================		

	
	// CREAR HOJAS
	@Test
	public void ejecutarCircuitoCompleto() throws InterruptedException, IOException {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		
		String hojaCreada = etiquetas.crearHoja();
		System.out.println("====================================================");
		System.out.println("LA HOJA CREADA ES: " + hojaCreada);
		System.out.println("====================================================");
		TimeUnit.SECONDS.sleep(2);
		
		String marcoCreado = (String) etiquetas.crearMarco(hojaCreada);
		System.out.println("====================================================");
		System.out.println("EL MARCO CREADO ES: " + marcoCreado);
		System.out.println("====================================================");
		TimeUnit.SECONDS.sleep(2);
		
		String templCreado = etiquetas.crearTempl(marcoCreado);
		System.out.println("====================================================");
		System.out.println("EL TEMPLATE CREADO ES: " + templCreado);
		System.out.println("====================================================");
		TimeUnit.SECONDS.sleep(2);
		
		String prodRegla = etiquetas.crearRegla(templCreado);
		System.out.println("====================================================");
		System.out.println("EL PRODUCTO DE LA REGLA CREADA ES: " + prodRegla);
		System.out.println("====================================================");
		TimeUnit.SECONDS.sleep(2);
		
		etiquetas.imprimirProducto(prodRegla);
		System.out.println("====================================================");
		System.out.println("EL PRODUCTO A IMPRIMIR ES EL: " + prodRegla);
		System.out.println("====================================================");
		TimeUnit.SECONDS.sleep(2);
		
	}
	
	
	
	
	
	
	
	
}
