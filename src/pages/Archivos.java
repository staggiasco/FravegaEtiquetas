package pages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;

public class Archivos {

	String nRegla;
	String nTempl;
	String tipEtiq;
	String nSuc;
	String fDesde;
	String fHasta;
	String prod;
	String categ;

	
	public String readTxt(String direccion) {
		
		String texto="";
		try {
			BufferedReader bf = new BufferedReader(new FileReader(direccion));
			
			String temp="";
			String bfRead="";
			
			while((bfRead = bf.readLine()) != null) {
				temp = temp + bfRead;
			}
			
		texto = temp;
		}
		catch(Exception e){
			System.out.println("NO SE ENCONTRO EL ARCHIVO");
				
		}
	
		return texto;
		
	}
	
	public static List<String[]> get(String location) {
		List<String[]> data = new ArrayList<String[]>();
		String bfRead;
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(location));
			
			while((bfRead = bf.readLine()) != null) {
				String[] line = bfRead.split(";");
				data.add(line);
			}	

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR: no existe el arhivo "+ location);
		}
			
		return data;
	}
		
	


	
	
}
