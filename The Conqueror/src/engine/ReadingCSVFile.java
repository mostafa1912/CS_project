package engine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadingCSVFile {
	public static void readFile(String path) throws IOException{
		String currentLine = "";
		FileReader fileReader= new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
		while ((currentLine = br.readLine()) != null) {
			//Body 
			System.out.println(currentLine);
			String [] line = currentLine.split(",");
		
			String cityName1 = line[0];			
			String cityName2 = line[1];
			int distance = Integer.parseInt(line[2]);

			System.out.println(cityName1);
			System.out.println(cityName2);
			System.out.println(distance);
			System.out.println("********************");


			
		}
			
	}
	
	
	
	public static void main(String[] args) throws IOException{
		readFile("distances.csv");
	}
}