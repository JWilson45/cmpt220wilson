package project2;

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
		
	}

}