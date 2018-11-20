package project2;

public class DecryptTest extends Save {
	public static void main(String[] args)  {
		Decrypt decrypt = new Decrypt();
		
		setFileLocation("src/project2/data/");
		setAllEncryptedDataFromFile(decrypt);

		decrypt.decrypt();
		
		System.out.println(decrypt.getDecryptedText());
	}
}