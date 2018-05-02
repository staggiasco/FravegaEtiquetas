package test;

import java.io.IOException;

import org.apache.xalan.xsltc.compiler.Template;
import org.junit.Test;

import pageFactory.AbstractPageObject;
import pages.DashBoard;
import pages.Hojas;
import pages.HomePage;
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
	
	public void creaHoja() {
		Hojas hojas = new Hojas(driver);
		hojas.ingresarNuevaHoja();
	}
	
	public void creaMarco() {
		Marcos marcos = new Marcos(driver, driverWait);
		marcos.ingresarNuevoMarco();
	}
	
	public void creaTempl() {
		Templates templ = new Templates(driver, driverWait);
		templ.ingresarNuevoTempl();
	
		//templ.ingresarHTMLList();
	}
	

	public void creaRegla() throws IOException {
		Reglas regla = new Reglas(driver, driverWait);
		regla.ingresarNuevaRegla();
		
		
	}

	
	


}
