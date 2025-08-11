package chapter06;
//다음의 코드를 컴파일하면 에러가 발생한다. 컴파일 에러가 발생하는 라인과 그 이유를 설명하라.
//에러가 생길 수 있는 경우
//문법 오류, 정의가 안된 변수나 클래스 사용, 잘못된 타입 사용, import 누락, 상속 혹은 오버라이딩 오류, 접근제한위반, 생성자호출문제
public class JAVA6_18 {

}
class MemberCall{
    static int iv = 10;
    static int cv = 20;

    int iv2 = cv;
    static int cv2 = iv;//라인A 클래스 변수에서 인스턴스 변수 사용하지 않음

    static void staticMethod1(){
        System.out.println(cv);
        System.out.println(iv);//라인B Static 메서드에서 인스턴스 변수 사용하지 않음
    }
    static void instanceMethod1(){
        System.out.println(cv);
        System.out.println(iv);//라인C 인스턴스 메서드 -> 인스턴수, 변수/ 클래스, 변수 모두 접근이 가능
    }
    static void staticMethod2(){
        staticMethod1();
        instanceMethod1();//라인D Static 메서드 -> 인스턴스 메서드 직접 호출 안됨
    }
    void instanceMethod2(){
        staticMethod1();
        instanceMethod1();//라인E 인스턴스 메서드
    }
}
//답변: A,B,D