/*package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
public class TemplFile {
	// This method will read a CSV file and return a List of String[]
	public static void readFile(){
		String filename = "C:\\Users\\31953658\\workspace\\FravegaProjectFer\\src\\docs\\DLavarropas(190x138).html";
		List <String[]> records = test.TemplFile.get1(filename);
		for (String[] record : records) {
			for (String field : record){
				System.out.println(field);
			}
		}
	}
	
	
	
		public static List<String[]> get(String filename) {
			List<String[]> data = new ArrayList<String[]>();
			String testRow;
			try {
				// Open and read the file
				BufferedReader br = new BufferedReader(new FileReader(filename));
				// Read data as long as it's not empty
				// Parse the data by comma using .split() method
				// Place into a temporary array, then add to List 
				while ((testRow = br.readLine()) != null) {
					String[] line = testRow.split(",");
					data.add(line);
				}
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: File not found " + filename);
			} catch (IOException e) {
				System.out.println("ERROR: Could not read " + filename);
			}
			return data;
		}

		public static List<String[]> get1(String filename) {
			// TODO Auto-generated method stub
			return null;
		}
	
	
}
*/