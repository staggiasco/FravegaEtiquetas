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
public class Reglas extends AbstractPageObject {

	public Reglas(WebDriver driver, WebDriverWait driverWait) {
		super(driver, driverWait);
		// TODO Auto-generated constructor stub
	}

	WebDriverWait wait = new WebDriverWait(driver, 30);
	private static final TimeUnit SECONDS = null;

	String nombreRegla = "R1";
	String ReglaReg = "100";

	
	public void ingresarAReglas() {
		driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[5]/a")).click();
	}

	public void crearNuevaRegla() throws IOException {

		String CSV_File = "C:\\Users\\31953658\\eclipse-workspace\\Etiquetas\\docs\\reglas.csv";
		String cell[];

		WebElement nuevaRegla = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[5]/ul/li[1]/a"));
		nuevaRegla.click();
		System.out.println("Ingresé a Reglas");

		CSVReader reader = new CSVReader(new FileReader(CSV_File));

		while ((cell = reader.readNext()) != null) {

			System.out.println("Ingresé al WHILE");
			for (int i = 0; i < 1; i++) {
				String nRegla = cell[i];
				String nTempl = cell[i + 1];
				String tipEtiq = cell[i + 2];
				String nSuc = cell[i + 3];
				String fDesde = cell[i + 4];
				String fHasta = cell[i + 5];
				String prod = cell[i + 6];
				String categ = cell[i + 7];

				driver.findElement(By.id("name")).sendKeys(nRegla);
				
				new Select(driver.findElement(By.id("cmbTemplate"))).selectByVisibleText(nTempl);
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				System.out.println(tipEtiq);
				new Select(driver.findElement(By.id("cmbLabelType"))).selectByValue(tipEtiq);
				System.out.println(tipEtiq);
				System.out.println(nSuc);
				
				if (nSuc != "") {
					driver.findElement(By.xpath("//*[@id=\'blockChannel\']/div/button")).click();
					driver.findElement(By.xpath("//*[@id=\"blockChannel\"]/div/ul/li[1]/div/input")).sendKeys(nSuc);
				}

				driver.findElement(By.id("dtSince")).sendKeys(fDesde);
				driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div")).click();
				driver.findElement(By.id("dtUntil")).sendKeys(fHasta);
				driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div")).click();
				driver.findElement(By.id("filterProduct")).sendKeys(prod);
				// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				// driver.findElement(By.id("btnSearchProducts")).click();
				// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				if (prod != "") {
					System.out.println(prod);
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					WebElement botonBuscar = driver.findElement(By.id("btnSearchProducts"));
					botonBuscar.click();

					String ddd = driver.findElement(By.xpath("//*[@id=\"products\"]/tbody/tr/td[2]")).getText();
					System.out.println("Validaciï¿½n: " + ddd);
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
					// wait.until(ExpectedConditions.visibilityOf(botonSave));
					// wait.until(ExpectedConditions.presenceOfElementLocated(botonSave));

					botonSave.click();

					// driver.findElement(By.id("btnSave")).click();
				}

				driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[5]/a")).click();
				driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[5]/ul/li[1]/a")).click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				// regla.click();
				// nuevaRegla.click();

			}

			// System.out.println(nRegla+" "+ tipEtiq);
			// inyectarParam();

			// leer();
			// inye1ctarParam();
		}

		// WebElement template= (WebElement) n);

	}

	public void eliminarRegla() {

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

	/*
	 * public static List<String[]> getData() { String location =
	 * "C:\\Users\\31953658\\workspace\\FravegaProjectFer\\src\\docs\\reglas.csv";
	 * return Archivos.get(location); }
	 * 
	 * 
	 * 
	 */
	// @Parameters
	/*
	 * public static void leer() { String location =
	 * "C:\\Users\\31953658\\workspace\\FravegaProjectFer\\src\\docs\\reglas.csv";
	 * List <String[]> records = Archivos.get(location);
	 * 
	 * for (String[] record: records) { for (String field : record) {
	 * System.out.println(field); } } }
	 */

	/*
	 * public void leerCSV() { String location =
	 * "C:\\Users\\31953658\\workspace\\FravegaProjectFer\\src\\docs\\reglas.csv";
	 * List<String[]> records = Archivos.readCSV(location); for (String[] record :
	 * records) { for (String field : record) { System.out.println(field); } } }
	 */

}
