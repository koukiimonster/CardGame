import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import Cards.Card;


public class Deck {
	List<Card> deck;
	
	public Deck() {
		deck = new ArrayList<Card>(52);
		
        // Build the deck
        for(int a = 0; a < 4; a++) {
            for(int b = 0; b < 13; b++) {
                deck.add(new Card(a, b));
            }
        }
	}
	
	public void shuffle() {
		int index1, index2;
		Random generator = new Random();
		Card temp;
		
        for (int i = 0; i < 100; i++) {
            index1 = generator.nextInt(deck.size() - 1);
            index2 = generator.nextInt(deck.size() - 1);
            temp = (Card) deck.get(index2);
            deck.set(index2 , deck.get(index1));
            deck.set(index1, temp);
        }
	}
	
	public void deal(List<Player> players) {
		shuffle();
		int playerCount = players.size();
		int cardCount = playerCount * 13;
		
		// deals the cards from the deck to players
		for(int i = 0; i < cardCount; i++) {
			// maybe can do it in a cleaner way?
			players.get(i % playerCount).getHand().addToHand(dealCard());
		}
		
		// sorts the hands for each player, makes it easier to find the first player since lowest card for each hand will the the lowest
		for(int i = 0; i < playerCount; i++) {
			players.get(i).getHand().sortHand();
		}
	}
	
	public Card dealCard() {
		return deck.remove(0);
	}
	
	public boolean isEmpty() {
		return deck.isEmpty();
	}
}
