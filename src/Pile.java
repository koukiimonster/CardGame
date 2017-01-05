import java.util.List;
import java.util.Stack;
import java.util.Vector;

import Cards.Card;


public class Pile {
	
	private Stack<List<Card>> cards;
	private Vector<Card> top;
	
	public Pile() {
		cards = new Stack<List<Card>>();
		top = new Vector<Card>();
	}
	
	public void setTop(List<Card> cards) {
		this.cards.push(cards);
		this.top = (Vector<Card>) cards;
	}
	
	public List<Card> getTop() {
		return top;
	}
}
