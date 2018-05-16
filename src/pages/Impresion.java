package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageFactory.AbstractPageObject;

public class Impresion extends AbstractPageObject {

	public Impresion(WebDriver driver, WebDriverWait driverWait) {
		super(driver, driverWait);

	}

	WebDriverWait wait = new WebDriverWait(driver, 30);
	private static final TimeUnit SECONDS = null;

	String articulo = "100106,501212";

	public void ingresoAImpresion() {

		WebElement BotonEtiquetas = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[6]/a"));
		BotonEtiquetas.click();
		
	}
	
	public void crearNuevaImpresion () {
		WebElement BotonImpresion = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[6]/ul/li[1]/a"));
		BotonImpresion.click();

	}
	

	public void seleccionarFiltro() {
		WebElement actbox = driver
				.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div/div[1]/div/div[5]/span/button"));
		WebElement stockbox = driver
				.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div/div[1]/div/div[6]/span/button"));

		wait.until(ExpectedConditions.visibilityOf(actbox));
		wait.until(ExpectedConditions.visibilityOf(stockbox));

		// Quitar el click de la categoría
		actbox.click();
		stockbox.click();

		driver.findElement(By.id("filterSKU")).sendKeys(articulo); // Ingresar SKU
		driver.findElement(By.xpath("//*[@id='btnSearch']/span[1]")).click();// Click buscar
	}
	
	public void seleccionProducto() {
		driver.findElement(By.xpath("//*[@id='products']/thead/tr/th[1]/input")).click(); 	// Click Checkbox//*[@id="products"]/thead/tr/th[1]
		driver.findElement(By.xpath("//*[@id='addBtn']")).click(); 							// Click Agregar
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement imprimir = driver.findElement(By.id("btnCreateLabel"));
		wait.until(ExpectedConditions.visibilityOf(imprimir));
		imprimir.click();			// CLIQUEAR el BOTON
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		System.out.println("Se agregaron los articulos");
	}
	
	public void imprimirEtiquetas() {	
		System.out.println("Ingresé a imprimir");
		WebElement printBtn = driver.findElement(By.xpath("//*[@id=\"printBtn\"]"));
		wait.until(ExpectedConditions.visibilityOf(printBtn));
		printBtn.click();
		WebElement acptimp = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button[1]"));
	    wait.until(ExpectedConditions.visibilityOf(acptimp));
	    acptimp.click();    
		
		
	}

	public static TimeUnit getSeconds() {
		return SECONDS;
	}

}
