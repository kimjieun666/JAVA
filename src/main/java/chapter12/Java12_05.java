package chapter12;

//아래는 예제7-3에 열거형 Kind와 Number를 새로 정의하여 적용한 것이다
//에 알맞은 코드를 넣어 예제를 완성하시오.
//(Math.random()을 사용했으므로 실행결과가 달라질 수 있다.)
public class Java12_05 {
    public static void main(String[] args) {
        Deck d = new Deck();
        Card c = d.pick(0);
        System.out.println(c);

        d.shuffle();
        c = d.pick(0);
        System.out.println(c);
    }
}

class Deck {
    final int CARD_NUM = Card.Kind.values().length * Card.Number.values().length;
    Card[] cardArr = new Card[CARD_NUM];

    Deck() {
        int i = 0;
        for (Card.Kind kind : Card.Kind.values()) {
            for (Card.Number num : Card.Number.values()) {
                cardArr[i++] = new Card(kind, num);
            }
        }
    }

    Card pick(int index) {
        return cardArr[index];
    }

    Card pick() {
        int index = (int) (Math.random() * CARD_NUM);
        return pick(index);
    }

    void shuffle() {
        for (int i = 0; i < cardArr.length; i++) {
            int r = (int) (Math.random() * CARD_NUM);
            Card temp = cardArr[i];
            cardArr[i] = cardArr[r];
            cardArr[r] = temp;
        }
    }
}

class Card {
    enum Kind {CLOVER, HEART, DIAMOND, SPADE}

    enum Number {
        ACE, TWO, THREE, FOUR, FIVE,
        SIX, SEVEN, EIGHT, NINE, TEN,
        JACK, QUEEN, KING
    }

    Kind kind;
    Number num;

    Card() {
        this(Kind.SPADE, Number.ACE);
    }

    Card(Kind kind, Number num) {
        this.kind = kind;
        this.num = num;
    }

    public String toString() {
        return "[" + kind.name() + "," + num.name() + "]";
    }
}