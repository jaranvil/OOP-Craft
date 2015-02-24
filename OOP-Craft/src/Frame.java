import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.*;


public class Frame extends JFrame {

    private JPanel contentPane;
    private  JLabel lblBackground;
    
    private final String[] names = {"images/bgSplash.jpg"};
    private Icon[] icon = {
            new ImageIcon(getClass().getResource(names[0])),
    }; //end icon array

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Frame frame = new Frame();
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
    public Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1030, 754);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));
        
        JPanel pannelSplash = new JPanel();
        contentPane.add(pannelSplash, "name_176391379087577");
        pannelSplash.setLayout(null);
        
        lblBackground = new JLabel("");
        lblBackground.setBounds(0, 0, 1004, 705);
        pannelSplash.add(lblBackground);
        
        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, "name_176401134234545");
        
        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, "name_176404153688270");
        
        JPanel panel_3 = new JPanel();
        contentPane.add(panel_3, "name_176405815791633");
        
        lblBackground.setIcon(icon[0]);
    }

}
