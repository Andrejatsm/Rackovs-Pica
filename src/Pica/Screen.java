package Pica;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Screen extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String name;
    private String street;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Screen frame = new Screen();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Screen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
    }

    /**
     * Create the frame with provided name and street information.
     */
    public Screen(String name, String street) {
        this(); // Call default constructor to set up the frame
        this.name = name;
        this.street = street;
    }

    // Geteri prieks varda un adreses
    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }
}
