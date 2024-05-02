package Pica;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Ordering extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtDad;
    private JTextField textField_1;
    private JButton btnNewButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ordering frame = new Ordering();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Ordering() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Ordering.class.getResource("/Pica/pluh.jpg")));
        setTitle("Ekrans");
        setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 410, 281);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Vārds, Uzvārds:");
        lblNewLabel.setBounds(10, 107, 158, 14);
        contentPane.add(lblNewLabel);

        txtDad = new JTextField();
        txtDad.setBounds(10, 132, 158, 20);
        contentPane.add(txtDad);
        txtDad.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(216, 132, 158, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Adrese:");
        lblNewLabel_1.setBounds(216, 107, 158, 14);
        contentPane.add(lblNewLabel_1);

        btnNewButton = new JButton("Turpināt");
        btnNewButton.setIcon(null);
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setBounds(147, 169, 89, 23);
        contentPane.add(btnNewButton);
        btnNewButton.setEnabled(false);

        JLabel lblNewLabel_3 = new JLabel("Fæh pizzeria");
        lblNewLabel_3.setForeground(new Color(255, 0, 0));
        lblNewLabel_3.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
        lblNewLabel_3.setIcon(new ImageIcon(Ordering.class.getResource("/Pica/png-clipart-pizza-pizza-removebg-preview (1).png")));
        lblNewLabel_3.setBounds(26, 0, 348, 96);
        contentPane.add(lblNewLabel_3);

        // Add ActionListener to the button
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtDad.getText().trim();
                String surname = textField_1.getText().trim();

                // Check if name and surname fields are not empty
                if (!name.isEmpty() && !surname.isEmpty()) {
                    // Open the Screen frame
                    Screen screen = new Screen();
                    screen.setVisible(true);
                    dispose(); // Close the current frame
                } else {
                    // Display a message or perform other actions if fields are empty
                    // For example:
                    // JOptionPane.showMessageDialog(Ordering.this, "Please fill in all fields.");
                }
            }
        });

        // Add a listener to check if all fields are filled
        txtDad.getDocument().addDocumentListener(new CustomDocumentListener());
        textField_1.getDocument().addDocumentListener(new CustomDocumentListener());
    }

    // Custom Document Listener to handle text field changes
    private class CustomDocumentListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            checkFields();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            checkFields();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // Plain text components don't fire these events
        }

        private void checkFields() {
            String name = txtDad.getText().trim();
            String surname = textField_1.getText().trim();

            // Enable the button only if name and surname fields are not empty
            btnNewButton.setEnabled(!name.isEmpty() && !surname.isEmpty());
        }
    }
}
