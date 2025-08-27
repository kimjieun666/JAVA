package chapter06;
//문제 6-3에서 정의한 Student클래스에 다음과 같이 정의된 두 개의 메서드 getTotal()과 getAverage()를 추가하라.
//1. 메서드명: getTotal
//   기   능: 국어(kor), 영어(eng), 수학(math)의 점수를 모두 더해서 반환한다.
//   반환타입: int
//   매개변수: 없음
//2. 메서드명: getAverage
//   기   능: 총점(국어(kor), 영어(eng), 수학(math))을 과목수로 나눈 평균을 구한다.
//   반환타입: float
//   매개변수: 없음
public class Java6_04 {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "홍길동";
        s.ban = 1;
        s.no = 1;
        s.kor = 100;
        s.eng = 60;
        s.math = 76;

        System.out.println("이름:"+s.name);
        System.out.println("총점:"+s.getTotal());
        System.out.println("평균:"+s.getAverage());
    }
}
class Student2 {
    String  name;
    int ban;
    int no;
    int kor;
    int eng;
    int math; //선언

    int getTotal() {
        return kor + eng + math; //총점
    }

    float getAverage() {
        return (int) (getTotal() / 3f * 10 + 0.5f) / 10f;
    }
}
//10f로 나눠서 둘째자리 만들기
//실행결과
//이름: 홍길동
//총점: 236
//퍙균: 78.7