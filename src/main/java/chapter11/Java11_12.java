package chapter11;
//다음은 섯다게임에서 카드의 순위를 결정하는 등급목록(족보)이다.
//HashMap에 등급과 점수를 저장하는 registerJokbo()와 게임참가자의 점수를 계산해서 반환하는
//getPoint()를 완성하시오.
import java.util.*;
public class Java11_12 {
    public static void main(String args[]) throws Exception {
        SutdaDeck deck = new SutdaDeck();
        deck.shuffle();

        Player1 p1 = new Player1("타짜", deck.pick(), deck.pick());
        Player1 p2 = new Player1("고수", deck.pick(), deck.pick());

        System.out.println(p1+" "+deck.getPoint(p1));
        System.out.println(p2+" "+deck.getPoint(p2));
    }
}
class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard1[] cards = new SutdaCard1[CARD_NUM];
    int pos = 0;
    Map<String, Integer> jokbo = new HashMap<>();

    SutdaDeck() {
        for (int i = 0; i < cards.length; i++) {
            int num = i % 10 + 1;
            boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);
            cards[i] = new SutdaCard1(num, isKwang);
        }
        registerJokbo();
    }

    private void registerJokbo() {
        // 광땡
        jokbo.put("KK", 4000);

        // 땡(10~1)
        jokbo.put("1010", 3100);
        jokbo.put("99", 3090);
        jokbo.put("88", 3080);
        jokbo.put("77", 3070);
        jokbo.put("66", 3060);
        jokbo.put("55", 3050);
        jokbo.put("44", 3040);
        jokbo.put("33", 3030);
        jokbo.put("22", 3020);
        jokbo.put("11", 3010);

        // 특수(알리,독사,구삥,장삥,장사,세륙 등)
        jokbo.put("12", 2060);
        jokbo.put("21", 2060); // 알리
        jokbo.put("14", 2050);
        jokbo.put("41", 2050); // 독사
        jokbo.put("19", 2040);
        jokbo.put("91", 2040); // 구삥
        jokbo.put("110", 2030);
        jokbo.put("101", 2030); // 장삥
        jokbo.put("104", 2020);
        jokbo.put("410", 2020); // 장사
        jokbo.put("46", 2010);
        jokbo.put("64", 2010); // 세륙
    }

    public int getPoint(Player1 p) {
        if (p == null) return 0;

        SutdaCard1 c1 = p.c1;
        SutdaCard1 c2 = p.c2;

        Integer score;

        // 광땡
        if (c1.isKwang && c2.isKwang) {
            score = jokbo.get("KK");
        } else {
            // 땡/특수 조합 먼저 찾기
            score = jokbo.get("" + c1.num + c2.num);
            if (score == null) {
                score = jokbo.get("" + c2.num + c1.num); // 순서 반대도 시도
            }
            // 일반 끗: (합 % 10) + 1000
            if (score == null) {
                score = Integer.valueOf((c1.num + c2.num) % 10 + 1000);
            }
        }

        p.point = score; // 플레이어에 점수 저장(필드가 있다면)
        return score;
    }

    SutdaCard1 pick() throws Exception {
        if (pos < 0 || pos >= CARD_NUM) {
            throw new Exception("남아있는 카드가 없습니다.");
        }
        SutdaCard1 c = cards[pos];
        cards[pos] = null; // 이미 뽑은 카드는 비워두기
        pos++;
        return c;
    }

    void shuffle() {
        // Fisher–Yates 스타일 셔플
        for (int i = CARD_NUM - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            SutdaCard1 tmp = cards[i];
            cards[i] = cards[j];
            cards[j] = tmp;
        }
        pos = 0; // 셔플 후 처음부터 다시 뽑을 수 있게 위치 초기화
    }
}

//[실행결과]
//[타짜]8K,3 1001
//[고수]9,1K 2040

