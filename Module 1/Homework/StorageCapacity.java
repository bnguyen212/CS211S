
public enum StorageCapacity {

	DEFAULT (64), SMALL (128), MEDIUM (256), LARGE (512), XLARGE (1024), XXLARGE (2048);

	private int storageCapacity;

	private StorageCapacity(int storageCapacity) {
		this.storageCapacity = storageCapacity;
	}

	public int getStorageCapacity() {
		return storageCapacity;
	}

	@Override
	public String toString() {
		return storageCapacity + "GB";
	}

}
