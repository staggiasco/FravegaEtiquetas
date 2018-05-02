package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	float ancho = 10;
	float alto = 10;
	int r = (int) (Math.random()*100);
	
	private WebElement marco = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[3]/a"));
	private WebElement nuevoMarco = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[3]/ul/li[1]/a"));
//	private WebElement mNombre = driver.findElement(By.id("name"));
	
	
	public void ingresarNuevoMarco() {
		System.out.println("Ingreso a Marcos Nuevo");
		marco.click();
		nuevoMarco.click();
	//	mNombre.sendKeys("SOyunMarco");
		driver.findElement(By.id("name")).sendKeys(mNombre+r);
		new Select (driver.findElement(By.id("cmbPaper"))).selectByValue(hojaValue);
		driver.findElement(By.id("width")).sendKeys(Float.toString(ancho));
		driver.findElement(By.id("height")).sendKeys(Float.toString(alto));
		driver.findElement(By.id("btnSave")).click();
		new Select (driver.findElement(By.name("layouts_length"))).selectByValue("100");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}
	
	
	
}
