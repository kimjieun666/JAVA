package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

//다음에 제시된 BanNoAscending클래스를 완성하여 ArrayList에 담긴 Student인스턴스들이
//반(ban)과 번호(no)로 오름차순 정렬되게 하시오.(반이 같은 경우 번호 비교해서 정렬)
class Student4 {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    Student4 (String name, int ban, int no, int kor, int eng, int math) {
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
}

class BanNoAscending implements Comparator {
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Student1 && o2 instanceof Student1) {
            Student1 s1 = (Student1) o1;
            Student1 s2 = (Student1) o2;

            int result = s1.ban - s2.ban;
            if (result == 0) { //반이 같으면 번호를 비교한다.
                result = s1.no - s2.no;
            }
            return result;
        }
        return -1;
    }
}
public class JAVA11_07 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student1("홍길동", 1, 1, 100, 100, 100));
        list.add(new Student1("남궁성", 1, 2, 90, 70, 80));
        list.add(new Student1("김지은", 1, 3, 80, 80, 90));
        list.add(new Student1("김자바", 1, 4, 70, 90, 70));
        list.add(new Student1("안자바", 1, 5, 60, 100, 80));

        Collections.sort(list, new BanNoAscending());
        Iterator it = list.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
}
//[실행결과]
//홍길동 1 1 100 100 100, 300,100.0
//남궁성 1 2 90 70 80, 240,80.0
//김지은 1 3 80 80 90, 250,83.3
//김자바 1 4 70 90 70, 230,76.7
//안자바 1 5 60 100 80, 240,80.0
//반을 뺼셈한 결과가 '0'이면(반이 같으면) 번호(no)를 뺄셈해서 반환하기만 하면 된다.