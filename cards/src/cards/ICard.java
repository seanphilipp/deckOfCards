package cards;

import java.util.Comparator;

public interface ICard {
	
	/**
	 * Each card has a natural order which is an absolute position of ordering among
	 * ICards of the same implementation. The natural orders of all cards should be unique
	 * and sorting all cards by natural order should result in the expected ordering of
	 * cards if the cards are orderable.
	 * @return An order integer that corresponds to the Integer.compare() interface.
	 */
	int getNaturalOrder();
	
	public static Comparator<ICard> DefaultComparator = new Comparator<ICard>(){

		@Override
		public int compare(ICard arg0, ICard arg1) {
			if(arg0 == null || arg1 == null){
				throw new IllegalArgumentException("null ICards cannot be compared");
			}
			return Integer.compare(arg0.getNaturalOrder(), arg1.getNaturalOrder());
		}
		
	};
}