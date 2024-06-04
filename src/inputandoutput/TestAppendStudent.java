package inputandoutput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestAppendStudent {
	/*
	public static void main(String[] args) throws IOException {
		Scanner input=new Scanner(System.in);
		System.out.println("How many Students do you need in the list?");
		Students [] students=new Students[input.nextInt()];
		//int i=0;
		//Students st1=new Students();
		//while(i<=students.length) {
		for(Students st1:students) {
			st1=new Students();
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
			FileWriter writer=new FileWriter("StudentAppend.txt");
			//Write data to file
			writer.write("Student id: "+ st1.getId()+" Full name: "+st1.getFullname()+" date of Birth "+st1.getDob()+" age: "+st1.getAge()+"\n");
			//writer.write("this is a sample file!");
			//close the file
			writer.close();
			System.out.println("File written successifully!");

		}
	}
	 */
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("How many Students do you need in the list?");
		Students[] students = new Students[input.nextInt()];

		FileWriter writer = new FileWriter("StudentAppend.txt", true); // Open the file in append mode

		for (int i = 0; i < students.length; i++) {
			Students st1 = new Students();
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

			// Write data to the file
			writer.write("Student id: " + st1.getId() + " Full name: " + st1.getFullname() + " date of Birth " + st1.getDob() + " age: " + st1.getAge() + "\n");
			System.out.println("File written successfully!");
		}

		// Close the file
		writer.close();
	}
}
