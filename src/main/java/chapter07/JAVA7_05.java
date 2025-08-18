package chapter07;
//다음 코드는 컴파이라면 에러가 발생한다. 그 이유를 설명하고 에러를 수정하기 위해서는 코드를 어떻게 바꾸어야 하나?
public class JAVA7_05 {
    static class Product
    {
        int price; //제품의 가격
        int bonusPoint;//제품구매 시 제공하는 보너스점수

        Product() {} //****에러 수정을 위해 추가 됨.

        Product(int price) {
            this.price = price;
            bonusPoint =(int)(price/10.0);
        }
    }
    static class Tv extends Product {
        Tv() {}
        public String toString() {
            return "Tv";
        }
    }
    static class Exercise7_5 {
        public static void main(String[] args) {
            Tv t = new Tv();
        }
    }
}
//Product 클래스에 기본 생성자 Product()가 없기 때문에 에러 발생
//Product 클래스에 기본 생성자 Product() {}를 추가해 줘야한다.