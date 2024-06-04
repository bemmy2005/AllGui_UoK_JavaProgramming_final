package inputandoutput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestStudent {
	public static void main(String[] args) throws IOException {
		Scanner input=new Scanner(System.in);
		Students st1=new Students();
		System.out.println("Write your id: ");
		st1.setId(input.nextInt());
		System.out.println("Write your first name: ");
		st1.setFname(input.next());
		System.out.println("Write your last name: ");
		st1.setLname(input.next());
		System.out.println("Write your dob: ");
		st1.setDob(input.nextInt());
		st1.setAge();
		st1.setFullname();
		st1.setMessage();
		st1.write_to_a_File();


	}

}
