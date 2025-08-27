package chapter06;
//다음과 같은 실행결과를 얻도록 Student클래스에 생성자와 info()를 추가하라.
public class Java6_05 {
    public static void main(String[] args) {
        Student s = new Student("홍길동",1,1,100,60,76);
        System.out.println(s.info());
    }
}
class Student {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public Student() {

    }

    String info() {
        double avg = getAverage();
        return name + " " + ban + " " + no + " " + kor + " " + eng + " " + math + " " + avg;
    }

    public int getTotal() {
        return kor + eng + math;
    }

    public double getAverage() {
        int total = getTotal();
        return Math.round((total * 10) / 3f) / 10d;
    }
}
//실행결과
//홍길동, 1, 1, 100, 60, 76, 236, 78.7
