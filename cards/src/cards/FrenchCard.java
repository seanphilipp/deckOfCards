package cards;


public class FrenchCard implements ICard{

	
	public enum Suit {
		Hearts, Clubs, Diamonds, Spades;
	}
	
	public enum Type {
		Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Jack, Queen, King;
	}
	
	private Suit suit;
	private Type type;

	public FrenchCard(Suit suit, Type type) {
		this.suit = suit;
		this.type = type;
	}

	@Override
	public int getNaturalOrder() {
		//The natural order is a 0's based integer in order of combinations of Suit, Type, ordination
		//strictly set by the Suit and Type enums... the ordination is strict because of the rules of
		//ordering of French cards... Hearts < Clubs, and Ace < Two
		return Type.values().length * suit.ordinal() + type.ordinal();
	}

	public Suit getSuit() {
		return suit;
	}

	public Type getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FrenchCard other = (FrenchCard) obj;
		if (suit != other.suit)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FrenchCard [suit=" + suit + ", type=" + type + "]";
	}

	
}
