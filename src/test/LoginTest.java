package test;

import java.io.IOException;

import org.apache.xalan.xsltc.compiler.Template;
import org.junit.Test;

import pageFactory.AbstractPageObject;
import pages.DashBoard;
import pages.Hojas;
import pages.HomePage;
import pages.Impresion;
import pages.Marcos;
import pages.Reglas;
import pages.Templates;

public class LoginTest extends BaseTest {
	
	//CONSTRUCTOR
	
	public LoginTest() {
		super.setup();
		}	
	
//================================================================= INICIO ================================================================		
	
	public void ingresarEtiq() {
		HomePage homePage = new HomePage(driver, driverWait);
		homePage.ingresarEtiquetas();
		}
	
	public void verNuevasActualizaciones() {
		DashBoard dashboard = new DashBoard(driver, driverWait);
		dashboard.verNuevasActualizaciones();
	}
	
//================================================================= HOJAS ================================================================	

	public void crearHoja() {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.crearNuevaHoja();
	}
	
	
	public void eliminarHoja() {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.eliminarHoja();
	}

//================================================================= MARCOS ================================================================		
	
	public void crearMarco() {
		Marcos marcos = new Marcos(driver, driverWait);
		marcos.ingresarAMarco();
		marcos.crearNuevoMarco();
	}
	
	public void eliminarMarco( ) {
		Marcos marcos = new Marcos(driver, driverWait);
		marcos.ingresarAMarco();
		marcos.eliminarMarco();
	}
	
	
//================================================================= TEMPLATE ================================================================		
	
	public void crearTempl() {
		Templates templ = new Templates(driver, driverWait);
		templ.ingresarATemplate();
		templ.crearNuevoTempl();
	}
	
	public void eliminarTempl(String nombreT) {
		Templates templ = new Templates (driver, driverWait);
		templ.ingresarATemplate();
		templ.borrarTemplate(nombreT);
	}
	
//================================================================= REGLAS ================================================================	
	
	public void crearRegla() throws IOException {
		Reglas regla = new Reglas(driver, driverWait);
		regla.ingresarAReglas();
		regla.crearNuevaRegla();
	}
	
	public void eliminarRegla() {
		Reglas regla = new Reglas(driver, driverWait);
		regla.ingresarAReglas();
		regla.eliminarRegla();
	}

//================================================================= IMPRESION ================================================================	
	
	public void imprimirPrducto () {
		Impresion impresion = new Impresion (driver, driverWait);
		impresion.ingresoAImpresion();
		impresion.seleccionProducto();
		impresion.imprimirProductoCola();
	}


}
