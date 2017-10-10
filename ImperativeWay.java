package functions;

import java.util.Comparator;

import functions.utils.Card;
import functions.utils.StandardDeck;

/**
 * 
 * 
 *
 *
 * The example gives tries to sort a deck of Cards
 */
public class ImperativeWay {

	public static void main(String[] args) {

		StandardDeck myDeck = new StandardDeck();
		System.out.println("Creating deck:");

		myDeck.sort(new SortByRankThenSuit());

	}

}

/**
 * 
 * @author srinirag
 * 
 * 
 * 
 * 
 *
 */
class SortByRankThenSuit implements Comparator<Card> {
	@Override
	public int compare(Card firstCard, Card secondCard) {
		int compVal = firstCard.getRank().value()
				- secondCard.getRank().value();
		if (compVal != 0)
			return compVal;
		else
			return firstCard.getSuit().value() - secondCard.getSuit().value();
	}
}
