package pages;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
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
	 
	 
	 String nombreRegla = "R18";
	 
	
	 
	 public void ingresarAReglas() {
		 WebElement regla = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[5]/a"));
		wait.until(ExpectedConditions.visibilityOf(regla));
		regla.click();
	} 
	 
	 
   	public void crearNuevaRegla() throws IOException, InterruptedException {
	
		WebElement nuevaRegla = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[5]/ul/li[1]/a"));	
		wait.until(ExpectedConditions.visibilityOf(nuevaRegla));		
		nuevaRegla.click();
		
		TimeUnit.SECONDS.sleep(1);
		
		System.out.println("Ingresé a Reglas");
   		
   		String CSV_File = "C:\\Users\\31953658\\eclipse-workspace\\Etiquetas\\docs\\reglas3.csv";
   
   		CSVReader reader =  new CSVReader(new FileReader(CSV_File));
   		String cell[] = null;
		
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
					
				if( (!nSuc.equalsIgnoreCase("")) && (!nSuc.equalsIgnoreCase("todos")) ) {
					
					WebElement comboSuc = driver.findElement(By.xpath("//*[@id=\"blockChannel\"]/div/button"));
					
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					wait.until(ExpectedConditions.elementToBeClickable(comboSuc));
					comboSuc.click();	
					
	
					driver.findElement(By.xpath("//*[@id=\"blockChannel\"]/div/ul/li[1]/div/input")).sendKeys(nSuc);		
					TimeUnit.SECONDS.sleep(1);
					driver.findElement(By.xpath("//*[@id=\"blockChannel\"]/div/ul/li[7]/a/label")).click();
				
				}
				

	
			driver.findElement(By.id("dtSince")).click();
			driver.findElement(By.id("dtSince")).clear();
			driver.findElement(By.id("dtSince")).sendKeys(fDesde);
				
			driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div")).click();	
			
		
		
				driver.findElement(By.id("dtUntil")).click();
				driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[1]/th[3]")).click();
				driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[1]/th[3]")).click();
				driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[1]/th[3]")).click();
				driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[3]/td[1]")).click();
				
				
				if( (prod.equalsIgnoreCase("")) && (categoria.equalsIgnoreCase("")) ){
					
					WebElement botonSave = driver.findElement(By.id("btnSave"));
					//wait.until(ExpectedConditions.visibilityOf(botonSave));
					botonSave.click();
					
					TimeUnit.SECONDS.sleep(3);
					
				}
				
				if (!prod.equalsIgnoreCase("")) {
							
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.findElement(By.id("filterProduct")).sendKeys(prod);
					TimeUnit.SECONDS.sleep(1);
					WebElement botonBuscarProd = driver.findElement(By.id("btnSearchProducts"));
					botonBuscarProd.click();

					TimeUnit.SECONDS.sleep(1);
					
					WebElement botonSave = driver.findElement(By.id("btnSave"));
			//		wait.until(ExpectedConditions.visibilityOf(botonSave));
					botonSave.click();

					//TimeUnit.SECONDS.sleep(3);

				} else if (!categoria.equalsIgnoreCase("")) {

				//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.findElement(By.id("filterCategory")).sendKeys(categoria);
					TimeUnit.SECONDS.sleep(1);
					
					WebElement botonBuscarCat = driver.findElement(By.id("btnSearchCategories"));
					botonBuscarCat.click();
					
				
					WebElement ventana = driver.findElement(By.id("categoriesModal"));
					wait.until(ExpectedConditions.visibilityOf(ventana));
					
					TimeUnit.SECONDS.sleep(1);
					WebElement ventanaCategoria = driver.findElement(By.xpath("//*[@id=\"categoriesModal\"]/div/a"));
					wait.until(ExpectedConditions.visibilityOf(ventanaCategoria));	
					ventanaCategoria.click();
					
					TimeUnit.SECONDS.sleep(1);
					
					/*
					WebElement ventanaConfirm = driver.findElement(By.xpath("//*[@id=\"searchConfirmBtn\"]"));
					wait.until(ExpectedConditions.visibilityOf(ventanaConfirm));
					ventanaConfirm.click();
					*/
					
					WebElement footer = driver.findElement(By.xpath("//*[@id=\"modalSerchCategories\"]/div/div/div[3]/button"));
					footer.click();
					
					TimeUnit.SECONDS.sleep(1);
					
					WebElement botonSave = driver.findElement(By.id("btnSave"));
					//wait.until(ExpectedConditions.visibilityOf(botonSave));
					botonSave.click();
				
					TimeUnit.SECONDS.sleep(3);
					
				}
			
			
				
				
				driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[5]/a")).click();
				WebElement nuevo = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[5]/ul/li[1]/a"));
				
				wait.until(ExpectedConditions.visibilityOf(nuevo));
				nuevo.click();
				
				System.out.println("========================================================");
				System.out.println(" ");
				System.out.println("Regla Nombre:" + nRegla + "|");
				System.out.println("Template Nombre:" + nTempl + "|");
				System.out.println("Tipo Etiqueta:" + tipEtiq + "|");
				System.out.println("Sucursal Nombre:" + nSuc + "|");
				System.out.println("Fecha Desde:" + fDesde + "|");
				System.out.println("Fecha Hasta:" + fHasta + "|");
				System.out.println("Producto:" + prod + "|");
				System.out.println("Categoría:" + categoria + "|");
				System.out.println(" ");
				System.out.println("========================================================");
				
				
				TimeUnit.SECONDS.sleep(3);
				
				
				}
				
		}
   	}
   	
   	
   	
public void eliminarRegla() {

		
		WebElement verRegla = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[5]/ul/li[2]/a"));
		verRegla.click();
		
		
		WebElement registro = driver.findElement(By.xpath("//*[@id='rules_length']/label/select"));
		new Select(registro).selectByValue("100");

		int i = 0;

		WebElement tdbody = driver.findElement(By.xpath("//*[@id='rules']/tbody"));

		List<WebElement> trs = tdbody.findElements(By.xpath("tr"));

		for (WebElement td : trs) {

			i++;

			System.out.println("========================");
			System.out.println("    La TR de la Tabla   ");
			System.out.println("========================");

			List<WebElement> tds = td.findElements(By.tagName("td"));

			for (WebElement g : tds) {

				String nomElem = g.getText();

				if (nomElem.equalsIgnoreCase(nombreRegla)) {
					nomElem = "BORRADO";
					td.findElement(By.xpath("//*[@id=\"rules\"]/tbody/tr[" + i + "]/td[1]/button")).click();
					WebElement botonConf = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button[1]"));
					wait.until(ExpectedConditions.visibilityOf(botonConf));
					botonConf.click();
				}

				System.out.println(nomElem);

			}

			System.out.println("Contador en :" + i);

		}
	}
   	
   	
   	
   	
}



    
	
