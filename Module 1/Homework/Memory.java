
public enum Memory {

	SMALL(8), DEFAULT(16), MEDIUM(32), LARGE(64), XLARGE(128), XXLARGE(256);

	private int memory;

	private Memory(int memory) {
		this.memory = memory;
	}

	public double getMemory() {
		return memory;
	}

	@Override
	public String toString() {
		return memory + "GB";
	}

}
