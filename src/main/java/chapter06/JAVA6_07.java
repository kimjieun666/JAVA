package chapter06;
//문제 6-6에서 작성한 클래스메서드 getDistance()를 MyPoint클래스의 인스턴스메서드로 정의하라.
class MyPoint {
    int x;
    int y;

    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    double getDistance(int x, int y) {
        return Math.sqrt((x - this.x)*(x - this.x) + (y - this.y)*(y - this.y));
    }
}
class JAVA6_07 {
    public static void main(String args[]) {
        MyPoint p = new MyPoint(1, 1);
        // p (2,2)와 의 거리를 구한다.
        System.out.println(p.getDistance(2, 2));
    }
}
//실행결과
//1.4142135623730915