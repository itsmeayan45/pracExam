import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeGUI extends JFrame implements ActionListener {

    JButton btn;
    JLabel lbl;

    DateTimeGUI() {

        // Frame settings
        setTitle("Date & Time Display");
        setSize(400, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        btn = new JButton("Show Date & Time");
        lbl = new JLabel("Click the button to see date & time");

        // Add components
        add(btn);
        add(lbl);

        // Register listener
        btn.addActionListener(this);

        setVisible(true);
    }

    // Event handling
    public void actionPerformed(ActionEvent e) {

        // Get current date & time
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        lbl.setText(now.format(format));
    }

    // Main method
    public static void main(String[] args) {
        new DateTimeGUI();
    }
}
