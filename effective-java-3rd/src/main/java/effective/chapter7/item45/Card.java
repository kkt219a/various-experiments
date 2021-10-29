package effective.chapter7.item45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

/**
 * Card는 숫자(rank)와 무늬(suit)를 묶은 불변 값 클래스고 숫자와 무늬는 모두 열거 타입이다.
 * 이 작업은 두 집합의 원소들로 만들 수 있는 가능한 모든 조합을 계산하는 거고, 이를 데카르트 곱이라 부른다.
 */
// 반복 방식과 스트림 방식으로 두 리스트의 데카르트 곱을 생성한다. (275-276쪽)
public class Card {
    public enum Suit { SPADE, HEART, DIAMOND, CLUB }
    public enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN,
                       EIGHT, NINE, TEN, JACK, QUEEN, KING }

    private final Suit suit;
    private final Rank rank;

    @Override public String toString() {
        return rank + " of " + suit + "S";
    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;

    }
    private static final List<Card> NEW_DECK = newDeckStream();

    // 코드 45-4 데카르트 곱 계산을 반복 방식으로 구현 (275쪽)
    private static List<Card> newDeckIter() {
        List<Card> result = new ArrayList<>();
        for (Suit suit : Suit.values())
            for (Rank rank : Rank.values())
                result.add(new Card(suit, rank));
        return result;
    }

//    // 코드 45-5 데카르트 곱 계산을 스트림 방식으로 구현 (276쪽)
    // flatMap 메소드는 스트림의 원소 각각을 하나의 스트림으로 매핑해 그 스트림들을 다시 하나의 스트림으로 합치는 평탄화 작업이다.
    private static List<Card> newDeckStream() {
        return Stream.of(Suit.values())
                .flatMap(suit ->
                        Stream.of(Rank.values())
                                .map(rank -> new Card(suit, rank)))
                .collect(toList());
    }

    public static void main(String[] args) {
        System.out.println(NEW_DECK);
    }
}
