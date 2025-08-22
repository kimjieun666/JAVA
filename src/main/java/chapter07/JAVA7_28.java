package chapter07;
//아래의 를 익명 클래스 로 변경하시오
import java.awt.*;
import java.awt.event.*;
public class JAVA7_28 {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.addWindowListener(new EventHandler());
    }

    static class EventHandler extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            e.getWindow().dispose();
            System.exit(0);
        }
    }
}