import java.util.ArrayList;


public class GameTest {
	
	public static void main(String[] args) {
		final Game game = new Game();
		Player currentPlayer = new Player();
		
		currentPlayer = game.findFirstPlayer();
		
		currentPlayer.getLowestCard();
	}
	
}
