package blackjack;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CardTest {
    Deck deck = new Deck();

    @org.junit.Test
    public void getCardImage() {
        for (Card card : deck.getCards())
        {
            card.getCardImage();
        }
    }

    @org.junit.Test
    public void getValue() {
        for (Card card : deck.getCards())
        {
            System.out.println(card.getValue());
        }
    }

    @org.junit.Test
    public void getFaceName() {

    }

    @org.junit.Test
    public void getSuit() {
    }

    public CardTest() throws IOException {
    }
}