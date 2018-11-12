import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class encrypt1 {
	private static long[] keys;
	private static Scanner input;
	private static ArrayList<Integer> randomCharShift;

	public static void main(String[] args) {
		input = new Scanner(System.in);

		String text = input.nextLine();

		keys = Key_Listener.random();
		/**String encryptedText = */encrypt(text);

	}

	private static void encrypt(String text) {
		long[] encryptedArray = new long[text.length()];
		for (int i = 0, j = 0;i<text.length();i++,j++) {
			encryptedArray[i] = (text.charAt(i) * keys[j]) - keys[j+1];
			if(j+1 >= keys.length-1)
				j = 0;
		}

		String arrayString = Arrays.toString(encryptedArray);

		ArrayList<Integer> encryptedEncryption = new ArrayList<Integer>();
		randomCharShift = new ArrayList<Integer>();
		int randomCharShiftNumber;

		for (int i = 1;i<arrayString.length()-1;i++) {
			if(arrayString.charAt(i) == ',') {
				encryptedEncryption.add(0);
				randomCharShift.add(1);
				i += 2;
			}
			do randomCharShiftNumber = (int)(Math.random()*244);
			while(randomCharShiftNumber < 32 || ((int)arrayString.charAt(i))-48 + randomCharShiftNumber == 133);

			encryptedEncryption.add((((int)arrayString.charAt(i))-48) + randomCharShiftNumber);
			randomCharShift.add(randomCharShiftNumber);
		}

		int[] encEnc = new int[encryptedEncryption.size()];
		for (int i = 0; i<encryptedEncryption.size();i++)
			encEnc[i] = encryptedEncryption.get(i);

		for (int i : encEnc)
			System.out.print((char)i);

		decrypt();
	}

	private static void decrypt(/*String encryptedText*/) {
		String encryptedText = input.nextLine();
		ArrayList<Integer> textToChar = new ArrayList<Integer>();

		for (int i = 0; i<encryptedText.length();i++) {
			textToChar.add((int)encryptedText.charAt(i));
		}

		ArrayList<Integer> decryptStage2 = new ArrayList<Integer>();

		for (int i = 0; i<textToChar.size(); i++) {
			decryptStage2.add(textToChar.get(i) - randomCharShift.get(i));
		}

		StringBuilder decryptStage2String = new StringBuilder();
		for(int i = 1; i<decryptStage2.toString().length()-1;i++) {
			if (decryptStage2.toString().charAt(i) == ',')
				i+=2;
			if (decryptStage2.toString().charAt(i) == '-') {
				i++;
				decryptStage2String.append(" ");
				continue;
			}
			decryptStage2String.append(decryptStage2.toString().charAt(i));
		}

		StringBuilder encryptedChar = new StringBuilder();
		ArrayList<Integer> encryptedInt = new ArrayList<Integer>();

		for(int i = 0;i<decryptStage2String.length();i++) {
			if(decryptStage2String.toString().charAt(i) == ' ') {
				encryptedInt.add(Integer.parseInt(encryptedChar.toString()));
				encryptedChar = new StringBuilder();
				continue;
			}
			encryptedChar.append(decryptStage2String.toString().charAt(i));		
		}
		encryptedInt.add(Integer.parseInt(encryptedChar.toString()));
		
		StringBuilder decrypredText = new StringBuilder();
		ArrayList<Long> finalResultChar = new ArrayList<Long>();
		for (int i = 0,j = 0; i<encryptedInt.size();i++,j++) {
			finalResultChar.add((encryptedInt.get(i) + keys[j+1])/keys[j]);
			decrypredText.append((char)Long.parseLong(finalResultChar.get(i).toString()));
			if(j+1 >= keys.length-1)
				j = 0;
		}
		
		String result = decrypredText.toString();
		System.out.println(result);
	}
}