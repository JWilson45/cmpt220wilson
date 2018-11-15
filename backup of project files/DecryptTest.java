package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DecryptTest extends Save {
	public static void main(String[] args)  {
		Decrypt decrypt = new Decrypt();

		try {
			decrypt.setEncryptedText(readFile("src/project2/data/EncryptedText.txt"));
			readKeyFromFile("src/project2/data/key.txt", decrypt);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		decrypt.decrypt();
		
		System.out.println(decrypt.getDecryptedText());
	}

	private static String readFile(String file) throws FileNotFoundException {
		File encryptedText = new File(file);
		Scanner input = new Scanner(encryptedText);
		String s = input.nextLine();
		input.close();
		return s;
	}

	/**
	 * Method reads and separates 
	 * @param file File path
	 * @param e Decrypt object
	 * @return Long Array for decrypting
	 * @throws FileNotFoundException 
	 */
	private static void readKeyFromFile(String file, Decrypt e) throws FileNotFoundException {
		File keyTextFile = new File(file);
		Scanner input = new Scanner(keyTextFile);
		long[] longArray = new long[input.nextInt()];
		ArrayList<Integer> longList = new ArrayList<>();

		for(int i = 0; i<longArray.length;i++)
			longArray[i] = input.nextLong();


		e.setKey(longArray);


		while(input.hasNext())
			longList.add(input.nextInt());


		e.setKey2(longList);


		input.close();
	}
}