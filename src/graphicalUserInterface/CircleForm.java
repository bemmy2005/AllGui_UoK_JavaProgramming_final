package graphicalUserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CircleForm implements ActionListener{
	JFrame frame;
	JLabel radius_lb=new JLabel("Radius");
	JLabel area_lb=new JLabel("Area");
	JLabel perimeter_lb=new JLabel("Perimeter");
	JTextField radius_tf=new JTextField("");
	JTextField area_tf=new JTextField("");
	JTextField perimeter_tf=new JTextField();
	JButton calculate_btn=new JButton("Calculate");
	JButton reset_btn=new JButton("Reset");
	JButton back_btn=new JButton("Back");
	public CircleForm() {
		create_window();
		set_location_size();
		addcomponents();
		addActionEvent();
	}



	private void create_window() {
		frame=new JFrame();
		frame.setTitle("Circle");
		frame.setBounds(20,20,400,300);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}



	private void set_location_size() {
		radius_lb.setBounds(20,20,100,30);
		area_lb.setBounds(20,80,100,30);
		perimeter_lb.setBounds(20,140,100,30);
		radius_tf.setBounds(200,20,100,30);
		area_tf.setBounds(200,80,100,30);
		perimeter_tf.setBounds(200,140,100,30);
		
		calculate_btn.setBounds(20,200,100,30);
		reset_btn.setBounds(120,200,100,30);
		back_btn.setBounds(220,200,100,30);

	}



	private void addcomponents() {
		frame.add(radius_lb);
		frame.add(area_lb);
		frame.add(perimeter_lb);
		frame.add(radius_tf);
		frame.add(area_tf);
		frame.add(perimeter_tf);
		frame.add(calculate_btn);
		frame.add(reset_btn);
		frame.add(back_btn);

	}



	private void addActionEvent() {
		calculate_btn.addActionListener(this);
		reset_btn.addActionListener(this);
		back_btn.addActionListener(this);

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Circle c=new Circle(0);
		if(e.getSource()==calculate_btn) {
			c.setRadius(Double.parseDouble(radius_tf.getText()));
			c.calculateArea();
			c.calculatePerimeter();
			area_tf.setText(Double.toString(c.getArea()));
			perimeter_tf.setText(Double.toString(c.getPerimeter()));
			c.insertDataIntoDatabase();			
		}else if(e.getSource()==reset_btn) {
			
		} else {
			frame.dispose();
			MainForm mf=new MainForm();
		}

	}

}
