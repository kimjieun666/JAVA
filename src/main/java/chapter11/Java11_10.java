package chapter11;
//다음 예제의 빙고판은 1~30사이의 숫자들로 만든 것인데 숫자들의 위치가 잘 섞이지 않는다는 문제가 있다.
//이러한 문제가 발생하는 이유와 이 문제를 개선하기 위한 방법을 설명, 이를 개선한 새로운 코드 작성
import java.util.*;
public class Java11_10
//HashSet은 중복을 허용하지 않고 순서를 유지하지 않기 때문에 발생하는 문제이다
//아무리 임의의 순서로 저장을 해도 해싱 알고리즘의 특성상 한 숫자가 고정된 위치에 저장되기 때문이다.
//이 문제를 해결하기 위해서는 저장순서를 유지하는 List 인터페이스를 구현한 컬렉션 클래스를 사용하도록 변경해야 한다.
{
    public static void main(String[] args)
    {
        Set set = new HashSet();
        int[][] board = new int[5][5];
        for(int i=0; set.size() < 25; i++) {
            set.add((int)(Math.random()*30)+1+"");
        }
        ArrayList list = new ArrayList(set);
        Collections.shuffle(list);

        Iterator it = list.iterator();
        for(int i=0; i < board.length; i++) {
            for(int j=0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt((String)it.next());
                System.out.print((board[i][j] < 10 ? " " : " ") + board[i][j]);
            }
            System.out.println();
        }
    } // main
}