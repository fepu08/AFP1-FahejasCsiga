package blackjack;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import blackjack.GUI.ActHit;
import blackjack.GUI.ActNo;
import blackjack.GUI.ActRules;
import blackjack.GUI.ActStand;
import blackjack.GUI.ActYes;

public class GUI extends JFrame{
	//randomizer for cards
    Random rnd = new Random();
	
	//button color
    Color colorButton = Color.yellow;

    //buttons
    JButton bHit = new JButton();
    JButton bStand = new JButton();
    JButton bYes = new JButton();
    JButton bNo = new JButton();
    JButton bRules = new JButton();
    
    //fonts
    Font fontQuest = new Font("Times New Roman", Font.BOLD, 40);
    Font fontButton = new Font("Times New Roman", Font.PLAIN, 25);
    Font fontLogo = new Font("Times New Roman", Font.BOLD, 80);

    
    //screen resolution
    int sW = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int sH = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    //window resolution
    int aW = 1300;
    int aH = 800;
    
    //deck
    Deck deck = new Deck();
    
    //player and dealer card array
    ArrayList<Card> pCards = new ArrayList<Card>();
    ArrayList<Card> dCards = new ArrayList<Card>();
    
    //player and dealer totals
    int pMinTotal = 0;
    int pMaxTotal = 0;
    int dMinTotal = 0;
    int dMaxTotal = 0;
    
    //boolean for stages
    boolean hit_stay_q = true;
    boolean dealer_turn = false;
    boolean play_more_q = false;
    boolean dHitter = false;

    public GUI() throws IOException {
    	this.setTitle("Blackjack");
        this.setBounds((sW - aW - 6) / 2, (sH - aH - 29) / 2, aW + 6, aH + 29);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Board board = new Board();
        this.setContentPane(board);
        board.setLayout(null);
        Move move = new Move();
        this.addMouseMotionListener(move);

        Click click = new Click();
        this.addMouseListener(click);
        
        //button stuff

        ActHit actHit = new ActHit();
        bHit.addActionListener(actHit);
        bHit.setBounds(1000, 200, 100, 50);
        bHit.setBackground(colorButton);
        bHit.setFont(fontButton);
        bHit.setText("HIT");
        board.add(bHit);

        ActStand actStand = new ActStand();
        bStand.addActionListener(actStand);
        bStand.setBounds(1130, 200, 130, 50);
        bStand.setBackground(colorButton);
        bStand.setFont(fontButton);
        bStand.setText("STAND");
        board.add(bStand);

        ActYes actYes = new ActYes();
        bYes.addActionListener(actYes);
        bYes.setBounds(1000, 600, 100, 50);
        bYes.setBackground(colorButton);
        bYes.setFont(fontButton);
        bYes.setText("YES");
        board.add(bYes);

        ActNo actNo = new ActNo();
        bNo.addActionListener(actNo);
        bNo.setBounds(1150, 600, 100, 50);
        bNo.setBackground(colorButton);
        bNo.setFont(fontButton);
        bNo.setText("NO");
        board.add(bNo);
        
        ActRules actRules = new ActRules();
        bRules.addActionListener(actRules);
        bRules.setBounds(40, 50, 50, 50);
        bRules.setBackground(colorButton);
        bRules.setFont(fontButton);
        bRules.setText("?");
        board.add(bRules);
    }
    public class Board extends JPanel {

        public void paintComponent(Graphics g) {
            //background
            Image img = null;
            try {
                img = ImageIO.read(new File("background.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(img, 0, 0, null);
            
            //blackjack logo
            g.setColor(Color.YELLOW);
            g.setFont(fontLogo);
            g.drawString("Blackjack", 290, 120);
            
            //who's hand
            g.setColor(Color.black);
            g.setFont(fontQuest);
            g.drawString("Your hand:", 350, 190);
            g.drawString("Dealer's hand:", 320, 450);
            
          
            
            
            
            
			}
			
        }
    
    public class Move implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent arg0) {

        }

        @Override
        public void mouseMoved(MouseEvent arg0) {

        }

    }

    public class Click implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent arg0) {

        }

        @Override
        public void mouseEntered(MouseEvent arg0) {

        }

        @Override
        public void mouseExited(MouseEvent arg0) {

        }

        @Override
        public void mousePressed(MouseEvent arg0) {

        }

        @Override
        public void mouseReleased(MouseEvent arg0) {

        }

    }
    public class ActYes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            deck.RefreshCards();
            pCards.clear();
            dCards.clear();
            play_more_q = false;
            hit_stay_q = true;
            int random = rnd.nextInt(52);
            pCards.add(deck.getCards().get(random));
            deck.getCards().get(random).used = true;
            while (deck.getCards().get(random).used == true) {
                random = rnd.nextInt(52);
            }
            dCards.add(deck.getCards().get(random));
            deck.getCards().get(random).used = true;
            random = rnd.nextInt(52);
            while (deck.getCards().get(random).used == true) {
                random = rnd.nextInt(52);
            }
            pCards.add(deck.getCards().get(random));
            deck.getCards().get(random).used = true;
            random = rnd.nextInt(52);
            while (deck.getCards().get(random).used == true) {
                random = rnd.nextInt(52);
            }
            dCards.add(deck.getCards().get(random));
            deck.getCards().get(random).used = true;

        }
    }
    public class ActHit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (hit_stay_q == true) {

                int tempMax = 0;
                if (pMaxTotal <= 21) {
                    tempMax = pMaxTotal;
                } else {
                    tempMax = pMinTotal;
                }
                int random = rnd.nextInt(52);
                while (deck.getCards().get(random).used == true) {
                    random = rnd.nextInt(52);
                }
                pCards.add(deck.getCards().get(random));
                deck.getCards().get(random).used = true;

            }
        }
    }
    public class ActStand implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (hit_stay_q == true) {

                int tempMax = 0;
                if (pMaxTotal <= 21) {
                    tempMax = pMaxTotal;
                } else {
                    tempMax = pMinTotal;
                }
                hit_stay_q = false;
                dealer_turn = true;
            }
        }
    }
    public class ActNo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }

    }
    public class ActRules implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        	JOptionPane.showMessageDialog(null, "A Blackjack egy kártyajáték, melyet 52 lapos francia kártyával játszanak dzsókerek nélkül.\r\n" + 
        			"A játék célja, hogy a játékos lapjai összértéke minél közelebb legyen a huszonegyhez, de azt ne lépje túl.\r\n" + 
        			"A játékot egy játékos játssza és a gép, aki az osztó. A játékot az nyeri, akinek a lapjainak az értéke nagyobb. Az osztó addig húz lapot, amíg a lapjainak az értéke\r\n" + 
        			"el nem éri legalább a 17-et.\r\n" + "Akkor van az egyik félnek Blackjack-je, ha az elsõ két kapott lap összértéke 21.\r\n" + "Ha valamelyik fél túllépné a 21-et, akkor azt úgy szokás mondani, hogy besokallt(angolul bust).\r\n"+
        			"Hit - lapkérés\r\n"+"Stand - Megállás", "Help", JOptionPane.PLAIN_MESSAGE);
        }

    }
}
