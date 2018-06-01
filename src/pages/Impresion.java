package pages;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import pageFactory.AbstractPageObject;

public class Impresion extends AbstractPageObject {

	public Impresion(WebDriver driver, WebDriverWait driverWait) {
		super(driver, driverWait);

	}

	
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	private static final TimeUnit SECONDS = null;

	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	String articulo = "100106,501212";
	String reg = "log_length";
	String nomProd = "Celular Libre Motorola MOTO Z Negro";

	public void ingresoAImpresion() {

		WebElement BotonEtiquetas = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[6]/a"));
		BotonEtiquetas.click();
		
	}
	
	public void crearNuevaImpresion () {
		WebElement BotonImpresion = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[6]/ul/li[1]/a"));
		BotonImpresion.click();

	}
	

	public void seleccionarFiltro(String prodRegla) {
		WebElement actbox = driver
				.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div/div[1]/div/div[5]/span/button"));
		WebElement stockbox = driver
				.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div/div[1]/div/div[6]/span/button"));

		wait.until(ExpectedConditions.visibilityOf(actbox));
		wait.until(ExpectedConditions.visibilityOf(stockbox));

		// Quitar el click de la categoría
		actbox.click();
		stockbox.click();

		driver.findElement(By.id("filterSKU")).sendKeys(prodRegla); // Ingresar SKU
		driver.findElement(By.xpath("//*[@id='btnSearch']/span[1]")).click();// Click buscar
	}
	
	public void seleccionProducto() {
		driver.findElement(By.xpath("//*[@id='products']/thead/tr/th[1]/input")).click(); 	// Click Checkbox//*[@id="products"]/thead/tr/th[1]
		driver.findElement(By.xpath("//*[@id='addBtn']")).click(); 							// Click Agregar
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement imprimir = driver.findElement(By.id("btnCreateLabel"));
		wait.until(ExpectedConditions.visibilityOf(imprimir));
		imprimir.click();			// CLIQUEAR el BOTON
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		System.out.println("Se agregaron los articulos");
	}
	
	public void imprimirEtiquetas() throws InterruptedException {	
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Ingresé a imprimir");
		
		WebElement printBtn = driver.findElement(By.xpath("//*[@id=\"printBtn\"]"));
		TimeUnit.SECONDS.sleep(1);
		wait.until(ExpectedConditions.visibilityOf(printBtn));
		printBtn.click();
		WebElement acptimp = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button[1]"));
	    wait.until(ExpectedConditions.visibilityOf(acptimp));
	    acptimp.click();    
		
		
	}

	public static TimeUnit getSeconds() {
		return SECONDS;
	}

	
	public void buscarImpresion (String nomImpr) {
		
		WebElement botonHistorial = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[6]/ul/li[2]/a"));
		botonHistorial.click();
		
		mostrarRegistros(reg);
		
		WebElement campoBuscar = driver.findElement(By.xpath("//*[@id=\"log_filter\"]/label/input"));
		campoBuscar.sendKeys("Celu");
		
		
		int i = 0;

		WebElement tdbody = driver.findElement(By.xpath("//*[@id='log']/tbody"));

		List<WebElement> trs = tdbody.findElements(By.xpath("tr"));

		for (WebElement td : trs) {

			i++;

			System.out.println("========================");
			System.out.println("    La TR de la Tabla   ");
			System.out.println("========================");

			List<WebElement> tds = td.findElements(By.tagName("td"));

			for (WebElement g : tds) {

				String nomElem = g.getText();

				if (nomElem.equalsIgnoreCase(nomProd)) {
					nomElem = "BUSTED";
					Assert.assertEquals("Celular Libre Motorola MOTO Z Negro", nomProd);
				}

				System.out.println(nomElem);

			}

			System.out.println("Contador en :" + i);

		}
		
		
		
	}
	
	
	public void mostrarRegistros(String reg) {
		WebElement registro = driver.findElement(By.name(reg));
		new Select(registro).selectByValue("100");
	}
	
	
	
}
