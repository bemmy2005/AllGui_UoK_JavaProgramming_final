package graphicalUserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RectangleForm implements ActionListener {
    JFrame frame;
    JLabel length_lb = new JLabel("Length");
    JLabel width_lb = new JLabel("Width");
    JLabel area_lb = new JLabel("Area");
    JLabel perimeter_lb = new JLabel("Perimeter");
    JTextField length_tf = new JTextField("");
    JTextField width_tf = new JTextField("");
    JTextField area_tf = new JTextField("");
    JTextField perimeter_tf = new JTextField();
    JButton calculate_btn = new JButton("Calculate");
    JButton reset_btn = new JButton("Reset");
    JButton back_btn = new JButton("Back");

    public RectangleForm() {
        create_window();
        set_location_size();
        addcomponents();
        addActionEvent();
    }

    private void create_window() {
        frame = new JFrame();
        frame.setTitle("Rectangle");
        frame.setBounds(20, 20, 400, 300);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void set_location_size() {
        length_lb.setBounds(20, 20, 100, 30);
        width_lb.setBounds(20, 60, 100, 30);
        area_lb.setBounds(20, 120, 100, 30);
        perimeter_lb.setBounds(20, 180, 100, 30);
        length_tf.setBounds(200, 20, 100, 30);
        width_tf.setBounds(200, 60, 100, 30);
        area_tf.setBounds(200, 120, 100, 30);
        perimeter_tf.setBounds(200, 180, 100, 30);
        calculate_btn.setBounds(20, 220, 100, 30);
        reset_btn.setBounds(120, 220, 100, 30);
        back_btn.setBounds(220, 220, 100, 30);
    }

    private void addcomponents() {
        frame.add(length_lb);
        frame.add(width_lb);
        frame.add(area_lb);
        frame.add(perimeter_lb);
        frame.add(length_tf);
        frame.add(width_tf);
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
        Rectangle r = new Rectangle(0, 0);
        if (e.getSource() == calculate_btn) {
            r.setLength(Double.parseDouble(length_tf.getText()));
            r.setWidth(Double.parseDouble(width_tf.getText()));
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
