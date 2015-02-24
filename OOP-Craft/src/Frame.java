//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import java.awt.CardLayout;
//import javax.swing.*;
//
//
//public class Frame extends JFrame {
//
//    private JPanel contentPane;
//    private  JLabel lblBackground;
//    private JLabel lblTitle;
//    
//    private final String[] names = {"images/bgSplash3.png",     // 0 - Splash screen background. http://pichost.me/1646676/
//                                    "images/title.png"};               // 1 - http://textcraft.net/
//    private Icon[] icon = {
//        new ImageIcon(getClass().getResource(names[0])),
//        new ImageIcon(getClass().getResource(names[1])),
//    }; //end icon array
//
//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    Frame frame = new Frame();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//    /**
//     * Create the frame.
//     */
//    public Frame() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 671, 604);
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//        contentPane.setLayout(new CardLayout(0, 0));
//        
//        JPanJLabel lblTitle = new JLabel("");
//        lblTitle.setBounds(10, 73, 625, 111);
//        pannelSplash.add(lblTitle);
//        
//        lblBackground = new JLabel("");
//        lblBackground.setBounds(0, 0, 650, 560);
//        pannelSplash.add(lblBackground);
//        
//        JPanel panel_1 = new JPanel();
//        contentPane.add(panel_1, "name_176401134234545");
//        
//        JPanel panel_2 = new JPanel();
//        contentPane.add(panel_2, "name_176404153688270");
//        
//        JPanel panel_3 = new JPanel();
//        contentPane.add(panel_3, "name_176405815791633");
//        
//        lblBackground.setIcon(icon[0]d.setIcon(icon[0]);
//        
//        lblTitle = new JLabel("");
//        lblTitle.setBounds(10, 73, 625, 111);
//        pannelSplash.add(lblTitle);
//        lblTitle.setIcon(icon[1]);
//    }
//
//}
