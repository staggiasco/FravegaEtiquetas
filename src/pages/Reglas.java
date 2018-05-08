package pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;

import junit.framework.TestFailure;
import junit.framework.TestResult;
import pageFactory.AbstractPageObject;

//@RunWith(value = Parameterized.class)
public class Reglas extends AbstractPageObject{

	public Reglas(WebDriver driver, WebDriverWait driverWait) {
		super(driver, driverWait);
		// TODO Auto-generated constructor stub
	}


	 WebDriverWait wait = new WebDriverWait(driver,30);
	 private static final TimeUnit SECONDS = null;
	
   	public void ingresarNuevaRegla() throws IOException {

   		String CSV_File = "C:\\Users\\31953658\\workspace\\FravegaProjectFer\\src\\docs\\reglas2.csv";
   		String cell[];
   		
		WebElement regla = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[5]/a"));
		WebElement nuevaRegla = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[5]/ul/li[1]/a"));

		regla.click();
		nuevaRegla.click();
		System.out.println("ingres� a Reglas");
	
		
		CSVReader reader =  new CSVReader(new FileReader(CSV_File));
		
		while((cell=reader.readNext())!= null){
			
			System.out.println("ingres� al WHILE");
				for (int i=0;i<1;i++) {
					String nRegla = cell[i];
					String nTempl = cell[i+1];
					String tipEtiq = cell[i+2];
					String nSuc = cell[i+3];
					String fDesde = cell[i+4];
					String fHasta = cell[i+5];
					String prod = cell[i+6];
					String categ = cell[i+7];

				driver.findElement(By.id("name")).sendKeys(nRegla);
				new Select(driver.findElement(By.id("cmbTemplate"))).selectByVisibleText(nTempl);
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				System.out.println(tipEtiq);
				new Select(driver.findElement(By.id("cmbLabelType"))).selectByValue(tipEtiq);
				System.out.println(tipEtiq);
				System.out.println(nSuc);
				if(nSuc!="") {
					driver.findElement(By.xpath("//*[@id=\'blockChannel\']/div/button")).click();
					driver.findElement(By.xpath("//*[@id=\"blockChannel\"]/div/ul/li[1]/div/input")).sendKeys(nSuc);					
				}
				
				
				
				driver.findElement(By.id("dtSince")).sendKeys(fDesde);
				driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div")).click();
				driver.findElement(By.id("dtUntil")).sendKeys(fHasta);
				driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div")).click();
				driver.findElement(By.id("filterProduct")).sendKeys(prod);
			//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//	driver.findElement(By.id("btnSearchProducts")).click();
			//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				if (prod != "") {
					System.out.println(prod);
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					WebElement botonBuscar = driver.findElement(By.id("btnSearchProducts"));
							botonBuscar.click();
							
					String ddd= driver.findElement(By.xpath("//*[@id=\"products\"]/tbody/tr/td[2]")).getText();		
						System.out.println("Validaci�n: "+ddd);	
							wait.until(ExpectedConditions.visibilityOf(botonBuscar));		
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
					WebElement botonSave = driver.findElement(By.id("btnSave"));
					wait.until(ExpectedConditions.visibilityOf(botonSave));
					botonSave.click();
					
				} else {

					driver.findElement(By.id("filterCategory")).sendKeys(categ);
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.findElement(By.id("btnSearchCategories")).click();
					
					
					WebElement botonSave = driver.findElement(By.id("btnSave"));
					//wait.until(ExpectedConditions.visibilityOf(botonSave));
				//	wait.until(ExpectedConditions.presenceOfElementLocated(botonSave));
					
					botonSave.click();
					
					
					//driver.findElement(By.id("btnSave")).click();
				}
				
				driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[5]/a")).click();
				driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[5]/ul/li[1]/a")).click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				//regla.click();
				//nuevaRegla.click();
				
			}
		
		//	System.out.println(nRegla+" "+ tipEtiq);
	//	inyectarParam();
		
		
		
		//leer();
		//inye1ctarParam();
	}


	
		
		
		
	//	WebElement template= (WebElement) n);
		
		
	}
    
	
	
	
	
	
	
	
	
	
	
	
	/*
	public static List<String[]> getData() {
		String location = "C:\\Users\\31953658\\workspace\\FravegaProjectFer\\src\\docs\\reglas.csv";
		return Archivos.get(location);
	}
	
	
	
	*/
	//@Parameters
/*	public static  void leer() {
		String location = "C:\\Users\\31953658\\workspace\\FravegaProjectFer\\src\\docs\\reglas.csv";
		List <String[]> records = Archivos.get(location);
		
		for (String[] record: records) {
			for (String field : record) {
				System.out.println(field);
			}
		}
	}
	*/
	
	/*
	public void leerCSV() {
		String location = "C:\\Users\\31953658\\workspace\\FravegaProjectFer\\src\\docs\\reglas.csv";
		List<String[]> records = Archivos.readCSV(location);
		for (String[] record : records) {
			for (String field : record) {
				System.out.println(field);
			}
		}
	}
	*/
	
	
}
