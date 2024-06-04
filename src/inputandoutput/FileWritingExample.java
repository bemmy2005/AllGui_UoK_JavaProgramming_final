package inputandoutput;

import java.io.FileWriter;
import java.io.IOException;

public class FileWritingExample {
	public static void main(String[] args) {
		try {
			//create a FileWriter object
			FileWriter writer=new FileWriter("Output.txt");
			//Write data to file
			writer.write("Hello, world!\n");
			writer.write("this is a sample file!");
			//close the file
			writer.close();
			System.out.println("File written successifully!");
		} catch (IOException e) {
			System.out.println("An error occured: "+e.getMessage());	
		}
	}
}
