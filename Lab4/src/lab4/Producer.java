package lab4;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Producer extends Thread {
	private final Buffer buffer;
	private int id;
	public Producer(Buffer buffer, int id) {
		super("Producer #" + id);
		this.buffer = buffer;
		this.id = id;
	}
	public void produce() throws InterruptedException {
		buffer.put(id);
	}
	public void kill() {
		this.id = 0;
	}
	@Override
	public void run() {
		while(true) {
			if(this.id == 0) return;
			try {
			produce();
			Thread.sleep(2000);
			}
			catch(InterruptedException exception) {
				Alert alert = new Alert(AlertType.INFORMATION);
		        alert.setTitle("Exception");
		        alert.setHeaderText("Warning!");
		        alert.setContentText(exception.getMessage());
		        alert.showAndWait();			
			}
		}
	}
}
