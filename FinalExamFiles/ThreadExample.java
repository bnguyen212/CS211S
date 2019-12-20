public class ThreadExample extends Thread {
  private String message;
  private int numTimes;

  public ThreadExample(String message, int numTimes) {
     this.message = message;
     this.numTimes = numTimes;
  }

  public void run() {
    for(int i=0; i<numTimes; i++) {
      System.out.println(message);
   }
  }

  public static void main(String[] args) {
    Thread[] threads = new ThreadExample[2];
    threads[0] = new ThreadExample("Brian Nguyen", 10);
    threads[1] = new ThreadExample("snow!", 100);
    for(Thread t : threads) {
			t.start();
		}
  }
}