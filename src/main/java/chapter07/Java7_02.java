package chapter07;
//문제 7-1의 SutdaDesk클래스에 다음에 정의된 새로운 메서드를 추가하고 테스트하시오.
//1. 메서드명: shuffle
//   기   능: 배열 cards에 담긴 카드의 위치를 뒤섞는다(Math.random()사용).
//   반환타입: 없음
//   매개변수: 없음

//2. 메서드명: pick
//   기   능: 배열 cards에서 지정된 위치의 SutdaCard를 반환한다.
//   반환타입: SutdaCard
//   매개변수: int index - 위치

//3. 메서드명: pick
//   기   능: 배열 cards에서 지정된 위치의 SutdaCard를 반환한다.(Math.random()사용).
//   반환타입: SutdaCard
//   매개변수: 없음

public class Java7_02 {
    static class SutdaDeck {
        final int CARD_NUM = 20;
        SutdaCard[] cards = new SutdaCard[CARD_NUM];

        SutdaDeck() {
            for (int i = 0; i < cards.length; i++) {
                int num = i % 10 + 1;
                boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);
                cards[i] = new SutdaCard(num, isKwang);
            }
        }

        void shuffle() {
            for (int i = 0; i < cards.length; i++) {
                int j = (int) (Math.random() * cards.length);
                // cards[i] cards[j]와의 값을 서로 바꾼다.
                SutdaCard tmp = cards[i];
                cards[i] = cards[j];
                cards[j] = tmp;
            }
        }

        SutdaCard pick(int index) {
            if (index < 0 || index >= CARD_NUM) // index의 유효성을 검사한다.
                return null;
            return cards[index];
        }

        SutdaCard pick() {
            int index = (int) (Math.random() * cards.length);
            return pick(index); // pick(int index)를 호출한다.
        }
    } // SutdaDeck

    static class SutdaCard {
        int num;
        boolean isKwang;

        SutdaCard() {
            this(1, true);
        }

        SutdaCard(int num, boolean isKwang) {
            this.num = num;
            this.isKwang = isKwang;
        }

        public String toString() {
            return num + (isKwang ? "K" : "");
        }
    }

    class Exercise7_2 {
        public static void main(String args[]) {
            SutdaDeck deck = new SutdaDeck();

            System.out.println(deck.pick(0));
            System.out.println(deck.pick());
            deck.shuffle();

            for (int i = 0; i < deck.cards.length; i++)
                System.out.print(deck.cards[i] + ",");

            System.out.println();
            System.out.println(deck.pick(0));
        }
    }
}

//실행결과
//1K
//7
//2,6,10,1K,7,3,10,5,7,8,5,1,2,9,6,9,4,8K,4,3K
//2
