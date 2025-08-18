package chapter07;
//문제7-10에서 작성한 MyTv2클래스에 이전 채널로 이동하는 기능의 메서드를 추가해서 실행결과를 얻도록 하라.
//[hint] 이전 채널의 값을 저장할 멤버변수를 정의하라
//메서드명: gotoPrevChannel
//기   능: 현재 채널을 이전 채널로 변경한다.
//반환타입: 없음
//매개변수: 없음
public class JAVA7_11 {
    static class MyTv2 {
        private boolean isPowerOn;
        private int channel;
        private int volume;
        private int prevChannel; //**추가) 이전 채널

        final int MAX_VOLUME = 100;
        final int MIN_VOLUME = 0;
        final int MAX_CHANNEL = 100;
        final int MIN_CHANNEL = 1;

        public void setVolume(int volume) {
            if (volume > MAX_VOLUME || volume < MIN_VOLUME)
                return;

            this.volume = volume;
        }

        public int getVolume() {
            return volume;
        }

        public void setChannel(int channel) {
            if (channel > MAX_CHANNEL || channel < MIN_CHANNEL)
                return;

            prevChannel = this.channel; //현재 채널을 이전 채널에 저장한다.
            this.channel = channel;
        }

        public int getChannel() {
            return channel;
        }

        public void gotoPrevChannel() {
            setChannel(prevChannel); //**추가) 현재 체널을 이전 채널로 변경한다.
        }
    }
    static class Exercise7_11 {
        public static void main(String args[]) {
            MyTv2 t = new MyTv2();
            t.setChannel(10);
            System.out.println("CH:"+t.getChannel());
            t.setChannel(20);
            System.out.println("CH:"+t.getChannel());
            t.gotoPrevChannel();
            System.out.println("CH:"+t.getChannel());
            t.gotoPrevChannel();
            System.out.println("CH:"+t.getChannel());
        }
    }
}
//실행결과
//CH:10
//CH:20
//CH:10
//CH:20
