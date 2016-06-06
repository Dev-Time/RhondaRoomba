package rhonda;

import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialDataListener;
import com.pi4j.io.serial.SerialFactory;

public class PiSerial {
	private int baud;
	private Serial serial;
	private SerialDataListener serialdl;
	
	PiSerial(int baud) {
		this.baud = baud;
	}
	
	public void init() {
		serial = SerialFactory.createInstance();
		serialdl = new MySerialDataListener();
		serial.addListener(serialdl);
		if (serial.isClosed()) {
			serial.open(Serial.DEFAULT_COM_PORT, baud);
		}
	}
	public void write(int i) {
		if (serial.isOpen()) {
			serial.write((byte) i);
			serial.flush();
		}
		
	}
	public void close() {
		if (serial.isOpen()) {
			serial.close();
		}
	}
}
