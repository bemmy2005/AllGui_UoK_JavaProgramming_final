package inputandoutput;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;

public class Students {
	private int id;
	private String fname;
	private String Lname;
	private String fullname;
	private int age;
	private int dob;
	private String message;
	public Students() {}
	public Students(int id, String fname, String lname, String fullname, int age,int dob, String message) {
		super();
		this.id = id;
		this.fname = fname;
		Lname = lname;
		this.fullname = fullname;
		this.age = age;
		this.message = message;
		this.dob=dob;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname() {
		this.fullname = this.fname+" "+Lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge() {
		this.age = Year.now().getValue()-this.dob;
	}

	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob = dob;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage() {
		if(this.age>80) {
			this.message = "You are a very old person!";
		}else if(this.age>=80 && this.age<50) {
			this.message = "You are an old person!";
		}	else if(this.age>=50 && this.age<30) {
			this.message = "You are a mature person!";
		}else if(this.age>=30 && this.age<18) {
			this.message = "You are a person!";
		}else {
			this.message = "No more information to be asked!";
		}
	}
	public void write_to_a_File() throws IOException {
		//create a FileWriter object
		FileWriter writer=new FileWriter("Student.txt");
		//Write data to file
		writer.write("Student id: "+ this.getId()+" Full name: "+this.getFullname()+" date of Birth "+this.getDob()+" age: "+this.getAge()+"Message: "+this.getMessage()+"\n");
		//writer.write("this is a sample file!");
		//close the file
		writer.close();
		System.out.println("File written successifully!");
	}

}
