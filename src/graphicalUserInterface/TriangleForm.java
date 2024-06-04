package graphicalUserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TriangleForm implements ActionListener {
	JFrame frame;
	JLabel base_lb = new JLabel("Base");
	JLabel height_lb = new JLabel("Height");
	JLabel side1_lb = new JLabel("Side 1");
	JLabel side2_lb = new JLabel("Side 2");
	JLabel side3_lb = new JLabel("Side 3");
	JLabel area_lb = new JLabel("Area");
	JLabel perimeter_lb = new JLabel("Perimeter");
	JTextField base_tf = new JTextField("");
	JTextField height_tf = new JTextField("");
	JTextField side1_tf = new JTextField("");
	JTextField side2_tf = new JTextField("");
	JTextField side3_tf = new JTextField("");
	JTextField area_tf = new JTextField("");
	JTextField perimeter_tf = new JTextField();
	JButton calculate_btn = new JButton("Calculate");
	JButton reset_btn = new JButton("Reset");
	JButton back_btn = new JButton("Back");

	public TriangleForm() {
		create_window();
		set_location_size();
		addcomponents();
		addActionEvent();
	}

	private void create_window() {
		frame = new JFrame();
		frame.setTitle("Triangle");
		frame.setBounds(20, 20, 400, 400);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void set_location_size() {
		base_lb.setBounds(20, 20, 100, 30);
		height_lb.setBounds(20, 60, 100, 30);
		side1_lb.setBounds(20, 100, 100, 30);
		side2_lb.setBounds(20, 140, 100, 30);
		side3_lb.setBounds(20, 180, 100, 30);
		area_lb.setBounds(20, 220, 100, 30);
		perimeter_lb.setBounds(20, 260, 100, 30);
		base_tf.setBounds(200, 20, 100, 30);
		height_tf.setBounds(200, 60, 100, 30);
		side1_tf.setBounds(200, 100, 100, 30);
		side2_tf.setBounds(200, 140, 100, 30);
		side3_tf.setBounds(200, 180, 100, 30);
		area_tf.setBounds(200, 220, 100, 30);
		perimeter_tf.setBounds(200, 260, 100, 30);
		calculate_btn.setBounds(20, 320, 100, 30);
		reset_btn.setBounds(120, 320, 100, 30);
		back_btn.setBounds(220, 320, 100, 30);
	}

	private void addcomponents() {
		frame.add(base_lb);
		frame.add(height_lb);
		frame.add(side1_lb);
		frame.add(side2_lb);
		frame.add(side3_lb);
		frame.add(area_lb);
		frame.add(perimeter_lb);
		frame.add(base_tf);
		frame.add(height_tf);
		frame.add(side1_tf);
		frame.add(side2_tf);
		frame.add(side3_tf);
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
		Triangle t = new Triangle(0, 0, 0, 0, 0);
		if (e.getSource() == calculate_btn) {
			t.setBase(Double.parseDouble(base_tf.getText()));
			t.setHeight(Double.parseDouble(height_tf.getText()));
			t.setSide1(Double.parseDouble(side1_tf.getText()));
			t.setSide2(Double.parseDouble(side2_tf.getText()));
			t.setSide3(Double.parseDouble(side3_tf.getText()));
			t.calculateArea();
			t.calculatePerimeter();
			area_tf.setText(Double.toString(t.getArea()));
			perimeter_tf.setText(Double.toString(t.getPerimeter()));
			t.insertDataIntoDatabase();
		} else if (e.getSource() == reset_btn) {
			// Reset fields
		} else {
			frame.dispose();
			MainForm mf = new MainForm();
		}
	}
}
