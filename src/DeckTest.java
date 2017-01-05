import Cards.Card;


public class DeckTest {
	public static void main(String[] args) {
		Deck deck = new Deck();
		
		while(!deck.isEmpty()) {
			Card c = deck.dealCard();
			System.out.println(c.toString());
		}
		
	}
}
