import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddTwoNumbers extends JFrame implements ActionListener {

    JTextField t1, t2, tResult;
    JButton btnAdd;

    AddTwoNumbers() {

        // Frame settings
        setTitle("Add Two Numbers");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        t1 = new JTextField();
        t2 = new JTextField();
        tResult = new JTextField();
        tResult.setEditable(false);

        btnAdd = new JButton("Add");

        // Add components
        add(new JLabel("First Number:"));
        add(t1);

        add(new JLabel("Second Number:"));
        add(t2);

        add(new JLabel("Result:"));
        add(tResult);

        add(btnAdd);

        // Add action listener
        btnAdd.addActionListener(this);

        setVisible(true);
    }

    // Event handling
    public void actionPerformed(ActionEvent e) {

        try {
            int num1 = Integer.parseInt(t1.getText());
            int num2 = Integer.parseInt(t2.getText());

            int sum = num1 + num2;

            tResult.setText(String.valueOf(sum));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        }
    }

    // Main method
    public static void main(String[] args) {
        new AddTwoNumbers();
    }
}
