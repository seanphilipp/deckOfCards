package cards;

import java.util.ArrayList;
import java.util.List;

import cards.FrenchCard.Type;
import cards.FrenchCard.Suit;

public class DeckFactory {
	
	public static IDeck buildFrench52CardDeck(){
		
		//Crate all possible cards in a 52 card deck.
		List<ICard> cards = new ArrayList<ICard>();
		for (Suit suit : FrenchCard.Suit.values()) {
			for (Type type : FrenchCard.Type.values()) {
				cards.add(new FrenchCard(suit, type));
			}
		}
		Deck deck = new Deck(cards);
		return deck;
		
	}
}
