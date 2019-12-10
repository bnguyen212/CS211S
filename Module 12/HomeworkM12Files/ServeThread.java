import java.util.*;
import java.util.concurrent.*;

public class ServeThread implements Runnable {

	private int serveCount = 0;
	private List<Food> foodList;
	private BlockingQueue<Food> foodQueue;

	public ServeThread(List<Food> foodList, BlockingQueue<Food> queue) {
		this.foodList = foodList;
		this.foodQueue = queue;
	}

	@Override
	public void run() {
		while(serveCount < foodList.size()) {
			System.out.println("SERVER READY");
			try {
				Food food = foodQueue.take();
				System.out.println("SERVER STARTING: " + food);
				Thread.sleep(food.getServeTime() * 1000);
				System.out.println("SERVER ENDING: " + food);
				serveCount++;
			} catch (InterruptedException ex) { }
		}
	}
}