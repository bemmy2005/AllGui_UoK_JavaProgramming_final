package allthethingsforgui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class StudentForm implements ActionListener{
	JFrame frame;//id;fname;lname;email;telephone;
	JLabel id_lb=new JLabel("ID");
	JLabel fname_lb=new JLabel("First name");
	JLabel lname_lb=new JLabel("Last Name");
	JLabel email_lb=new JLabel("Email");
	JLabel telephone_lb=new JLabel("Telephone");
	JLabel gender_lb=new JLabel("Gender");

	JTextField id_txf=new JTextField();
	JTextField fname_txf=new JTextField();
	JTextField lname_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField telephone_txf=new JTextField();

	String []gender={"Male", "Female"};
	JComboBox<String> genderBox = new JComboBox<>(gender);

	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public StudentForm() {
		createForm();

	}
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_tbtn.addActionListener(this);
		delete_btn.addActionListener(this);
		//genderBox.addActionListener(this);
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("Student form");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
	}


	private void setLocationandSize() {
		id_lb.setBounds(10, 10, 100, 30);
		fname_lb.setBounds(10, 50, 100, 30);
		lname_lb.setBounds(10, 90, 100, 30);
		email_lb.setBounds(10, 130, 100, 30);
		telephone_lb.setBounds(10, 170, 100, 30);
		gender_lb.setBounds(10, 210, 100, 30);
		id_txf.setBounds(160, 10, 130, 30);
		fname_txf.setBounds(160, 50, 130, 30);
		lname_txf.setBounds(160, 90, 130, 30);
		email_txf.setBounds(160, 130, 130, 30);
		telephone_txf.setBounds(160, 170, 130, 30);
		genderBox.setBounds(160, 210, 130, 30);
		//Buttons CRUD
		insert_btn.setBounds(10,250, 85, 30);
		Read_btn.setBounds(100,250, 85, 30);
		update_tbtn.setBounds(190,250, 85, 30);
		delete_btn.setBounds(280,250, 85, 30);
		setFontforall();
		addcomponentforFrame();

	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		id_lb.setFont(font);
		fname_lb.setFont(font);
		lname_lb.setFont(font);
		email_lb.setFont(font);
		telephone_lb.setFont(font);

		id_txf.setFont(font);
		fname_txf.setFont(font);
		lname_txf.setFont(font);
		email_txf.setFont(font);
		telephone_txf.setFont(font);
		gender_lb.setFont(font);
		genderBox.setFont(font);
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addcomponentforFrame() {
		frame.add(id_lb);
		frame.add(fname_lb);
		frame.add(lname_lb);
		frame.add(email_lb);
		frame.add(telephone_lb);
		frame.add(gender_lb);
		frame.add(id_txf);
		frame.add(fname_txf);
		frame.add(lname_txf);
		frame.add(email_txf);
		frame.add(telephone_txf);
		frame.add(genderBox);
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		ActionEvent();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Student st=new Student();
		if(e.getSource()==insert_btn) {
			st.setFname(fname_txf.getText());
			st.setLname(lname_txf.getText());
			st.setEmail(email_txf.getText());
			st.setTelephone(telephone_txf.getText());
			String selectedOption = (String) genderBox.getSelectedItem();
			st.setGender(selectedOption);
			//st.insertData(st.getFname(), st.getLname(), st.getEmail(), st.getTelephone(), st.getGender());
			st.insertData();
		}else if (e.getSource()==Read_btn) {
			int id=Integer.parseInt(id_txf.getText());
			st.readwithID(id);
			id_txf.setText(String.valueOf(st.getId()));
			fname_txf.setText(st.getFname());
			lname_txf.setText(st.getLname());
			email_txf.setText(st.getEmail());
			telephone_txf.setText(st.getTelephone());
			st.setGender(st.getGender());
			
		}else if (e.getSource()==update_tbtn) {
			int id=Integer.parseInt(id_txf.getText());
			//st.readwithID(id);
			//id_txf.setText(String.valueOf(st.getId()));
			//fname_txf.setText(st.getFname());
			//lname_txf.setText(st.getLname());
			//email_txf.setText(st.getEmail());
			//telephone_txf.setText(st.getTelephone());
			//st.setGender(st.getGender());
			st.setFname(fname_txf.getText());
			st.setLname(lname_txf.getText());
			st.setEmail(email_txf.getText());
			st.setTelephone(telephone_txf.getText());
			st.setGender((String)genderBox.getSelectedItem());
			st.update(id);
		}else {
			int id=Integer.parseInt(id_txf.getText());
			st.delete(id);
		}

	}
	public static void main(String[] args) {
		StudentForm stf=new StudentForm();

	}



}
