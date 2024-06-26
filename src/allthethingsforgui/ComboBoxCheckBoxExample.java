package allthethingsforgui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxCheckBoxExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Combo Box and Check Box Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Combo Box
        String[] options = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setSelectedIndex(0);

        // Check Box
        JCheckBox checkBox = new JCheckBox("Enable Feature");

        // Button
        JButton button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                boolean featureEnabled = checkBox.isSelected();

                JOptionPane.showMessageDialog(frame,
                        "Selected Option: " + selectedOption + "\nFeature Enabled: " + featureEnabled,
                        "Result",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Layout
        frame.setLayout(new GridLayout(4, 1));
        frame.add(comboBox);
        frame.add(checkBox);
        frame.add(button);

        frame.setVisible(true);
    }
}

