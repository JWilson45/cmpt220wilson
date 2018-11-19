package project2;

import java.util.ArrayList;

/**
 * 	Usage:	Initialize using constructor, setEncryptedText, decrypt(), then
 * getDecryptedText()
 * @author Jason Wilson
 *
 */
public class Decrypt extends Encryption{

	/**Constructor*/
	public Decrypt() {
		this(null,null,null);
	}

	/**Constructor
	 * @param key First key generated
	 * @param key2  Second key generated
	 * @param encryptedText The text that is to be decrypted
	 */
	public Decrypt(long[] key, ArrayList<Integer> key2, String encryptedText) {
		this.setKey(key);
		this.setKey2(key2);
		this.setEncryptedText(encryptedText);
	}

	/**Initialize decryption*/
	public void decrypt() {
		ArrayList<Integer> encryptedTextAsChar = toChar();
		ArrayList<Integer> key2UsedDecryption = reverseKey2(encryptedTextAsChar);
		String decryptedStage2String = Stage2(key2UsedDecryption);
//		System.out.println(encryptedTextAsChar);
//		System.out.println(key2UsedDecryption);
//		System.out.println(decryptedStage2String);
		ArrayList<Integer> encryptedInt = Stage3(decryptedStage2String);
		setDecryptedText(FinalStage(encryptedInt));		
	}

	private String FinalStage(ArrayList<Integer> encryptedInt) {
		StringBuilder finalText = new StringBuilder();
		ArrayList<Long> finalResultChar = new ArrayList<>();
		for (int i = 0,j = 0; i<encryptedInt.size();i++,j++) {
			finalResultChar.add((encryptedInt.get(i) + getKey()[j+1])/getKey()[j]);
			finalText.append((char)Long.parseLong(finalResultChar.get(i).toString()));
			if(j+1 >= getKey().length-1)
				j = 0;
		}
		return finalText.toString();
	}

	private ArrayList<Integer> Stage3(String decryptedStage2String) {
		StringBuilder encryptedChar = new StringBuilder();
		ArrayList<Integer> encryptedInt = new ArrayList<Integer>();
		for(int i = 0;i<decryptedStage2String.length();i++) {
			if(decryptedStage2String.toString().charAt(i) == ' ') {
				encryptedInt.add(Integer.parseInt(encryptedChar.toString()));
				encryptedChar = new StringBuilder();
				continue;
			}
			encryptedChar.append(decryptedStage2String.charAt(i));		
		}
		encryptedInt.add(Integer.parseInt(encryptedChar.toString()));

		return encryptedInt;
	}

	private String Stage2(ArrayList<Integer> key2UsedDecryption) {
		StringBuilder decryptStage2String = new StringBuilder();
		for(int i = 1; i<key2UsedDecryption.toString().length()-1;i++) {
			if (key2UsedDecryption.toString().charAt(i) == ',')
				i+=2;
			if (key2UsedDecryption.toString().charAt(i) == '-') {
				i++;
				decryptStage2String.append(" ");
				continue;
			}
			decryptStage2String.append(key2UsedDecryption.toString().charAt(i));
		}
		return decryptStage2String.toString();
	}

	private ArrayList<Integer> reverseKey2(ArrayList<Integer> encryptedTextAsChar) {
		ArrayList<Integer> key2Dercyption = new ArrayList<Integer>();
		for (int i = 0; i<encryptedTextAsChar.size(); i++)
			key2Dercyption.add((encryptedTextAsChar.get(i) - getKey2().get(i)));
		return key2Dercyption;
	}

	private ArrayList<Integer> toChar(){
		ArrayList<Integer> textToChar = new ArrayList<Integer>();
		for (int i = 0; i<getEncryptedText().length();i++)
			textToChar.add((int) getEncryptedText().charAt(i));

		return textToChar;
	}

}