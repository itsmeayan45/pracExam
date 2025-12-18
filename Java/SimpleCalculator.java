import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {

    JTextField t1, t2, tResult;
    JButton add, sub, mul, div, mod;

    SimpleCalculator() {

        // Frame settings
        setTitle("Simple Calculator");
        setSize(350, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Components
        t1 = new JTextField();
        t2 = new JTextField();
        tResult = new JTextField();
        tResult.setEditable(false);

        add = new JButton("Add (+)");
        sub = new JButton("Subtract (-)");
        mul = new JButton("Multiply (*)");
        div = new JButton("Divide (/)");
        mod = new JButton("Modulus (%)");

        // Add components to frame
        add(new JLabel("Enter First Number:"));
        add(t1);

        add(new JLabel("Enter Second Number:"));
        add(t2);

        add(add);
        add(sub);

        add(mul);
        add(div);

        add(mod);
        add(new JLabel("Result:"));

        add(tResult);

        // Add action listeners
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        mod.addActionListener(this);

        setVisible(true);
    }

    // Event handling
    public void actionPerformed(ActionEvent e) {

        try {
            double num1 = Double.parseDouble(t1.getText());
            double num2 = Double.parseDouble(t2.getText());
            double result = 0;

            if (e.getSource() == add)
                result = num1 + num2;
            else if (e.getSource() == sub)
                result = num1 - num2;
            else if (e.getSource() == mul)
                result = num1 * num2;
            else if (e.getSource() == div)
                result = num1 / num2;
            else if (e.getSource() == mod)
                result = num1 % num2;

            tResult.setText(String.valueOf(result));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid Input!");
        }
    }

    // Main method
    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
