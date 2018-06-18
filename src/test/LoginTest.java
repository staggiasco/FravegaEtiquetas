package test;

import java.io.IOException;

import org.apache.xalan.xsltc.compiler.Template;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public void ingresarEtiq(String perfil) {
		HomePage homePage = new HomePage(driver, driverWait);
		homePage.ingresarEtiquetas(perfil);
	}
	
	public void verNuevasActualizaciones() {
		DashBoard dashboard = new DashBoard(driver, driverWait);
		dashboard.verNuevasActualizaciones();
	}
	
//================================================================= HOJAS ================================================================	

	public String tCrearHoja() {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		//hojas.crearNuevaHoja(); // Version 1.0
		String nombreHoja = hojas.crearNuevaHoja();
	
		return nombreHoja;
	}
	
	public void tIngresarCrearHoja() {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.ingresarCrearHoja();
	}

	public void tEliminarHoja() {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.eliminarHoja();
	}

	
	
	
	public void tCrearHojaIncorrecta() throws InterruptedException {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.crearMargenesIncorrectos();
	}
	
	//--------------------------------------------- CASOS NEGATIVOS HOJAS ---------------------------------------------------------------------------------------
	
	
	public void tIngresarNumerosEnNombre(String nombre, String ancho, String alto, String msuperiro, String minferior, String mizq, String mderecho) {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.ingresarCrearHoja();
		hojas.CasosNegativosHojas(nombre,ancho,alto,msuperiro,minferior,mizq,mderecho);
	}
	
	public void tNombreVacio(String nombre, String ancho, String alto, String msuperiro, String minferior, String mizq, String mderecho) {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.ingresarCrearHoja();
		hojas.CasosNegativosHojas(nombre,ancho,alto,msuperiro,minferior,mizq,mderecho);
	}
	
	public void tAnchoVacio(String nombre, String ancho, String alto, String msuperiro, String minferior, String mizq, String mderecho) {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.ingresarCrearHoja();
		hojas.CasosNegativosHojas(nombre,ancho,alto,msuperiro,minferior,mizq,mderecho);
	}
	
	public void tAltoVacio(String nombre, String ancho, String alto, String msuperiro, String minferior, String mizq, String mderecho) {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.CasosNegativosHojas(nombre,ancho,alto,msuperiro,minferior,mizq,mderecho);
	}
	
	public void tMargenSuperiorVacio(String nombre, String ancho, String alto, String msuperiro, String minferior, String mizq, String mderecho) {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.CasosNegativosHojas(nombre,ancho,alto,msuperiro,minferior,mizq,mderecho);	
	}
	
	public void tMargenInferiorVacio(String nombre, String ancho, String alto, String msuperiro, String minferior, String mizq, String mderecho) {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.CasosNegativosHojas(nombre,ancho,alto,msuperiro,minferior,mizq,mderecho);
	}
	
	public void tMargenIzqVacio(String nombre, String ancho, String alto, String msuperiro, String minferior, String mizq, String mderecho) {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.CasosNegativosHojas(nombre,ancho,alto,msuperiro,minferior,mizq,mderecho);
	}
	
	public void tMargenDerechoVacio(String nombre, String ancho, String alto, String msuperiro, String minferior, String mizq, String mderecho) {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.CasosNegativosHojas(nombre,ancho,alto,msuperiro,minferior,mizq,mderecho);
    }
	
	public void tCrearHojaVacia(String nombre, String ancho, String alto, String msuperiro, String minferior, String mizq, String mderecho) {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.CasosNegativosHojas(nombre,ancho,alto,msuperiro,minferior,mizq,mderecho);
	}
	
	public void tCrearHojaCancelar(String nombre, String ancho, String alto, String msuperiro, String minferior, String mizq, String mderecho) {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.CasosNegativosHojas(nombre,ancho,alto,msuperiro,minferior,mizq,mderecho);
	}
	
	public void tCrearHojaAnchoConLetras(String nombre, String ancho, String alto, String msuperiro, String minferior, String mizq, String mderecho) {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.CasosNegativosHojas(nombre,ancho,alto,msuperiro,minferior,mizq,mderecho);
	}
	
	public void tCrearHojaAltoConLetras(String nombre, String ancho, String alto, String msuperiro, String minferior, String mizq, String mderecho) {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.CasosNegativosHojas(nombre,ancho,alto,msuperiro,minferior,mizq,mderecho);
	}
	
	  public void tCrearHojaMargenSupConLetras(String nombre, String ancho, String alto, String msuperiro, String minferior, String mizq, String mderecho) {
		Hojas hojas = new Hojas(driver, driverWait);
		hojas.ingresarAHoja();
		hojas.CasosNegativosHojas(nombre,ancho,alto,msuperiro,minferior,mizq,mderecho); 
	}
	  
	    public void tCrearHojaMargenInfConLetras(String nombre, String ancho, String alto, String msuperiro, String minferior, String mizq, String mderecho) {
	    	Hojas hojas = new Hojas(driver, driverWait);
			hojas.ingresarAHoja();
			hojas.CasosNegativosHojas(nombre,ancho,alto,msuperiro,minferior,mizq,mderecho); 	
	}
	    
	    public void tCrearHojaMargenIzqConLetras(String nombre, String ancho, String alto, String msuperiro, String minferior, String mizq, String mderecho) {
	    	Hojas hojas = new Hojas(driver, driverWait);
			hojas.ingresarAHoja();
			hojas.CasosNegativosHojas(nombre,ancho,alto,msuperiro,minferior,mizq,mderecho); 
	}
	
	    public void tCrearHojaMargenDerechoConLetras(String nombre, String ancho, String alto, String msuperiro, String minferior, String mizq, String mderecho) {
	    	Hojas hojas = new Hojas(driver, driverWait);
			hojas.ingresarAHoja();
			hojas.CasosNegativosHojas(nombre,ancho,alto,msuperiro,minferior,mizq,mderecho); 
	}
	 
	    public void tCrearHojaMargenesSuperanHoja(String nombre, String ancho, String alto, String msuperiro, String minferior, String mizq, String mderecho) {
	    	Hojas hojas = new Hojas(driver, driverWait);
			hojas.ingresarAHoja();
			hojas.CasosNegativosHojas(nombre,ancho,alto,msuperiro,minferior,mizq,mderecho); 
	}
	    
	  
//================================================================= MARCOS ================================================================		
	
	public String crearMarco(String hojaCreada) {
		Marcos marcos = new Marcos(driver, driverWait);
		marcos.ingresarAMarco();
		//marcos.crearNuevoMarco(hojaCreada); // Version1.0
		String nombreMarco = marcos.crearNuevoMarco(hojaCreada);
		
		return nombreMarco;
		
	}
	
	public void eliminarMarco( ) {
		Marcos marcos = new Marcos(driver, driverWait);
		marcos.ingresarAMarco();
		marcos.eliminarMarco();
	}
	
//-------------------------------------------------------------- CASOS NEGATIVOS MARCOS -----------------------------------------------------
	
	public void tCrearMarcoVacio(String hojaCreada2, String nombre, String ancho, String alto) {
		Marcos marcos = new Marcos(driver, driverWait);
		marcos.ingresarAMarco();
		marcos.CasosNegativosMarcos(hojaCreada2,nombre,ancho,alto);
	}
	
//================================================================= TEMPLATE ================================================================		
	
	public String crearTempl(String marcoCreado) {
		Templates templ = new Templates(driver, driverWait);
		templ.ingresarATemplate();
		String nombreTempl = templ.crearNuevoTempl(marcoCreado);
				
		return nombreTempl;
		
	}
	
	public void eliminarTempl(String nombreT) {
		Templates templ = new Templates (driver, driverWait);
		templ.ingresarATemplate();
		templ.borrarTemplate(nombreT);
	}
	
//================================================================= REGLAS ================================================================	
	
	public String crearRegla(String templCreado) throws IOException, InterruptedException {
		Reglas regla = new Reglas(driver, driverWait);
		regla.ingresarAReglas();
		//regla.crearNuevaRegla(templCreado);
		String prodRegla = regla.crearNuevaRegla(templCreado);
		
		return prodRegla;
	}
	
	public void eliminarRegla() {
		Reglas regla = new Reglas(driver, driverWait);
		regla.ingresarAReglas();
		regla.eliminarRegla();
	}

//================================================================= IMPRESION ================================================================	
	
	public void imprimirProducto (String prodRegla) throws InterruptedException {
		Impresion impresion = new Impresion (driver, driverWait);
		impresion.ingresoAImpresion();
		impresion.crearNuevaImpresion();
		impresion.seleccionarFiltro(prodRegla);
		impresion.seleccionProducto();
		impresion.imprimirEtiquetas();
	}

	
	public void buscarImpr () {
		Impresion impresion = new Impresion (driver, driverWait);
		impresion.ingresoAImpresion();
		impresion.buscarImpresion(null);
	}

}
