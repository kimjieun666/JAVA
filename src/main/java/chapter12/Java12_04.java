package chapter12;

import java.util.ArrayList;
import java.util.List;

//아래의 메서드 두 개의 ArrayList를 매개변수로 받아서 하나의 새로운 ArrayList로
//병합하는 메서드이다. 이를 지네릭 메서드로 변경하시오.
public class Java12_04 {
    public static <T> ArrayList<T> merge(List<? extends T> list, List<? extends T> list2) {
        ArrayList<T> newList = new ArrayList<>(list.size() + list2.size());
        newList.addAll(list);
        newList.addAll(list2);
        return newList;
    }
}