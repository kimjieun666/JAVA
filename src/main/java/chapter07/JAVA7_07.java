package chapter07;
//다음 코드의 실행했을 때 호출되는 생성자의 순서와 실행결과를 적으시오.
//생성자 조건
//1. 다른 클래스 호출 시 첫 줄에 작성해야한다.
//2. 이름이 클래스와 동일해야 한다.
//3. 반환타입 없음(void)
//4. 다른 생성자 호출 this()필요.
public class JAVA7_07 {
    static class Parent {
        int x=100;
        Parent() {
            this(200); // Parent(int x)를 호출
        }
        Parent(int x) {
            this.x = x;
        }
        int getX() {
            return x;
        }
    }
    static class Child extends Parent {
        int x = 3000;

        Child() {
            this(1000); // Child(int x)를 호출
        }
        Child(int x) {
            this.x = x;
        }
    }
    static class Exercise7_7 {
        public static void main(String[] args) {
            Child c = new Child();

            System.out.println("x="+c.getX());
        }
    }
}
