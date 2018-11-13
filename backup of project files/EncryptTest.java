import java.util.Scanner;

public class EncryptTest extends Save {

	public static void main(String[] args) {
		Encrypt encrypt = new Encrypt();
		
		Scanner input = new Scanner(System.in);
		
		encrypt.setText(input.nextLine());
		
		input.close();
		
		encrypt.encrypt();
		
		save(encrypt);
		
	}

}