package temp;

//PROG 1400 - Assignment 3
//Jared Everett
//w0269431


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
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultCaret;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


public class Main extends JFrame {

    //weapon costs
    private final int FISTCOST = 0;
    private final int WOODCOST = 55;
    private final int IRONCOST = 205;
    private final int DIAMONDCOST = 505;
    
    //armour costs
    private final int COPPERARMOUR = 50;
    private final int IRONARMOUR = 100;
    private final int DIAMONDARMOUR = 150;
    
    //item costs
    private final int HEALTH1 = 25;
    private final int HEALTH2 = 100;
    private final int DEFENSE = 40;
    
    //frame properties
    private JPanel contentPane;
    private JPanel panelSplash;
    private JPanel panelCharacter;
    private JButton btnNextCharacter;
    private JButton btnPreviousCharacter;
    private JLabel lblCharacterStats;
    private JTextField textName;
    private JButton btnSelectCharacter;
    private JButton btnCancel;
    private JPanel panelHome;
    private JLabel lblBackground3;
    private JLabel lblTaskbar1;
    private JLabel lblHomeTitle;
    private JPanel panelWeapons;
    private JLabel lblWeaponStats;
    private JTextArea txtCombat;
    private JLabel lblName;
    private JLabel lblCharacterClass;
    private JButton btnExit;
    private JLabel lblGoldIcon;
    private JLabel lblMoney;
    private JLabel lblCharacterMainPic;
    private JLabel lblWeapon;
    private JLabel lblDefense;
    private JLabel lblWeaponThumbnail;
    private JLabel lblDefenseThumbnail1;
    private JLabel lblDefenseThumbnail2;
    private JLabel lblDefenseThumbnail3;
    private JButton btnHeal;
    private JButton btnWeaponsButton;
    private JLabel lblNewLabel;
    private JButton btnNextWeapon;
    private JButton btnLastWeapon;
    private JLabel lblSelectAWeapon;
    private JLabel label;
    private JLabel label_1;
    private JLabel lblMoneyWeapons;
    private JButton btnWeaponSelect;
    private JPanel panelOpponents;
    private JLabel lblNewLabel_1;
    private JButton btnBackFromWeapons;
    private JLabel lblChooseYourOpponent;
    private JButton btnBackFromOpponents;
    private JButton btnNextOpponent;
    private JLabel lblOpponentStats;
    private JButton btnLastOpponent;
    private JButton btnFight;
    private JPanel panelCombat;
    private JLabel lblNewLabel_2;
    private JLabel label_2;
    private JLabel lblHomeHPBar;
    private JLabel lblHp;
    private JLabel lblHomeHp;
    private JButton btnItems;
    private JLabel lblCombatTitle;
    private JLabel lblPlayerImage;
    private JLabel lblOpponentImage;
    private JLabel label_3;
    private JLabel label_4;
    private JLabel lblPlayerHP;
    private JLabel lblOpponentHP;
    private JLabel lblPlayerHPText;
    private JLabel lblOpponentHPText;
    private JPanel panelVictory;
    private JLabel lblNewLabel_3;
    private JLabel lblVictory;
    private JLabel lblReward;
    private JLabel label_5;
    private JLabel lblRewardAmount;
    private JButton btnReturnFromWin;
    private JPanel panelDefeat;
    private JLabel lblCombatWeapon;
    private JLabel lblDurability;
    private JLabel lblWeaponDurability;
    private JLabel lblItems;
    private JButton btnItem1;
    private JButton btnItem2;
    private JButton btnItem3;
    private JPanel panelArmour;
    private JLabel label_7;
    private JLabel lblHelmet;
    private JLabel lblChestplate;
    private JLabel lblLeggings;
    private JLabel lblChooseYourArmour;
    private JButton btnNextHelmet;
    private JButton btnLastHelmet;
    private JButton btnLastChestplate;
    private JButton btnNextChestplate;
    private JButton btnLastLegging;
    private JButton btnNextLegging;
    private JLabel lblCurrent;
    private JLabel lblHelmetStats;
    private JButton btnBackFromArmour;
    private JLabel lblChestplateStats;
    private JLabel lblLeggingsStat;
    private JLabel label_8;
    private JLabel label_9;
    private JLabel lblArmourMoney;
    private JLabel lblHomeDuribility;
    private JLabel lblYouMoney;
    private JLabel lblCostForSeleted;
    private JLabel lblOutift;
    private JLabel label_11;
    private JLabel lblArmourCost;
    private JButton btnPurchaseArmour;
    private JLabel label_12;
    private JPanel panelItems;
    private JLabel label_13;
    private JLabel lblBuyItems;
    private JLabel label_14;
    private JButton btnFirstItem;
    private JButton btnSecondItem;
    private JButton btnThirdItem;
    private JButton btnBackFromItems;
    private JLabel lblBonus3;
    private JLabel lblBonus2;
    private JLabel lblBonus;
    
    
    private int characterStatsArrayIndex = 0;
    private int weaponStatsArrayIndex = 0;
    private int opponentStatsArrayIndex = 0;
    private int helmetStatsArrayIndex = 0;
    private int chestplateStatsArrayIndex = 0;
    private int leggingsStatsArrayIndex = 0;
    
    private int playerAttackDelay=5;
    private int opponentAttackDelay=5;
    private int textAreaLines=0;

    private int currentWeapon=0;
    private int currentOpponent=0;
    private int currentHelmet=0;
    private int currentChestplate=0;
    private int currentLeggings=0;
    
    private boolean running = false;
    private boolean canRun = true;
    private int runCount=0; 
    
    private boolean usedCheatCode = false;
    
    private Timer timer = new Timer(500, new MyTimerActionListener());
    
    private int[] inventory = {0, 0, 0};

    Character player;
    Opponent opponent;
    
    
    
    
    //-------------IMAGE ARRAYS-----------------------------------
    
    
    
    //Splash screen background. http://pichost.me/1646676/
    //http://textcraft.net/
    private final String[] names = {"images/bgSplash3.png",     
                                    "images/title.png"};               
    private Icon[] icon = {
        new ImageIcon(getClass().getResource(names[0])),
        new ImageIcon(getClass().getResource(names[1])),
    }; //end icon array
    
    
    
    //available characters
    private final String[] characterStatImages = {"images/dba_dev_stats.png",     
                                                "images/sys_admin_stats.png",
                                                "images/Programmer_stats.png",
                                                "images/web_dev_stats.png"};          
    private Icon[] characterStats = {
        new ImageIcon(getClass().getResource(characterStatImages[0])),
        new ImageIcon(getClass().getResource(characterStatImages[1])),
        new ImageIcon(getClass().getResource(characterStatImages[2])),
        new ImageIcon(getClass().getResource(characterStatImages[3]))
    }; //end icon array

    //http://s3.amazonaws.com/rapgenius/1376168691_03clNsD.png
    //http://www.stickaz.com/8666-9874-large/iron-sword-minecraft.png
    private final String[] weaponStatImages = {"images/fist_stats.png",
    											"images/wood_stats.png",
    											"images/iron_stats.png",
    											"images/diamond_stats.png"};
    private Icon[] weaponStats = {
		new ImageIcon(getClass().getResource(weaponStatImages[0])),
		new ImageIcon(getClass().getResource(weaponStatImages[1])),
		new ImageIcon(getClass().getResource(weaponStatImages[2])),
		new ImageIcon(getClass().getResource(weaponStatImages[3]))
    };
    
    private final String[] WeaponSelectImages = {"images/equip_button.png",     
                                                "images/equipped_button.png",
                                                "images/weapon_purchase.png"};          
    private Icon[] weaponSelect = {
        new ImageIcon(getClass().getResource(WeaponSelectImages[0])),
        new ImageIcon(getClass().getResource(WeaponSelectImages[1])),
        new ImageIcon(getClass().getResource(WeaponSelectImages[2]))
    }; //end icon array
    
    private final String[] WeaponThumbnailImages = {"images/fist_thumbnail2.png",
                                                    "images/wood_thumbnail.png",
                                                    "images/iron_thumbnail.png",
                                                    "images/diamond_thumbnail.png"};          
    private Icon[] weaponThumbnails = {
        new ImageIcon(getClass().getResource(WeaponThumbnailImages[0])),
        new ImageIcon(getClass().getResource(WeaponThumbnailImages[1])),
        new ImageIcon(getClass().getResource(WeaponThumbnailImages[2])),
        new ImageIcon(getClass().getResource(WeaponThumbnailImages[3]))
    }; //end icon array
    
    private final String[] opponentStatImages = {"images/flower_stats.png",
                                                    "images/spider_stats.png",
                                                    "images/zombie_stats.png",
                                                    "images/creeper_stats.png"};          
    private Icon[] opponentStats = {
        new ImageIcon(getClass().getResource(opponentStatImages[0])),
        new ImageIcon(getClass().getResource(opponentStatImages[1])),
        new ImageIcon(getClass().getResource(opponentStatImages[2])),
        new ImageIcon(getClass().getResource(opponentStatImages[3]))
    }; //end icon array

    private final String[] hpBarImages = {"images/hpProgressBar/hp20%.png",
                                                "images/hpProgressBar/hp30%.png",
                                                "images/hpProgressBar/hp40%.png",
                                                "images/hpProgressBar/hp50%.png",
                                                "images/hpProgressBar/hp60%.png",
                                                "images/hpProgressBar/hp70%.png",
                                                "images/hpProgressBar/hp80%.png",
                                                "images/hpProgressBar/hp90%.png",
                                                "images/hpProgressBar/hp100%.png"};          
    private Icon[] hpBar = {
        new ImageIcon(getClass().getResource(hpBarImages[0])),
        new ImageIcon(getClass().getResource(hpBarImages[1])),
        new ImageIcon(getClass().getResource(hpBarImages[2])),
        new ImageIcon(getClass().getResource(hpBarImages[3])),
        new ImageIcon(getClass().getResource(hpBarImages[4])),
        new ImageIcon(getClass().getResource(hpBarImages[5])),
        new ImageIcon(getClass().getResource(hpBarImages[6])),
        new ImageIcon(getClass().getResource(hpBarImages[7])),
        new ImageIcon(getClass().getResource(hpBarImages[8]))
    }; //end icon array
    
    private final String[] helmetStatImages = {"images/blankArmour.png",
                                                "images/copper_helmet_stats.png",
                                                "images/Iron_helmet_stats.png",
                                                "images/diamond_helmet_stats.png"};
                                                                                                     
    private Icon[] helmetStats = {
        new ImageIcon(getClass().getResource(helmetStatImages[0])),
        new ImageIcon(getClass().getResource(helmetStatImages[1])),
        new ImageIcon(getClass().getResource(helmetStatImages[2])),
        new ImageIcon(getClass().getResource(helmetStatImages[3]))
    }; //end icon array
    
    private final String[] chestplateStatImages = {"images/blankArmour.png",
                                                    "images/copper_chestplate_stats.png",
                                                    "images/iron_chestplace_stats.png",
                                                    "images/diamond_chestplate_stats.png"};
    private Icon[] chestplateStats = {
        new ImageIcon(getClass().getResource(chestplateStatImages[0])),
        new ImageIcon(getClass().getResource(chestplateStatImages[1])),
        new ImageIcon(getClass().getResource(chestplateStatImages[2])),
        new ImageIcon(getClass().getResource(chestplateStatImages[3]))
    };
    
    private final String[] leggingStatImages = {"images/blankArmour.png",
                                                "images/copper_leggings_stats.png",
                                               "images/iron_leggings_stats.png",
                                                "images/diamond_leggings_stats.png"}; 
    private Icon[] leggingStats = {
        new ImageIcon(getClass().getResource(leggingStatImages[0])),
        new ImageIcon(getClass().getResource(leggingStatImages[1])),
        new ImageIcon(getClass().getResource(leggingStatImages[2])),
        new ImageIcon(getClass().getResource(leggingStatImages[3]))
    };
    
    private final String[] helmetThumbImages = {"images/equipment_thumbnail.png",
                                            "armourThumbnails/copperHelmet.png",
                                            "armourThumbnails/ironHelmet.png",
                                            "armourThumbnails/diamondHelmet.png"};
                                                                 
    private Icon[] helmetThumbs = {
        new ImageIcon(getClass().getResource(helmetThumbImages[0])),
        new ImageIcon(getClass().getResource(helmetThumbImages[1])),
        new ImageIcon(getClass().getResource(helmetThumbImages[2])),
        new ImageIcon(getClass().getResource(helmetThumbImages[3]))
    }; //end icon array
  
    
    private final String[] chestplateThumbImages = {"images/equipment_thumbnail.png",
                                                    "armourThumbnails/copperChestplate.png",
                                                    "armourThumbnails/ironChestplate.png",
                                                    "armourThumbnails/diamondChestplate.png"};
    
    private Icon[] chestplateThumbs = {
        new ImageIcon(getClass().getResource(chestplateThumbImages[0])),
        new ImageIcon(getClass().getResource(chestplateThumbImages[1])),
        new ImageIcon(getClass().getResource(chestplateThumbImages[2])),
        new ImageIcon(getClass().getResource(chestplateThumbImages[3]))
    }; //end icon array

    private final String[] leggingsThumbImages = {"images/equipment_thumbnail.png",
                                                    "armourThumbnails/copperLeggings.png",
                                                    "armourThumbnails/ironLeggings.png",
                                                    "armourThumbnails/diamondLeggings.png"};

    private Icon[] leggingsThumbs = {
        new ImageIcon(getClass().getResource(leggingsThumbImages[0])),
        new ImageIcon(getClass().getResource(leggingsThumbImages[1])),
        new ImageIcon(getClass().getResource(leggingsThumbImages[2])),
        new ImageIcon(getClass().getResource(leggingsThumbImages[3]))
    }; //end icon array


    private final String[] itemImages = {"images/health1.png",
                                        "images/health1_selected.png",
                                        "images/health2.png",
                                        "images/health2_selected.png",
                                        "images/defense.png",
                                        "images/defense_selected.png"};

    private Icon[] items = {
        new ImageIcon(getClass().getResource(itemImages[0])),
        new ImageIcon(getClass().getResource(itemImages[1])),
        new ImageIcon(getClass().getResource(itemImages[2])),
        new ImageIcon(getClass().getResource(itemImages[3])),
        new ImageIcon(getClass().getResource(itemImages[4])),
        new ImageIcon(getClass().getResource(itemImages[5]))
    }; //end icon array
    
    private final String[] itemThumbImages = {"images/equipment_thumbnail.png",
                                                    "images/health1_thumb.png",
                                                    "images/health2_thumb.png",
                                                    "images/defense_thumb.png"};

    private Icon[] itemThumbs = {
        new ImageIcon(getClass().getResource(itemThumbImages[0])),
        new ImageIcon(getClass().getResource(itemThumbImages[1])),
        new ImageIcon(getClass().getResource(itemThumbImages[2])),
        new ImageIcon(getClass().getResource(itemThumbImages[3]))
    }; //end icon array
    
    private JLabel lblInventory;
    private JLabel lblItemSlot1;
    private JLabel lblItemSlot2;
    private JLabel lblItemSlot3;
    private JLabel label_15;
    private JLabel lblYourMoney;
    private JLabel lblItemMoney;
    private JLabel lblInventory_1;
    private JLabel lblHomeInv1;
    private JLabel lblHomeInv2;
    private JLabel lblHomeInv3;

     //Launch the application.

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
        btnStart.setFocusable(false);
        btnStart.setContentAreaFilled(false);
        btnStart.setBorderPainted(false);
        btnStart.setOpaque(false);
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setDisplayPanel(1);
            }
        });
        
        btnExit = new JButton("");
        btnExit.setIcon(new ImageIcon(Main.class.getResource("/temp/images/exit.png")));
        btnExit.setOpaque(false);
        btnExit.setFocusable(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setBorderPainted(false);
        btnExit.setBounds(95, 320, 461, 49);
        panelSplash.add(btnExit);
        btnStart.setIcon(new ImageIcon(Main.class.getResource("images/start_game.png")));
        btnStart.setBounds(95, 271, 461, 49);
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
        btnNextCharacter.setFocusable(false);
        btnNextCharacter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchCharacter(true);
            }
        });
        btnNextCharacter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                btnNextCharacter.setIcon(new ImageIcon(Main.class.getResource("images/arrow_big.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnNextCharacter.setIcon(new ImageIcon(Main.class.getResource("images/arrow.png")));
            }
        });
        btnNextCharacter.setBorderPainted(false);
        btnNextCharacter.setContentAreaFilled(false);
        btnNextCharacter.setOpaque(false);
        btnNextCharacter.setIcon(new ImageIcon(Main.class.getResource("images/arrow.png")));
        btnNextCharacter.setBounds(538, 290, 83, 87);
        panelCharacter.add(btnNextCharacter);
        
        btnPreviousCharacter = new JButton("");
        btnPreviousCharacter.setFocusable(false);
        btnPreviousCharacter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchCharacter(false);
            }
        });
        btnPreviousCharacter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnPreviousCharacter.setIcon(new ImageIcon(Main.class.getResource("images/left_arrow_big.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnPreviousCharacter.setIcon(new ImageIcon(Main.class.getResource("images/left_arrow.png")));
            }
        });
        btnPreviousCharacter.setIcon(new ImageIcon(Main.class.getResource("images/left_arrow.png")));
        btnPreviousCharacter.setOpaque(false);
        btnPreviousCharacter.setContentAreaFilled(false);
        btnPreviousCharacter.setBorderPainted(false);
        btnPreviousCharacter.setBounds(10, 290, 83, 87);
        panelCharacter.add(btnPreviousCharacter);
        
        btnSelectCharacter = new JButton("");
        btnSelectCharacter.setFocusable(false);
        btnSelectCharacter.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	    
                selectCharacter();
        	}
        });
        btnSelectCharacter.setIcon(new ImageIcon(Main.class.getResource("images/select_button.png")));
        btnSelectCharacter.setOpaque(false);
        btnSelectCharacter.setContentAreaFilled(false);
        btnSelectCharacter.setBorderPainted(false);
        btnSelectCharacter.setBounds(375, 474, 199, 59);
        panelCharacter.add(btnSelectCharacter);
        
        btnCancel = new JButton("");
        btnCancel.setFocusable(false);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setDisplayPanel(0);
            }
        });
        btnCancel.setIcon(new ImageIcon(Main.class.getResource("images/cancel_button.png")));
        btnCancel.setOpaque(false);
        btnCancel.setBorderPainted(false);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setBounds(76, 474, 199, 59);
        panelCharacter.add(btnCancel);
        
        JLabel lblbackground2 = new JLabel("");
        lblbackground2.setIcon(new ImageIcon(Main.class.getResource("images/background2.png")));
        lblbackground2.setBounds(0, 0, 657, 556);
        panelCharacter.add(lblbackground2);
        
        panelHome = new JPanel();
        contentPane.add(panelHome, "name_21947366516201");
        panelHome.setLayout(null);
        
        JButton btnCombat = new JButton("");
        btnCombat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setDisplayPanel(4);
            }
        });
        
        lblHomeInv3 = new JLabel("");
        lblHomeInv3.setIcon(new ImageIcon(Main.class.getResource("/temp/images/equipment_thumbnail.png")));
        lblHomeInv3.setBounds(390, 463, 50, 50);
        panelHome.add(lblHomeInv3);
        
        lblHomeInv2 = new JLabel("");
        lblHomeInv2.setIcon(new ImageIcon(Main.class.getResource("/temp/images/equipment_thumbnail.png")));
        lblHomeInv2.setBounds(390, 402, 50, 50);
        panelHome.add(lblHomeInv2);
        
        lblHomeInv1 = new JLabel("");
        lblHomeInv1.setIcon(new ImageIcon(Main.class.getResource("/temp/images/equipment_thumbnail.png")));
        lblHomeInv1.setBounds(390, 341, 50, 50);
        panelHome.add(lblHomeInv1);
        
        lblInventory_1 = new JLabel("Inventory");
        lblInventory_1.setForeground(Color.WHITE);
        lblInventory_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblInventory_1.setBounds(369, 296, 114, 36);
        panelHome.add(lblInventory_1);
        
        lblHomeDuribility = new JLabel("stub");
        lblHomeDuribility.setForeground(Color.WHITE);
        lblHomeDuribility.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblHomeDuribility.setBounds(345, 252, 107, 36);
        panelHome.add(lblHomeDuribility);
        
        btnItems = new JButton("");
        btnItems.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setDisplayPanel(9);
                setupItemsPanel();
            }
        });
        btnItems.setIcon(new ImageIcon(Main.class.getResource("/temp/images/items_button.png")));
        btnItems.setOpaque(false);
        btnItems.setFocusable(false);
        btnItems.setContentAreaFilled(false);
        btnItems.setBorderPainted(false);
        btnItems.setBounds(493, 329, 150, 50);
        panelHome.add(btnItems);
        
        lblHomeHp = new JLabel("100 / 100");
        lblHomeHp.setForeground(Color.WHITE);
        lblHomeHp.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblHomeHp.setBounds(258, 524, 97, 36);
        panelHome.add(lblHomeHp);
        
        lblHp = new JLabel("HP");
        lblHp.setForeground(Color.WHITE);
        lblHp.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblHp.setBounds(194, 524, 39, 36);
        panelHome.add(lblHp);
        
        lblHomeHPBar = new JLabel("");
        lblHomeHPBar.setBounds(229, 522, 150, 38);
        panelHome.add(lblHomeHPBar);
        
        label_2 = new JLabel("");
        label_2.setIcon(new ImageIcon(Main.class.getResource("/temp/images/progressBarBackground.png")));
        label_2.setBounds(229, 522, 150, 38);
        panelHome.add(label_2);
        btnCombat.setIcon(new ImageIcon(Main.class.getResource("/temp/images/button_combat.png")));
        btnCombat.setOpaque(false);
        btnCombat.setFocusable(false);
        btnCombat.setContentAreaFilled(false);
        btnCombat.setBorderPainted(false);
        btnCombat.setBounds(514, 451, 129, 50);
        panelHome.add(btnCombat);
        
        JButton btnArmour = new JButton("");
        btnArmour.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setDisplayPanel(8);
        		setupArmourPanel();
        	}
        });
        btnArmour.setIcon(new ImageIcon(Main.class.getResource("/temp/images/button_armour.png")));
        btnArmour.setOpaque(false);
        btnArmour.setFocusable(false);
        btnArmour.setContentAreaFilled(false);
        btnArmour.setBorderPainted(false);
        btnArmour.setBounds(493, 267, 150, 50);
        panelHome.add(btnArmour);
        
        btnWeaponsButton = new JButton("");
        btnWeaponsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setDisplayPanel(3);
                setupWeaponPanel();
            }
        });
        btnWeaponsButton.setFocusable(false);
        btnWeaponsButton.setIcon(new ImageIcon(Main.class.getResource("/temp/images/weapons_button.png")));
        btnWeaponsButton.setOpaque(false);
        btnWeaponsButton.setContentAreaFilled(false);
        btnWeaponsButton.setBorderPainted(false);
        btnWeaponsButton.setBounds(493, 206, 150, 50);
        panelHome.add(btnWeaponsButton);
        
        btnHeal = new JButton("");
        btnHeal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(player.getMoney()>=25)
                {
                    player.setHp(player.getMaxHP());
                    player.setMoney(player.getMoney()-25);
                    setupHomePage();
                }
            }
        });
        btnHeal.setFocusable(false);
        btnHeal.setIcon(new ImageIcon(Main.class.getResource("/temp/images/button_heal.png")));
        btnHeal.setOpaque(false);
        btnHeal.setContentAreaFilled(false);
        btnHeal.setBorderPainted(false);
        btnHeal.setBounds(514, 390, 129, 50);
        panelHome.add(btnHeal);
        
        lblDefenseThumbnail3 = new JLabel("");
        lblDefenseThumbnail3.setIcon(new ImageIcon(Main.class.getResource("/temp/images/equipment_thumbnail.png")));
        lblDefenseThumbnail3.setBounds(285, 463, 50, 50);
        panelHome.add(lblDefenseThumbnail3);
        
        lblDefenseThumbnail2 = new JLabel("");
        lblDefenseThumbnail2.setIcon(new ImageIcon(Main.class.getResource("/temp/images/equipment_thumbnail.png")));
        lblDefenseThumbnail2.setBounds(285, 402, 50, 50);
        panelHome.add(lblDefenseThumbnail2);
        
        lblDefenseThumbnail1 = new JLabel("");
        lblDefenseThumbnail1.setIcon(new ImageIcon(Main.class.getResource("/temp/images/equipment_thumbnail.png")));
        lblDefenseThumbnail1.setBounds(285, 341, 50, 50);
        panelHome.add(lblDefenseThumbnail1);
        
        lblWeaponThumbnail = new JLabel("");
        lblWeaponThumbnail.setIcon(new ImageIcon(Main.class.getResource("/temp/images/equipment_thumbnail.png")));
        lblWeaponThumbnail.setBounds(285, 252, 50, 50);
        panelHome.add(lblWeaponThumbnail);
        
        lblDefense = new JLabel("Defense");
        lblDefense.setForeground(Color.WHITE);
        lblDefense.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblDefense.setBounds(275, 296, 83, 36);
        panelHome.add(lblDefense);
        
        lblWeapon = new JLabel("Weapon");
        lblWeapon.setForeground(Color.WHITE);
        lblWeapon.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblWeapon.setBounds(275, 206, 107, 36);
        panelHome.add(lblWeapon);
        
        lblCharacterMainPic = new JLabel("");
        lblCharacterMainPic.setBounds(20, 175, 239, 318);
        panelHome.add(lblCharacterMainPic);
        
        lblMoney = new JLabel("stub");
        lblMoney.setForeground(Color.WHITE);
        lblMoney.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblMoney.setBounds(567, 524, 83, 36);
        panelHome.add(lblMoney);
        
        lblGoldIcon = new JLabel("New label");
        lblGoldIcon.setIcon(new ImageIcon(Main.class.getResource("/temp/images/gold36x39.png")));
        lblGoldIcon.setBounds(518, 524, 39, 36);
        panelHome.add(lblGoldIcon);
        
        lblCharacterClass = new JLabel("stub");
        lblCharacterClass.setForeground(Color.CYAN);
        lblCharacterClass.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCharacterClass.setBounds(10, 538, 129, 14);
        panelHome.add(lblCharacterClass);
        
        lblName = new JLabel("Jared");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setForeground(Color.WHITE);
        lblName.setBounds(10, 524, 129, 14);
        panelHome.add(lblName);
        
        lblTaskbar1 = new JLabel("");
        lblTaskbar1.setIcon(new ImageIcon(Main.class.getResource("/temp/images/taskbar2.png")));
        lblTaskbar1.setBounds(0, 522, 650, 39);
        panelHome.add(lblTaskbar1);
        
        lblHomeTitle = new JLabel("stub");
        lblHomeTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblHomeTitle.setForeground(Color.WHITE);
        lblHomeTitle.setFont(new Font("Algerian", Font.PLAIN, 30));
        lblHomeTitle.setBounds(10, 129, 633, 35);
        panelHome.add(lblHomeTitle);
        
        lblBackground3 = new JLabel("New label");
        lblBackground3.setIcon(new ImageIcon(Main.class.getResource("/temp/images/background2.png")));
        lblBackground3.setBounds(0, 0, 653, 561);
        panelHome.add(lblBackground3);
        
        panelWeapons = new JPanel();
        contentPane.add(panelWeapons, "name_735893869682704");
        panelWeapons.setLayout(null);
        
        btnNextWeapon = new JButton("");
        btnNextWeapon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchWeapon(true);
            }
        });
        btnNextWeapon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                btnNextWeapon.setIcon(new ImageIcon(Main.class.getResource("images/arrow_big.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnNextWeapon.setIcon(new ImageIcon(Main.class.getResource("images/arrow.png")));
            }
        });
        
        btnLastWeapon = new JButton("");
        btnLastWeapon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchWeapon(false);
            }
        });
        btnLastWeapon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLastWeapon.setIcon(new ImageIcon(Main.class.getResource("images/left_arrow_big.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnLastWeapon.setIcon(new ImageIcon(Main.class.getResource("images/left_arrow.png")));
            }
        });
        
        btnWeaponSelect = new JButton("");
        btnWeaponSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectWeapon();
            }
        });
        
        btnBackFromWeapons = new JButton("");
        btnBackFromWeapons.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setDisplayPanel(2);
                setupHomePage();
            }
        });
        btnBackFromWeapons.setIcon(new ImageIcon(Main.class.getResource("/temp/images/backFromWeapons.png")));
        btnBackFromWeapons.setOpaque(false);
        btnBackFromWeapons.setFocusable(false);
        btnBackFromWeapons.setContentAreaFilled(false);
        btnBackFromWeapons.setBorderPainted(false);
        btnBackFromWeapons.setBounds(10, 11, 162, 58);
        panelWeapons.add(btnBackFromWeapons);
        btnWeaponSelect.setIcon(new ImageIcon(Main.class.getResource("/temp/images/weapon_purchase.png")));
        btnWeaponSelect.setOpaque(false);
        btnWeaponSelect.setFocusable(false);
        btnWeaponSelect.setContentAreaFilled(false);
        btnWeaponSelect.setBorderPainted(false);
        btnWeaponSelect.setBounds(224, 426, 200, 70);
        panelWeapons.add(btnWeaponSelect);
        
        lblMoneyWeapons = new JLabel("stub");
        lblMoneyWeapons.setForeground(Color.WHITE);
        lblMoneyWeapons.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblMoneyWeapons.setBounds(548, 521, 83, 36);
        panelWeapons.add(lblMoneyWeapons);
        
        label_1 = new JLabel("New label");
        label_1.setIcon(new ImageIcon(Main.class.getResource("/temp/images/gold36x39.png")));
        label_1.setBounds(502, 524, 39, 36);
        panelWeapons.add(label_1);
        
        label = new JLabel("");
        label.setIcon(new ImageIcon(Main.class.getResource("/temp/images/taskbar2.png")));
        label.setBounds(0, 521, 650, 39);
        panelWeapons.add(label);
        
        lblSelectAWeapon = new JLabel("Select a Weapon");
        lblSelectAWeapon.setHorizontalAlignment(SwingConstants.CENTER);
        lblSelectAWeapon.setForeground(Color.WHITE);
        lblSelectAWeapon.setFont(new Font("Algerian", Font.PLAIN, 30));
        lblSelectAWeapon.setBounds(10, 131, 633, 35);
        panelWeapons.add(lblSelectAWeapon);
        btnLastWeapon.setIcon(new ImageIcon(Main.class.getResource("/temp/images/left_arrow.png")));
        btnLastWeapon.setOpaque(false);
        btnLastWeapon.setFocusable(false);
        btnLastWeapon.setContentAreaFilled(false);
        btnLastWeapon.setBorderPainted(false);
        btnLastWeapon.setBounds(38, 261, 83, 87);
        panelWeapons.add(btnLastWeapon);
        btnNextWeapon.setIcon(new ImageIcon(Main.class.getResource("/temp/images/arrow.png")));
        btnNextWeapon.setOpaque(false);
        btnNextWeapon.setFocusable(false);
        btnNextWeapon.setContentAreaFilled(false);
        btnNextWeapon.setBorderPainted(false);
        btnNextWeapon.setBounds(513, 261, 83, 87);
        panelWeapons.add(btnNextWeapon);
        
        lblWeaponStats = new JLabel("");
        lblWeaponStats.setIcon(new ImageIcon(Main.class.getResource("/temp/images/fist_stats.png")));
        lblWeaponStats.setBounds(162, 205, 322, 200);
        panelWeapons.add(lblWeaponStats);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/temp/images/background2.png")));
        lblNewLabel.setBounds(0, 0, 653, 560);
        panelWeapons.add(lblNewLabel);
        
        panelOpponents = new JPanel();
        contentPane.add(panelOpponents, "name_752769073779697");
        panelOpponents.setLayout(null);
        
        btnBackFromOpponents = new JButton("");
        btnBackFromOpponents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setDisplayPanel(2);
                setupHomePage();
            }
        });
        
        btnLastOpponent = new JButton("");
        btnLastOpponent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLastOpponent.setIcon(new ImageIcon(Main.class.getResource("images/left_arrow_big.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnLastOpponent.setIcon(new ImageIcon(Main.class.getResource("images/left_arrow.png")));
            }
        });
        btnLastOpponent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchOpponent(false);
            }
        });
        
        btnFight = new JButton("");
        btnFight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectOpponent();
            }
        });
        btnFight.setIcon(new ImageIcon(Main.class.getResource("/temp/images/fight_button.png")));
        btnFight.setOpaque(false);
        btnFight.setFocusable(false);
        btnFight.setContentAreaFilled(false);
        btnFight.setBorderPainted(false);
        btnFight.setBounds(223, 438, 204, 75);
        panelOpponents.add(btnFight);
        btnLastOpponent.setIcon(new ImageIcon(Main.class.getResource("/temp/images/left_arrow.png")));
        btnLastOpponent.setOpaque(false);
        btnLastOpponent.setFocusable(false);
        btnLastOpponent.setContentAreaFilled(false);
        btnLastOpponent.setBorderPainted(false);
        btnLastOpponent.setBounds(50, 256, 83, 87);
        panelOpponents.add(btnLastOpponent);
        
        lblOpponentStats = new JLabel("");
        lblOpponentStats.setIcon(new ImageIcon(Main.class.getResource("/temp/images/flower_stats.png")));
        lblOpponentStats.setBounds(161, 198, 322, 200);
        panelOpponents.add(lblOpponentStats);
        
        btnNextOpponent = new JButton("");
        btnNextOpponent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnNextOpponent.setIcon(new ImageIcon(Main.class.getResource("images/arrow_big.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnNextOpponent.setIcon(new ImageIcon(Main.class.getResource("images/arrow.png")));
            }
        });
        btnNextOpponent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchOpponent(true);
            }
        });
        btnNextOpponent.setIcon(new ImageIcon(Main.class.getResource("/temp/images/arrow.png")));
        btnNextOpponent.setOpaque(false);
        btnNextOpponent.setFocusable(false);
        btnNextOpponent.setContentAreaFilled(false);
        btnNextOpponent.setBorderPainted(false);
        btnNextOpponent.setBounds(508, 256, 83, 87);
        panelOpponents.add(btnNextOpponent);
        btnBackFromOpponents.setIcon(new ImageIcon(Main.class.getResource("/temp/images/backFromWeapons.png")));
        btnBackFromOpponents.setOpaque(false);
        btnBackFromOpponents.setFocusable(false);
        btnBackFromOpponents.setContentAreaFilled(false);
        btnBackFromOpponents.setBorderPainted(false);
        btnBackFromOpponents.setBounds(10, 11, 162, 58);
        panelOpponents.add(btnBackFromOpponents);
        
        lblChooseYourOpponent = new JLabel("Choose your Opponent");
        lblChooseYourOpponent.setHorizontalAlignment(SwingConstants.CENTER);
        lblChooseYourOpponent.setForeground(Color.WHITE);
        lblChooseYourOpponent.setFont(new Font("Algerian", Font.PLAIN, 30));
        lblChooseYourOpponent.setBounds(0, 128, 633, 35);
        panelOpponents.add(lblChooseYourOpponent);
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Main.class.getResource("/temp/images/background2.png")));
        lblNewLabel_1.setBounds(0, 0, 653, 560);
        panelOpponents.add(lblNewLabel_1);
        
        panelCombat = new JPanel();
        contentPane.add(panelCombat, "name_762226878835683");
        panelCombat.setLayout(null);
        
        JButton btnRun = new JButton("");
        btnRun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                run();
            }
        });
        btnRun.setIcon(new ImageIcon(Main.class.getResource("/temp/images/run_button.png")));
        btnRun.setOpaque(false);
        btnRun.setBorderPainted(false);
        btnRun.setContentAreaFilled(false);
        btnRun.setBounds(503, 501, 125, 50);
        panelCombat.add(btnRun);
        
        btnItem3 = new JButton("New button");
        btnItem3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		useItem(2);
        	}
        });
        btnItem3.setIcon(new ImageIcon(Main.class.getResource("/temp/images/equipment_thumbnail.png")));
        btnItem3.setOpaque(false);
        btnItem3.setFocusable(false);
        btnItem3.setContentAreaFilled(false);
        btnItem3.setBorderPainted(false);
        btnItem3.setBounds(376, 501, 77, 50);
        panelCombat.add(btnItem3);
        
        btnItem2 = new JButton("New button");
        btnItem2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		useItem(1);
        	}
        });
        btnItem2.setIcon(new ImageIcon(Main.class.getResource("/temp/images/equipment_thumbnail.png")));
        btnItem2.setOpaque(false);
        btnItem2.setFocusable(false);
        btnItem2.setContentAreaFilled(false);
        btnItem2.setBorderPainted(false);
        btnItem2.setBounds(300, 501, 77, 50);
        panelCombat.add(btnItem2);
        
        btnItem1 = new JButton("New button");
        btnItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                useItem(0);
            }
        });
        btnItem1.setOpaque(false);
        btnItem1.setFocusable(false);
        btnItem1.setContentAreaFilled(false);
        btnItem1.setBorderPainted(false);
        btnItem1.setIcon(new ImageIcon(Main.class.getResource("/temp/images/equipment_thumbnail.png")));
        btnItem1.setBounds(227, 501, 77, 50);
        panelCombat.add(btnItem1);
        
        lblItems = new JLabel("Items");
        lblItems.setForeground(Color.WHITE);
        lblItems.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblItems.setBounds(300, 478, 77, 22);
        panelCombat.add(lblItems);
        
        lblWeaponDurability = new JLabel("10");
        lblWeaponDurability.setForeground(Color.WHITE);
        lblWeaponDurability.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblWeaponDurability.setBounds(73, 516, 69, 22);
        panelCombat.add(lblWeaponDurability);
        
        lblDurability = new JLabel("Weapon Durability");
        lblDurability.setForeground(Color.WHITE);
        lblDurability.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblDurability.setBounds(10, 478, 174, 22);
        panelCombat.add(lblDurability);
        
        lblCombatWeapon = new JLabel("");
        lblCombatWeapon.setIcon(new ImageIcon(Main.class.getResource("/temp/images/equipment_thumbnail.png")));
        lblCombatWeapon.setBounds(20, 501, 50, 50);
        panelCombat.add(lblCombatWeapon);
        
        lblOpponentHPText = new JLabel("100 / 100");
        lblOpponentHPText.setForeground(Color.WHITE);
        lblOpponentHPText.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblOpponentHPText.setBounds(503, 408, 97, 36);
        panelCombat.add(lblOpponentHPText);
        
        lblPlayerHPText = new JLabel("100 / 100");
        lblPlayerHPText.setForeground(Color.WHITE);
        lblPlayerHPText.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblPlayerHPText.setBounds(52, 408, 97, 36);
        panelCombat.add(lblPlayerHPText);
        
        lblOpponentHP = new JLabel("");
        lblOpponentHP.setIcon(new ImageIcon(Main.class.getResource("/temp/images/hpProgressBar/hp60%.png")));
        lblOpponentHP.setBounds(477, 408, 150, 38);
        panelCombat.add(lblOpponentHP);
        
        lblPlayerHP = new JLabel("");
        lblPlayerHP.setIcon(new ImageIcon(Main.class.getResource("/temp/images/hpProgressBar/hp40%.png")));
        lblPlayerHP.setBounds(30, 408, 150, 38);
        panelCombat.add(lblPlayerHP);
        
        label_4 = new JLabel("");
        label_4.setIcon(new ImageIcon(Main.class.getResource("/temp/images/progressBarBackground.png")));
        label_4.setBounds(477, 408, 150, 38);
        panelCombat.add(label_4);
        
        label_3 = new JLabel("");
        label_3.setIcon(new ImageIcon(Main.class.getResource("/temp/images/progressBarBackground.png")));
        label_3.setBounds(30, 408, 150, 38);
        panelCombat.add(label_3);
        
        txtCombat = new JTextArea();
        txtCombat.setForeground(Color.WHITE);
        txtCombat.setFont(new Font("Monospaced", Font.BOLD, 14));
        txtCombat.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        txtCombat.setBackground(Color.BLACK);
        txtCombat.setBounds(180, 177, 287, 267);
        panelCombat.add(txtCombat);
        
        lblOpponentImage = new JLabel("");
        lblOpponentImage.setIcon(new ImageIcon(Main.class.getResource("/temp/images/creeper150x250.png")));
        lblOpponentImage.setBounds(477, 147, 150, 250);
        panelCombat.add(lblOpponentImage);
        
        lblPlayerImage = new JLabel("");
        lblPlayerImage.setIcon(new ImageIcon(Main.class.getResource("/temp/images/programmer150x250.png")));
        lblPlayerImage.setBounds(20, 147, 150, 250);
        panelCombat.add(lblPlayerImage);
        
        lblCombatTitle = new JLabel("Stub vs Stub");
        lblCombatTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblCombatTitle.setForeground(Color.WHITE);
        lblCombatTitle.setFont(new Font("Algerian", Font.PLAIN, 30));
        lblCombatTitle.setBounds(10, 131, 633, 35);
        panelCombat.add(lblCombatTitle);
        
        JLabel label_10 = new JLabel("");
        label_10.setIcon(new ImageIcon(Main.class.getResource("/temp/images/taskbar3.png")));
        label_10.setBounds(0, 458, 653, 102);
        panelCombat.add(label_10);
        
        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Main.class.getResource("/temp/images/background2.png")));
        lblNewLabel_2.setBounds(0, 0, 653, 560);
        panelCombat.add(lblNewLabel_2);
        
        panelVictory = new JPanel();
        contentPane.add(panelVictory, "name_833428815366290");
        panelVictory.setLayout(null);
        
        btnReturnFromWin = new JButton("");
        btnReturnFromWin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setDisplayPanel(2);
                setupHomePage();
            }
        });
        
        lblBonus3 = new JLabel("+25 HP");
        lblBonus3.setForeground(Color.WHITE);
        lblBonus3.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblBonus3.setBounds(411, 335, 77, 22);
        panelVictory.add(lblBonus3);
        
        lblBonus2 = new JLabel("");
        lblBonus2.setIcon(new ImageIcon(Main.class.getResource("/temp/images/health1_thumb.png")));
        lblBonus2.setBounds(351, 320, 50, 50);
        panelVictory.add(lblBonus2);
        
        lblBonus = new JLabel("Bonus!");
        lblBonus.setHorizontalAlignment(SwingConstants.CENTER);
        lblBonus.setForeground(Color.WHITE);
        lblBonus.setFont(new Font("Algerian", Font.PLAIN, 30));
        lblBonus.setBounds(179, 335, 148, 35);
        panelVictory.add(lblBonus);
        btnReturnFromWin.setIcon(new ImageIcon(Main.class.getResource("/temp/images/backFromWeapons.png")));
        btnReturnFromWin.setOpaque(false);
        btnReturnFromWin.setFocusable(false);
        btnReturnFromWin.setContentAreaFilled(false);
        btnReturnFromWin.setBorderPainted(false);
        btnReturnFromWin.setBounds(232, 410, 169, 67);
        panelVictory.add(btnReturnFromWin);
        
        lblRewardAmount = new JLabel("200");
        lblRewardAmount.setHorizontalAlignment(SwingConstants.CENTER);
        lblRewardAmount.setForeground(Color.WHITE);
        lblRewardAmount.setFont(new Font("Algerian", Font.PLAIN, 30));
        lblRewardAmount.setBounds(385, 261, 66, 35);
        panelVictory.add(lblRewardAmount);
        
        label_5 = new JLabel("");
        label_5.setIcon(new ImageIcon(Main.class.getResource("/temp/images/gold36x39.png")));
        label_5.setBounds(356, 252, 32, 44);
        panelVictory.add(label_5);
        
        lblReward = new JLabel("Reward:");
        lblReward.setHorizontalAlignment(SwingConstants.CENTER);
        lblReward.setForeground(Color.WHITE);
        lblReward.setFont(new Font("Algerian", Font.PLAIN, 30));
        lblReward.setBounds(165, 261, 148, 35);
        panelVictory.add(lblReward);
        
        lblVictory = new JLabel("Victory!");
        lblVictory.setHorizontalAlignment(SwingConstants.CENTER);
        lblVictory.setForeground(Color.WHITE);
        lblVictory.setFont(new Font("Algerian", Font.PLAIN, 70));
        lblVictory.setBounds(0, 130, 633, 93);
        panelVictory.add(lblVictory);
        
        lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(Main.class.getResource("/temp/images/background2.png")));
        lblNewLabel_3.setBounds(0, 0, 653, 560);
        panelVictory.add(lblNewLabel_3);
        
        panelDefeat = new JPanel();
        contentPane.add(panelDefeat, "name_14940664607691");
        panelDefeat.setLayout(null);
        
        JButton btnRestart = new JButton("");
        btnRestart.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		restartGame();
        	}
        });
        btnRestart.setIcon(new ImageIcon(Main.class.getResource("/temp/images/restart_button.png")));
        btnRestart.setOpaque(false);
        btnRestart.setFocusable(false);
        btnRestart.setContentAreaFilled(false);
        btnRestart.setBorderPainted(false);
        btnRestart.setBounds(243, 321, 150, 50);
        panelDefeat.add(btnRestart);
        
        JLabel lblDefeat = new JLabel("Defeat :(");
        lblDefeat.setHorizontalAlignment(SwingConstants.CENTER);
        lblDefeat.setForeground(Color.WHITE);
        lblDefeat.setFont(new Font("Algerian", Font.PLAIN, 70));
        lblDefeat.setBounds(10, 137, 633, 93);
        panelDefeat.add(lblDefeat);
        
        JLabel label_6 = new JLabel("");
        label_6.setIcon(new ImageIcon(Main.class.getResource("/temp/images/background2.png")));
        label_6.setBounds(0, 0, 653, 561);
        panelDefeat.add(label_6);
        
        panelArmour = new JPanel();
        contentPane.add(panelArmour, "name_19306160383264");
        panelArmour.setLayout(null);
        
        btnPurchaseArmour = new JButton("");
        btnPurchaseArmour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equipArmour();
            }
        });
        btnPurchaseArmour.setIcon(new ImageIcon(Main.class.getResource("/temp/images/purchase_armour_button.png")));
        btnPurchaseArmour.setOpaque(false);
        btnPurchaseArmour.setFocusable(false);
        btnPurchaseArmour.setContentAreaFilled(false);
        btnPurchaseArmour.setBorderPainted(false);
        btnPurchaseArmour.setBounds(26, 448, 150, 60);
        panelArmour.add(btnPurchaseArmour);
        
        lblArmourCost = new JLabel("stub");
        lblArmourCost.setForeground(Color.WHITE);
        lblArmourCost.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblArmourCost.setBounds(123, 391, 75, 29);
        panelArmour.add(lblArmourCost);
        
        label_11 = new JLabel("New label");
        label_11.setIcon(new ImageIcon(Main.class.getResource("/temp/images/gold36x39.png")));
        label_11.setBounds(88, 390, 39, 36);
        panelArmour.add(label_11);
        
        lblOutift = new JLabel("outift:");
        lblOutift.setForeground(Color.WHITE);
        lblOutift.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblOutift.setBounds(26, 391, 75, 29);
        panelArmour.add(lblOutift);
        
        lblCostForSeleted = new JLabel("Cost for seleted\r\n");
        lblCostForSeleted.setForeground(Color.WHITE);
        lblCostForSeleted.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblCostForSeleted.setBounds(10, 356, 150, 36);
        panelArmour.add(lblCostForSeleted);
        
        lblYouMoney = new JLabel("Your money:");
        lblYouMoney.setForeground(Color.WHITE);
        lblYouMoney.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblYouMoney.setBounds(0, 525, 117, 29);
        panelArmour.add(lblYouMoney);
        
        lblArmourMoney = new JLabel("stub");
        lblArmourMoney.setForeground(Color.WHITE);
        lblArmourMoney.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblArmourMoney.setBounds(158, 525, 75, 29);
        panelArmour.add(lblArmourMoney);
        
        label_9 = new JLabel("New label");
        label_9.setIcon(new ImageIcon(Main.class.getResource("/temp/images/gold36x39.png")));
        label_9.setBounds(127, 524, 39, 36);
        panelArmour.add(label_9);
        
        label_8 = new JLabel("");
        label_8.setIcon(new ImageIcon(Main.class.getResource("/temp/images/taskbar2.png")));
        label_8.setBounds(0, 519, 650, 39);
        panelArmour.add(label_8);
        
        lblLeggingsStat = new JLabel("");
        lblLeggingsStat.setIcon(new ImageIcon(Main.class.getResource("/temp/images/diamond_leggings_stats.png")));
        lblLeggingsStat.setBounds(279, 393, 250, 115);
        panelArmour.add(lblLeggingsStat);
        
        lblChestplateStats = new JLabel("");
        lblChestplateStats.setIcon(new ImageIcon(Main.class.getResource("/temp/images/diamond_chestplate_stats.png")));
        lblChestplateStats.setBounds(279, 260, 250, 115);
        panelArmour.add(lblChestplateStats);
        
        btnBackFromArmour = new JButton("");
        btnBackFromArmour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setupHomePage();
                setDisplayPanel(2);
            }
        });
        btnBackFromArmour.setIcon(new ImageIcon(Main.class.getResource("/temp/images/backFromWeapons.png")));
        btnBackFromArmour.setOpaque(false);
        btnBackFromArmour.setFocusable(false);
        btnBackFromArmour.setContentAreaFilled(false);
        btnBackFromArmour.setBorderPainted(false);
        btnBackFromArmour.setBounds(0, 11, 162, 58);
        panelArmour.add(btnBackFromArmour);
        
        lblHelmetStats = new JLabel("");
        lblHelmetStats.setIcon(new ImageIcon(Main.class.getResource("/temp/images/diamond_helmet_stats.png")));
        lblHelmetStats.setBounds(279, 124, 250, 115);
        panelArmour.add(lblHelmetStats);
        
        lblCurrent = new JLabel("Current");
        lblCurrent.setForeground(Color.WHITE);
        lblCurrent.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblCurrent.setBounds(10, 113, 75, 22);
        panelArmour.add(lblCurrent);
        
        btnNextLegging = new JButton("");
        btnNextLegging.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchLeggings(true);
            }
        });
        btnNextLegging.setIcon(new ImageIcon(Main.class.getResource("/temp/images/arrow.png")));
        btnNextLegging.setOpaque(false);
        btnNextLegging.setFocusable(false);
        btnNextLegging.setContentAreaFilled(false);
        btnNextLegging.setBorderPainted(false);
        btnNextLegging.setBounds(542, 403, 83, 87);
        panelArmour.add(btnNextLegging);
        
        btnLastLegging = new JButton("");
        btnLastLegging.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchLeggings(false);
            }
        });
        btnLastLegging.setIcon(new ImageIcon(Main.class.getResource("/temp/images/left_arrow.png")));
        btnLastLegging.setOpaque(false);
        btnLastLegging.setFocusable(false);
        btnLastLegging.setContentAreaFilled(false);
        btnLastLegging.setBorderPainted(false);
        btnLastLegging.setBounds(196, 403, 83, 87);
        panelArmour.add(btnLastLegging);
        
        btnNextChestplate = new JButton("");
        btnNextChestplate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchChestplate(true);
            }
        });
        btnNextChestplate.setIcon(new ImageIcon(Main.class.getResource("/temp/images/arrow.png")));
        btnNextChestplate.setOpaque(false);
        btnNextChestplate.setFocusable(false);
        btnNextChestplate.setContentAreaFilled(false);
        btnNextChestplate.setBorderPainted(false);
        btnNextChestplate.setBounds(542, 271, 83, 87);
        panelArmour.add(btnNextChestplate);
        
        btnLastChestplate = new JButton("");
        btnLastChestplate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchChestplate(false);
            }
        });
        btnLastChestplate.setIcon(new ImageIcon(Main.class.getResource("/temp/images/left_arrow.png")));
        btnLastChestplate.setOpaque(false);
        btnLastChestplate.setFocusable(false);
        btnLastChestplate.setContentAreaFilled(false);
        btnLastChestplate.setBorderPainted(false);
        btnLastChestplate.setBounds(196, 271, 83, 87);
        panelArmour.add(btnLastChestplate);
        
        btnLastHelmet = new JButton("");
        btnLastHelmet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchHelmet(false);
            }
        });
        btnLastHelmet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
            }
        });
        btnLastHelmet.setIcon(new ImageIcon(Main.class.getResource("/temp/images/left_arrow.png")));
        btnLastHelmet.setOpaque(false);
        btnLastHelmet.setFocusable(false);
        btnLastHelmet.setContentAreaFilled(false);
        btnLastHelmet.setBorderPainted(false);
        btnLastHelmet.setBounds(196, 139, 83, 87);
        panelArmour.add(btnLastHelmet);
        
        btnNextHelmet = new JButton("");
        btnNextHelmet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchHelmet(true);
            }
        });
        btnNextHelmet.setIcon(new ImageIcon(Main.class.getResource("/temp/images/arrow.png")));
        btnNextHelmet.setOpaque(false);
        btnNextHelmet.setFocusable(false);
        btnNextHelmet.setContentAreaFilled(false);
        btnNextHelmet.setBorderPainted(false);
        btnNextHelmet.setBounds(542, 139, 83, 87);
        panelArmour.add(btnNextHelmet);
        
        lblChooseYourArmour = new JLabel("Choose Your Armour");
        lblChooseYourArmour.setHorizontalAlignment(SwingConstants.CENTER);
        lblChooseYourArmour.setForeground(Color.WHITE);
        lblChooseYourArmour.setFont(new Font("Algerian", Font.PLAIN, 30));
        lblChooseYourArmour.setBounds(180, 78, 463, 35);
        panelArmour.add(lblChooseYourArmour);
        
        lblLeggings = new JLabel("");
        lblLeggings.setIcon(new ImageIcon(Main.class.getResource("/temp/images/equipment_thumbnail.png")));
        lblLeggings.setBounds(19, 267, 50, 50);
        panelArmour.add(lblLeggings);
        
        lblChestplate = new JLabel("");
        lblChestplate.setIcon(new ImageIcon(Main.class.getResource("/temp/images/equipment_thumbnail.png")));
        lblChestplate.setBounds(19, 206, 50, 50);
        panelArmour.add(lblChestplate);
        
        lblHelmet = new JLabel("");
        lblHelmet.setIcon(new ImageIcon(Main.class.getResource("/temp/images/equipment_thumbnail.png")));
        lblHelmet.setBounds(19, 145, 50, 50);
        panelArmour.add(lblHelmet);
        
        label_12 = new JLabel("");
        label_12.setIcon(new ImageIcon(Main.class.getResource("/temp/images/taskbar4.png")));
        label_12.setBounds(0, 356, 198, 163);
        panelArmour.add(label_12);
        
        label_7 = new JLabel("");
        label_7.setIcon(new ImageIcon(Main.class.getResource("/temp/images/background2.png")));
        label_7.setBounds(0, 0, 653, 561);
        panelArmour.add(label_7);
        
        panelItems = new JPanel();
        contentPane.add(panelItems, "name_1000085043348417");
        panelItems.setLayout(null);
        
        btnFirstItem = new JButton("");
        btnFirstItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                btnFirstItem.setIcon(items[1]);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnFirstItem.setIcon(items[0]);
            }
        });
        btnFirstItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                purchaseItem(1, HEALTH1);
            }
        });
        
        btnBackFromItems = new JButton("");
        btnBackFromItems.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setDisplayPanel(2);
                setupHomePage();
            }
        });
        
        lblItemMoney = new JLabel("stub");
        lblItemMoney.setForeground(Color.WHITE);
        lblItemMoney.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblItemMoney.setBounds(371, 525, 75, 29);
        panelItems.add(lblItemMoney);
        
        lblYourMoney = new JLabel("Your money:");
        lblYourMoney.setForeground(Color.WHITE);
        lblYourMoney.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblYourMoney.setBounds(206, 525, 124, 29);
        panelItems.add(lblYourMoney);
        
        label_15 = new JLabel("New label");
        label_15.setIcon(new ImageIcon(Main.class.getResource("/temp/images/gold36x39.png")));
        label_15.setBounds(337, 524, 39, 36);
        panelItems.add(label_15);
        
        lblItemSlot3 = new JLabel("");
        lblItemSlot3.setIcon(new ImageIcon(Main.class.getResource("/temp/images/equipment_thumbnail.png")));
        lblItemSlot3.setBounds(360, 394, 50, 50);
        panelItems.add(lblItemSlot3);
        
        lblItemSlot2 = new JLabel("");
        lblItemSlot2.setIcon(new ImageIcon(Main.class.getResource("/temp/images/equipment_thumbnail.png")));
        lblItemSlot2.setBounds(300, 394, 50, 50);
        panelItems.add(lblItemSlot2);
        
        lblItemSlot1 = new JLabel("");
        lblItemSlot1.setIcon(new ImageIcon(Main.class.getResource("/temp/images/equipment_thumbnail.png")));
        lblItemSlot1.setBounds(240, 394, 50, 50);
        panelItems.add(lblItemSlot1);
        
        lblInventory = new JLabel("Inventory");
        lblInventory.setHorizontalAlignment(SwingConstants.CENTER);
        lblInventory.setForeground(Color.WHITE);
        lblInventory.setFont(new Font("Algerian", Font.PLAIN, 30));
        lblInventory.setBounds(10, 348, 633, 35);
        panelItems.add(lblInventory);
        btnBackFromItems.setIcon(new ImageIcon(Main.class.getResource("/temp/images/backFromWeapons.png")));
        btnBackFromItems.setOpaque(false);
        btnBackFromItems.setFocusable(false);
        btnBackFromItems.setContentAreaFilled(false);
        btnBackFromItems.setBorderPainted(false);
        btnBackFromItems.setBounds(10, 11, 162, 58);
        panelItems.add(btnBackFromItems);
        
        btnThirdItem = new JButton("");
        btnThirdItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                purchaseItem(3, DEFENSE);
            }
        });
        btnThirdItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnThirdItem.setIcon(items[5]);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnThirdItem.setIcon(items[4]);
            }
        });
        btnThirdItem.setIcon(new ImageIcon(Main.class.getResource("/temp/images/defense.png")));
        btnThirdItem.setOpaque(false);
        btnThirdItem.setFocusable(false);
        btnThirdItem.setContentAreaFilled(false);
        btnThirdItem.setBorderPainted(false);
        btnThirdItem.setBounds(472, 159, 150, 150);
        panelItems.add(btnThirdItem);
        
        btnSecondItem = new JButton("");
        btnSecondItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                purchaseItem(2, HEALTH2);
            }
        });
        btnSecondItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSecondItem.setIcon(items[3]);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnSecondItem.setIcon(items[2]);
            }
        });
        btnSecondItem.setIcon(new ImageIcon(Main.class.getResource("/temp/images/health2.png")));
        btnSecondItem.setOpaque(false);
        btnSecondItem.setFocusable(false);
        btnSecondItem.setContentAreaFilled(false);
        btnSecondItem.setBorderPainted(false);
        btnSecondItem.setBounds(248, 159, 150, 150);
        panelItems.add(btnSecondItem);
        btnFirstItem.setIcon(new ImageIcon(Main.class.getResource("/temp/images/health1.png")));
        btnFirstItem.setOpaque(false);
        btnFirstItem.setFocusable(false);
        btnFirstItem.setContentAreaFilled(false);
        btnFirstItem.setBorderPainted(false);
        btnFirstItem.setBounds(31, 159, 150, 150);
        panelItems.add(btnFirstItem);
        
        label_14 = new JLabel("");
        label_14.setIcon(new ImageIcon(Main.class.getResource("/temp/images/taskbar2.png")));
        label_14.setBounds(0, 521, 650, 39);
        panelItems.add(label_14);
        
        lblBuyItems = new JLabel("buy items");
        lblBuyItems.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuyItems.setForeground(Color.WHITE);
        lblBuyItems.setFont(new Font("Algerian", Font.PLAIN, 30));
        lblBuyItems.setBounds(0, 89, 633, 35);
        panelItems.add(lblBuyItems);
        
        label_13 = new JLabel("");
        label_13.setIcon(new ImageIcon(Main.class.getResource("/temp/images/background2.png")));
        label_13.setBounds(0, 0, 653, 560);
        panelItems.add(label_13);
        
        
    }//end constructor
    
    //set a panel to display, turn all others to false
    public void setDisplayPanel(int panel)
    {
        boolean[] state = {false,
                            false,
                            false,
                            false,
                            false,
                            false,
                            false,
                            false,
                            false,
                            false};
        state[panel] = true;
        
        panelSplash.setVisible(state[0]);
        panelCharacter.setVisible(state[1]);
        panelHome.setVisible(state[2]);
        panelWeapons.setVisible(state[3]);
        panelOpponents.setVisible(state[4]);
        panelCombat.setVisible(state[5]);
        panelVictory.setVisible(state[6]);
        panelDefeat.setVisible(state[7]);
        panelArmour.setVisible(state[8]);
        panelItems.setVisible(state[9]);
    }
    
    
    
   
    //-------------SELECT CHARACTER PANEL-----------------------------------
    
    
    
    //called from arrow buttons, changes character stat images
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
    
    //called from select button 
    //validate name string
    //instance player and start homepage
    public void selectCharacter()
    {
        String name = textName.getText();
        if(name.equals(""))
        {
            JOptionPane.showMessageDialog (null, "Enter a name.", "Enter Name", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if(validate_name(name))
            {
                if(characterStatsArrayIndex == 0) //dba
                        player = (Character) new DBADev();
                if(characterStatsArrayIndex == 1) //sys
                        player = (Character) new SysAdmin();
                if(characterStatsArrayIndex == 2) //prog
                        player = (Character) new Programmer();
                if(characterStatsArrayIndex == 3) //web
                        player = (Character) new WebDev();
                player.setName(name);
                setDisplayPanel(2);
                setupHomePage();
            } else {
                JOptionPane.showMessageDialog (null, "Invaid Name.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    //validate string for valid characters and 100 char length
    public boolean validate_name(String s)
    {
        String validChars = "abcdefghijklmnopqrstuvwxyz' ";
        char testChar;
        String input = s.toLowerCase();
        
        for (int i = 0; i < input.length(); i++)
        {
            testChar = input.charAt(i);
            if (validChars.indexOf(testChar) < 0)
                return false; // if invalid
        }
        
        if(input.length() > 100)
            return false;
         
        return true; 
    } 
    
    
    
    
    //-------------HOME PANEL-----------------------------------
    
    
    
    
    
    //setup labels and update information on home panel
    public void setupHomePage()
    {
        lblName.setText(player.getName());
        lblHomeTitle.setText(player.getName() + " the " + player.getCharacterClass());
        lblCharacterClass.setText(player.getCharacterClass());
        lblMoney.setText(Integer.toString(player.getMoney()));
        lblCharacterMainPic.setIcon(player.getPicture239x318());
        lblHomeInv1.setIcon(itemThumbs[inventory[0]]);
        lblHomeInv2.setIcon(itemThumbs[inventory[1]]);
        lblHomeInv3.setIcon(itemThumbs[inventory[2]]);
        homeArmourThumbnails();
        
        
        if(!(currentWeapon==0))
            {lblHomeDuribility.setText(Integer.toString(player.getWeapon().getDurability()));
        } else {
            lblHomeDuribility.setText("");
        }
        
        lblWeaponThumbnail.setIcon(weaponThumbnails[currentWeapon]);
        
        homeHPBar();
    }
    
    //set value of HP bar on home panel
    public void homeHPBar()
    {
        double currentHp = (double) player.getHp();
        double maxHp = (double) player.getMaxHP();
        double hpPercent = (currentHp / maxHp)*100;

        
        lblHomeHp.setText(player.getHp()+" / "+player.getMaxHP());
        
        if(hpPercent>90)
            lblHomeHPBar.setIcon(hpBar[8]);
        else if(hpPercent>80)
            lblHomeHPBar.setIcon(hpBar[7]);
        else if(hpPercent>70)
            lblHomeHPBar.setIcon(hpBar[6]);
        else if(hpPercent>60)
            lblHomeHPBar.setIcon(hpBar[5]);  
        else if(hpPercent>50)
            lblHomeHPBar.setIcon(hpBar[4]);
        else if(hpPercent>40)
            lblHomeHPBar.setIcon(hpBar[3]);
        else if(hpPercent>30)
            lblHomeHPBar.setIcon(hpBar[2]);
        else if(hpPercent>20)
            lblHomeHPBar.setIcon(hpBar[1]);
        else if(hpPercent<=20)
            lblHomeHPBar.setIcon(hpBar[0]);
    }
    
    //set armour thumbnails on homepage
    public void homeArmourThumbnails()
    {
        lblDefenseThumbnail1.setIcon(helmetThumbs[currentHelmet]);
        lblDefenseThumbnail2.setIcon(chestplateThumbs[currentChestplate]);
        lblDefenseThumbnail3.setIcon(leggingsThumbs[currentLeggings]);
    }
    
    
    
    //-------------WEAPONS PANEL-----------------------------------
    
    
    
    
    //setup labels on weapons panel
    public void setupWeaponPanel()
    {
        if(currentWeapon == weaponStatsArrayIndex)
            btnWeaponSelect.setIcon(weaponSelect[1]);
        else
            btnWeaponSelect.setIcon(weaponSelect[2]);
        
        lblMoneyWeapons.setText(Integer.toString(player.getMoney()));
    }
    
    
    //selected from arrow buttons
    //sets stat images from array
    public void switchWeapon(boolean next)
    {
        if(next)
        {
            if(weaponStatsArrayIndex == weaponStats.length-1)
                weaponStatsArrayIndex = 0;
            else
                weaponStatsArrayIndex++;
                    
            lblWeaponStats.setIcon(weaponStats[weaponStatsArrayIndex]);
        } else {
            if(weaponStatsArrayIndex == 0)
                weaponStatsArrayIndex = weaponStats.length-1;
            else
                weaponStatsArrayIndex--;
            
            lblWeaponStats.setIcon(weaponStats[weaponStatsArrayIndex]);
        }
        setupWeaponPanel();
    }
    
    //called from purchase weapon button
    //instance weapon
    public void selectWeapon()
    {
        boolean equip = false;
        int cost=0;
        if(!(currentWeapon == weaponStatsArrayIndex))
        {
            if(weaponStatsArrayIndex==0 && player.getMoney()>FISTCOST)
            {
                equip = true;
                cost = FISTCOST;
            }    
            if(weaponStatsArrayIndex==1 && player.getMoney()>WOODCOST)
            {
                equip = true;
                cost=WOODCOST;
            }  
            if(weaponStatsArrayIndex==2 && player.getMoney()>IRONCOST)
            {
                equip = true;
                cost=IRONCOST;
            }  
            if(weaponStatsArrayIndex==3 && player.getMoney()>DIAMONDCOST)
            {
                equip = true;
                cost = DIAMONDCOST;
            }     
        }
        
        if(equip)
        {
            int reply = JOptionPane.showConfirmDialog(null, "Confirm "+cost+" gold purchase.", "Buy Weapon", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                currentWeapon = weaponStatsArrayIndex;
                player.equip(weaponStatsArrayIndex);
                player.setMoney(player.getMoney()-player.getWeapon().getCost()); 
            }
            setDisplayPanel(2);
            setupHomePage();
        } else {
            JOptionPane.showMessageDialog (null, "Not enough gold.", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    
    
    
    //-------------OPPONENTS PANEL-----------------------------------
    
    
    
    
    
    public void switchOpponent(boolean next)
    {
        if(next)
        {
            if(opponentStatsArrayIndex == opponentStats.length-1)
                opponentStatsArrayIndex = 0;
            else
                opponentStatsArrayIndex++;
                    
            lblOpponentStats.setIcon(opponentStats[opponentStatsArrayIndex]);
        } else {
            if(opponentStatsArrayIndex == 0)
                opponentStatsArrayIndex = opponentStats.length-1;
            else
                opponentStatsArrayIndex--;
            
            lblOpponentStats.setIcon(opponentStats[opponentStatsArrayIndex]);
        }
        
    }
    
    //instance opponent
    //start combat
    public void selectOpponent()
    {
        if(opponentStatsArrayIndex==0)
            opponent = (Opponent) new Flower();
        if(opponentStatsArrayIndex==1)
            opponent = (Opponent) new Spider();
        if(opponentStatsArrayIndex==2)
            opponent = (Opponent) new Zombie();
        if(opponentStatsArrayIndex==3)
            opponent = (Opponent) new Creeper();
        
        currentOpponent=opponentStatsArrayIndex;
        
        setDisplayPanel(5);
        setupCombatPanel();
    }
    
    
    
    
    
    //-------------ARMOUR PANEL-----------------------------------
    
    
    
    //prepare armour panel
    //display current armour info and reset index values
    public void setupArmourPanel()
    {
        lblHelmetStats.setIcon(helmetStats[0]);
        lblChestplateStats.setIcon(chestplateStats[0]);
        lblLeggingsStat.setIcon(leggingStats[0]);
        lblArmourMoney.setText(Integer.toString(player.getMoney()));
        
        helmetStatsArrayIndex=0;
        chestplateStatsArrayIndex=0;
        leggingsStatsArrayIndex=0;
        
        lblArmourCost.setText(Integer.toString(updatePrice()));
        armourThumbnails();
    }
    
    //next three methods enable switching between the three types of armour
    public void switchHelmet(boolean next)
    {
        if(next)
        {
            if(helmetStatsArrayIndex == helmetStats.length-1)
                helmetStatsArrayIndex = 0;
            else
                helmetStatsArrayIndex++;
                    
            lblHelmetStats.setIcon(helmetStats[helmetStatsArrayIndex]);
        } else {
            if(helmetStatsArrayIndex == 0)
                helmetStatsArrayIndex = helmetStats.length-1;
            else
                helmetStatsArrayIndex--;
            
            lblHelmetStats.setIcon(helmetStats[helmetStatsArrayIndex]);
        }
        
        lblArmourCost.setText(Integer.toString(updatePrice()));
    }
    
    public void switchChestplate(boolean next)
    {
        if(next)
        {
            if(chestplateStatsArrayIndex == chestplateStats.length-1)
                chestplateStatsArrayIndex = 0;
            else
                chestplateStatsArrayIndex++;
                    
            lblChestplateStats.setIcon(chestplateStats[chestplateStatsArrayIndex]);
        } else {
            if(chestplateStatsArrayIndex == 0)
                chestplateStatsArrayIndex = chestplateStats.length-1;
            else
                chestplateStatsArrayIndex--;
            
            lblChestplateStats.setIcon(chestplateStats[chestplateStatsArrayIndex]);
        }
        lblArmourCost.setText(Integer.toString(updatePrice()));
    }
    
    public void switchLeggings(boolean next)
    {
        if(next)
        {
            if(leggingsStatsArrayIndex == leggingStats.length-1)
                leggingsStatsArrayIndex = 0;
            else
                leggingsStatsArrayIndex++;
                    
            lblLeggingsStat.setIcon(leggingStats[leggingsStatsArrayIndex]);
        } else {
            if(leggingsStatsArrayIndex == 0)
                leggingsStatsArrayIndex = leggingStats.length-1;
            else
                leggingsStatsArrayIndex--;
            
            lblLeggingsStat.setIcon(leggingStats[leggingsStatsArrayIndex]);
        }
        lblArmourCost.setText(Integer.toString(updatePrice()));
    }
    
    //calculate the price of the current armour outfit displayed
    public int updatePrice()
    {
        int cost=0;
        
        //helmet cost
        if(helmetStatsArrayIndex==1)
            cost = cost +COPPERARMOUR;
        if(helmetStatsArrayIndex==2)
            cost = cost +IRONARMOUR;
        if(helmetStatsArrayIndex==3)
            cost = cost +DIAMONDARMOUR;
        
      //chestplate cost
        if(chestplateStatsArrayIndex==1)
            cost = cost +COPPERARMOUR;
        if(chestplateStatsArrayIndex==2)
            cost = cost +IRONARMOUR;
        if(chestplateStatsArrayIndex==3)
            cost = cost +DIAMONDARMOUR;
        
      //leggings cost
        if(leggingsStatsArrayIndex==1)
            cost = cost +COPPERARMOUR;
        if(leggingsStatsArrayIndex==2)
            cost = cost +IRONARMOUR;
        if(leggingsStatsArrayIndex==3)
            cost = cost +DIAMONDARMOUR;
        
        return cost;
    }
    
    //purchase armour
    public void equipArmour()
    {
        if(player.getMoney()>=updatePrice())
        {
            int reply = JOptionPane.showConfirmDialog(null, "Confirm "+updatePrice()+" gold purchase.", "Buy Armour", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
            {
                player.setMoney(player.getMoney()-updatePrice());
                
                if(!(helmetStatsArrayIndex==0))
                {
                    player.equipArmour(helmetStatsArrayIndex, 0);
                    currentHelmet = helmetStatsArrayIndex;
                }
                if(!(chestplateStatsArrayIndex==0))
                {
                    player.equipArmour(chestplateStatsArrayIndex, 1);
                    currentChestplate = chestplateStatsArrayIndex;
                }
                if(!(leggingsStatsArrayIndex==0))
                {
                    player.equipArmour(leggingsStatsArrayIndex, 2);
                    currentLeggings = leggingsStatsArrayIndex;
                }
                setDisplayPanel(2);
                setupHomePage();
            } 
        } else {
            JOptionPane.showMessageDialog (null, "Not enough gold.", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
        
        //cheat to get extra money
        if(updatePrice()==0)
        {
        	if(!usedCheatCode)
        	{
        		JOptionPane.showMessageDialog (null, "Why would you try to buy no armour? Poor guy, here's 500 gold.", "Message", JOptionPane.INFORMATION_MESSAGE);
	        	player.setMoney(player.getMoney()+500);
	        	usedCheatCode = true;
	        	setDisplayPanel(2);
	            setupHomePage();
        	} else {
        		JOptionPane.showMessageDialog (null, "Trying to get more free gold, huh? -100 gold!", "Message", JOptionPane.INFORMATION_MESSAGE);
        		player.setMoney(player.getMoney()-100);
        		setDisplayPanel(2);
	            setupHomePage();
        	}
    	} 	
    }
    
    //update thumbnails on the armour panel
    public void armourThumbnails()
    {
        lblHelmet.setIcon(helmetThumbs[currentHelmet]);
        lblChestplate.setIcon(chestplateThumbs[currentChestplate]);
        lblLeggings.setIcon(leggingsThumbs[currentLeggings]);
    }
    
    
    
    
    //-------------ITEMS PANEL-----------------------------------
    
    
    
    
    //prepare items panel by setting current inventory and money label
    public void setupItemsPanel()
    {
        lblItemMoney.setText(Integer.toString(player.getMoney()));
        
        lblItemSlot1.setIcon(itemThumbs[inventory[0]]);
        lblItemSlot2.setIcon(itemThumbs[inventory[1]]);
        lblItemSlot3.setIcon(itemThumbs[inventory[2]]);
    }
    
    //on item click, attempt to purchase
    public void purchaseItem(int item, int cost)
    {
        boolean purchase = false;
        if(player.getMoney()>=cost)
        {
            int reply = JOptionPane.showConfirmDialog(null, "Confirm "+cost+" gold purchase.", "Buy Armour", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
            {
                for(int x=0;x<inventory.length;x++)
                {
                    if(inventory[x]==0)
                    {
                        inventory[x] = item;
                        player.setMoney(player.getMoney() - cost);
                        setupItemsPanel();
                        purchase = true;
                    }
                    if(purchase)
                        break;
                }
                if(!purchase)
                    JOptionPane.showMessageDialog (null, "Inventory Full", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog (null, "Not enough gold.", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    
    
    //-------------COMBAT PANEL-----------------------------------
     
    
    
    
    public void setupCombatPanel()
    {
        lblCombatTitle.setText(player.getName()+" VS "+opponent.getName());
        lblPlayerImage.setIcon(player.getPicture150x250());
        lblOpponentImage.setIcon(opponent.getPicture150x250());
        lblCombatWeapon.setIcon(weaponThumbnails[currentWeapon]);
        btnItem1.setIcon(itemThumbs[inventory[0]]);
        btnItem2.setIcon(itemThumbs[inventory[1]]);
        btnItem3.setIcon(itemThumbs[inventory[2]]);
        updatePlayerHPBar();
        updateOpponentHPBar();
        updateDurability();
        
        txtCombat.setText(null);
        textAreaLines=0;
        canRun = true;
        
        timer.start();
    }
    
    public void updatePlayerHPBar()
    {
        double currentHp = (double) player.getHp();
        double maxHp = (double) player.getMaxHP();
        double hpPercent = (currentHp / maxHp)*100;

        
        lblPlayerHPText.setText(player.getHp()+" / "+player.getMaxHP());
        
        if(hpPercent>90)
            lblPlayerHP.setIcon(hpBar[8]);
        else if(hpPercent>80)
            lblPlayerHP.setIcon(hpBar[7]);
        else if(hpPercent>70)
            lblPlayerHP.setIcon(hpBar[6]);
        else if(hpPercent>60)
            lblPlayerHP.setIcon(hpBar[5]);  
        else if(hpPercent>50)
            lblPlayerHP.setIcon(hpBar[4]);
        else if(hpPercent>40)
            lblPlayerHP.setIcon(hpBar[3]);
        else if(hpPercent>30)
            lblPlayerHP.setIcon(hpBar[2]);
        else if(hpPercent>20)
            lblPlayerHP.setIcon(hpBar[1]);
        else if(hpPercent<=20)
            lblPlayerHP.setIcon(hpBar[0]);
    }
    
    public void updateOpponentHPBar()
    {
        double currentHp = (double) opponent.getHp();
        double maxHp = (double) opponent.getMaxHp();
        double hpPercent = (currentHp / maxHp)*100;

        
        lblOpponentHPText.setText(opponent.getHp()+" / "+opponent.getMaxHp());
        
        if(hpPercent>90)
            lblOpponentHP.setIcon(hpBar[8]);
        else if(hpPercent>80)
            lblOpponentHP.setIcon(hpBar[7]);
        else if(hpPercent>70)
            lblOpponentHP.setIcon(hpBar[6]);
        else if(hpPercent>60)
            lblOpponentHP.setIcon(hpBar[5]);  
        else if(hpPercent>50)
            lblOpponentHP.setIcon(hpBar[4]);
        else if(hpPercent>40)
            lblOpponentHP.setIcon(hpBar[3]);
        else if(hpPercent>30)
            lblOpponentHP.setIcon(hpBar[2]);
        else if(hpPercent>20)
            lblOpponentHP.setIcon(hpBar[1]);
        else if(hpPercent<=20)
            lblOpponentHP.setIcon(hpBar[0]);
    }
    
    
    //timer handler
    class MyTimerActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

          if(running)
          {
              if(runCount>=5)
              {
                  runCount=0;
                  running = false;
                  
                  Random r = new Random();
                  if(r.nextInt(4) == 1)
                  {
                      timer.stop();
                      player.setDefensePotion(false);
                      setDisplayPanel(2);
                      setupHomePage();
                  } else {
                      txtCombat.append("Run Failed.\n");
                      textAreaLines++;
                      canRun = false;
                  }
              } else
                  runCount++;
          }
            
          //player attack
          if(playerAttackDelay>player.getSpeed())
          {
              playerAttackDelay=0;
              
              int damage = opponent.defense(player.attack());
              opponent.setHp(opponent.getHp()-damage);
              
              clearTextArea();
              txtCombat.append(player.getName()+" hits for "+damage+" points\n");
              textAreaLines++;
              
          } else {
              playerAttackDelay++;
          }
          
          //opponent attack
          if(opponentAttackDelay>opponent.getSpeed())
          {
              opponentAttackDelay=0;
              
              int damage = player.defense(opponent.attack(), currentOpponent);
              player.setHp(player.getHp()-damage);
              
              clearTextArea();
              txtCombat.append("\t"+opponent.getName()+" hits for "+damage+" points\n");
              textAreaLines++;
          } else {
              opponentAttackDelay++;
          }
            
          updatePlayerHPBar();
          updateOpponentHPBar();
          updateDurability();
          checkWeapon();
          checkForWinner();
        }
      }
    
    public void useItem(int slot)
    {
        if(inventory[slot]==1)
        {
            inventory[slot] = 0;
            lblItemSlot1.setIcon(items[0]);
            player.setHp(player.getHp()+25);
        }
        if(inventory[slot]==2)
        {
            inventory[slot] = 0;
            lblItemSlot1.setIcon(items[0]);
            player.setHp(player.getHp()+100);
        }
        if(inventory[slot]==3)
        {
            inventory[slot] = 0;
            lblItemSlot1.setIcon(items[0]);
            player.setDefensePotion(true);
        }
        
        btnItem1.setIcon(itemThumbs[inventory[0]]);
        btnItem2.setIcon(itemThumbs[inventory[1]]);
        btnItem3.setIcon(itemThumbs[inventory[2]]);
    }
    
    public void checkForWinner()
    {
        if(player.getHp()<=0)
        {
            timer.stop();
            player.setDefensePotion(false);
            setDisplayPanel(7);
        }
        if(opponent.getHp()<=0)
        {
            timer.stop();
            player.setDefensePotion(false);
            setDisplayPanel(6);
            setupVictoryPanel();
        }
    }
    
    public void updateDurability()
    {
    	  if(currentWeapon==0)
        	  lblWeaponDurability.setText("N/A");
          else
        	  lblWeaponDurability.setText(Integer.toString(player.getWeapon().getDurability()));
    }
    
    public void checkWeapon()
    {
    	if(!(currentWeapon==0))
    	{
    		if(player.getWeapon().getDurability() <= 0)
        	{
        		currentWeapon = 0;
                player.equip(0);
                lblCombatWeapon.setIcon(weaponThumbnails[currentWeapon]);
        		txtCombat.append("WEAPON BREAKS!\n");
                textAreaLines++;
        	}
        }
	}
    	
    public void run()
    {
        if(canRun)
        {
            txtCombat.append("RUNING...\n");
            textAreaLines++;
            running = true;
        } else {
            txtCombat.append("You can't run again\n");
            textAreaLines++;
        }
        
    }
    
    public void clearTextArea()
    {
        if(textAreaLines>=12)
        {
            txtCombat.setText(null);
            textAreaLines=0;
        }
    }
    
    public void restartGame()
    {
    	player.setWeapon(null);
    	player = null;
    	currentWeapon=0;
    	currentHelmet=0;
    	currentChestplate=0;
    	currentLeggings=0;
        playerAttackDelay=5;
        opponentAttackDelay=5;
        textAreaLines=0;
        usedCheatCode = false;
    	setDisplayPanel(1);
    }
    
    
    
    
    //-------------------VICTORY PANEL-----------------
    
    
    
    //displays reward information and allows a 1/4 chance bonus potion
    public void setupVictoryPanel()
    {
    	lblRewardAmount.setText(Integer.toString(opponent.getReward()));
        player.setMoney(player.getMoney()+opponent.getReward());
        
        lblBonus.setVisible(false);
        lblBonus2.setVisible(false);
        lblBonus3.setVisible(false);
        
        Random r = new Random();
        boolean bonus = false;
        if(r.nextInt(4)==1)
        {
        	for(int x=0;x<inventory.length;x++)
        	{
        		if(inventory[x]==0)
        		{
        			inventory[x] = 1;
        			bonus = true;
        			lblBonus.setVisible(true);
                    lblBonus2.setVisible(true);
                    lblBonus3.setVisible(true);
        		}
        		if(bonus)
        			break;
        	}
        }
    }
    
}