package blackjack;

import java.awt.image.BufferedImage;

class Card {
	private String faceName, suit;
	public int Value;
	public BufferedImage cardImage;
	public boolean used;
	
	public Card(String suit, String face, int value, BufferedImage img) {
		this.suit = suit;
		this.faceName = face;
		this.Value = value;
		this.cardImage = img;
		this.used = false;
		
	}

	public BufferedImage getCardImage() {
		return cardImage;
	}

	public int getValue() {
		return Value;
	}

	public String getFaceName() {
		return faceName;
	}

	public String getSuit() {
		return suit;
	}
}
