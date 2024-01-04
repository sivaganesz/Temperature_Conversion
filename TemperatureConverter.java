import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter {
    private JFrame frame;
    private JTextField valueField;
    private JRadioButton celsiusToRadioButton, fahrenheitToRadioButton;
    private JButton convertButton, clearButton;

    public TemperatureConverter() {
        frame = new JFrame("Celsius to Fahrenheit Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLayout(null);

        JLabel valueLabel = new JLabel("Enter Value  :");
        valueLabel.setBounds(60,65,100,25);

        valueField = new JTextField(10);
        valueField.setBounds(180,65,100,25);


        celsiusToRadioButton = new JRadioButton("Celsius to Fahrenheit");
        celsiusToRadioButton.setBounds(50,170,190,25);
        fahrenheitToRadioButton = new JRadioButton("Fahrenheit to Celsius");
        fahrenheitToRadioButton.setBounds(50,120,190,25);
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(celsiusToRadioButton);
        radioButtonGroup.add(fahrenheitToRadioButton);

        convertButton = new JButton("Convert");
        convertButton.setBounds(80,230,90,25);
        clearButton = new JButton("Clear");
        clearButton.setBounds(200,230,90,25);

        frame.add(valueLabel);
        frame.add(valueField);
        frame.add(celsiusToRadioButton);
        frame.add(fahrenheitToRadioButton);
        frame.add(convertButton);
        frame.add(clearButton);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        frame.setVisible(true);
    }

   private void convert() {
    try {
        double inputValue = Double.parseDouble(valueField.getText());
        double result;

        if (celsiusToRadioButton.isSelected()) {
            result = (inputValue * 9 / 5) + 32;
        } else if (fahrenheitToRadioButton.isSelected()) {
            result = (inputValue - 32) * 5 / 9;
        } else {

            JOptionPane.showMessageDialog(frame, "Please select a conversion type (Celsius to Fahrenheit or Fahrenheit to Celsius).");
            return;
        }

        JOptionPane.showMessageDialog(frame, "Result: " + result);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.");
    }
}


   private void clearFields() {
        valueField.setText("");
        celsiusToRadioButton.setSelected(false);
        fahrenheitToRadioButton.setSelected(false);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TemperatureConverter();
            }
        });
    }
}
