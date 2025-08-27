package chapter06;
//다음과 같이 정의된 메서드를 작성하고 테스트하시오.
//메서드명: Max
//기   능: 주어진 int형 배열의 값 중에서 제일 큰 값을 반환한다.
//        만일 주어진 배열이 null이거나 크기가 0인 경우 -999999를 반환한다.
//반환타입: int
//매개변수: int[] arr - 최대값을 구할 배열
public class Java6_23 {
    public static int max(int[] arr) {
        if (arr == null || arr.length == 0)
            return -999999;
        int max = arr[0]; //배열의 첫 번째 값으로 최대값을 초기화 한다.
        for (int i = 1; i < arr.length; i++) { //배열의 두 번째 값부터 비교한다.
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = {3, 2, 9, 4, 7};
        System.out.println(java.util.Arrays.toString(data));
        System.out.println("최대값:" + max(data));
        System.out.println("최대값:" + max(null));
        System.out.println("최대값:" + max(new int[]{})); //크기가 0인 배열
    }
}
//실행결과
//[3, 2, 9, 4, 7]
//최대값: 9
//최대값: -999999
//최대값: -999999