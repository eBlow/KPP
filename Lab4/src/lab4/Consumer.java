package lab4;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Consumer extends Thread {
	private final Buffer buffer;
	private int id;
	public StringBuilder result;
	public Consumer(Buffer buffer, int id) {
		super("Consumer #" + id);
		this.buffer = buffer;
		this.id = id;
		result = new StringBuilder();
	}
	public void consume() throws InterruptedException {		
		this.result.append(buffer.take() + " ");
	}
	public void kill() {
		this.id = 0;
	}
	@Override
	public void run() {
		while(true) {
			if(this.id == 0) return;
			try {
			consume();
			Thread.sleep(1000);
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
