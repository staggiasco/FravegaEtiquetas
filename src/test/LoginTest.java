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
	
	public void ingresarEtiq() {
		HomePage homePage = new HomePage(driver, driverWait);
		homePage.ingresarEtiquetas();
		}
	
	public void verNuevasActualizaciones() {
		DashBoard dashboard = new DashBoard(driver, driverWait);
		dashboard.verNuevasActualizaciones();
	}
	
	public void crearHoja() {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.crearNuevaHoja();
	}
	
	
	public void borrarHoja() {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.borrarHoja();
	}
	
	public void creaMarco() {
		Marcos marcos = new Marcos(driver, driverWait);
		marcos.ingresarNuevoMarco();
	}
	
	public void crearTempl() {
		Templates templ = new Templates(driver, driverWait);
		templ.ingresarATemplate();
		templ.crearNuevoTempl();
	}
	
	public void borrarTempl(String nombreT) {
		Templates templ = new Templates (driver, driverWait);
		templ.ingresarATemplate();
		templ.borrarTemplate(nombreT);
	}
	
	
	

	public void creaRegla() throws IOException {
		Reglas regla = new Reglas(driver, driverWait);
		regla.ingresarNuevaRegla();
		
		
	}

	
	
	
	
	public void MingresarEtiq() {
	HomePage homePage = new HomePage(driver, driverWait);
	homePage.ingresarEtiquetas();
    }

	public void MingresoImpresion(){
	Impresion Impresion = new Impresion(driver, driverWait);
	Impresion.ingresoImpresion();

	}

	public void MparaImp(){
	Impresion Impresion = new Impresion(driver, driverWait);
	Impresion.seleccionProducto();


	   }

	public void MimpProd(){
	Impresion Impresion = new Impresion(driver, driverWait);
	Impresion.imprimirProductoCola();

	}
	
	


}
