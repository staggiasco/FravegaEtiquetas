package pages;

import junit.framework.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pageFactory.AbstractPageObject;

public class Hojas extends AbstractPageObject {

	public Hojas(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	private String nombre = "hojaFer2";
	private float ancho = 10;
	private float alto = 10;
	String orienHoja = "Horizontal";
	int r = (int) (Math.random()*100);

	private WebElement hoja = driver.findElement(By
			.xpath("/html/body/div/nav/ul[1]/li[2]/a"));
	
	private WebElement nuevaHoja = driver.findElement(By
			.xpath("/html/body/div/nav/ul[1]/li[2]/ul/li[1]/a"));
	
/*	private WebElement nombreHoja = driver.findElement(By.id("name"));
	private WebElement anchoHoja = driver.findElement(By.id("width"));
	private WebElement altoHoja = driver.findElement(By.id("height"));
	private WebElement SelOrien = driver.findElement(By.id("cmbOrientation"));
	private WebElement botGuardar = driver.findElement(By.id("btnSave"));
*/
	public void ingresarNuevaHoja() {
		//nuevaAct.click();
		System.out.println("metodo ingresarNuevaHoja");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		//titulo1.getText();
		//System.out.println(titulo1);
		hoja.click();
		nuevaHoja.click();
		driver.findElement(By.id("name")).sendKeys(nombre+(r));
		driver.findElement(By.id("width")).sendKeys(Float.toString(ancho));
		driver.findElement(By.id("height")).sendKeys(Float.toString(alto));
		new Select(driver.findElement(By.id("cmbOrientation"))).selectByVisibleText(orienHoja);
		driver.findElement(By.id("btnSave")).click();
		new Select (driver.findElement(By.name("papers_length"))).selectByValue("100");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		/*		nombreHoja.sendKeys(nombre);
		anchoHoja.sendKeys(Float.toString(ancho));
		altoHoja.sendKeys(Float.toString(alto));
		Select Orientacion = new Select(SelOrien);
		Orientacion.selectByVisibleText("Vertical");
		botGuardar.click();
*/
	}
 
}
