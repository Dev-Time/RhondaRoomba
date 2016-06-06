package rhonda;

public class Main {

	public static void main(String[] args) {
		PiSerial ser = new PiSerial(57600);
		RoomberryPiController brain = new RoomberryPiController(ser);
		
		System.out.println("Begining Control of Roomba");
		ser.init();
		brain.wakeup();
		brain.start();
		brain.control();
		brain.clean();
		ser.close();
		System.out.println("Finished");
	}

}
