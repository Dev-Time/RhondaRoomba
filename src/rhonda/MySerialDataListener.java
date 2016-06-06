package rhonda;

import java.util.Stack;

import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataListener;

public class MySerialDataListener implements SerialDataListener {
	private Stack<SerialDataEvent> queue = new Stack<SerialDataEvent>();
	
	MySerialDataListener() {
		
	}

	@Override
	public void dataReceived(SerialDataEvent e) {
		queue.push(e);
	}
	public String read() {
		return queue.pop().getData();
	}
	public boolean isEmpty() {
		return queue.isEmpty();
	}

}
