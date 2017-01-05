import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import Cards.Card;


public class Game {
	private HandType handType;
	private int round;
	private int playerCount;
	private Pile pile;
	
	// center of pile location, should never have to change..not sure on where to put it yet
	private int pileLocation;
	
	// Game will register and manage observers (players)..
	private List<PlayerObserver> observerList;
	
	private List<Player> players;
	private Player currentPlayer;
	private int currentPlayerIndex;
	
	
	
	private Scanner console = new Scanner(System.in);
	
	public Game() {
		//Get players
		// Only used to test
		pile = new Pile();
		players = new ArrayList<>();
		players.add(new Player("player1"));
		players.add(new Player("player2"));
		players.add(new Player("player3"));
		players.add(new Player("player4"));
		//Create deck, shuffle and deal out to players
		deal();
		// find player with lowest card;
		currentPlayer = findFirstPlayer();
		
		//play();
		
		
	}
	
	
	
	public void start() {
		
	}
	
	// should return the current player's hand
	public void displayHand() {
		Hand hand = currentPlayer.getHand();
		
	}
	
	public Player findFirstPlayer() {
		// initialize to lowest card from first player in list
		int count = 1;
		Card lowestCard = players.get(count-1).getLowestCard();
		// initialize to lowest card from next player in list
		Card nextCard = players.get(count).getLowestCard();
		Player player = players.get(count-1);
		
		// As long as the lowest card is bigger then the next we keep checking
		while(lowestCard.getRank() > nextCard.getRank() || (lowestCard.getRank() == nextCard.getRank() && lowestCard.getSuit() > nextCard.getSuit())) {
			//System.out.println("Comparing player" + count + "'s hand to player" + (count+1) + "'s hand..");
			//System.out.println("Player" + count + "'s lowest: " + lowestCard.toString());
			//System.out.println("Player" + (count+1) + "'s lowest: " + nextCard.toString());
			if(lowestCard.compareTo(nextCard) == 1) {
				lowestCard = nextCard;
				if(count < 3) {
					++count;
				}
				nextCard = players.get(count).getLowestCard();
			} 
		}
		//System.out.println("Lowest card: " + lowestCard.toString());
		return player;
	}
	
	public void deal() {
		Deck deck = new Deck();
		
		deck.shuffle();				// shuffles the deck
		deck.deal(players);			// deals the deck to the players
	}
	
	// actual game code here
	public void play() {
		round = 1;
		pile.getTop();
		// or can do with if statement
		while(!currentPlayer.turnEnded()) {
			System.out.println("Take your turn: Input index of cards you wish to play and hit enter.");
			String input = console.nextLine();
			
			//currentPlayer.
			//on
			
		}
		
		
		
	}
	
	// only call this if max players is 4?? or when it's less??
	/*
    public Player findThreeOfSpades() {
    	int index = 0;
    	Card card = players.get(index).getLowestCard();
    	
    	
    	
    	
    	return players.get(index);
    }
    */
}
