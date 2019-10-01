package blackjack;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class GUI extends JFrame {
    //randomizer for cards
    Random rnd = new Random();

    //strings
    String questHitStay = new String("Hit or Stand?");
    String questPlayMore = new String("Play more?");
    String winner = new String();

    //button color
    Color colorButton = Color.yellow;

    //buttons
    JButton bHit = new JButton();
    JButton bStand = new JButton();
    JButton bYes = new JButton();
    JButton bNo = new JButton();
    JButton bRules = new JButton();

    //screen resolution
    int sW = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int sH = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    //window resolution
    int aW = 1300;
    int aH = 800;

    //card grid position and dimensions
    int gridX = 50;
    int gridY = 50;
    int gridW = 900;
    int gridH = 400;

    //deck
    Deck deck = new Deck();

    //card spacing and dimensions
    int spacing = 10;
    int rounding = 10;
    int tCardW = (int) gridW / 6;
    int tCardH = (int) gridH / 2;
    int cardW = tCardW - spacing * 2;
    int cardH = tCardH - spacing * 2;

    //boolean for stages
    boolean hit_stay_q = true;
    boolean dealer_turn = false;
    boolean play_more_q = false;
    boolean dHitter = false;

    //player and dealer card array
    ArrayList<Card> pCards = new ArrayList<Card>();
    ArrayList<Card> dCards = new ArrayList<Card>();
    
    //player and dealer totals
    int pMinTotal = 0;
    int pMaxTotal = 0;
    int dMinTotal = 0;
    int dMaxTotal = 0;

    //fonts
    Font fontQuest = new Font("Times New Roman", Font.BOLD, 40);
    Font fontButton = new Font("Times New Roman", Font.PLAIN, 25);
    Font fontLogo = new Font("Times New Roman", Font.BOLD, 80);


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

    
    public void refresher() {

        if (hit_stay_q == true) {
            bHit.setVisible(true);
            bStand.setVisible(true);
        } else {
            bHit.setVisible(false);
            bStand.setVisible(false);
        }

        if (dealer_turn == true) {
            if (dHitter == false) {}
                
        }

        if (play_more_q == true) {
            bYes.setVisible(true);
            bNo.setVisible(true);
        } else {
            bYes.setVisible(false);
            bNo.setVisible(false);
        }
		
		if ((pMaxTotal == 21 || pMinTotal >= 21) && hit_stay_q == true) {
			int tempMax = 0;
			if (pMaxTotal <= 21) {
				tempMax = pMaxTotal;
			} else {
				tempMax = pMinTotal;
			}
			hit_stay_q = false;
			dealer_turn = true;
		}
		
		if ((dMaxTotal == 21 || dMinTotal >= 21) && dealer_turn == true) {
			int tempMax = 0;
			if (dMaxTotal <= 21) {
				tempMax = dMaxTotal;
			} else {
				tempMax = dMinTotal;
			}
			dealer_turn = false;
			play_more_q = true;
		}
		
		repaint();
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
            
            //questions
            if (hit_stay_q == true) {
                g.setColor(Color.black);
                g.setFont(fontQuest);
                g.drawString(questHitStay, gridX + gridW + 60, gridY + 90);
                g.drawString("Total:", gridX + gridW + 60, gridY + 290);
                if (pMinTotal == pMaxTotal) {
                    g.drawString(Integer.toString(pMaxTotal), gridX + gridW + 60, gridY + 350);
                } else if (pMaxTotal <= 21) {
                    g.drawString(Integer.toString(pMinTotal) + " or " + Integer.toString(pMaxTotal), gridX + gridW + 60, gridY + 350);
                } else {
                    g.drawString(Integer.toString(pMinTotal), gridX + gridW + 60, gridY + 350);
                }
            } else if (play_more_q == true) {
                g.setColor(Color.black);
                g.setFont(fontQuest);
                g.drawString(questPlayMore, gridX + gridW + 70, gridY + 500);
                g.setColor(Color.RED);
                g.drawString(winner, gridX + gridW + 70, gridY + 450);
                
            }            
            
            //player cards
			int index = 0;
			for (Card c : pCards) {
				g.drawImage(c.getCardImage(), 100+index*110, 230, 100, 150, Color.black, null);
				index++;
			}
			//dealer cards
			g.drawImage(dCards.get(0).cardImage, 100, 500, 100, 150, Color.black, null);
			if (dealer_turn == true || play_more_q == true) {
				index=0;
				for (Card c : dCards) {
					g.drawImage(c.getCardImage(), 100+index*110, 500, 100, 150, Color.black, null);
					index++;
				
				}
				g.setColor(Color.black);
				g.setFont(fontQuest);
				g.drawString("Your total: ", gridX+gridW+60, gridY+40);
				if (pMaxTotal <= 21) {
					g.drawString(Integer.toString(pMaxTotal), gridX+gridW+60, gridY+120);
				} else {
					g.drawString(Integer.toString(pMinTotal), gridX+gridW+60, gridY+120);
				}
				g.drawString("Dealer's total: ", gridX+gridW+60, gridY+240);
				if (dMaxTotal <= 21) {
					g.drawString(Integer.toString(dMaxTotal), gridX+gridW+60, gridY+320);
				} else {
					g.drawString(Integer.toString(dMinTotal), gridX+gridW+60, gridY+320);
				}
			}
			
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
            Main.terminator = true;
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
        			"Hit - lapkérés\r\n"+"Stand - Megállás\r\n"+"Push - Ha az osztó és a játékos kártyáinak értéke megegyezik, vagy mind a ketten besokalltak. Ilyenkor egyik fél sem nyer.", "Help", JOptionPane.PLAIN_MESSAGE);
        }

    }
}
