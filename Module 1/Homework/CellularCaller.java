
public class CellularCaller implements Caller {

	@Override
	public void call(String contact) {
		System.out.println("Calling " + contact + " via your cellular network...");
	}
}
