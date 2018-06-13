package pages;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.model.RecordStream;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageFactory.AbstractPageObject;

public class Templates extends AbstractPageObject {

	public Templates(WebDriver driver, WebDriverWait driverWait) {
		super(driver, driverWait);
		// TODO Auto-generated constructor stub
	}

	WebDriverWait wait = new WebDriverWait(driver, 30);
	private static final TimeUnit SECONDS = null;

	JavascriptExecutor js = (JavascriptExecutor) driver;

	String nTempl = "TemplFer";
	String prod = "100106";
	static String txt = "";
	int r = (int) (Math.random()*100);
	
	String reg = "templates_length";
	String ver = "/html/body/div/nav/ul[1]/li[4]/ul/li[2]/a";

	public void ingresarATemplate() {
		WebElement template = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[4]/a"));
		template.click();
		System.out.println("Ingresé a Templates");	
	}

	
	public String crearNuevoTempl(String marcoCreado) {
		WebElement nuevoTempl = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[4]/ul/li[1]/a"));
		nuevoTempl.click();

		String templCreado = (nTempl + r);
		driver.findElement(By.id("name")).sendKeys(templCreado);
		new Select(driver.findElement(By.id("cmbLayout"))).selectByVisibleText(marcoCreado);
		driver.findElement(By.id("filterProduct")).sendKeys(prod);
		driver.findElement(By.id("btnSearchProducts")).click();
		System.out.println("READD FILLLLEEE");
		ingresarHTML();
		driver.findElement(By.id("btnSave")).click();
		
		return templCreado;
		
	}

	public void ingresarHTML() {
		
		Archivos arch = new Archivos();
		
		String direccion = "C:\\Users\\32343720\\eclipse-workspace\\FravegaEtiquetas\\docs\\temChico.html";
		txt = arch.readTxt(direccion);
		driver.findElement(By.xpath("//*[@id='editor']/textarea")).sendKeys(txt);
	
	}

	public void borrarTemplate(String nombreT) {
		WebElement verTempl = driver.findElement(By.xpath(ver));
		verTempl.click();

		mostrarRegistros(reg);

		int i = 0;

		// CAMBIA EL XPATH
		WebElement tdbody = driver.findElement(By.xpath("//*[@id=\"templates\"]/tbody"));

		List<WebElement> trs = tdbody.findElements(By.xpath("tr"));

		for (WebElement td : trs) {

			i++;

			System.out.println("========================");
			System.out.println("    La TR de la Tabla   ");
			System.out.println("========================");

			List<WebElement> tds = td.findElements(By.tagName("td"));

			for (WebElement g : tds) {

				String nomElem = g.getText();

				if (nomElem.equalsIgnoreCase(nombreT)) {
					// g.findElement(By.xpath("/td[0]/button")).click();
					nomElem = "BORRADO";
					td.findElement(By.xpath("//*[@id=\"templates\"]/tbody/tr[" + i + "]/td[1]/button")).click();// CAMBIA
																												// EL
																												// XPATH
					WebElement botonConf = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button[1]"));
					wait.until(ExpectedConditions.visibilityOf(botonConf));
					botonConf.click();

				}

				System.out.println(nomElem);
			}

		}
	}

	public void mostrarRegistros(String reg) {
		WebElement registro = driver.findElement(By.name(reg));
		new Select(registro).selectByValue("100");
	}

}
