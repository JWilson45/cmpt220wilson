package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EncryptTest extends Save {

	public static void main(String[] args) throws FileNotFoundException {
		Encrypt encrypt = new Encrypt();
		
		Scanner input = new Scanner(System.in);
		
		encrypt.setDecryptedText(input.nextLine());
		
		input.close();
		
		encrypt.encrypt();
		
		save(encrypt);
		
		String encryptedFromFile = readFile("src/project2/data/EncryptedText.txt");
		
		//Trouble character sniffer
		for(int i = 0; i<encrypt.getEncryptedText().length();i++) {
			if(encrypt.getEncryptedText().charAt(i) != encryptedFromFile.charAt(i)) {
				System.out.print((int)encrypt.getEncryptedText().charAt(i-1) + ", " + (int)encrypt.getEncryptedText().charAt(i)+ ", " + (int)encrypt.getEncryptedText().charAt(i+1));
				System.out.println();
				System.out.print((int)encryptedFromFile.charAt(i-1) + ", " + (int)encryptedFromFile.charAt(i) + ", " + (int)encryptedFromFile.charAt(i-1));
				System.out.println("\n");
				System.exit(0);
			}
		}
		
	}
		private static String readFile(String file) throws FileNotFoundException {
			File encryptedText = new File(file);
			Scanner input = new Scanner(encryptedText);
			String s = input.nextLine();
			input.close();
			return s;
		}
}
//		Decrypt d = new Decrypt();
//		d.setEncryptedText(encrypt.getEncryptedText());
//		d.setKey(encrypt.getKey());
//		d.setKey2(encrypt.getKey2());
//		d.decrypt();