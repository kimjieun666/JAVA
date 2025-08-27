package chapter07;
//다음과 같은 실행결과를 얻도록 1~4의 코드를 완성하시오
    class Outer2{
        int value =10; //outer.this.value

        class Inner{
            int value =20; //this.value

            void method(){
                int value =30; //value

            System.out.println(value);
            System.out.println(this.value);
            System.out.println(Outer2.this.value);
        }
    }//inner클래스 끝
}//outer클래스 끝
public class Java7_27 {
        public static void main(String[] args) {
            Outer2 o = new Outer2();
            Outer2.Inner ii = o.new Inner();
            ii.method();
        }
}
//[실행결과]
//30
//20
//10