

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

    private JPanel contentPane;
    private JPanel panelSplash;
    private JPanel panelCharacter;
    private JButton btnNextCharacter;
    private JButton btnPreviousCharacter;
    
    
    private final String[] names = {"images/bgSplash3.png",     // 0 - Splash screen background. http://pichost.me/1646676/
                                    "images/title.png"};               // 1 - http://textcraft.net/
    private Icon[] icon = {
        new ImageIcon(getClass().getResource(names[0])),
        new ImageIcon(getClass().getResource(names[1])),
    }; //end icon array
    private JTextField textName;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 683, 605);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));
        
        panelSplash = new JPanel();
        contentPane.add(panelSplash, "name_180325881387403");
        panelSplash.setLayout(null);
        
        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panelSplash.setVisible(false);
                panelCharacter.setVisible(true);
            }
        });
        btnStart.setIcon(new ImageIcon(Main.class.getResource("/images/start.png")));
        btnStart.setBounds(154, 304, 330, 106);
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
        
        JLabel lblBlackBox = new JLabel("");
        lblBlackBox.setIcon(new ImageIcon(Main.class.getResource("/images/hunter_stats.png")));
        lblBlackBox.setBackground(Color.BLACK);
        lblBlackBox.setBorder(null);
        lblBlackBox.setBounds(103, 232, 439, 231);
        panelCharacter.add(lblBlackBox);
        
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
        
        JLabel lblbackground2 = new JLabel("");
        lblbackground2.setIcon(new ImageIcon(Main.class.getResource("/images/background2.png")));
        lblbackground2.setBounds(0, 0, 657, 556);
        panelCharacter.add(lblbackground2);
        

    }
}
