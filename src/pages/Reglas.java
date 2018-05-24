package pages;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;

import pageFactory.AbstractPageObject;

//@RunWith(value = Parameterized.class)
public class Reglas extends AbstractPageObject{

	public Reglas(WebDriver driver, WebDriverWait driverWait) {
		super(driver, driverWait);
		// TODO Auto-generated constructor stub
	}


	 WebDriverWait wait = new WebDriverWait(driver,30);
	 private static final TimeUnit SECONDS = null;
	
   	public void ingresarNuevaRegla() throws IOException, InterruptedException {

   		
		WebElement regla = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[5]/a"));
		WebElement nuevaRegla = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[5]/ul/li[1]/a"));
		
		wait.until(ExpectedConditions.visibilityOf(regla));
		
		regla.click();
		
		wait.until(ExpectedConditions.visibilityOf(nuevaRegla));
		
		nuevaRegla.click();
		System.out.println("ingres� a Reglas");
   		
   		String CSV_File = "C:\\Users\\31953658\\eclipse-workspace\\Etiquetas\\docs\\reglas3.csv";
   
   		CSVReader reader =  new CSVReader(new FileReader(CSV_File));
   		String cell[];
		
		while((cell=reader.readNext())!=null){
			
				for (int i=0; i < 1; i++) {
					String nRegla = cell[i];	
					String nTempl = cell[i+1];
					String tipEtiq = cell[i+2];
					String nSuc = cell[i+3];
					String fDesde = cell[i+4];
					String fHasta = cell[i+5];
					String prod = cell[i+6];
					String categoria = cell[i+7];
					
				driver.findElement(By.id("name")).sendKeys(nRegla);
				
				WebElement tipoTempl = driver.findElement(By.id("cmbTemplate"));
					new Select(tipoTempl).selectByVisibleText(nTempl);
					wait.until(ExpectedConditions.elementToBeClickable(tipoTempl));
					
					//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					
				WebElement tipoEtiq = driver.findElement(By.id("cmbLabelType"));	
					new Select(tipoEtiq).selectByVisibleText(tipEtiq);
					
					//wait.until(ExpectedConditions.visibilityOf(tipoEtiq));
					wait.until(ExpectedConditions.elementToBeClickable(tipoEtiq));
					
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					
				if(nSuc!="" || nSuc!= "todos " ) {
					WebElement comboSuc = driver.findElement(By.xpath("//*[@id=\"blockChannel\"]/div/button"));
					
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					wait.until(ExpectedConditions.elementToBeClickable(comboSuc));
					comboSuc.click();	
					
	
					driver.findElement(By.xpath("//*[@id=\"blockChannel\"]/div/ul/li[1]/div/input")).sendKeys(nSuc);					
					driver.findElement(By.xpath("//*[@id=\"blockChannel\"]/div/ul/li[7]/a/label")).click();
				}
				

			System.out.println(fDesde);
			driver.findElement(By.id("dtSince")).click();
			driver.findElement(By.id("dtSince")).clear();
			driver.findElement(By.id("dtSince")).sendKeys(fDesde);
				
			driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div")).click();	
			
			System.out.println(fHasta);
		
				driver.findElement(By.id("dtUntil")).click();
				driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[1]/th[3]")).click();
				driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[1]/th[3]")).click();
				driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[1]/th[3]")).click();
				driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[3]/td[1]")).click();

				if (prod != "") {
					System.out.println(prod);
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.findElement(By.id("filterProduct")).sendKeys(prod);
					WebElement botonBuscarProd = driver.findElement(By.id("btnSearchProducts"));
					botonBuscarProd.click();

					WebElement botonSave = driver.findElement(By.id("btnSave"));
					wait.until(ExpectedConditions.visibilityOf(botonSave));
					botonSave.click();

				} else {

					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.findElement(By.id("filterCategory")).sendKeys(categoria);
					driver.findElement(By.id("btnSearchCategories")).click();
					WebElement botonBuscarCat = driver.findElement(By.id("btnSearchCategories"));
					botonBuscarCat.click();

					WebElement botonSave = driver.findElement(By.id("btnSave"));
					wait.until(ExpectedConditions.visibilityOf(botonSave));
					botonSave.click();
				
				}
			
				driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[5]/a")).click();
				WebElement nuevo = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[5]/ul/li[1]/a"));
				
				wait.until(ExpectedConditions.visibilityOf(nuevo));
				nuevo.click();
				
				TimeUnit.SECONDS.sleep(1);
				
				}
				
		}
   	}
}



    
	
