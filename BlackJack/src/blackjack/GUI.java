package blackjack;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
    int dTotal = 0;
    int pTotal = 0;

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
}
