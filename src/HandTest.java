import java.util.ArrayList;
import java.util.List;

import Cards.Card;


public class HandTest {
	
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		// lazy to do loop
		players.add(new Player("player1"));
		players.add(new Player("player2"));
		players.add(new Player("player3"));
		players.add(new Player("player4"));
		
		deck.deal(players);
		
		System.out.println(players.get(0).getHand().toString());
		System.out.println(players.get(1).getHand().toString());
		System.out.println(players.get(2).getHand().toString());
		System.out.println(players.get(3).getHand().toString());
		
		Card c1 = players.get(0).getLowestCard();
		Card c2 = players.get(1).getLowestCard();
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c1.compareTo(c2));
		

		Player myPlayer = players.get(0);
		
		myPlayer.selectCard(0, 1, 2);
		List<Card> playedCards = myPlayer.playCards();
		System.out.println(myPlayer.getHand().toString());
		//System.out.println()
		
		//hand.sortHand();
		
		//System.out.println("\n\n-------------------------------------\n" + hand.toString());
		
		
		
	}
}
