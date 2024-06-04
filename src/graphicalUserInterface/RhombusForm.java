package graphicalUserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RhombusForm implements ActionListener {
    JFrame frame;
    JLabel diagonal1_lb = new JLabel("Diagonal 1");
    JLabel diagonal2_lb = new JLabel("Diagonal 2");
    JLabel side_lb = new JLabel("Side");
    JLabel area_lb = new JLabel("Area");
    JLabel perimeter_lb = new JLabel("Perimeter");
    JTextField diagonal1_tf = new JTextField("");
    JTextField diagonal2_tf = new JTextField("");
    JTextField side_tf = new JTextField("");
    JTextField area_tf = new JTextField("");
    JTextField perimeter_tf = new JTextField();
    JButton calculate_btn = new JButton("Calculate");
    JButton reset_btn = new JButton("Reset");
    JButton back_btn = new JButton("Back");

    public RhombusForm() {
        create_window();
        set_location_size();
        addcomponents();
        addActionEvent();
    }

    private void create_window() {
        frame = new JFrame();
        frame.setTitle("Rhombus");
        frame.setBounds(20, 20, 400, 350);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void set_location_size() {
        diagonal1_lb.setBounds(20, 20, 100, 30);
        diagonal2_lb.setBounds(20, 60, 100, 30);
        side_lb.setBounds(20, 100, 100, 30);
        area_lb.setBounds(20, 160, 100, 30);
        perimeter_lb.setBounds(20, 220, 100, 30);
        diagonal1_tf.setBounds(200, 20, 100, 30);
        diagonal2_tf.setBounds(200, 60, 100, 30);
        side_tf.setBounds(200, 100, 100, 30);
        area_tf.setBounds(200, 160, 100, 30);
        perimeter_tf.setBounds(200, 220, 100, 30);
        calculate_btn.setBounds(20, 280, 100, 30);
        reset_btn.setBounds(120, 280, 100, 30);
        back_btn.setBounds(220, 280, 100, 30);
    }

    private void addcomponents() {
        frame.add(diagonal1_lb);
        frame.add(diagonal2_lb);
        frame.add(side_lb);
        frame.add(area_lb);
        frame.add(perimeter_lb);
        frame.add(diagonal1_tf);
        frame.add(diagonal2_tf);
        frame.add(side_tf);
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
        Rhombus r = new Rhombus(0, 0, 0);
        if (e.getSource() == calculate_btn) {
            r.setDiagonal1(Double.parseDouble(diagonal1_tf.getText()));
            r.setDiagonal2(Double.parseDouble(diagonal2_tf.getText()));
            r.setSide(Double.parseDouble(side_tf.getText()));
            r.calculateArea();
            r.calculatePerimeter();
            area_tf.setText(Double.toString(r.getArea()));
            perimeter_tf.setText(Double.toString(r.getPerimeter()));
            r.insertDataIntoDatabase();
        } else if (e.getSource() == reset_btn) {
            // Reset fields
        } else {
            frame.dispose();
            MainForm mf = new MainForm();
        }
    }
}
