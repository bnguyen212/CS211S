
public enum StorageCapacity {

	DEFAULT (64), SMALL (128), MEDIUM (256), LARGE (512), XLARGE (1024), XXLARGE (2048);
	
	/* SSD_128(128), SSD_256(256), SSD_512(512), SSD_1T(1024), SSD_2T(2048), SSD_4T(4096); */

	private int storageCapacity;

	private StorageCapacity(int storageCapacity) {
		this.storageCapacity = storageCapacity;
	}

	public int getStorageCapacity() {
		return storageCapacity;
	}

	@Override
	public String toString() {
		if (storageCapacity < 1023) {
			return storageCapacity + "GB";
		} else {
			return (storageCapacity/1024) + "TB";
		}
	}

}
