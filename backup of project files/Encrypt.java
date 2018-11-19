package project2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Usage: 	Initialize using constructor, setDecryptedText, encrypt(), then
 * getEncryptedText()
 * @author Jason Wilson
 */
public class Encrypt extends Encryption{

	/**Constructor*/
	public Encrypt(){
		this(null);
	}

	/**Constructor
	 * @param decryptedText The string to be encrypted
	 */
	public Encrypt(String decryptedText) {
		this.setDecryptedText(decryptedText);
		setKey2(new ArrayList<>());
	}

	/**Initialize encryption*/
	public void encrypt() {
		//Set Variable(s)
		long[] encryptedArray = new long[getDecryptedText().length()];

		//Check for keys
		if (getKey() == null)
			generateNewKey();

		/*First level of encryption:
		 * takes the string provided by user and
		 * changes their values using the random
		 * numbers the key provides.*/
		for (int i = 0, j = 0;i<getDecryptedText().length();i++,j++) {
			encryptedArray[i] = (getDecryptedText().charAt(i) * getKey()[j]) - getKey()[j+1];
			//Prevents array index out of bounds
			if(j+1 >= getKey().length-1)
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
				getKey2().add(1);
				i += 2;
			}

			//Excluding problem causing char values
			do randomCharShiftNumber = (int)(Math.random()*244);
			while(
					randomCharShiftNumber < 32
					|| ((int)Arrays.toString(l).charAt(i))-48 + randomCharShiftNumber == 133
					|| ((int)Arrays.toString(l).charAt(i))-48 + randomCharShiftNumber == 44
					);

			//Adding values to Lists
			encryptionStage2.add((((int)Arrays.toString(l).charAt(i))-48) + randomCharShiftNumber);
			getKey2().add(randomCharShiftNumber);
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
		setEncryptedText(encryptedString.toString());
	}

	/**Generates a new random set of keys based on user input*/
	public void generateNewKey() {
		setKey(Key_Listener.random());
	}

}