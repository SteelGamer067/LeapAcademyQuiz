package leapacademyquiz.utilities;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {
	static int interval;
	static Timer timer;
	public static int time = 0;
	
	public void countdown() {
		int delay = 1000,  period = 1000;
	    timer = new Timer();
	    interval = 181;
	    timer.scheduleAtFixedRate(new TimerTask() {

	        public void run() {
	            System.out.println(setInterval());

	        }
	    }, delay, period);
	}

	public final int setInterval() {
	    if (interval == 1) timer.cancel();
	    return --interval;
	}
	
	public static void main(String[] args) {
		CountdownTimer cdTimer = new CountdownTimer();
		cdTimer.countdown();
	}
}
