package chapter06;
//다음과 같이 정의된 메서드를 작성하고 테스트하시오.[주의]Math.random()을 사용하는 경우 실행결과와 다를 수 있음
//메서드명: shuffle
//기   능: 주어진 배열에 담긴 값의 위치를 바꾸는 작업을 반복하여 뒤섞이게 한다. 처리한 배열을 반환.
//반환타입: int[]
//매개변수: int[] arr - 정수값이 담긴 배열
public class JAVA6_20 {
    public static int[] shuffle(int[] arr) {
        if (arr == null || arr.length == 0) return arr; //null 또는 빈 배열이면 그대로 반환

        for (int i = 0; i < arr.length; i++) { //0 ~ arr.length-1 사이의 랜덤 인덱스
            int randomIndex = (int) (Math.random() * arr.length);

            int temp = arr[i];//현재 i번째 값과 랜덤 인덱스 값을 교환];
            arr[randomIndex] = temp;
        }
        return arr;
    }
    public static void main(String[] args)
    {
        int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(java.util.Arrays.toString(original));

        int[] result = shuffle(original);
        System.out.println(java.util.Arrays.toString(result));
    }
}
//실행결과
//[1,2,3,4,5,6,7,8,9]
//[4,6,8,3,2,9,7,1,5]
