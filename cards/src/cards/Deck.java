package cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class Deck implements IDeck {

	private List<ICard> cards = new ArrayList<ICard>();
	
	public Deck(List<ICard> cards){
		this.cards.addAll(cards);
	}
	
	@Override
	public void shuffle() {
		Collections.shuffle(new ArrayList<ICard>(cards));
	}

	@Override
	public void cut(int cardPosition) {
		List<ICard> cutCards = new ArrayList<ICard>();
		Iterator<ICard> iterator = cards.iterator();
		//Remove all the cards up to the position
		int currentPosition = 1;
		while (iterator.hasNext() && currentPosition++ < cardPosition) {
			cutCards.add(iterator.next());
			iterator.remove();
		}
		//Add them all back to the bottom.
		cards.addAll(cutCards);
	}

	@Override
	public ICard deal() {
		ICard toReturn = null;
		Iterator<ICard> iterator = cards.iterator();
		if(iterator.hasNext()){
			toReturn = iterator.next();
			iterator.remove();
		}
		return toReturn;
	}

	@Override
	public ICard turnOver() {
		ICard toReturn = null;
		Iterator<ICard> iterator = cards.iterator();
		if(iterator.hasNext()){
			toReturn = iterator.next();
		}
		return toReturn;
	}

	@Override
	public int search(ICard toFind) {
		//Return the index (1's based converted) of any instance - 0 is equivalent to non existent.
		return cards.indexOf(toFind) + 1;
	}

	@Override
	public void newOrder() {
		cards.sort(ICard.DefaultComparator);
	}

}
