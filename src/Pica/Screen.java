package Pica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class Screen extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> garsa;
    private JRadioButton maza;
    private JRadioButton videja;
    private JRadioButton liela;
    private JCheckBox exSiers;
    private JCheckBox exMerce;
    private JCheckBox exPiedev;
    private JCheckBox exPepsi;
    private JCheckBox exFanta;
    private JCheckBox exSprite;
    private String[] Garsa = {"Kebaba", "Margarita", "Pepperoni", "Siera", "Studentu"};
    private JLabel MazaCena;
    private JLabel VidejaCena;
    private JLabel LielaCena;
    private double addOnPrice = 0.00;
    private JLabel lblDaudz;
    private int qty = 1;
    private JRadioButton rdoPiegad;
    private JRadioButton rdoPats;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final ButtonGroup buttonGroup_1 = new ButtonGroup();
    private JTextArea textArea;
    private double Kopa;
    
    
    static void saglabat(String textArea) {
        try {
            FileWriter fw = new FileWriter("Ceks.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(textArea);
            pw.close();
            JOptionPane.showMessageDialog(null, "Ceks saglabāts failā Ceks.txt", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Radās kļūda saglabājot failā! ", "Kļūda", JOptionPane.ERROR_MESSAGE);
        }
    }

    static String nolasit() {
        StringBuilder content = new StringBuilder();
        try {
            FileReader fr = new FileReader("Ceks.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Kļūda nolasot failu!", "Kļūda", JOptionPane.ERROR_MESSAGE);
        }
        return content.toString();
    
    }
    
    
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
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                loadGarsas();
            }
        });
        setBackground(Color.WHITE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Screen.class.getResource("/Pica/pluh.jpg")));
        setTitle("Crimson Moon Shines Bright");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1017, 577);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("Reset");
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textArea.setText(null);
            	Kopa = 0;
            	addOnPrice = 0;
        	}
        });
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        mnNewMenu.add(mntmNewMenuItem_1);

        contentPane = new JPanel();
        contentPane.setBackground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textArea = new JTextArea(); 
        textArea.setBounds(541, 23, 439, 482);
        contentPane.add(textArea); 
        
        JLabel lblNewLabel = new JLabel("Picas Veids:");
        lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        lblNewLabel.setBackground(Color.LIGHT_GRAY);
        lblNewLabel.setBounds(10, 11, 161, 22);
        contentPane.add(lblNewLabel);
        
        garsa = new JComboBox<>();
        garsa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPrice();
            }
        });
        garsa.setBounds(10, 36, 260, 22);
        contentPane.add(garsa);

        JLabel sad = new JLabel("Izmērs/Cena:");
        sad.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        sad.setBackground(Color.LIGHT_GRAY);
        sad.setBounds(10, 69, 161, 22);
        contentPane.add(sad);

        maza = new JRadioButton("Mazā - 20cm");
        buttonGroup.add(maza);
        maza.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        maza.setBackground(Color.LIGHT_GRAY);
        maza.setBounds(10, 90, 109, 23);
        contentPane.add(maza);

        videja = new JRadioButton("Vidējā - 30cm");
        buttonGroup.add(videja);
        videja.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        videja.setBackground(Color.LIGHT_GRAY);
        videja.setBounds(10, 116, 109, 23);
        contentPane.add(videja);

        liela = new JRadioButton("Lielā - 30.5cm");
        buttonGroup.add(liela);
        liela.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        liela.setBackground(Color.LIGHT_GRAY);
        liela.setBounds(10, 142, 109, 23);
        contentPane.add(liela);

        JLabel lblNewLabel_1 = new JLabel("Piedevas:");
        lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
        lblNewLabel_1.setBounds(10, 172, 161, 23);
        contentPane.add(lblNewLabel_1);

        exSiers = new JCheckBox("Extra Siers - 1,30");
        exSiers.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        exSiers.setBackground(Color.LIGHT_GRAY);
        exSiers.setBounds(10, 193, 142, 23);
        contentPane.add(exSiers);

        exMerce = new JCheckBox("Extra Mērce - 1,00");
        exMerce.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        exMerce.setBackground(Color.LIGHT_GRAY);
        exMerce.setBounds(10, 219, 142, 23);
        contentPane.add(exMerce);

        exPiedev = new JCheckBox("Extra Piedevas - 1,50");
        exPiedev.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        exPiedev.setBackground(Color.LIGHT_GRAY);
        exPiedev.setBounds(10, 245, 142, 23);
        contentPane.add(exPiedev);

        exPepsi = new JCheckBox("Pepsi 1L - 1.80");
        exPepsi.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        exPepsi.setBackground(Color.LIGHT_GRAY);
        exPepsi.setBounds(168, 193, 120, 23);
        contentPane.add(exPepsi);

        exFanta = new JCheckBox("Fanta 1L - 1.80");
        exFanta.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        exFanta.setBackground(Color.LIGHT_GRAY);
        exFanta.setBounds(168, 219, 120, 23);
        contentPane.add(exFanta);

        exSprite = new JCheckBox("Sprite 1L - 1.80");
        exSprite.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        exSprite.setBackground(Color.LIGHT_GRAY);
        exSprite.setBounds(168, 245, 120, 23);
        contentPane.add(exSprite);

        JLabel lblNewLabel_1_1_1 = new JLabel("Izvēlies:");
        lblNewLabel_1_1_1.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        lblNewLabel_1_1_1.setBackground(Color.LIGHT_GRAY);
        lblNewLabel_1_1_1.setBounds(10, 275, 161, 22);
        contentPane.add(lblNewLabel_1_1_1);

        rdoPiegad = new JRadioButton("Piegāde");
        buttonGroup_1.add(rdoPiegad);
        rdoPiegad.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        rdoPiegad.setBackground(Color.LIGHT_GRAY);
        rdoPiegad.setBounds(10, 296, 109, 23);
        contentPane.add(rdoPiegad);

        rdoPats = new JRadioButton("Savākšu Pats");
        buttonGroup_1.add(rdoPats);
        rdoPats.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        rdoPats.setBackground(Color.LIGHT_GRAY);
        rdoPats.setBounds(10, 322, 109, 23);
        contentPane.add(rdoPats);


        ItemListener radioItemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getItem() == rdoPiegad) {
  
                        rdoPats.setSelected(false);
                    } else if (e.getItem() == rdoPats) {

                        rdoPiegad.setSelected(false);
                    }
                }
            }
        };

        // Add the ItemListener to both radio buttons
        rdoPiegad.addItemListener(radioItemListener);
        rdoPats.addItemListener(radioItemListener);

        JLabel sss = new JLabel("Daudzums:");
        sss.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        sss.setBackground(Color.LIGHT_GRAY);
        sss.setBounds(10, 352, 161, 22);
        contentPane.add(sss);

        JButton btnNewButton = new JButton("-");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                qty--;
                lblDaudz.setText(String.valueOf(qty));
            }
        });
        btnNewButton.setBackground(Color.RED);
        btnNewButton.setBounds(20, 377, 61, 23);
        contentPane.add(btnNewButton);

        
        lblDaudz = new JLabel("1"); 
        lblDaudz.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDaudz.setHorizontalAlignment(SwingConstants.CENTER);
        lblDaudz.setBounds(91, 377, 46, 23);
        contentPane.add(lblDaudz);

        JButton btnNewButton_1 = new JButton("+");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		qty++;
        		lblDaudz.setText(String.valueOf(qty));
        	}
        });
        btnNewButton_1.setBackground(Color.GREEN);
        btnNewButton_1.setBounds(147, 377, 61, 23);
        contentPane.add(btnNewButton_1);

        JButton btnBill = new JButton("Apstiprināt");
        btnBill.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        btnBill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	showPasutijumaDetalas();
            }
        });
        btnBill.setBounds(70, 411, 101, 23);
        contentPane.add(btnBill);

        JButton btnAgain = new JButton("Dzēst Izvelni");
        btnAgain.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		sutaAtkal();
        	}
        });
        btnAgain.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        btnAgain.setBounds(70, 445, 101, 23);
        contentPane.add(btnAgain);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(Screen.class.getResource("/Pica/sāpes.png")));
        lblNewLabel_3.setBounds(342, 322, 200, 200);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(Screen.class.getResource("/Pica/maragrita.png")));
        lblNewLabel_4.setBounds(342, 11, 200, 164);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon(Screen.class.getResource("/Pica/siers.png")));
        lblNewLabel_5.setBounds(342, 142, 200, 200);
        contentPane.add(lblNewLabel_5);

        MazaCena = new JLabel("");
        MazaCena.setHorizontalAlignment(SwingConstants.CENTER);
        MazaCena.setBounds(168, 91, 83, 22);
        contentPane.add(MazaCena);

        VidejaCena = new JLabel("");
        VidejaCena.setHorizontalAlignment(SwingConstants.CENTER);
        VidejaCena.setBounds(168, 117, 83, 22);
        contentPane.add(VidejaCena);

        LielaCena = new JLabel("");
        LielaCena.setHorizontalAlignment(SwingConstants.CENTER);
        LielaCena.setBounds(168, 143, 83, 22);
        contentPane.add(LielaCena);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(541, 23, 439, 482);
        contentPane.add(textArea);
        
        JLabel lblCeks = new JLabel("Ceks:");
        lblCeks.setFont(new Font("Sylfaen", Font.PLAIN, 13));
        lblCeks.setBackground(Color.LIGHT_GRAY);
        lblCeks.setBounds(541, 0, 161, 22);
        contentPane.add(lblCeks);
    }

    private void loadGarsas() {
        for (String garsaName : Garsa) {
            garsa.addItem(garsaName);
        }
    }

    private void showPrice() {
        if (garsa.getSelectedIndex() == 0) {
            MazaCena.setText("5,60");
            VidejaCena.setText("6,60");
            LielaCena.setText("7,60");
        } else if (garsa.getSelectedIndex() == 1) {
            MazaCena.setText("6,80");
            VidejaCena.setText("7,80");
            LielaCena.setText("8,80");
        } else if (garsa.getSelectedIndex() == 2) {
            MazaCena.setText("4,80");
            VidejaCena.setText("5,80");
            LielaCena.setText("6,80");
        } else if (garsa.getSelectedIndex() == 3) {
            MazaCena.setText("9,40");
            VidejaCena.setText("10,40");
            LielaCena.setText("11,40");
        } else if (garsa.getSelectedIndex() == 4) {
            MazaCena.setText("4,20");
            VidejaCena.setText("5,20");
            LielaCena.setText("6,20");
        } else {
            MazaCena.setText("6,30");
            VidejaCena.setText("7,30");
            LielaCena.setText("8,30");
        }
    }
    private String addOnPrice() {
    	String addOns = "";
    	
    	if(exSiers.isSelected())
    	{
    		addOnPrice += 1.30;
    		addOns = addOns + "\n\t" + exSiers.getText() + "\t\t" + "1.30";
    	}
    	if(exMerce.isSelected())
    	{
    		addOnPrice += 1.00;
    		addOns = addOns + "\n\t" + exMerce.getText() + "\t\t" + "1.00";
    	}
    	if(exPiedev.isSelected())
    	{
    		addOnPrice += 1.50;
    		addOns = addOns + "\n\t" + exPiedev.getText() + "\t\t" + "1.50";
    	}
    	if(exPepsi.isSelected())
    	{
    		addOnPrice += 1.80;
    		addOns = addOns + "\n\t" + exPepsi.getText() + "\t\t" + "1.80";
    	}
    	if(exFanta.isSelected())
    	{
    		addOnPrice += 1.80;
    		addOns = addOns + "\n\t" + exFanta.getText() + "\t\t" + "1.80";
    	}
    	if(exSprite.isSelected())
    	{
    		addOnPrice += 1.80;
    		addOns = addOns + "\n\t" + exSprite.getText() + "\t\t" + "1.80";
    	}
    	
    	return addOns;
    }
    private String lielumsPica() {
    
    	String size = "";
    	if(maza.isSelected())
    		size = maza.getText();
    	else if (videja.isSelected())
    		size = videja.getText();
    	else
    		size = liela.getText();
    	
		return size;
    }
    private double cenaPica() {
        double picaCena = 0;
        String priceText = "";
        if(maza.isSelected()) {
            priceText = MazaCena.getText();
        } else if (videja.isSelected()) {
            priceText = VidejaCena.getText();
        } else {
            priceText = LielaCena.getText();
        }
        
        // Maina komatu uz punktu lai darbotos
        priceText = priceText.replace(',', '.');
        
        picaCena = Double.parseDouble(priceText);
        return picaCena;
    }
    private String servicaMetode() {
    String serviss = "";
    if(rdoPiegad.isSelected())
    	serviss = "Piegade";
    else if(rdoPats.isSelected())
    	serviss = "Savaksu pats";
    return serviss;
    }
    private double servicaCena() {
    	double servicaCena = 0;
    	if(rdoPiegad.isSelected())
    		servicaCena = 1.40;
    	else if(rdoPats.isSelected())
		servicaCena = 0.00;
    	
    	return servicaCena;
    }
    private double Cena() {
        double Cena = 0;
        
        Cena = addOnPrice + cenaPica() + servicaCena();
        
        return Cena;
    }
    
    private void sutaAtkal() {
    	textArea.setText(null);
    	Kopa = 0;
    	addOnPrice = 0;
    }
    private void showPasutijumaDetalas() {
        double Kopa = 0;
        int daudzums = Integer.parseInt(lblDaudz.getText());
        Kopa = Cena() * daudzums;
        
        DecimalFormat df = new DecimalFormat("#.##");
        String roundedKopa = df.format(Kopa);

        
        if (textArea != null) {
            textArea.setText("\nGarša: \t" +garsa.getSelectedItem()+ "\n\nLielums: \t" + lielumsPica() + "\n\nCena: \t\t" + cenaPica() + "\n\nPiedevas: \t" + addOnPrice() +
                "\n\nServiss: \t" + servicaMetode() + "\n\nDaudzums: \t\t" + "x" + daudzums+ "\n\n*******************************************************************************************************"
                + "\n\nCena Kopa: \t\t" + roundedKopa + "Eiro");
        }
    }
}
