package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import pageFactory.AbstractPageObject;


public class Impresion extends AbstractPageObject{

	public Impresion(WebDriver driver, WebDriverWait driverWait) {
		super(driver, driverWait);
		
	}
	

	WebDriverWait wait = new WebDriverWait(driver,30);
	private static final TimeUnit SECONDS = null;
	

	String articulo = "100106,501212";
    
	
	

	public void ingresoImpresion(){
	
		WebElement BotonEtiquetas = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[6]/a"));
		WebElement BotonImpresion = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[6]/ul/li[1]/a"));
	//	WebElement boton = driver.findElement(By.xpath("//*[@id='btnCreateLabel']"));
	
		// wait.until(ExpectedConditions.elementToBeClickable(BotonEtiquetas));
	//	driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[6]/a")).click();
			BotonEtiquetas.click();
			BotonImpresion.click();
		}	

	public void seleccionProducto(){
		
		WebElement actbox   = driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div/div[1]/div/div[5]/span/button"));
		WebElement stockbox = driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div/div[1]/div/div[6]/span/button"));
		
		
		wait.until(ExpectedConditions.visibilityOf(actbox));
		wait.until(ExpectedConditions.visibilityOf(stockbox));
					
			actbox.click();
			stockbox.click();
			
				
		//Ingresar SKU 
		driver.findElement(By.id("filterSKU")).sendKeys(articulo);
		// Click buscar
		driver.findElement(By.xpath("//*[@id='btnSearch']/span[1]")).click();
		//Click Checkbox 
		driver.findElement(By.xpath("//*[@id='products']/thead/tr/th[1]/input")).click();
		//Click Agregar
		driver.findElement(By.xpath("//*[@id='addBtn']")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    //CLIQUEAR el BOTON
	//	wait.until(ExpectedConditions.visibilityOf(boton));
		driver.findElement(By.xpath("//*[@id='btnSearch']/span[1]")).click();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		System.out.println("Se agregaron los articulos");
	}
	

	public void imprimirProductoCola(){
		WebElement imprimir = driver.findElement(By.id("printBtn"));
		wait.until(ExpectedConditions.visibilityOf(imprimir));
		imprimir.click();
		WebElement acptimp = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button[1]"));
		wait.until(ExpectedConditions.visibilityOf(acptimp));
		acptimp.click();	
			}

	public static TimeUnit getSeconds() {
		return SECONDS;
	}
	

	
		
}
