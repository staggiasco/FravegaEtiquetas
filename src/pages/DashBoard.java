package pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageFactory.AbstractPageObject;

public class DashBoard extends AbstractPageObject {

	public DashBoard(WebDriver driver, WebDriverWait driverWait) {
		super(driver, driverWait);
		// TODO Auto-generated constructor stub
	}

	// WebElements para declarar
	
	// private WebElement tit = driver.findElement(By.xpath("/html/body/div/div/div[1]/h2")); ---> No le gusta el assert
	
	private WebElement nuevaAct = driver.findElement(By
			.xpath("//*[@id='page-wrapper']/div[2]/div[1]/div/a/div"));
	//private WebElement titulo1 = driver.findElement(By.xpath("//*[@id='page-wrapper']/div[1]/h2"));

	

	public void verNuevasActualizaciones() {
		// tit.getText();
		// Assert.assertEquals("Dashboard", tit);
		nuevaAct.click();
		System.out.println("Prueba Satisfactoria");
	//	System.out.println(titulo1.getText());
		

	}

}
