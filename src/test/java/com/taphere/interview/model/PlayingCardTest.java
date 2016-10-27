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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**
 * Unit tests for the PlayingCard object model
 * 
 * @author Russell Orf
 * @version 1.0.0
 * @see PlayingCard
 */
public class PlayingCardTest {

	private enum Suit {
		Hearts, Diamonds, Clubs, Spades
	}

	private enum Rank {
		Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
	}

	@Test
	public void testPlayingCard() {
		PlayingCard pc1 = new PlayingCard(PlayingCard.Rank.Ace, PlayingCard.Suit.Spades);

		// Test Rank values
		assertEquals(Rank.values().length, PlayingCard.Rank.values().length);

		for (int i = 0; i < Rank.values().length; i++) {
			assertEquals(Rank.values()[i].toString(), PlayingCard.Rank.values()[i].toString());
		}

		// Test Suit values
		assertEquals(Suit.values().length, PlayingCard.Suit.values().length);

		for (int i = 0; i < Suit.values().length; i++) {
			assertEquals(Suit.values()[i].toString(), PlayingCard.Suit.values()[i].toString());
		}

		// Test getters for Rank, Suit
		assertTrue(pc1.getRank().equals(PlayingCard.Rank.Ace));
		assertTrue(pc1.getSuit().equals(PlayingCard.Suit.Spades));

		// Test overridden toString() method
		assertTrue(pc1.toString().equals(PlayingCard.Rank.Ace + " of " + PlayingCard.Suit.Spades));

		// Test overridden equals(Object o) method
		assertEquals(pc1, new PlayingCard(PlayingCard.Rank.Ace, PlayingCard.Suit.Spades));
		assertNotEquals(pc1, new PlayingCard(PlayingCard.Rank.Ten, PlayingCard.Suit.Diamonds));
	}

	@Test
	public void testExceptions() {

		try {
			new PlayingCard(null, PlayingCard.Suit.Spades);
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Card rank is empty!");
		}

		try {
			new PlayingCard(PlayingCard.Rank.Ace, null);
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Card suit is empty!");
		}
	}
}
