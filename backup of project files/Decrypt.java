public class Decrypt extends Encryption{
	private long[] key;
	private long[] key2;
	private String encryptedText;
	private String decryptedText;
	
	/**Constructor*/
	public Decrypt() {
		setEncryptedText(null);
		setKey(null);
		setKey2(null);
	}
	
	public Decrypt(long[] key, long[] key2, String encryptedText) {
		this.setKey(key);
		this.setKey2(key2);
		this.setEncryptedText(encryptedText);
	}

	public long[] getKey() {
		return key;
	}

	public void setKey(long[] key) {
		this.key = key;
	}

	public long[] getKey2() {
		return key2;
	}

	public void setKey2(long[] key2) {
		this.key2 = key2;
	}
	
	public void setBothKeys(long[] key,long[] key2) {
		this.key = key;
		this.key2 = key2;
	}

	public String getEncryptedText() {
		return encryptedText;
	}

	public void setEncryptedText(String encryptedText) {
		this.encryptedText = encryptedText;
	}

	public String getDecryptedText() {
		return decryptedText;
	}

}