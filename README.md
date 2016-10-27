# DeckOfCards

Java implementation for a standard deck of poker-style playing cards. This deck is 52 cards with 4 suits (Hearts, Diamonds, Clubs and
Spades) and 13 ranks (Ace, 2-10, Jack, Queen, and King).

***

The StandardDeck class exposes the following methods:

* ``shuffle()`` - Shuffle returns no value, but results in the cards in the deck being randomly permuted. It does not use any library-provided "shuffle" operations to implement this function. It does use a library-provided random number generator.

* ``deal_one_card()`` - This function returns one card from the deck to the caller. If all cards have been dealt, no card is returned.

***

Specifically, a call to ``shuffle()`` followed by 52 calls to ``deal_one_card()`` results in the caller being provided all 52 cards of the deck in a random order. If the caller then makes a 53rd call to ``deal_one_card()``, no card is dealt.