package chapter11;
//다음은 SutdaCard클래스를 HashSet에 저장하고 출력하는 예제이다
//HashSet에 중복된 카드가 저장되지 않도록 SutdaCard의 hashCode()를 알맞게 오버라이딩하시오
import java.util.*;
class SutdaCard {
    int num;
    boolean isKwang;
    SutdaCard() {
        this(1, true);
    }
        SutdaCard(int num, boolean isKwang) {
            this.num = num;
            this.isKwang = isKwang;
        }

    public boolean equals(Object obj) {
        if(obj instanceof SutdaCard1) {
            SutdaCard1 c = (SutdaCard1)obj;
            return num==c.num && isKwang==c.isKwang;
        } else {
            return false;
        }
    }
    public String toString() {
        return num + ( isKwang ? "K":"");
    }
    public int hashCode() {
        return toString().hashCode(); // String클래스의 hashCode()를 호출한다.
    }
}
public class Java11_11 {
    public static void main(String[] args) {
        SutdaCard1 c1 = new SutdaCard1(3,true);
        SutdaCard1 c2 = new SutdaCard1(3,true);
        SutdaCard1 c3 = new SutdaCard1(1,true);

        HashSet set = new HashSet();
        set.add(c1);
        set.add(c2);
        set.add(c3);

        System.out.println(set);
    }
}
//[실행결과]
//[3K, 1K]