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

/**
 * Poker-Style Standard Playing Card
 * 
 * enum-based model implementation of a Standard Playing Card. A Standard
 * Playing Card consists of a rank and suit, both required fields.
 * 
 * The Rank can be any number two through ten, Ace, Jack, Queen, or King. The
 * Suit can be either Hearts, Diamonds, Clubs, or Spades.
 * 
 * 
 * @author Russell Orf
 * @version 1.0.0
 * @see StandardDeck
 */
public class PlayingCard {

	public enum Suit {
		Hearts, Diamonds, Clubs, Spades
	};

	public enum Rank {
		Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
	};

	private Suit suit;

	private Rank rank;

	/**
	 * Constructs an instance of PlayingCard
	 * 
	 * @param rank
	 *            Any of the Rank enum values defined in this same class
	 * @param suit
	 *            Any of the Suit enum values defined in this same class
	 * @throws IllegalArgumentException
	 *             if either the rank or suit are null
	 */
	public PlayingCard(Rank rank, Suit suit) {
		if (rank == null) {
			throw new IllegalArgumentException("Card rank is empty!");
		}
		if (suit == null) {
			throw new IllegalArgumentException("Card suit is empty!");
		}

		this.rank = rank;
		this.suit = suit;
	}

	/**
	 * Returns the Rank enum used to initialize the object
	 * 
	 * @return rank
	 */
	public Rank getRank() {
		return rank;
	}

	/**
	 * Returns the Suit enum used to initialize the object
	 * 
	 * @return suit
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * Overrides the Object.toString() method to return a useful String of the
	 * Rank and Suit
	 * 
	 * @return String Pretty-printed string of the Rank and Suit; e.g.,
	 *         "Ace of Spades"
	 */
	@Override
	public String toString() {
		return new StringBuilder().append(rank).append(" of ").append(suit).toString();
	}

	/**
	 * Overrides the Object.equals(Object o) method to usefully compare two
	 * PlayingCard objects
	 * 
	 * @return boolean True when the Rank and Suit match, leveraging the
	 *         overridden toString(); false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		return o instanceof PlayingCard && ((PlayingCard) o).toString().equals(toString());
	}
}