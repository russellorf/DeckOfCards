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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the StandardDeck object model
 * 
 * @author Russell Orf
 * @version 1.0.0
 * @see StandardDeck
 */
public class StandardDeckTest {

	private List<PlayingCard> controlDeck = new LinkedList<>();

	@Before
	public void setup() {
		for (PlayingCard.Suit as : PlayingCard.Suit.values()) {
			for (PlayingCard.Rank ar : PlayingCard.Rank.values()) {
				controlDeck.add(new PlayingCard(ar, as));
			}
		}
	}

	@Test
	public void testConstructor() {

		List<PlayingCard> deckToTest = new LinkedList<>(new StandardDeck().getDeck());

		// Check that both decks are the same size
		assertEquals(controlDeck.size(), deckToTest.size());

		// Check that each member of each deck is the same; this is possible
		// since the LinkedHashSet internal data structure of the StandardDeck
		// maintains the insertion order, and the decks are constructed in the
		// same order
		for (int i = 0; i < 52; i++) {
			assertEquals(deckToTest.get(i), controlDeck.get(i));
		}
	}

	@Test
	public void testShuffle() {
		StandardDeck sd = new StandardDeck();
		List<PlayingCard> preShuffledCards = new LinkedList<>(sd.getDeck());

		// Shuffle cards
		sd.shuffle();
		List<PlayingCard> shuffledCards = new LinkedList<>(sd.getDeck());

		// Check that deck size is same after shuffle as before
		assertEquals(preShuffledCards.size(), shuffledCards.size());

		// Check that the shuffled deck has the same cards as the pre-shuffled
		// deck
		for (PlayingCard preshuffledCard : preShuffledCards) {

			boolean containsSameCard = false;
			for (PlayingCard shuffledCard : shuffledCards) {
				if (preshuffledCard.equals(shuffledCard)) {
					containsSameCard = true;
				}
			}

			assertTrue(containsSameCard);
		}

		// Check that the shuffled cards are in a random order. Here we are
		// assuming the deck is sufficiently shuffled if no more than five cards
		// are in the same position as the pre-shuffled deck
		int cardsInSamePosition = 0;
		for (int i = 0; i < preShuffledCards.size(); i++) {
			if (shuffledCards.get(i).equals(preShuffledCards.get(i))) {
				cardsInSamePosition++;
			}
		}
		assertTrue(cardsInSamePosition <= 5);
	}

	@Test
	public void testDealOneCard() {
		StandardDeck sd = new StandardDeck();

		// Deal all 52 cards
		for (int i = 0; i < 52; i++) {
			List<PlayingCard> preDealDeck = new LinkedList<>(sd.getDeck());
			int numCardsBeforeDeal = sd.getDeck().size();

			// Deal a card
			PlayingCard dealtCard = sd.deal_one_card();
			List<PlayingCard> postDealDeck = new LinkedList<>(sd.getDeck());
			int numCardsAfterDeal = postDealDeck.size();

			// Check that the deck now has one less card in it.
			assertEquals(numCardsBeforeDeal, numCardsAfterDeal + 1);

			// Check that the deck no longer has the dealt card in it.
			for (PlayingCard card : postDealDeck) {
				assertNotEquals(dealtCard, card);
			}

			// Check that the preDealDeck and postDealDeck are identical, save
			// for the one dealt card.
			for (int j = 0; j < numCardsAfterDeal; j++) {
				assertEquals(preDealDeck.get(j + 1), postDealDeck.get(j));
			}
		}

		// No more cards in the deck; check that next dealt card is null
		assertNull(sd.deal_one_card());
	}
}