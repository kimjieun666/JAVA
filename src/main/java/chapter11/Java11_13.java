package chapter11;

import java.util.Comparator;
import java.util.TreeMap;

//다음 코드는 문제 11-12를 발전시킨 것으로 각 player들의 점수를 계산하고 점수가 제일 높은 사람을 출력하는 코드이다.
//TreeMap의 정렬기준을 점수가 제일 높은 사람부터 내림차순이 되도록 아래의 코드를 완성하시오.
//단, 동점자 처리는 하지 않는다.
public class JAVA11_13 {
    public static void main(String[] args) throws Exception {
        SutdaDeck deck = new SutdaDeck();

        deck.shuffle();

        Player1[] pArr = {
                new Player1("타짜", deck.pick(), deck.pick()),
                new Player1("고수", deck.pick(), deck.pick()),
                new Player1("물주", deck.pick(), deck.pick()),
                new Player1("중수", deck.pick(), deck.pick()),
                new Player1("하수", deck.pick(), deck.pick()),
        };
        // 점수 기준의 내림차순으로 정렬 (동점자는 같은 키로 간주되어 나중 값이 덮어쓰일 수 있음)
        TreeMap<Player1, Integer> ranks = new TreeMap<>(new Comparator<Player1>() {
            public int compare(Player1 p1, Player1 p2) {
                return p2.point - p1.point; // 높은 점수가 먼저 오도록
            }
        });
        for (int i = 0; i < pArr.length; i++) {
            Player1 p = pArr[i];
            ranks.put(p, deck.getPoint(p));
            System.out.println(p + " " + deck.getPoint(p));
        }

        System.out.println("1위는 " + ranks.firstKey() + "입니다.");
    }
}

class Player1 {
    String name;
    SutdaCard1 c1;
    SutdaCard1 c2;

    int point;

    Player1(String name, SutdaCard1 c1, SutdaCard1 c2) {
        this.name = name ;
        this.c1 = c1 ;
        this.c2 = c2 ;
    }

    public String toString() {
        return "["+name+"]"+ c1.toString() +","+ c2.toString();
    }
} // class Player

class SutdaCard1 {
    int num;
    boolean isKwang;

    SutdaCard1() {
        this(1, true);
    }

    SutdaCard1(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }
    public String toString() {
        return num + ( isKwang ? "K":"");
    }
}