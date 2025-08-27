package chapter07;
//문제 7-1에 나오는 섯다카드의 숫자와 종류는 사실 한번 값이 지정되면 변경되어서는 안되는 갓이다.
//카드의 숫자가 한번 잘못 바뀌면 똑같은 카드가 두 장이 될 수도 있기 때문이다.
//이러한 문제점이 발생하지 않도록 아래의 SutdaCard를 수정하시오.
public class Java7_14 {
    static class SutdaCard{
        final int NUM;
        final boolean IS_KWANG;

        SutdaCard() {
            this(1, true);
        }

        SutdaCard(int num, boolean isKwang) {
            this.NUM = num;
            this.IS_KWANG = isKwang;
        }

        public String toString() {
            return NUM + ( IS_KWANG ? "K":"");
        }
    }

    static class Exercise7_14 {
        public static void main(String[] args) {
            SutdaCard card = new SutdaCard(1, true);
        }
    }
}
