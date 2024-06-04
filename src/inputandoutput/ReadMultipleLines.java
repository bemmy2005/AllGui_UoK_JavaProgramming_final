package inputandoutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadMultipleLines {
	public static void main(String[] args) {
		try {
			// Create a FileReader object
			FileReader reader = new FileReader("StudentAppend.txt");
			// Create a BufferedReader object
			BufferedReader bufferedReader = new BufferedReader(reader);

			// Read lines from the file
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}

			// Close the reader
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}
}
