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

	// String nombreT = "TemplFer2222";
	String prod = "100106";
	static String txt = "";

	String tempReg = "templates_length";

	String ver = "/html/body/div/nav/ul[1]/li[4]/ul/li[2]/a";

	public void ingresarATemplate() {
		WebElement template = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[4]/a"));
		template.click();
		System.out.println("Ingresé a Templates");
	}

	public void crearNuevoTempl() {
		WebElement nuevoTempl = driver.findElement(By.xpath("/html/body/div/nav/ul[1]/li[4]/ul/li[1]/a"));
		nuevoTempl.click();

		// driver.findElement(By.id("name")).sendKeys(nombreT);
		new Select(driver.findElement(By.id("cmbLayout"))).selectByValue("2");
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

	public void borrarTemplate(String nombreT) {
		WebElement verTempl = driver.findElement(By.xpath(ver));
		verTempl.click();

		mostrarRegistros(tempReg);

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

	public void mostrarRegistros(String tempReg) {
		WebElement registro = driver.findElement(By.name(tempReg));
		new Select(registro).selectByValue("100");
	}

}
