
public class WifiCaller implements Caller {

	@Override
	public void call(String contact) {
		System.out.println("Calling " + contact + " via Wi-Fi...");
	}
}
