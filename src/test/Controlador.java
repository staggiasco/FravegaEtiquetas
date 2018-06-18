package test;

import java.io.IOException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


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
		String hojaCreada = etiquetas.tCrearHoja();
		
		return hojaCreada;
	}
	
     //ELIMINAR HOJAS
	
	public void eliminarHojaEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tEliminarHoja();
	}
	
	
	public void creaHojaIncorrecta() throws InterruptedException {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tCrearHojaIncorrecta();
	}
	
	
	//------------------------------------------ CASOS NEGATIVOS HOJAS  ---------------------------------------------------------------------------------------------------
	
	//INTENTAR CREAR HOJA - NOMBRE INGRESANDO NUMEROS
	
	public void cNombraeConNumeros() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tIngresarCrearHoja();
		etiquetas.tIngresarNumerosEnNombre("4444","5","5","5","5","5","5");
	}
	
	//INTENTAR CREAR HOJA - NOMBRE "VACIO".
	
	public void cNombreVacio() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tIngresarCrearHoja();
		etiquetas.tNombreVacio("","5","5","5","5","5","5");
	}
	
	//INTENTAR CREAR HOJA - ANCHO "VACIO"
	
	public void cAnchoVacio() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tIngresarCrearHoja();
		etiquetas.tAnchoVacio("Ancho Vacio","","5","5","5","5","5");
	}
	
	//INTENTAR CREAR HOJA - ALTO "VACIO"
	
	public void cAltoVacio() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tIngresarCrearHoja();
		etiquetas.tAltoVacio("Alto vacio","5","","5","5","5","5");
    }
	
	//INTENTAR CREAR HOJA - MARGEN SUPERIOR "VACIO"
	
	public void cMargenSuperiorVacio() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tIngresarCrearHoja();
	    etiquetas.tMargenSuperiorVacio("MSuperior Vacio","5","5","","5","5","5");
	}
	
	//INTENTAR CREAR HOJA - MARGEN INFERIOR "VACIO"
	
	public void cMargenInferiorVacio() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tIngresarCrearHoja();
		etiquetas.tMargenInferiorVacio("MInferior Vacio","5","5","5","","5","5");
	}
	
	//INTENTAR CREAR HOJA - MARGEN IZQ "VACIO"
	
    public void cMargenInfeiorIzqVacio() {
    	LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tIngresarCrearHoja();
		etiquetas.tMargenIzqVacio("MIzq Vacio","5","5","5","5","","5");
    }
    
    //INTENTAR CREAR HOJA - MARGEN DERECHO "VACIO"
   
	public void cMargenDerechoVacio() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tIngresarCrearHoja();
		etiquetas.tMargenDerechoVacio("MDerecho Vacio","5","5","5","5","5","");
	}
	
	//INTENTAR CREAR HOJA - TODOS LOS DATOS "VACIOS"
	
    public void cCrearHojaVacia() {
    	LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tIngresarCrearHoja();
		etiquetas.tCrearHojaVacia("","","","","","","");
    }
   	//INTENTAR CREAR HOJA - CANCELAR
    
	public void cCrearHojaCancelar() {
	    	LoginTest etiquetas = new LoginTest();
			etiquetas.ingresarEtiq(perfil);
			etiquetas.tIngresarCrearHoja();
			etiquetas.tCrearHojaCancelar("Crea y Cancela","5","5","5","5","5","5");
    }
    
    //INTENTAR CREAR HOJA - ANCHO INGRESAR LETRAS
	
    public void cCrearHojaAnchoConLetras() {
    	LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tIngresarCrearHoja();
		etiquetas.tCrearHojaAnchoConLetras("Ancho con letras","Ancho","5","5","5","5","5");
    }
	
	//INTENTAR CREAR HOJA - ALTO INGRESAR LETRAS
    
	public void cCrearHojaAltoConLetras() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tIngresarCrearHoja();
		etiquetas.tCrearHojaAltoConLetras("Alto con Letras","5","Alto","5","5","5","5");
	}
    
    //INTENTAR CREAR HOJA - MARGEN SUPERIOR CON LETRAS
	
    public void cCrearHojaMargenSupConLetras() {
    	LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tIngresarCrearHoja();
		etiquetas.tCrearHojaMargenSupConLetras("MSuperior con letras","5","5","Msuperior","5","5","5");
    }
    
  //INTENTAR CREAR HOJA - MARGEN INFERIOR CON LETRAS
    
    public void cCrearHojaMargenInfConLetras() {
    	LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tIngresarCrearHoja();
		etiquetas.tCrearHojaMargenInfConLetras("MInferior con letras","5","5","5","Minferior","5","5");
    }
	
    //INTENTAR CREAR HOJA - MARGEN IZQ CON LETRAS
    
    public void cCrearHojaMargenIzqConLetras() {
    	LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tIngresarCrearHoja();
		etiquetas.tCrearHojaMargenIzqConLetras("Mizq con letras","5","5","5","5","Mizq","5");
    }
	
    //INTENTAR CREAR HOJA - MARGEN DERECHO CON LETRAS
    
    public void cCrearHojaMargenDerechoConLetras() {
    	LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tIngresarCrearHoja();
		etiquetas.tCrearHojaMargenDerechoConLetras("Mizq con letras","5","5","5","5","5","MDerecho");
    }
    
    //INTENTAR CREAR HOJA - MARGENES SUPERAN HOJA
    
    public void cCrearHojaMargenesSuperanHoja() {
    	LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.tIngresarCrearHoja();
		etiquetas.tCrearHojaMargenesSuperanHoja("Magenes superan hoja","5","5","50","50","50","50");
    }
  
//================================================================= MARCOS ================================================================	

	// CREAR MARCOS

	public void cCreaMarcoEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil); //Login

	//etiquetas.crearMarco(hojaCreada);
}
	// ELIMINAR MARCO
	@Test
	public void cEliminarMarcoEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.eliminarMarco();
	}

	
// ----------------------------------------------- CASOS NEGATIVOS MARCOS -------------------------------------------------------------------
	
	// CREAR MARCO - TODOS LOS DATOS "VACIOS"
	
	public void cCreaMarcoCamposVacios() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		String hojaCreada2 = etiquetas.tCrearHoja();
		etiquetas.tCrearMarcoVacio(hojaCreada2, "", "", "");
	}
	
	// CREA MARCO - NOMBRE "VACIO"
	
	public void cCrearMarcoNombreVacio() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		String hojaCreada2 = etiquetas.tCrearHoja();
		etiquetas.tCrearMarcoNombreVacio(hojaCreada2, "", "25", "25");	
	}
	
	// CREA MARCO - NOMBRE "VACIO"
	
	public void cCrearMarcoAnchoVacio() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		String hojaCreada2 = etiquetas.tCrearHoja();
		etiquetas.tCrearMarcoAnchoVacio(hojaCreada2, "Ancho Vacio", "", "25");	
	}
	
	// CREA MARCO - NOMBRE "VACIO"
	
	public void cCrearMarcoAltoVacio() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		String hojaCreada2 = etiquetas.tCrearHoja();
		etiquetas.tCrearMarcoAltoVacio(hojaCreada2, "Alto Vacio", "25", "");	
	}
	
	// CREA MARCO - NOMBRE SUPERA LIMITE
	
	public void cCrearMarcoNombreSuperaLimite() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		String hojaCreada2 = etiquetas.tCrearHoja();
		etiquetas.tCrearMarcoNombreSuperaLimite(hojaCreada2, "Nombre superaaaaaaaaaaaaaaaaa limiteeeeeeeeeeeeeeeeeeeee", "25", "25");	
	}
	
	// CREA MARCO - ANCHO SUPERA LIMITE
	
	public void cCrearMarcoAnchoSuperaLimite() {
	LoginTest etiquetas = new LoginTest();
	etiquetas.ingresarEtiq(perfil);
	String hojaCreada2 = etiquetas.tCrearHoja();
	etiquetas.tCrearMarcoAnchoSuperaLimite(hojaCreada2, "Ancho supera limite", "2555555555555555", "5");	
	}
	
	// CREA MARCO - ALTO SUPERA LIMITE
	
	public void cCrearMarcoAltoSuperaLimite() {
	LoginTest etiquetas = new LoginTest();
	etiquetas.ingresarEtiq(perfil);
	String hojaCreada2 = etiquetas.tCrearHoja();
	etiquetas.tCrearMarcoAltoSuperaLimite(hojaCreada2, "Alto supera limite", "2", "22222222222222222222222225");	
	}
	
	// CREA MARCO - CREA Y CANCELA
	
	public void cCrearMarcoYCancela() {
	LoginTest etiquetas = new LoginTest();
	etiquetas.ingresarEtiq(perfil);
	String hojaCreada2 = etiquetas.tCrearHoja();
	etiquetas.tCrearMarcoCreaYCancela(hojaCreada2, "Crea y Cancela", "25", "25");	
	}
	
	// CREAR MARCO - ALTO CON LETRAS
	
	public void cCrearMarcoAltoConLetras() {
	LoginTest etiquetas = new LoginTest();
	etiquetas.ingresarEtiq(perfil);
	String hojaCreada2 = etiquetas.tCrearHoja();
	etiquetas.tCrearMarcoCreaAltoConLetras(hojaCreada2, "Alto con letras", "25", "Alto");	
	}
	
	// CREAR MARCO - ANCHO CON LETRAS
	
	public void cCrearMArcoAnchoConLetras() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		String hojaCreada2 = etiquetas.tCrearHoja();
		etiquetas.tCrearMarcoCreaAnchoConLeteas(hojaCreada2, "Ancho con letras", "Ancho", "25");	
	}
	

//================================================================= TEMPLATE ================================================================	
	
	// CREAR TEMPLATES

	public void cCreaTemplateEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.crearTempl(nombreT);
	}

	// ELIMINAR TEMPLATES
	
	public void cEliminarTemplateEtiqueta() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.eliminarTempl(nombreT);
	}

//================================================================= REGLAS ================================================================		

	// CREAR REGLA

	public void cCreaReglaEtiquetas() throws IOException, InterruptedException  {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
	    //etiquetas.crearRegla();
	}
	
	
	//
	public void cEliminarReglaEtiquetas() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.eliminarRegla();
	}

	
//================================================================= IMPRESION ================================================================	
	 

	
	public void cImprimirEtiqueta() throws InterruptedException {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.imprimirProducto(nombreT);	
	}
	

	public void cBuscarImpr() {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		etiquetas.buscarImpr();
	}
	
	
//================================================================= PUNTA A PUNTA ================================================================		

	
	// CREAR HOJAS
	
	public void ejecutarCircuitoCompleto() throws InterruptedException, IOException {
		LoginTest etiquetas = new LoginTest();
		etiquetas.ingresarEtiq(perfil);
		
		String hojaCreada = etiquetas.tCrearHoja();
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
