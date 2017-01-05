import java.util.List;

import Cards.Card;


public class HandValidator {
	
	
	private static HandValidator validator = null; 
	
	protected HandValidator() {
		
	}
	
	public static HandValidator getInstance() {
		if(validator == null) {
			validator = new HandValidator();
		}
		return validator;
	}
	
	public boolean validate(List<Card> cards, HandType type) {
		

		return false;
	}
	
}
