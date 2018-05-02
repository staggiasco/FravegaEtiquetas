package pages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadFile {
	
	public static List<String[]> get(String filename) {
		List<String[]> data = new ArrayList<String[]>();
		String texto;
	
	try
		{
		//Creamos un archivo FileReader que obtiene lo que tenga el archivo
	
		//El contenido de lector se guarda en un BufferedReader
		BufferedReader contenido=new BufferedReader(new FileReader(filename));

		//Con el siguiente ciclo extraemos todo el contenido del objeto "contenido" y lo mostramos

	while((texto=contenido.readLine())!=null) {
			System.out.println(texto);
		}
	}
	catch(Exception e) {
		System.out.println("Error al leer");
		}
	return data;
	}

}
