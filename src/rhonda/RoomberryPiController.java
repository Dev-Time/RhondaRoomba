package rhonda;

import java.util.concurrent.TimeUnit;

public class RoomberryPiController {
	private PiSerial ser;
	private boolean started = false;
	private int controlmode = 0;
	
	RoomberryPiController(PiSerial ser) {
		this.ser = ser;
	}
	
	public void start() {
		if (started == false) {
			ser.write(128);
			started = true;
			controlmode = 1;
			try {
				TimeUnit.MILLISECONDS.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
	public void control() {
		if (started == true && controlmode != 1) {
			ser.write(130);
			try {
				TimeUnit.MILLISECONDS.sleep(20);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		}
	}
	public void clean() {
		if (started == true) {
			ser.write(135);
		}
	}
	public void wakeup() {
		PiGpio gpio = new PiGpio();
		gpio.wakeup();
	}
}
