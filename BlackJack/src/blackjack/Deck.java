package blackjack;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;

class Deck {
	ArrayList<Card> Cards = new ArrayList<Card>();
	public Deck() throws IOException{
		Card C1 = new Card("club","2", 2, ImageIO.read(new File("./Cards/2_of_clubs.png")));
		Card C2 = new Card("club","3", 3, ImageIO.read(new File("./Cards/3_of_clubs.png")));
		Card C3 = new Card("club","4", 4, ImageIO.read(new File("./Cards/4_of_clubs.png")));
		Card C4 = new Card("club","5", 5, ImageIO.read(new File("./Cards/5_of_clubs.png")));
		Card C5 = new Card("club","6", 6, ImageIO.read(new File("./Cards/6_of_clubs.png")));
		Card C6 = new Card("club","7", 7, ImageIO.read(new File("./Cards/7_of_clubs.png")));
		Card C7 = new Card("club","8", 8, ImageIO.read(new File("./Cards/8_of_clubs.png")));
		Card C8 = new Card("club","9", 9, ImageIO.read(new File("./Cards/9_of_clubs.png")));
		Card C9 = new Card("club","10", 10, ImageIO.read(new File("./Cards/10_of_clubs.png")));

		Card C10 = new Card("diamond","2", 2, ImageIO.read(new File("./Cards/2_of_diamonds.png")));
		Card C11 = new Card("diamond","3", 3, ImageIO.read(new File("./Cards/3_of_diamonds.png")));
		Card C12 = new Card("diamond","4", 4, ImageIO.read(new File("./Cards/4_of_diamonds.png")));
		Card C13 = new Card("diamond","5", 5, ImageIO.read(new File("./Cards/5_of_diamonds.png")));
		Card C14 = new Card("diamond","6", 6, ImageIO.read(new File("./Cards/6_of_diamonds.png")));
		Card C15 = new Card("diamond","7", 7, ImageIO.read(new File("./Cards/7_of_diamonds.png")));
		Card C16 = new Card("diamond","8", 8, ImageIO.read(new File("./Cards/8_of_diamonds.png")));
		Card C17 = new Card("diamond","9", 9, ImageIO.read(new File("./Cards/9_of_diamonds.png")));
		Card C18 = new Card("diamond","10", 10, ImageIO.read(new File("./Cards/10_of_diamonds.png")));

		Card C19 = new Card("heart","2", 2, ImageIO.read(new File("./Cards/2_of_hearts.png")));
		Card C20 = new Card("heart","3", 3, ImageIO.read(new File("./Cards/3_of_hearts.png")));
		Card C21 = new Card("heart","4", 4, ImageIO.read(new File("./Cards/4_of_hearts.png")));
		Card C22 = new Card("heart","5", 5, ImageIO.read(new File("./Cards/5_of_hearts.png")));
		Card C23 = new Card("heart","6", 6, ImageIO.read(new File("./Cards/6_of_hearts.png")));
		Card C24 = new Card("heart","7", 7, ImageIO.read(new File("./Cards/7_of_hearts.png")));
		Card C25 = new Card("heart","8", 8, ImageIO.read(new File("./Cards/8_of_hearts.png")));
		Card C26 = new Card("heart","9", 9, ImageIO.read(new File("./Cards/9_of_hearts.png")));
		Card C27 = new Card("heart","10", 10, ImageIO.read(new File("./Cards/10_of_hearts.png")));

		Card C28 = new Card("spade","2", 2, ImageIO.read(new File("./Cards/2_of_spades.png")));
		Card C29 = new Card("spade","3", 3, ImageIO.read(new File("./Cards/3_of_spades.png")));
		Card C30 = new Card("spade","4", 4, ImageIO.read(new File("./Cards/4_of_spades.png")));
		Card C31 = new Card("spade","5", 5, ImageIO.read(new File("./Cards/5_of_spades.png")));
		Card C32 = new Card("spade","6", 6, ImageIO.read(new File("./Cards/6_of_spades.png")));
		Card C33 = new Card("spade","7", 7, ImageIO.read(new File("./Cards/7_of_spades.png")));
		Card C34 = new Card("spade","8", 8, ImageIO.read(new File("./Cards/8_of_spades.png")));
		Card C35 = new Card("spade","9", 9, ImageIO.read(new File("./Cards/9_of_spades.png")));
		Card C36 = new Card("spade","10", 10, ImageIO.read(new File("./Cards/10_of_spades.png")));

		Card C37 = new Card("club","jack", 10, ImageIO.read(new File("./Cards/jack_of_clubs.png")));
		Card C38= new Card("diamond","jack", 10, ImageIO.read(new File("./Cards/jack_of_diamonds.png")));
		Card C39 = new Card("heart","jack", 10, ImageIO.read(new File("./Cards/jack_of_hearts.png")));
		Card C40 = new Card("spade","jack", 10, ImageIO.read(new File("./Cards/jack_of_spades.png")));

		Card C41 = new Card("club","queen", 10, ImageIO.read(new File("./Cards/queen_of_clubs.png")));
		Card C42= new Card("diamond","queen", 10, ImageIO.read(new File("./Cards/queen_of_diamonds.png")));
		Card C43 = new Card("heart","queen", 10, ImageIO.read(new File("./Cards/queen_of_hearts.png")));
		Card C44 = new Card("spade","queen", 10, ImageIO.read(new File("./Cards/queen_of_spades.png")));

		Card C45 = new Card("club","king", 10, ImageIO.read(new File("./Cards/king_of_clubs.png")));
		Card C46 = new Card("diamond","king", 10, ImageIO.read(new File("./Cards/king_of_diamonds.png")));
		Card C47 = new Card("heart","king", 10, ImageIO.read(new File("./Cards/king_of_hearts.png")));
		Card C48 = new Card("spade","king", 10, ImageIO.read(new File("./Cards/king_of_spades.png")));

		Card C49 = new Card("club","ace", 1, ImageIO.read(new File("./Cards/ace_of_clubs.png")));
		Card C50 = new Card("diamond","ace", 1, ImageIO.read(new File("./Cards/ace_of_diamonds.png")));
		Card C51 = new Card("heart","ace", 1, ImageIO.read(new File("./Cards/ace_of_hearts.png")));
		Card C52 = new Card("spade","ace", 1, ImageIO.read(new File("./Cards/ace_of_spades.png")));

		Cards.add(C1);
		Cards.add(C2);
		Cards.add(C3);
		Cards.add(C4);
		Cards.add(C5);
		Cards.add(C6);
		Cards.add(C7);
		Cards.add(C8);
		Cards.add(C9);
		Cards.add(C10);
		Cards.add(C11);
		Cards.add(C12);
		Cards.add(C13);
		Cards.add(C14);
		Cards.add(C15);
		Cards.add(C16);
		Cards.add(C17);
		Cards.add(C18);
		Cards.add(C19);
		Cards.add(C20);
		Cards.add(C21);
		Cards.add(C22);
		Cards.add(C23);
		Cards.add(C24);
		Cards.add(C25);
		Cards.add(C26);
		Cards.add(C27);
		Cards.add(C28);
		Cards.add(C29);
		Cards.add(C30);
		Cards.add(C31);
		Cards.add(C32);
		Cards.add(C33);
		Cards.add(C34);
		Cards.add(C35);
		Cards.add(C36);
		Cards.add(C37);
		Cards.add(C38);
		Cards.add(C39);
		Cards.add(C40);
		Cards.add(C41);
		Cards.add(C42);
		Cards.add(C43);
		Cards.add(C44);
		Cards.add(C45);
		Cards.add(C46);
		Cards.add(C47);
		Cards.add(C48);
		Cards.add(C49);
		Cards.add(C50);
		Cards.add(C51);
		Cards.add(C52);
	}

	public void RefreshCards() {
		for (int i = 0; i < 52; i++) {
			Cards.get(i).used = false;
		}

	}
	public ArrayList<Card> getCards() {
		return Cards;
	}
}
