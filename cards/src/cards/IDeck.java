package cards;

public interface IDeck {
	
	/**
	 * Randomizes order of ICards registered to the deck.
	 */
	void shuffle();
	
	/**
	 * Splits the set of ICards at a point defined by the position of a card, where 
	 * All cards below that card will be moved to the top of the deck, and cards above
	 * will be moved to the bottom of the deck.
	 */
	void cut(int cardPosition);
	
	/**
	 * Retrieves and removes the top ICard from the deck and removes that ICard 
	 * from the deck.
	 * @return The top ICard.
	 */
	ICard deal();
	
	/**
	 * Retrieves the top ICard from the deck but does not remove it.
	 * @return The top ICard.
	 */
	ICard turnOver();
	
	/**
	 * Finds a card and returns its position.
	 * @param toFind The card to find.
	 * @return The position (1's based) of the ICard in the deck; 0 indicates non-existent.
	 */
	int search(ICard toFind);
	
	/**
	 * Reorders the ICards according to their natural order (see: ICard.natualOrder())
	 */
	void newOrder();
}
