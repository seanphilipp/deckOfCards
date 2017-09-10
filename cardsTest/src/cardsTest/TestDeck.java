package cardsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import cards.Deck;
import cards.FrenchCard;
import cards.FrenchCard.Suit;
import cards.FrenchCard.Type;
import cards.ICard;

public class TestDeck {

	public Deck testDeck;
	
	@Before
	public void before()
	{
		testDeck = new Deck(
				Arrays.asList(
						new FrenchCard(Suit.Spades, Type.Ace), 
						new FrenchCard(Suit.Spades, Type.Nine), 
						new FrenchCard(Suit.Hearts, Type.Queen))
				);
	}
	
	@Test
	public void testShuffle() {
		//Test shuffle by comparing the permutation of the unshuffled deck against what is dealt after the shuffle.
		testDeck.shuffle();
		List<ICard> originalOrder = new ArrayList<ICard>(Arrays.asList(
				new FrenchCard(Suit.Spades, Type.Ace), 
				new FrenchCard(Suit.Spades, Type.Nine), 
				new FrenchCard(Suit.Hearts, Type.Queen)));
		Assert.assertTrue(checkCardsNotInSameOrder(originalOrder , testDeck.deal(), testDeck.deal(), testDeck.deal()));
		//The above test method would be useful to retest shuffle multiple consecutive times... but we would want a
		//way to add cards back to the deck.
	}

	/**
	 * Verifies that the same sequence of ICards in an input list are not
	 * listed in a params list of ICards
	 * @param originalOrder An input list that will be checked to a params list. This lists
	 * contents will be replaced by those in the newOrder paramter upon return of the method.
	 * @param newOrder Cards to check against the input list.
	 * @return True if all cards in both sets of cards are in the exact same order.
	 */
	private boolean checkCardsNotInSameOrder(List<ICard> originalOrder,
			ICard... newOrder) {
		if(originalOrder.size() != newOrder.length){
			throw new IllegalArgumentException("originalOrder and newOrder must have the same count of elements.");
		}
		boolean sameOrder = true;
		for(int i=0; i < originalOrder.size(); i++){
			//The same card has the same natural order; no cards have identical natural orders.
			sameOrder &= originalOrder.get(i).getNaturalOrder() == newOrder[i].getNaturalOrder();
		}
		//Clear old elements and add new 
		originalOrder.clear();
		originalOrder.addAll(Arrays.asList(newOrder));
		return sameOrder;
	}

	@Test
	public void testCut() {
		//Cut the deck at position 2
		testDeck.cut(2);
		//Results should be the Nine of Spades on the top.
		FrenchCard top = (FrenchCard)testDeck.deal();
		Assert.assertEquals(Suit.Spades, top.getSuit());
		Assert.assertEquals(Type.Nine, top.getType());
		//Test the next two cards...
		top = (FrenchCard)testDeck.deal();
		Assert.assertEquals(Suit.Hearts, top.getSuit());
		Assert.assertEquals(Type.Queen, top.getType());
		top = (FrenchCard)testDeck.deal();
		Assert.assertEquals(Suit.Spades, top.getSuit());
		Assert.assertEquals(Type.Ace, top.getType());
	}

	@Test
	public void testDeal() {
		//The top card should be the one which was inserted first.
		FrenchCard top = (FrenchCard)testDeck.deal();
		Assert.assertEquals(top.getSuit(), Suit.Spades);
		Assert.assertEquals(top.getType(), Type.Ace);
	}

	@Test
	public void testTurnOver() {
		//The turn over card should be the top card.
		FrenchCard top = (FrenchCard)testDeck.turnOver();
		Assert.assertEquals(Suit.Spades, top.getSuit());
		Assert.assertEquals(Type.Ace, top.getType());
		//It should repeat the same card.
		FrenchCard topTwice = (FrenchCard)testDeck.turnOver();
		Assert.assertEquals(Suit.Spades, top.getSuit());
		Assert.assertEquals(Type.Ace, top.getType());
	}

	@Test
	public void testSearch() {
		Assert.assertEquals(1, testDeck.search(new FrenchCard(Suit.Spades, Type.Ace)));
		Assert.assertEquals(2, testDeck.search(new FrenchCard(Suit.Spades, Type.Nine)));
		Assert.assertEquals(3, testDeck.search(new FrenchCard(Suit.Hearts, Type.Queen)));
		Assert.assertEquals(0, testDeck.search(new FrenchCard(Suit.Hearts, Type.Ace)));
	}

	@Test
	public void testNewOrder() {
		//New order is as determined by the type of card in the Deck...
		//the FrenchCard new order requires the test deck to be ordered
		//as Hearts Queen, Spades Ace, Spades Nine.
		testDeck.newOrder();
		FrenchCard first = (FrenchCard)testDeck.deal();
		FrenchCard second = (FrenchCard)testDeck.deal();
		FrenchCard third = (FrenchCard)testDeck.deal();
		Assert.assertEquals(Suit.Hearts, first.getSuit());
		Assert.assertEquals(Type.Queen, first.getType());
		Assert.assertEquals(Suit.Spades, second.getSuit());
		Assert.assertEquals(Type.Ace, second.getType());
		Assert.assertEquals(Suit.Spades, third.getSuit());
		Assert.assertEquals(Type.Nine, third.getType());
	}

}
