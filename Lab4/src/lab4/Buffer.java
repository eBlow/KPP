package lab4;

import java.util.concurrent.*;

public class Buffer{
	private BlockingQueue<Integer> queue;
	public Buffer(Integer size) throws IllegalArgumentException {
		if (size<1) throw new IllegalArgumentException();
		queue = new LinkedBlockingQueue<Integer>(size);
	}
	public void put(Integer value) throws InterruptedException {
		this.queue.put(value);
	}
	public Integer take() throws InterruptedException {
		return this.queue.take();
	}
}
