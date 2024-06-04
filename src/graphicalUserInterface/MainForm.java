package graphicalUserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainForm implements ActionListener{


	JFrame frame;
	JButton Circle_btn=new JButton("Circle");
	JButton rectangle_btn=new JButton("Rectangle");
	JButton Triangle_btn=new JButton("Triangle");
	JButton Square_btn=new JButton("Square");
	JButton Rhombus_btn=new JButton("Rhombus");
	JButton Parallelogram_btn=new JButton("Parallelogram");

	public MainForm() {
		createWindow();
		setsizandlocation();
		addcomponentOnFrame();
		addactionEvent();

	}
	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("My 2D shapes");
		frame.setBounds(20,20,400,300);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	private void setsizandlocation() {
		Circle_btn.setBounds(20, 20, 150, 50);
		rectangle_btn.setBounds(200, 20, 150, 50);
		Triangle_btn.setBounds(20, 100, 150, 50);
		Square_btn.setBounds(20, 180, 150, 50);
		Rhombus_btn.setBounds(200, 100, 150, 50);
		Parallelogram_btn.setBounds(200, 180, 150, 50);

	}
	private void addcomponentOnFrame() {
		frame.add(Circle_btn);
		frame.add(rectangle_btn);
		frame.add(Triangle_btn);
		frame.add(Square_btn);
		frame.add(Rhombus_btn);
		frame.add(Parallelogram_btn);


	}
	private void addactionEvent() {
		Circle_btn.addActionListener(this);
		rectangle_btn.addActionListener(this);
		Triangle_btn.addActionListener(this);
		Square_btn.addActionListener(this);
		Rhombus_btn.addActionListener(this);
		Parallelogram_btn.addActionListener(this);


	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//MainForm mf=new MainForm();
		if(e.getSource()==Circle_btn) {
			CircleForm circle=new CircleForm();
			frame.dispose();
		}else if(e.getSource()==rectangle_btn) {
			RectangleForm rf=new RectangleForm();
			frame.dispose();
		}else if(e.getSource()==Triangle_btn) {
			TriangleForm tr=new TriangleForm();
			frame.dispose();
		}
		else if(e.getSource()==Rhombus_btn) {
			RhombusForm rf=new RhombusForm();
			frame.dispose();
		}else {
			ParallelogramForm pf=new ParallelogramForm();
			frame.dispose();
		}

	}
	public static void main(String[] args) {
		MainForm mf=new MainForm();
	}
}
