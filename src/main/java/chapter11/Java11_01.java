package chapter11;

import java.util.ArrayList;

//다음은 정수집합 1,2,3,4와 3,4,5,6의 교집합, 차집합, 합집합을 구하는 코드이다.
//코드를 완성하여 실행결과와 같은 결과를 출력하시오.
public class JAVA11_01 {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        ArrayList kyo = new ArrayList(); //교
        ArrayList cha = new ArrayList(); //차
        ArrayList hap = new ArrayList(); //합

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);

        kyo.addAll(list1);//list1의 모든 요소를 kyo에 저장한다.
        kyo.retainAll(list2);//list2와 kyo의 공통요소만 남기고 삭제한다.

        cha.addAll(list1);//cha에서 list2와 공통된 요소들을 모두 삭제한다.
        cha.removeAll(list2);

        hap.addAll(list1);//list1의 모든 요소를 hap에 저장한다.
        hap.removeAll(kyo);//hap에서 kyo와 공통된 모든 요소를 삭제한다.
        hap.addAll(kyo);//list2와 모든 요소를 hap에 저장한다.

        System.out.println("list1="+list1);
        System.out.println("list2="+list2);
        System.out.println("kyo="+kyo);
        System.out.println("cha="+cha);
        System.out.println("hap="+hap);
    }
}
//list1=[1, 2, 3, 4]
//list2=[3, 4, 5, 6]
//kyo=[3, 4]
//cha=[1, 2]
//hap=[1, 2, 3, 4, 5, 6]