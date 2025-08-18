package chapter07;
//아래 세 개의 클래스로부터 공통부분을 뽑아서 Unit이라는 클래스를 만들고
//이 클래스를 상속받도록 코드를 변경하시오.
// 공통 부모: 위치(x,y)와 정지(stop)는 공통, 이동(move)은 유닛마다 다르니 추상 메서드로 강제
// 공통 부모 클래스
abstract class Unit {
    int x, y; // 현재 위치

    abstract void move(int newX, int newY); // 이동 (유닛마다 구현)
    void stop() { } // 현재 위치에 정지
}

class Marine extends Unit { // 보병
    void move(int newX, int newY) { // 지정된 위치로 이동
        x = newX;
        y = newY;
    }
    void stimPack() { } // 스팀팩 사용
}

class Tank extends Unit { // 탱크
    void move(int newX, int newY) { // 지정된 위치로 이동
        x = newX;
        y = newY;
    }
    void changeMode() { } // 공격모드 변환
}

class Dropship extends Unit { // 수송선
    void move(int newX, int newY) { // 지정된 위치로 이동
        x = newX;
        y = newY;
    }
    void load() { }   // 선택된 대상을 태움
    void unload() { } // 선택된 대상을 내림
}