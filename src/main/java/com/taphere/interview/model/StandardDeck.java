/** 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

package com.taphere.interview.model;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Standard Deck of Poker-Style Playing Cards
 * 
 * Set-based implementation of a Standard Deck of Playing Cards. A Standard Deck
 * consists 52 cards representing every combination of the four suits and
 * thirteen ranks defined in the com.taphere.interview.model.PlayingCard model.
 * 
 * Note that this implementation is not thread-safe. If multiple threads attempt
 * to call the public methods on the same instance of StandardDeck, the calls to
 * the instance object must be synchronized externally.
 * 
 * @author Russell Orf
 * @version 1.0.0
 * @see PlayingCard
 */
public class StandardDeck {

	private Random rand = new Random();

	private Set<PlayingCard> deck = new LinkedHashSet<>();

	/**
	 * Constructs an instance of StandardDeck, populating the internal data
	 * structure with 52 instances of the PlayingCard object, one for each
	 * combination of Rank and Suit defined
	 * 
	 */
	public StandardDeck() {

		// Populate deck with all 52 available PlayingCards
		for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
			for (PlayingCard.Rank rank : PlayingCard.Rank.values()) {
				deck.add(new PlayingCard(rank, suit));
			}
		}
	}

	/**
	 * Takes the existing ordered set of PlayingCard objects and shuffles the
	 * order. The size of the deck remains the same.
	 * 
	 */
	public void shuffle() {
		List<PlayingCard> cardsInDeck = new LinkedList<>(deck);
		int totalDeckLength = cardsInDeck.size();
		Set<PlayingCard> newDeck = new LinkedHashSet<>();

		// Iterate through the deck, randomly select a card, remove from the old
		// deck and add to the new deck.
		for (int i = 0; i < totalDeckLength; i++) {
			PlayingCard randomlySelectedCard = cardsInDeck.get(rand.nextInt(cardsInDeck.size()));

			cardsInDeck.remove(randomlySelectedCard);
			newDeck.add(randomlySelectedCard);
		}

		deck = newDeck;
	}

	/**
	 * Removes one card from the 'top' of the deck and returns it to the client.
	 * The size of the deck after the method completes is exactly one less than
	 * prior to calling the method. The remaining cards in the deck maintain
	 * their original order. When the deck no longer has any cards, the method
	 * returns null.
	 * 
	 * @return PlayingCard Selected from the 'top' of the deck
	 */
	public PlayingCard deal_one_card() {
		if (deck.size() > 0) {
			List<PlayingCard> cardsInDeck = new LinkedList<>(deck);
			PlayingCard selectedCard = cardsInDeck.get(0);

			cardsInDeck.remove(0);
			deck = new LinkedHashSet<>(cardsInDeck);

			return selectedCard;
		}

		return null;
	}

	/**
	 * Utility method for retrieving the current state of the cards in the deck
	 * 
	 * @return deck A set of the remaining PlayingCard objects in the deck
	 */
	public Set<PlayingCard> getDeck() {
		return deck;
	}
}