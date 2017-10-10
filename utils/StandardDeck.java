package functions.utils;

import java.util.*;
import java.util.stream.*;
import java.lang.*;

public class StandardDeck {

	private List<Card> entireDeck;

	public StandardDeck(List<Card> existingList) {
		this.entireDeck = existingList;
	}

	public StandardDeck() {
		this.entireDeck = new ArrayList<>();
		for (Card.Suit s : Card.Suit.values()) {
			for (Card.Rank r : Card.Rank.values()) {
				this.entireDeck.add(new PlayingCard(r, s));
			}
		}
	}

	public StandardDeck deckFactory() {
		return new StandardDeck(new ArrayList<Card>());
	}

	public int size() {
		return entireDeck.size();
	}

	public List<Card> getCards() {
		return entireDeck;
	}

	public void addCard(Card card) {
		entireDeck.add(card);
	}

	public void addCards(List<Card> cards) {
		entireDeck.addAll(cards);
	}

	public void addDeck(StandardDeck deck) {
		List<Card> listToAdd = deck.getCards();
		entireDeck.addAll(listToAdd);
	}

	public void sort(Comparator<Card> c) {
		Collections.sort(entireDeck, c);
	}

	public void shuffle() {
		Collections.shuffle(entireDeck);
	}

	public String deckToString() {
		return this.entireDeck.stream().map(Card::toString)
				.collect(Collectors.joining("\n"));
	}

	
}

