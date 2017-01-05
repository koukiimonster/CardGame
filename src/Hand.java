import java.util.ArrayList;
import java.util.List;

import Cards.Card;

/*
 * A Hand represents a group of cards
 */
public class Hand {
	
	private List<Card> cards;
	private List<Card> selectedCards;
	private List<Integer> selectedCardsIndex;
	private List<Integer> cardCount;
	
	public Hand() {
		cards = new ArrayList<Card>();
		selectedCards = new ArrayList<Card>();
		selectedCardsIndex = new ArrayList<Integer>();
		cardCount = new ArrayList<>();
		for(int i = 0; i < 13; i++)
		cardCount.add(i, 0);
	}
	
	public void addToHand(Card card) {
		cards.add(card);
		addToCardCount(card);
		
	}
	
	public List<Card> getHand() {
		return cards;
	}
	
	public void setHand(List<Card> cards) {
		this.cards = cards;
		sortHand();
	}
	
	// code will select/deselect cards
	// might not match up the indices correctly...
	public void selectCard(int... indices) {
		// check to see if selected cards are already in the selected list
		for(int i = 0; i < indices.length; i++) {
			
			if(selectedCardsIndex.contains((Integer)indices[i])) {
				//selectedCardsIndex.remove(indices[i]);
				//selectedCards.remove(cards.get(indices[i]));
				//continue;
			}
			else {
				selectedCardsIndex.add(indices[i]);
				selectedCards.add(cards.get(indices[i]));
				System.out.println(selectedCardsIndex.get(i));
				System.out.println(selectedCards.get(i));
			}
		}
		//selectedCardsIndex.add(index);
		//selectedCards.add(cards.get(index));
	}
	
	// Actually remove the cards from the hand and play them into the pile
	// need a way to validate the hand...probably done at game level before playing it
	//@SuppressWarnings("null")
	public List<Card> playCards() {
		//TODO
		List<Card> discardingCards = new ArrayList<>();
		
		while(!selectedCardsIndex.isEmpty()) {
			discardingCards.add((cards.remove((selectedCardsIndex.remove(0).intValue()))));
			System.out.println(discardingCards.toString());
			System.out.println(selectedCardsIndex.toString());
		}
		
		return discardingCards;
	}
	
	public Card getLowestCard() {
		// assuming the hand is sorted
		return cards.get(0);
	}
	public Card getHighestCard() {
		return cards.get(cards.size()-1);
	}
	
    // Sort hand from lowest to highest, in terms of rank and suit
    public void sortHand() {
        ArrayList<Card> sortedHand = new ArrayList<Card>(13);
        int i;
        int position;
        Card low, high;
               
        // If the ranks are equal, then we check to see which is the higher 
        // of the two.
        while(cards.size() > 0) {
            position = 0;
            low = cards.get(0);
            for(i = 1; i < cards.size(); i++) {
                high = cards.get(i);               
                if(high.getRank() < low.getRank()) {
                    position = i;
                    low = high;
                } else if(high.getRank() == low.getRank()) {
                    if(high.getSuit() < low.getSuit()) {
                        position = i;
                        low = high;
                    }
                }   
            }
            cards.remove(position);
            sortedHand.add(low);
        }   
        cards = sortedHand;       
    }
    
    public String toString() {
    	return cards.toString();
    	/*
    	String returnString = "";
    	for(Card card: cards) {
    		returnString += card.toString() + "\n";
    	}
    	return returnString;
    	*/
    }
    
    private void addToCardCount(Card c) {
    	int value = cardCount.get(c.getRank());
    	value = value++;
    	cardCount.add(c.getRank(), value);
    }

    public List<Integer> getCardCount() {
    	return cardCount;
    }
}
