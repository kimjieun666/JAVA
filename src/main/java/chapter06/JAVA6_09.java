package chapter06;
//다음은 컴퓨터 게임의 병사(marine)를 클래스로 정의한 것이다. 이 클래스의 멤버 중에 static을 붙여야 하는 것은 어떤 것들이고 그 이유는 무엇인가?
//단, 모든 병사의 공격력과 방어력은 같아야 한다.
public class JAVA6_09 {
    public static void main(String[] args) {

    }
}

class Marine{
    int x=0, y=0;//마린의 위치좌표(x,y)
    int hp = 60;//현재체력
    int weapon = 6;//공격력
    int armor = 0;//방어력

    void weaponUp(){
        weapon++;
    }
    void armorUp(){
        armor++;
    }
    void move(int x, int y){
        this.x=x;
        this.y=y;
    }
}
//답변: static은 weapon, armor 모두 필요하다.
//모든 병사가 동일한 공격력과 방어력으로 즉, 공유되는 값으로 볼 수 있다.