package tw.edu.kuas.mis.yuan.D20140715;

import java.util.Timer;

public class TimerDemo {
	 public static void main(String[] args) {
		 Timer timer = new Timer();
		 timer.schedule(new Facebook(), 1000,200000000);
	 }
}