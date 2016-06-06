package rhonda;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class PiGpio {
	private GpioController gpio = GpioFactory.getInstance();
	private GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12);
	
	PiGpio() {
		
	}
	
	public void wakeup() {
		pin.setShutdownOptions(true, PinState.LOW);
		pin.high();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		pin.low();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		pin.high();
	}
}
