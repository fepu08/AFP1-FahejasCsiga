package blackjack;

        import org.junit.Test;

        import java.io.IOException;
        import java.util.ArrayList;

        import static org.junit.Assert.*;

public class DeckTest {
    Deck d = new Deck();

    public DeckTest() throws IOException {
    }

    @Test
    public void refreshCards() {
        //Deklaralasnal used:false
        for (int i = 0; i < d.getCards().size(); i++) {
            System.out.println(String.format("Value: %s | Suit: %s | Face Name: %s | Used: %s",
                    d.getCards().get(i).getValue(), d.getCards().get(i).getSuit(), d.getCards().get(i).getFaceName(), d.getCards().get(i).used));
        }

        //Beallitjuk az used-et true-ra
        for (int i = 0; i < d.getCards().size(); i++) {
            d.getCards().get(i).used = true;
            System.out.println(String.format("Value: %s | Suit: %s | Face Name: %s | Used: %s",
                    d.getCards().get(i).getValue(), d.getCards().get(i).getSuit(), d.getCards().get(i).getFaceName(), d.getCards().get(i).used));
        }

        //Megnezzuk hogy a refresh atallitja-e az used-et false-ra
        d.RefreshCards();
        for (int i = 0; i < d.getCards().size(); i++) {
            System.out.println(String.format("Value: %s | Suit: %s | Face Name: %s | Used: %s",
                    d.getCards().get(i).getValue(), d.getCards().get(i).getSuit(), d.getCards().get(i).getFaceName(), d.getCards().get(i).used));
        }
    }

    @Test
    public void getCards() {
        ArrayList<Card> cards = d.getCards();
        for (Card card : cards) {
            System.out.println(String.format("Value: %s | Suit: %s | Face Name: %s | Used: %s",
                    card.getValue(), card.getSuit(), card.getFaceName(), card.used));
        }
    }
}