package cardsTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

import cards.FrenchCard;
import cards.FrenchCard.Suit;
import cards.FrenchCard.Type;

public class TestFrenchCard {

	@Test
	public void testNaturalOrderUniqueAndAscending() {
		//Go through all types of French cards by parameterizing the ctor with all
		//combinations of the parameters to create a valid card.
		
		//Ensure that the natural order is composed ascending according to the ascending value of French
		//cards... that is:
		//suits (hearts, clubs, diamonds, spades) and 
		//types (Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King)
		Set<Integer> naturalOrders = new HashSet<Integer>();
		int lastOrder = -1;
		for (Suit suit : Arrays.asList(Suit.Hearts, Suit.Clubs, Suit.Diamonds, Suit.Spades)) {
			for (Type type : Arrays.asList(Type.Ace, Type.Two, Type.Three, Type.Four, Type.Five, 
					Type.Six, Type.Seven, Type.Eight, Type.Nine, Type.Jack, Type.Queen, Type.King)) {
				int naturalOrder = new FrenchCard(suit, type).getNaturalOrder();
				
				//The natural order of each card should be unique, therefore adding
				//the natural order integer to a set should return true, where
				//the set add() returns whether or not a unique integer was added to the set.
				Assert.assertTrue(naturalOrders.add(naturalOrder));
				
				//The natural order of these cards as we iterate through the nested loops should be increasing by one
				//for each loop... that ensures the natural ordering is ascending per the rules of the French cards.
				Assert.assertTrue(naturalOrder > lastOrder);
				lastOrder = naturalOrder;
			}
		}
	}
	
}
