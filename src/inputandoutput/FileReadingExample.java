package inputandoutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingExample {
	public static void main(String[] args) {
		try {
			//Create a FileReader object
			FileReader reader=new FileReader("Output.txt");
			//create a bufferedReader object
			BufferedReader bufferedReader=new BufferedReader(reader);
			//Read lines from the file
			String line;// = bufferedReader.readLine();
			while ((line = bufferedReader.readLine())!=null) {
				//line =bufferedReader.readLine();
				System.out.println(line);
			}
			//Close the reader
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("An error occured: "+e.getMessage());
		}
	}
}
