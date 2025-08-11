package chapter06;
//다음의 코드에 정의된 변수들을 종류별로 구분해서 적으시오.
public class JAVA6_08 {
}
class PlayingCard {
    int kind;
    int num;

    static int width;
    static int height;

    PlayingCard(int k, int n) {
        this.kind = k;
        this.num = n;
    }
    public static void main(String[] args) {
        PlayingCard card = new PlayingCard(1, 1);
    }
}

//클래스변수(static변수) : Width, height
//인스턴스변수: kind, num
//지역변수: k, n, card, args