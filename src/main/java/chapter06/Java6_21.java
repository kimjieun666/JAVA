package chapter06;
//Tv클래스를 주어진 로직대로 완성하시오. 완성한 후 실행해서 주어진 실행결과와 일치하는지 확인하라.[참고]코드를 단순히 하기 위해 유효성검사는 로직으로 제외했다.
    class MyTv {
        boolean isPowerOn;
        int channel;
        int volume;

        final int MAX_VOLUME = 100;
        final int MIN_VOLUME = 0;
        final int MAX_CHANNEL = 100;
        final int MIN_CHANNEL = 1;

        void turnOnOff() {
            isPowerOn = !isPowerOn; //isPowerOn의 값이 true면 false로 false면 true로 바꾼다.
        }
        void volumeUp() {
        if (volume < MAX_VOLUME)//volume의 값이 max_volume보다 작을 때만 값을 1 증가
            volume++;
        }
        void volumeDown() {
            if (volume > MIN_VOLUME)//volume의 값이 MIN_VOLUME보다 클 때만 값을 1감소시킨다.
                volume--;
        }
        void channelUp() {
            if (channel == MAX_CHANNEL) {//channel의 값을 1증가시킨다.
                channel = MIN_CHANNEL;
            } else {
                channel++;//만일 channel값이 max_channel이면, channel의 값을 MIN_CHANNEL로 바꾼다.
            }
        }
            void channelDown() {//channerl의 값을 1 감소
                if (channel == MIN_CHANNEL) {
                    channel = MAX_CHANNEL;//만일 channel값이 min_channel이면, channel의 값을 MAX_CHANNEL로 바꾼다.
                } else {
                    channel--;
                }
            }
        public class Java6_21 {
                public static void main(String[] args) {
                    MyTv t = new MyTv();

                    t.channel = 100;
                    t.volume = 0;
                    System.out.println("CH:"+t.channel+ ", VOL:" + t.volume);

                    t.channelDown();
                    t.volumeDown();
                    System.out.println("CH:"+ t.channel + ", VOL:" + t.volume);

                    t.volume = 100;
                    t.channelUp();
                    t.volumeUp();
                    System.out.println("CH:"+ t.channel + ", VOL:" + t.volume);
                }
            }
        }
