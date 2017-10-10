package functions;

import java.util.Comparator;

import functions.utils.Card;
import functions.utils.StandardDeck;

public class FunctionalWay {

	public static void main(String[] args) {

		StandardDeck myDeck = new StandardDeck();
		System.out.println("Creating deck:");

		myDeck.shuffle();

		myDeck.sort(Comparator.comparing(Card::getRank).thenComparing(
				Comparator.comparing(Card::getSuit)));

		System.out.println(myDeck.toString());

	}

}
