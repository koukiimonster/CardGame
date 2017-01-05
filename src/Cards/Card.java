package Cards;

public class Card {
	private int rank;
	private int suit;
	
    public enum rank {
    	THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE, TWO
    }
    
    public enum suit {
    	SPADES, CLUBS, DIAMONDS, HEARTS
    }
    
    // Suits and ranks are in order in terms of value.
    private static String suits[] = {"spades", "clubs", "diamonds", "hearts"};
    private static String ranks[] = {"3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace", "2"};
	
	
	public Card(int suit, int rank) {
		this.setRank(rank);
		this.setSuit(suit);
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}
	
	
    @Override
    public String toString() {
        return ranks[rank] + " of " + suits[suit];
    }

    
	public int compareTo(Card otherCard) {
		// Only checking if the other card is greater than this card..can only be less than or greater than
		if(this.rank < otherCard.rank) {
			//System.out.println("Less than");
			return -1;
		}
		else if(this.rank == otherCard.rank) {
			//System.out.println("Same rank..checking suit..");
			//System.out.println(this.rank + " vs " + otherCard.rank);
			if(this.suit < otherCard.suit) {
				//System.out.println(this.suit + " vs " + otherCard.suit);
				//System.out.println("Suit less than");
				return -1;
			}
		}
		else {
			return 1;
		}
		
		// Assume that other card is less than
		return 1;
	}
}
