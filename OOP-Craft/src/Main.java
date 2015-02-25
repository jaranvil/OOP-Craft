

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

    //properties
    private JPanel contentPane;
    private JPanel panelSplash;
    private JPanel panelCharacter;
    private JButton btnNextCharacter;
    private JButton btnPreviousCharacter;
    private JLabel lblCharacterStats;
    private JTextField textName;
    
    private int characterStatsArrayIndex = 0;
    
    //icon arrays
    private final String[] names = {"images/bgSplash3.png",     // 0 - Splash screen background. http://pichost.me/1646676/
                                    "images/title.png"};               // 1 - http://textcraft.net/
    private Icon[] icon = {
        new ImageIcon(getClass().getResource(names[0])),
        new ImageIcon(getClass().getResource(names[1])),
    }; //end icon array
    
    
    private final String[] characterStatImages = {"images/hunter_stats.png",     
                                                "images/mage_stats.png"};          
    private Icon[] characterStats = {
        new ImageIcon(getClass().getResource(characterStatImages[0])),
        new ImageIcon(getClass().getResource(characterStatImages[1])),
    }; //end icon array
    private JButton btnSelectCharacter;
    private JButton btnCancel;
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * 
     */
    public Main() {
        setTitle("OOPCraft");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 669, 599);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));
        
        panelSplash = new JPanel();
        contentPane.add(panelSplash, "name_180325881387403");
        panelSplash.setLayout(null);
        
        JButton btnStart = new JButton("");
        btnStart.setContentAreaFilled(false);
        btnStart.setBorderPainted(false);
        btnStart.setOpaque(false);
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panelSplash.setVisible(false);
                panelCharacter.setVisible(true);
            }
        });
        btnStart.setIcon(new ImageIcon(Main.class.getResource("/images/start_game.png")));
        btnStart.setBounds(95, 260, 461, 49);
        panelSplash.add(btnStart);
        
        JLabel lblTitle = new JLabel("");
        lblTitle.setBounds(10, 56, 625, 111);
        panelSplash.add(lblTitle);
        lblTitle.setIcon(icon[1]);
        
        JLabel lblbackground = new JLabel("");
        lblbackground.setBounds(0, 0, 650, 560);
        panelSplash.add(lblbackground);
        lblbackground.setIcon(icon[0]);
        
        panelCharacter = new JPanel();
        contentPane.add(panelCharacter, "name_182023997481703");
        panelCharacter.setLayout(null);
        
        lblCharacterStats = new JLabel("");
        lblCharacterStats.setIcon(characterStats[characterStatsArrayIndex]);
        lblCharacterStats.setBackground(Color.BLACK);
        lblCharacterStats.setBorder(null);
        lblCharacterStats.setBounds(103, 232, 439, 231);
        panelCharacter.add(lblCharacterStats);
        
        JLabel lblEnterName = new JLabel("Enter Name:");
        lblEnterName.setForeground(Color.WHITE);
        lblEnterName.setFont(new Font("Algerian", Font.PLAIN, 23));
        lblEnterName.setBounds(61, 167, 205, 35);
        panelCharacter.add(lblEnterName);
        
        JLabel lblSelectYourCharacter = new JLabel("Select Your Character");
        lblSelectYourCharacter.setForeground(Color.WHITE);
        lblSelectYourCharacter.setFont(new Font("Algerian", Font.PLAIN, 30));
        lblSelectYourCharacter.setBounds(10, 121, 392, 35);
        panelCharacter.add(lblSelectYourCharacter);
        
        textName = new JTextField();
        textName.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textName.setBackground(Color.LIGHT_GRAY);
        textName.setBounds(223, 172, 275, 26);
        panelCharacter.add(textName);
        textName.setColumns(10);
        
        btnNextCharacter = new JButton("");
        btnNextCharacter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchCharacter(true);
            }
        });
        btnNextCharacter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                btnNextCharacter.setIcon(new ImageIcon(Main.class.getResource("/images/arrow_big.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnNextCharacter.setIcon(new ImageIcon(Main.class.getResource("/images/arrow.png")));
            }
        });
        btnNextCharacter.setBorderPainted(false);
        btnNextCharacter.setContentAreaFilled(false);
        btnNextCharacter.setOpaque(false);
        btnNextCharacter.setIcon(new ImageIcon(Main.class.getResource("/images/arrow.png")));
        btnNextCharacter.setBounds(538, 290, 83, 87);
        panelCharacter.add(btnNextCharacter);
        
        btnPreviousCharacter = new JButton("");
        btnPreviousCharacter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchCharacter(false);
            }
        });
        btnPreviousCharacter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnPreviousCharacter.setIcon(new ImageIcon(Main.class.getResource("/images/left_arrow_big.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnPreviousCharacter.setIcon(new ImageIcon(Main.class.getResource("/images/left_arrow.png")));
            }
        });
        btnPreviousCharacter.setIcon(new ImageIcon(Main.class.getResource("/images/left_arrow.png")));
        btnPreviousCharacter.setOpaque(false);
        btnPreviousCharacter.setContentAreaFilled(false);
        btnPreviousCharacter.setBorderPainted(false);
        btnPreviousCharacter.setBounds(10, 290, 83, 87);
        panelCharacter.add(btnPreviousCharacter);
        
        btnSelectCharacter = new JButton("");
        btnSelectCharacter.setIcon(new ImageIcon(Main.class.getResource("/images/select_button.png")));
        btnSelectCharacter.setOpaque(false);
        btnSelectCharacter.setContentAreaFilled(false);
        btnSelectCharacter.setBorderPainted(false);
        btnSelectCharacter.setBounds(375, 474, 199, 59);
        panelCharacter.add(btnSelectCharacter);
        
        btnCancel = new JButton("");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelSplash.setVisible(true);
                panelCharacter.setVisible(false);
            }
        });
        btnCancel.setIcon(new ImageIcon(Main.class.getResource("/images/cancel_button.png")));
        btnCancel.setOpaque(false);
        btnCancel.setBorderPainted(false);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setBounds(76, 474, 199, 59);
        panelCharacter.add(btnCancel);
        
        JLabel lblbackground2 = new JLabel("");
        lblbackground2.setIcon(new ImageIcon(Main.class.getResource("/images/background2.png")));
        lblbackground2.setBounds(0, 0, 657, 556);
        panelCharacter.add(lblbackground2);
        

    }//end constructor
    
    
    //select character panel
    
    public void switchCharacter(boolean next)
    {
        if(next)
        {
            if(characterStatsArrayIndex == characterStats.length-1)
                characterStatsArrayIndex = 0;
            else
                characterStatsArrayIndex++;
                    
            lblCharacterStats.setIcon(characterStats[characterStatsArrayIndex]);
        } else {
            if(characterStatsArrayIndex == 0)
                characterStatsArrayIndex = characterStats.length-1;
            else
                characterStatsArrayIndex--;
            
            lblCharacterStats.setIcon(characterStats[characterStatsArrayIndex]);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
