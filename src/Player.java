import java.util.List;
import java.util.Observable;

import Cards.Card;


public class Player extends Observable {
	private Hand hand;
	private String name;
	private boolean turnCompleted;
	// generated player Id for the game to use
	//private final long playerId;
	
	public Player() {
		hand = new Hand();
		
	}
	
	public Player(String name) {
		this.name = name;
		this.hand = new Hand();
	}
	
	
	public boolean endTurn() {
		turnCompleted = true;
		return turnCompleted;
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean turnEnded() {
		return turnCompleted;
	}
	
	public void takeTurn() {
		turnCompleted = false;
	}
	
	public Card getLowestCard() {
		return hand.getLowestCard();
	}

	public void selectCard(int... indices) {
		hand.selectCard(indices);
	}
	
	public List<Card> playCards() {
		List<Card> cards = null;
		
		cards = hand.playCards();
		return cards;
	}
	
}
