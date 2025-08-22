package chapter07;
//다음의 코드를 실행한 결과를 적으시오.
public class JAVA7_20 {
    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();

        System.out.println("p.x =" + p.x);
        p.method();

        System.out.println("c.x =" + c.x);
        c.method();
    }
}
class Parent {
    int x = 100;

    void method() {
        System.out.println("Parent Method");
    }
}
class Child extends Parent {
    int x = 200;
    void method() {
        System.out.println("Child Method");
    }
}
//[실행결과]
//p.x =100
//Child Method
//c.x =200
//Child Method