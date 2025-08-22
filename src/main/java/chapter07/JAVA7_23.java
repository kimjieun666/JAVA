package chapter07;
//문제 7-22에서 정의한 클래스들의 면적을 구하는 메서드를 작성하고 테스트 하시오.
//메서드명: sumArea
//기   능: 주어진 배열에 담긴 도형들의 넓이를 모두 더해서 반환한다.
//반환타입: double
//매개변수: Shape[] arr
public class JAVA7_23 {
    static double sumArea(Shape[] arr) {
        double sum = 0;

        for (int i = 0; i < arr.length; i++)
            sum += arr[i].calcArea();
        return sum;
        }

        public static void main(String[]args){
            Shape[] arr = {new Circle(5.0), new Rectangle(3,4), new Circle(1)};
        System.out.println("면적의 합:"+sumArea(arr));
        }
    }