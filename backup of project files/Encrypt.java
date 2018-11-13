import java.util.ArrayList;
import java.util.Arrays;

/**
 * Usage: 	Initialize using constructor, setText, then getEncryptedText and
 *			class will return encrypted text.
 * @author Jason Wilson
 */
public class Encrypt extends Encryption{
	private long[] key;
	private ArrayList<Integer> key2;
	private String encryptedText;
	private String textToEncrypt;
	
	/**Constructor*/
	public Encrypt(){
		textToEncrypt = null;
		key2 = new ArrayList<>();
	}
	
	/**Constructor
	 * @param textToEncrypt The string to be encrypted
	 */
	public Encrypt(String textToEncrypt) {
		this.textToEncrypt = textToEncrypt;
		key2 = new ArrayList<>();
	}
	
	/**Initialize encryption*/
	public void encrypt() {
		//Set Variable(s)
		long[] encryptedArray = new long[textToEncrypt.length()];
		
		//Check for keys
		if (key == null)
			generateNewKey();
		
		/*First level of encryption:
		 * takes the string provided by user and
		 * changes their values using the random
		 * numbers the key provides.*/
		for (int i = 0, j = 0;i<textToEncrypt.length();i++,j++) {
			encryptedArray[i] = (textToEncrypt.charAt(i) * key[j]) - key[j+1];
			//Prevents array index out of bounds
			if(j+1 >= key.length-1)
				j = 0;
		}
		
		/*Sends the second stage to another random 
		 * generator to further encrypt the string and
		 * finalize*/
		stage2(encryptedArray);
	}
	
	private void stage2(long[] l) {
		//Set Variables
		int randomCharShiftNumber;
		ArrayList<Integer> encryptionStage2 = new ArrayList<Integer>();
		
		for (int i = 1;i<Arrays.toString(l).length()-1;i++) {
			//Adding only wanted characters from the string into array
			if(Arrays.toString(l).charAt(i) == ',') {
				encryptionStage2.add(0);
				key2.add(1);
				i += 2;
			}
			
			//Excluding problem causing char values
			do randomCharShiftNumber = (int)(Math.random()*244);
			while(randomCharShiftNumber < 32 || ((int)Arrays.toString(l).charAt(i))-48 + randomCharShiftNumber == 133);

			//Adding values to Lists
			encryptionStage2.add((((int)Arrays.toString(l).charAt(i))-48) + randomCharShiftNumber);
			key2.add(randomCharShiftNumber);
		}
		//Set the EncryptedText variable
		setEncryptedText(encryptionStage2);
	}
	
	private void setEncryptedText(ArrayList<Integer> encryptionStage2) {
		//Set Variable(s)
		StringBuilder encryptedString = new StringBuilder();
		
		for (int i = 0;i < encryptionStage2.size();i++) {
			encryptedString.append(((char)encryptionStage2.get(i).intValue()));
		}
		encryptedText = encryptedString.toString();
	}

	/**Generates a new random set of keys based on user input*/
	public void generateNewKey() {
		key = Key_Listener.random();
	}

	/**
	 * @return The primary key for number to be decrypted
	 */
	public long[] getKey() {
		return key;
	}

	/**
	 * Set the encryption key instead of
	 * randomly generating it.
	 * @param key
	 */
	public void setKey(long[] key) {
		this.key = key;
	}

	/**
	 * @return text that is entered and ready to be encrypted
	 */
	public String getText() {
		return textToEncrypt;
	}

	/**
	 * @param textToEncrypt String to be encrypted
	 */
	public void setText(String textToEncrypt) {
		this.textToEncrypt = textToEncrypt;
	}

	/**
	 * @return Second set of random numbers to use for decryption
	 */
	public ArrayList<Integer> getStage2() {
		return key2;
	}

	/**
	 * @return Encrypted text as a string
	 */
	public String getEncryptedText() {
		return encryptedText;
	}
}