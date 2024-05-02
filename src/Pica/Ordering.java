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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Ordering extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField vards;
    private JTextField adrese;
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
        setTitle("The Path Of A Belevolent One");
        setBackground(Color.WHITE);
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

        vards = new JTextField();
        vards.setBounds(10, 132, 158, 20);
        contentPane.add(vards);
        vards.setColumns(10);

        adrese = new JTextField();
        adrese.setBounds(216, 132, 158, 20);
        contentPane.add(adrese);
        adrese.setColumns(10);

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

      
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = vards.getText().trim();
                String surname = adrese.getText().trim();

                
                if (!name.isEmpty() && !surname.isEmpty()) {
                 
                    Screen screen = new Screen();
                    screen.setVisible(true);
                    dispose(); 
                } else {
                    JOptionPane.showMessageDialog(Ordering.this, "Lūdzu, aizpildi visus lodziņus lai pasūtītu.");
                }
            }
        });

        // Pārbauda vai visas ailes ir aizpildītas
        vards.getDocument().addDocumentListener(new CustomDocumentListener());
        adrese.getDocument().addDocumentListener(new CustomDocumentListener());
    }

   
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
          
        }

        private void checkFields() {
            String name = vards.getText().trim();
            String street = adrese.getText().trim();

            //Poga darboas tikai tad ja ir izdarīti specifiski prasījumi
            btnNewButton.setEnabled(!name.isEmpty() && !street.isEmpty() && name.length() > 3 && street.length() > 3);
        }
    }
}
