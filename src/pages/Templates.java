package pages;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.model.RecordStream;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import pageFactory.AbstractPageObject;


public class Templates extends AbstractPageObject {

	public Templates(WebDriver driver, WebDriverWait driverWait) {
		super(driver, driverWait);
		// TODO Auto-generated constructor stub
	}

	WebDriverWait wait = new WebDriverWait(driver, 5);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	String nombreT = "TemplFer";
	String prod = "100106";
	static String txt = "";

	
	
	
	
	

	private WebElement template = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[4]/a"));
	private WebElement nuevoTempl = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[4]/ul/li[1]/a"));
	

	
	public void ingresarNuevoTempl() {
		System.out.println("Ingresé a Templates");
		template.click();
		nuevoTempl.click();
		driver.findElement(By.id("name")).sendKeys(nombreT);
		new Select (driver.findElement(By.id("cmbLayout"))).selectByValue("2");
		driver.findElement(By.id("filterProduct")).sendKeys(prod);
		driver.findElement(By.id("btnSearchProducts")).click();
		System.out.println("READD FILLLLEEE");
		ingresarHTML();
		
	}
	
	public void ingresarHTML() {
		Archivos arch = new Archivos();
		String direccion = "C:\\Users\\31953658\\workspace\\FravegaProjectFer\\src\\docs\\DLavarropas(190x138).html";
		txt = arch.readTxt(direccion);
		driver.findElement(By.xpath("//*[@id='editor']/textarea")).sendKeys(txt);
	}
	
}
