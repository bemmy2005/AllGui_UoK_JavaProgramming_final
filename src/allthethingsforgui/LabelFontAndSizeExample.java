package allthethingsforgui;

import javax.swing.*;
import java.awt.*;

public class LabelFontAndSizeExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Label Font and Size Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label
        JLabel label = new JLabel("Hello, Swing!");

        // Set font
        Font font = new Font("Arial", Font.BOLD, 16);
        label.setFont(font);

        // Set size
        label.setSize(new Dimension(200, 30));

        // Add label to the frame
        frame.add(label);

        frame.setVisible(true);
    }
}

