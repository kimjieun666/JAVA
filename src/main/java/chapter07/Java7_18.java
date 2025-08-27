package chapter07;
//다음과 같은 실행결과를 얻도록 코드를 완성하시오.
//[hint] instanceof연산자를 사용해서 형변환한다.
//메서드명: action
//기   능: 주어진 객체의 메서드를 호출한다.
//        DanceRobot인 경우, dance()를 호출하고
//        SingRobot인 경우, sing()을 호출하고
//        DrawRobot인 경우, draw()를 호출한다.
//반환타입: 없음
//매개변수: Robot r - Robot인스턴스 또는 Robot의 자손 인스턴스
public class Java7_18 {
    public static void action(Robot r) {
        if(r instanceof DanceRobot) {
            DanceRobot dr = (DanceRobot)r;
            dr.dance();
        } else if(r instanceof SingRobot) {
            SingRobot sr = (SingRobot)r;
            sr.sing();
        } else if(r instanceof DrawRobot) {
            DrawRobot dr = (DrawRobot)r;
            dr.draw();
        }
    }

    public static void main(String[] args) {

        Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot()};
        for(int i=0; i< arr.length;i++)
            action(arr[i]);
    } // main
}
class Robot {}

class DanceRobot extends Robot {
    void dance() {
        System.out.println("춤을 춥니다.");
    }
}
class SingRobot extends Robot {
    void sing() {
        System.out.println("노래를 합니다.");
    }
}
class DrawRobot extends Robot {
    void draw() {
        System.out.println("그림을 그립니다.");
    }
}
//[실행결과]
//춤을 춥니다.
//노래를 합니다.
//그림을 그립니다.
