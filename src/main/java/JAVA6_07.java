import java.util.Scanner;
class MyPoint {
    int x;
    int y;
    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
/*
인스턴스메서드 를 작성하시오 (1) getDistance .
*/
}
class JAVA6_07 {
    public static void main(String args[]) {
        MyPoint p = new MyPoint(1,1);
        // p (2,2)와 의 거리를 구한다.
        System.out.println(p.getDistance(2,2));
    }
}