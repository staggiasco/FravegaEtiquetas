package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageFactory.AbstractPageObject;

public class Marcos extends AbstractPageObject {

	public Marcos(WebDriver driver, WebDriverWait driverWait) {
		super(driver, driverWait);
		// TODO Auto-generated constructor stub
	}

		WebDriverWait wait = new WebDriverWait(driver, 5);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String mNombre = "Marco";
		String hojaValue = "2";
		double ancho = 10;
		double alto = 10;
		int r = (int) (Math.random()*1000);
		
		String nombreMarco = null;
		
	
	public void ingresarAMarco() {
			WebElement marco = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[3]/a"));
			marco.click();
		}
		
	public String crearNuevoMarco(String hojaCreada) {
		System.out.println("Ingreso a Marcos Nuevo");
		WebElement nuevoMarco = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[3]/ul/li[1]/a"));
		nuevoMarco.click();
		
		
		
		String marcoCreado = (mNombre + 1);
		driver.findElement(By.id("name")).sendKeys(marcoCreado);
		new Select(driver.findElement(By.id("cmbPaper"))).selectByVisibleText(hojaCreada);
		driver.findElement(By.id("width")).sendKeys(Double.toString(ancho));
		driver.findElement(By.id("height")).sendKeys(Double.toString(alto));
		driver.findElement(By.id("btnSave")).click();
		new Select(driver.findElement(By.name("layouts_length"))).selectByValue("100");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		//*[@id="layouts"]/tbody/tr[28]/td[2]
		
		System.out.println(ancho);
		marcoCreado = marcoCreado +" (" +ancho+"0" + "x" +alto+"0" + ")";
		
		return marcoCreado;
		
		
	}
	
	public void eliminarMarco() {

		WebElement registro = driver.findElement(By.xpath("//*[@id='layouts_length']/label/select"));
		new Select(registro).selectByValue("100");

		int i = 0;

		WebElement tdbody = driver.findElement(By.xpath("//*[@id='layouts']/tbody"));

		List<WebElement> trs = tdbody.findElements(By.xpath("tr"));

		for (WebElement td : trs) {

			i++;

			System.out.println("========================");
			System.out.println("    La TR de la Tabla   ");
			System.out.println("========================");

			List<WebElement> tds = td.findElements(By.tagName("td"));

			for (WebElement g : tds) {

				String nomElem = g.getText();

				if (nomElem.equalsIgnoreCase(nombreMarco)) {
					nomElem = "BORRADO";
					td.findElement(By.xpath("//*[@id=\"layouts\"]/tbody/tr[" + i + "]/td[1]/button")).click();
					WebElement botonConf = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button[1]"));
					wait.until(ExpectedConditions.visibilityOf(botonConf));
					botonConf.click();
				}

				System.out.println(nomElem);

			}

			System.out.println("Contador en :" + i);

		}
	}
	
	public void CasosNegativosMarcos(String hojaCreada2, String nombre, String ancho, String alto) {
		
		System.out.println("Ingreso a Marcos Nuevo");
		WebElement nuevoMarco = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[3]/ul/li[1]/a"));
		nuevoMarco.click();
		System.out.println("La nueva hoja es: " + hojaCreada2);
		
		
		//WebElements
		WebElement wnombre = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		WebElement wancho  = driver.findElement(By.xpath("//*[@id=\"width\"]"));
		WebElement walto   = driver.findElement(By.xpath("//*[@id=\"height\"]"));
	
		//Limpiar campos
		wnombre.clear();
		wancho.clear();
		walto.clear();
		
		//Ingresando datos
		wnombre.sendKeys(nombre);
		new Select(driver.findElement(By.id("cmbPaper"))).selectByVisibleText(hojaCreada2);
		wancho.sendKeys(ancho);
		walto.sendKeys(alto);
		
				
		if (nombre == "Crea y Cancela") {
			driver.findElement(By.xpath("//*[@id=\"btnCancel\"]")).click();	
			WebElement msjhojas = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[1]/h2"));
			Assert.assertEquals(msjhojas.getText(),"Marcos");
		}
		else {
			driver.findElement(By.xpath("//*[@id=\"btnSave\"]/span[1]")).click();
		
		switch(nombre){
		 
		case "":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"toast-container\"]/div/div[2]"))).click();
			break;
		case "Ancho Vacio":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"toast-container\"]/div"))).click();
			break;
		case "Alto Vacio":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"toast-container\"]/div/div[2]"))).click();
			break;		
		case "Nombreeeeeeeeeee Superaaaaaaaaaaaaaaa Limiteeeeeeeeeeeeeeee":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"toast-container\"]/div/div[2]"))).click();
			break;	
		case "Ancho supera limite":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"toast-container\"]/div/div[2]"))).click();
			break;	
		case "Alto supera limite":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"toast-container\"]/div"))).click();
			break;	
		case "Crea y Cancela":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"page-wrapper\"]/div[1]/h2"))).click();
			break;	
		case "Alto con letras":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"toast-container\"]/div/div[2]"))).click();
			break;	
		case "Ancho con letras":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"toast-container\"]/div/div[2]"))).click();
			break;	
   }		
  }
 }
}