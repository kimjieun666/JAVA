package chapter06;
//문제 6-1에서 정의한 SutdaCard클래스에 두 개의 생성자와 info()를 추가해서 실행결과와 같은 결과를 얻도록 하기

public class JAVA6_02 {
    public static void main(String [] args) {
        SutdaCard card1 = new SutdaCard(3, false);
        SutdaCard card2 = new SutdaCard();

        System.out.println(card1.info());//3출력
        System.out.println(card2.info());//1K출력
    }
}

class SutdaCard {
    int num;//1~10
    boolean isKwang;//광 여부
    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang; //매개변수 있는 생성자
    }
    SutdaCard() {
        this(1,true);//SutdaCard(1, true) 호출한다.
    }
    String info() {
        return num + ( isKwang? "K" : " ");//숫자를 문자열로 반환한다. 광이면 K를 추가로 붙인다.
    }
}
//실행결과
//3
//1K