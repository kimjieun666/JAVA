package chapter11;

import java.util.*;

// 문제 11-8 확장: 전교등수(schoolRank), 반등수(classRank) 계산
class Student6 implements Comparable<Student6> {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    int total;       // 총점
    int schoolRank;  // 전교등수
    int classRank;   // 반등수

    Student6(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.total = kor + eng + math;
    }

    int getTotal() {
        return total;
    }

    float getAverage() {
        return (int)((getTotal() / 3f) * 10 + 0.5f) / 10f; // 소수 첫째자리 반올림
    }

    @Override
    public int compareTo(Student6 o) {
        // 총점 내림차순 (전교등수 계산용)
        return Integer.compare(o.total, this.total);
    }

    @Override
    public String toString() {
        return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + ","
                + getTotal() + "," + getAverage() + "," + schoolRank + "," + classRank;
    }
}

// 반 오름차순 → 같은 반 내 총점 내림차순
class ClassTotalComparator implements Comparator<Student6> {
    @Override
    public int compare(Student6 s1, Student6 s2) {
        int byBan = Integer.compare(s1.ban, s2.ban);
        if (byBan != 0) return byBan;
        return Integer.compare(s2.total, s1.total);
    }
}

public class Java11_09 {

    // 전교등수 계산: 총점 내림차순 정렬 후 동점자는 같은 등수
    public static void calculateSchoolRank(List<Student6> list) {
        Collections.sort(list); // Student6.compareTo 사용(총점 내림차순)
        int prevRank = -1;
        int prevTotal = -1;

        for (int i = 0; i < list.size(); i++) {
            Student6 s = list.get(i);
            if (s.total == prevTotal) {
                s.schoolRank = prevRank;
            } else {
                s.schoolRank = i + 1; // 1부터
            }
            prevRank = s.schoolRank;
            prevTotal = s.total;
        }
    }

    // 반등수 계산: 반 오름차순, 같은 반 내 총점 내림차순 정렬 후 동점 동석차
    private static void calculateClassRank(List<Student6> list) {
        list.sort(new ClassTotalComparator());

        int prevBan = -1;
        int prevRank = -1;
        int prevTotal = -1;
        int nWithinClass = 0; // 같은 반에서의 순번(0부터 증가)

        for (int i = 0; i < list.size(); i++) {
            Student6 s = list.get(i);

            // 새 반 시작 시 초기화
            if (s.ban != prevBan) {
                prevBan = s.ban;
                prevRank = -1;
                prevTotal = -1;
                nWithinClass = 0;
            }

            if (s.total == prevTotal) {
                s.classRank = prevRank;      // 동점은 같은 반등수
            } else {
                s.classRank = nWithinClass + 1;
            }

            prevRank = s.classRank;
            prevTotal = s.total;
            nWithinClass++;
        }
    }

    public static void main(String[] args) {
        List<Student6> list = new ArrayList<>();
        // 네가 제시한 정답 데이터셋
        list.add(new Student6("홍길동", 1, 3, 100, 100, 100));
        list.add(new Student6("김자바", 1, 2, 80, 80, 90));
        list.add(new Student6("남궁성", 1, 1, 90, 70, 80));
        list.add(new Student6("안자바", 2, 2, 60, 100, 80));
        list.add(new Student6("이자바", 2, 1, 70, 90, 70));

        calculateSchoolRank(list); // 전교등수
        calculateClassRank(list);  // 반등수

        // 최종 출력은 반 오름차순 + 총점 내림차순 순서로 표시됨
        for (Student6 s : list) {
            System.out.println(s);
        }
    }
}