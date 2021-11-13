package effective.chapter8.item51;

import effective.chapter7.item45.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card){
        cards.add(card);
    }

    public static class Card{
        public enum Suit { SPADE, HEART, DIAMOND, CLUB }
        public enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN,
            EIGHT, NINE, TEN, JACK, QUEEN, KING }
        private final Suit suit;
        private final Rank rank;
        public Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }
        private static Card getNewCard() {
            Random rnd = ThreadLocalRandom.current();
            Suit[] suits = Suit.values();
            Rank[] values = Rank.values();
            return new Card(suits[rnd.nextInt(suits.length)],values[rnd.nextInt(values.length)]);
        }
    }
}
