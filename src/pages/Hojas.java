package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageFactory.AbstractPageObject;

public class Hojas extends AbstractPageObject {

	public Hojas(WebDriver driver, WebDriverWait driverWait) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;

	WebDriverWait wait = new WebDriverWait(driver, 30);
	private static final TimeUnit SECONDS = null;

	private String nombre = "hojaFer2";
	private float ancho = 10;
	private float alto = 10;
	String orienHoja = "Horizontal";
	int r = (int) (Math.random() * 100);

	// String nombreHoja = "HojaMobileF";
	String nombreHoja = "Carta";
	String reg = "papers_length";
	

	public void ingresarAHoja() {
		WebElement hoja = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[2]/a"));
		hoja.click();
	}

	public void crearNuevaHoja() {

		System.out.println("metodo ingresarNuevaHoja");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement nuevaHoja = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[2]/ul/li[1]/a"));
		nuevaHoja.click();

		driver.findElement(By.id("name")).sendKeys(nombre + (r));
		driver.findElement(By.id("width")).sendKeys(Float.toString(ancho));
		driver.findElement(By.id("height")).sendKeys(Float.toString(alto));
		new Select(driver.findElement(By.id("cmbOrientation"))).selectByVisibleText(orienHoja);
		driver.findElement(By.id("btnSave")).click();
		new Select(driver.findElement(By.name("papers_length"))).selectByValue("100");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		System.out.println("SE HA CREADO LA HOJA CORRECTAMENTE.");

	}

	public void eliminarHoja() {

		int i = 0;
		WebElement verHoja = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[2]/ul/li[2]/a"));
		verHoja.click();

		mostrarRegistros(reg);
		
		WebElement tdbody = driver.findElement(By.xpath("//*[@id=\"papers\"]/tbody"));

		List<WebElement> trs = tdbody.findElements(By.xpath("tr"));

		for (WebElement td : trs) {

			i++;

			System.out.println("========================");
			System.out.println("    La TR de la Tabla   ");
			System.out.println("========================");

			List<WebElement> tds = td.findElements(By.tagName("td"));

			for (WebElement g : tds) {

				String nomElem = g.getText();

				if (nomElem.equalsIgnoreCase(nombreHoja)) {
					// g.findElement(By.xpath("/td[0]/button")).click();
					nomElem = "BORRADO";
					td.findElement(By.xpath("//*[@id=\"papers\"]/tbody/tr[" + i + "]/td[1]/button")).click();

					WebElement botonConf = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button[1]"));
					wait.until(ExpectedConditions.visibilityOf(botonConf));
					botonConf.click();

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
