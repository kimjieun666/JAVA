package chapter07;
//Outer클래스의 내부 클래스 Inner의 멤버변수 iv의 값을 출력하시오.
class Outer{
    static class Inner{
        int iv=200;
    }
}

class Java7_26 {
    public static void main(String[] args) {
        Outer.Inner ii = new Outer.Inner();
        System.out.println(ii.iv);
    }
}
//[실행결과]
//200