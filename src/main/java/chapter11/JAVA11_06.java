package chapter11;
//다음의 코드는 성적평균의 범위별로 학생 수를 세기 위한 것이다. TreeSet이 학생들의 평균을 기준으로 정렬하도록
//compare(Object o1, Object o2)와 평균점수의 범위를 주면 해당 범위에 속한 학생의 수를 반환하는 getGroupCount()를 완성하라

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Student3 implements Comparable {
        String name;
        int ban;
        int no;
        int kor;
        int eng;
        int math;

        Student3(String name, int ban, int no, int kor, int eng, int math) {
            this.name = name;
            this.ban = ban;
            this.no = no;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
        int getTotal() {
            return kor + eng + math;
        }
        float getAverage() {
            return (int)((getTotal()/ 3f)*10+0.5)/10f;
        }

        public String toString() {
            return name
                    +","+ban
                    +","+no
                    +","+kor
                    +","+eng
                    +","+math
                    +","+getTotal()
                    +","+getAverage()
                    ;
        }
    // 이름으로 정렬하기 (TreeSet에서 필요하지만 여기선 Comparator를 따로 씀)
    public int compareTo(Object o) {
        if (o instanceof Student3) {
            Student3 tmp = (Student3) o;
            return name.compareTo(tmp.name);
        } else {
            return -1;
        }
    }
}

public class JAVA11_06 {
    static int getGroupCount(TreeSet<Student3> tset, int from, int to) {
        Student3 s1 = new Student3("",0,0,from,from,from);
        Student3 s2 = new Student3("",0,0,to,to,to);

        // from 이상, to 미만
        return tset.subSet(s1, true, s2, false).size();
    }

    public static void main(String[] args) {
        TreeSet<Student3> set = new TreeSet<>(new Comparator<Student3>() { //익명클래스
            public int compare(Student3 s1, Student3 s2) {
                return (int)(s1.getAverage() - s2.getAverage());
            }
        });

        set.add(new Student3("홍길동", 1, 1, 100, 100, 100));
        set.add(new Student3("남궁성", 1, 2, 90, 70, 80));
        set.add(new Student3("김지은", 1, 3, 80, 80, 90));
        set.add(new Student3("김자바", 1, 4, 70, 90, 70));
        set.add(new Student3("안자바", 1, 5, 60, 100, 80));

        Iterator<Student3> it = set.iterator();
        while(it.hasNext())
            System.out.println(it.next());

        System.out.println("[60~69] :" + getGroupCount(set,60,70));
        System.out.println("[70~79] :" + getGroupCount(set,70,80));
        System.out.println("[80~89] :" + getGroupCount(set,80,90));
        System.out.println("[90~100] :" + getGroupCount(set,90,101));
    }
}
//[실행결과]
//김자바,1,4,70,90,70,230,76.7
//남궁성,1,2,90,70,80,240,80.0
//김지은,1,3,80,80,90,250,83.3
//홍길동,1,1,100,100,100,300,100.0
//[60~69] :0
//[70~79] :1
//[80~89] :2
//[90~100] :1