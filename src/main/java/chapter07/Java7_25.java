package chapter07;
//Outer클래스의 내부 클래스 lnner의 멤버변수 iv의 값을 출력하시오.
    class Outer1{
        class Inner1{
            int iv=100;
        }
    }

class Java7_25 {
        public static void main(String[] args) {
            Outer1 o = new Outer1();
            Outer1.Inner1 ii = o.new Inner1();
            System.out.println(ii.iv);
        }
}
//[실행결과]
//100