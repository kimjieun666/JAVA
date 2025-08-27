package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//문제 11-7의 Student클래스에 총점(total)과 전교등수(schoolRank)를 저장하기 위한 인스턴스변수를 추가하였다.
//Student클래스의 기본정렬을 이름(Name)이 아닌 총점을 기준으로 한 내림차순으로 변경한 다음
//총점을 기준으로 각 학생의 전교등수를 계산하고 전교등수를 기준으로 오름차순 정렬하여 출력하시오.
class Student5 implements Comparable {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    int total; //총점
    int schoolRank; //전교등수

    Student5 (String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;

        total = kor + eng + math;
    }

    int getTotal() {
        return total;
    }

    float getAverage() {
        return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
    }

    public int compareTo(Object o) {
        if (o instanceof Student5) {
            Student5 tmp = (Student5) o;

            return tmp.total - this.total; //총점 기준(내림차순)으로 정렬한다.
        } else {
            return -1;
        }
    }

    public String toString() {
        return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage() + "," + schoolRank; //새로추가
    }
}
public class Java11_08 {
    public static void calculateSchoolRank(List list) {
        Collections.sort(list);

        int prevRank = -1; // 이전 전교등수
        int prevTotal = -1; //이전 총점
        int lenght = list.size();

        for (int i = 0; i < lenght; i++) {
            Student5 s = (Student5) list.get(i);

            if (s.total == prevTotal) {
                s.schoolRank = prevRank;
            } else {
                s.schoolRank = i + 1;
            }
            prevRank = s.schoolRank;
            prevTotal = s.total;
        }
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student1("홍길동", 2, 1, 70, 90, 70));
        list.add(new Student1("남궁성", 2, 2, 60, 100, 80));
        list.add(new Student1("김지은", 1, 3, 100, 100, 100));
        list.add(new Student1("김자바", 1, 1, 90, 70, 80));
        list.add(new Student1("안자바", 1, 2, 80, 80, 90));

        Collections.sort(list, new BanNoAscending());
        Iterator it = list.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}

//[실행결과]
//김자바 1 1 90 70 80, 240,80.0
//안자바 1 2 80 80 90, 250,83.3
//김지은 1 3 100 100 100, 300,100.0
//홍길동 2 1 70 90 70, 230,76.7
//남궁성 2 2 60 100 80, 240,80.0