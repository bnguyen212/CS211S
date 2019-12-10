import java.util.*;
import java.util.concurrent.*;

public class CookThread implements Runnable {

	private List<Food> foodList;
	private BlockingQueue<Food> foodQueue;

	public CookThread(List<Food> foodList, BlockingQueue<Food> queue) {
		this.foodList = foodList;
		this.foodQueue = queue;
	}

	@Override
	public void run() {
		for(Food food : foodList) {
			try {
				System.out.println("COOK READY");
				System.out.println("COOK STARTING: " + food);
				Thread.sleep(food.getCookTime() * 1000);
				foodQueue.put(food);
				System.out.println("COOK ENDING: " + food);
			} catch (InterruptedException ex) { }
		}
	}
}