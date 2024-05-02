package Pica;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

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
    	setBackground(Color.WHITE);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Screen.class.getResource("/Pica/pluh.jpg")));
    	setTitle("Crimson Moon Shines Bright");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 563, 577);
        setLocationRelativeTo(null);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Reset");
        mnNewMenu.add(mntmNewMenuItem);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
        mnNewMenu.add(mntmNewMenuItem_1);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(10, 11, 161, 14);
        contentPane.add(lblNewLabel);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(10, 36, 260, 22);
        contentPane.add(comboBox);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setBounds(10, 69, 161, 14);
        contentPane.add(lblNewLabel_1);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
        rdbtnNewRadioButton.setBounds(10, 90, 109, 23);
        contentPane.add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
        rdbtnNewRadioButton_1.setBounds(10, 116, 109, 23);
        contentPane.add(rdbtnNewRadioButton_1);
        
        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
        rdbtnNewRadioButton_2.setBounds(10, 142, 109, 23);
        contentPane.add(rdbtnNewRadioButton_2);
        
        JLabel lblNewLabel_1_1 = new JLabel("New label");
        lblNewLabel_1_1.setBounds(10, 172, 161, 14);
        contentPane.add(lblNewLabel_1_1);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
        chckbxNewCheckBox.setBounds(10, 193, 97, 23);
        contentPane.add(chckbxNewCheckBox);
        
        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
        chckbxNewCheckBox_1.setBounds(10, 219, 97, 23);
        contentPane.add(chckbxNewCheckBox_1);
        
        JCheckBox chckbxNewCheckBox_2 = new JCheckBox("New check box");
        chckbxNewCheckBox_2.setBounds(10, 245, 97, 23);
        contentPane.add(chckbxNewCheckBox_2);
        
        JCheckBox chckbxNewCheckBox_3 = new JCheckBox("New check box");
        chckbxNewCheckBox_3.setBounds(109, 193, 97, 23);
        contentPane.add(chckbxNewCheckBox_3);
        
        JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("New check box");
        chckbxNewCheckBox_1_1.setBounds(109, 219, 97, 23);
        contentPane.add(chckbxNewCheckBox_1_1);
        
        JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("New check box");
        chckbxNewCheckBox_2_1.setBounds(109, 245, 97, 23);
        contentPane.add(chckbxNewCheckBox_2_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("New label");
        lblNewLabel_1_1_1.setBounds(10, 275, 161, 14);
        contentPane.add(lblNewLabel_1_1_1);
        
        JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
        rdbtnNewRadioButton_3.setBounds(10, 296, 109, 23);
        contentPane.add(rdbtnNewRadioButton_3);
        
        JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("New radio button");
        rdbtnNewRadioButton_1_1.setBounds(10, 322, 109, 23);
        contentPane.add(rdbtnNewRadioButton_1_1);
        
        JRadioButton rdbtnNewRadioButton_2_1 = new JRadioButton("New radio button");
        rdbtnNewRadioButton_2_1.setBounds(10, 348, 109, 23);
        contentPane.add(rdbtnNewRadioButton_2_1);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("New label");
        lblNewLabel_1_1_1_1.setBounds(10, 378, 161, 14);
        contentPane.add(lblNewLabel_1_1_1_1);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(30, 403, 61, 23);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_2 = new JLabel("1");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(109, 407, 46, 14);
        contentPane.add(lblNewLabel_2);
        
        JButton btnNewButton_1 = new JButton("New button");
        btnNewButton_1.setBounds(165, 403, 61, 23);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton_1_1 = new JButton("New button");
        btnNewButton_1_1.setBounds(85, 458, 89, 23);
        contentPane.add(btnNewButton_1_1);
        
        JButton btnNewButton_1_1_1 = new JButton("New button");
        btnNewButton_1_1_1.setBounds(85, 492, 89, 23);
        contentPane.add(btnNewButton_1_1_1);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(Screen.class.getResource("/Pica/sāpes.png")));
        lblNewLabel_3.setBounds(342, 322, 200, 200);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(Screen.class.getResource("/Pica/maragrita.png")));
        lblNewLabel_4.setBounds(342, -25, 200, 200);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon(Screen.class.getResource("/Pica/siers.png")));
        lblNewLabel_5.setBounds(342, 142, 200, 200);
        contentPane.add(lblNewLabel_5);
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
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
