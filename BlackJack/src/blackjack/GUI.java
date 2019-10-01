package blackjack;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;

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
    Font fontButton = new Font("Times New Roman", Font.PLAIN, 25);
    
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
    }
}
