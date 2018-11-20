package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * By default, the file location is "data/". Change file location
 * and file names with getters and setters. Use save(Encrypt e) to save
 * files and getAllEncryptedData(Decrypt e) to  
 * @author Jason Wilson
 *
 */
abstract class Save {

	private static String fileLocation = "data/";
	private static String keysFileName = "key.txt";
	private static String encryptedTextFileName = "EncryptedText.txt";

	public static void save(Encrypt e) {
		try {
			PrintWriter pw = new PrintWriter(fileLocation + encryptedTextFileName,"UTF-8");
			for(int i = 0; i<e.getEncryptedText().length();i++) {
				if (e.getEncryptedText().charAt(i) == ',')
					i++;
				pw.print(e.getEncryptedText().charAt(i));
			}
			PrintWriter pw2 = new PrintWriter("src/project2/data/key.txt","UTF-8");
			pw2.print(e.getKey().length + " ");
			for(int i = 1; i<Arrays.toString(e.getKey()).length()-1;i++) {
				if (Arrays.toString(e.getKey()).charAt(i) == ',')
					i++;
				pw2.print(Arrays.toString(e.getKey()).charAt(i));
			}
			pw2.println();
			for(int i = 1; i<e.getKey2().toString().length()-1;i++) {
				if (e.getKey2().toString().charAt(i) == ',')
					i++;
				pw2.print(e.getKey2().toString().charAt(i));
			}
			pw2.close();
			pw.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e1) {
			e1.printStackTrace();
			System.exit(1);
		}

	}

	public static void setAllEncryptedDataFromFile(Decrypt e) {
		try {
			setKeysFromFile(e);
			setEncryptedTextFromFile(e);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.exit(0);}
	}

	public static void setEncryptedTextFromFile(Decrypt e) throws FileNotFoundException {
		File encryptedText = new File(fileLocation + encryptedTextFileName);
		Scanner input = new Scanner(encryptedText);
		String s = input.nextLine();
		input.close();
		e.setEncryptedText(s);
	}

	public static void setKeysFromFile(Decrypt e) throws FileNotFoundException {
		File keyTextFile = new File(fileLocation + keysFileName);
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
	
	public static void setKeysFromFile(Decrypt e, String FileLocation) throws FileNotFoundException {
		String fileLocationTmp = fileLocation;
		fileLocation = FileLocation;
		setKeysFromFile(e);
		fileLocation = fileLocationTmp;
	}
	
	public static void setEncryptedTextFromFile(Decrypt e, String FileLocation) throws FileNotFoundException {
		String fileLocationTmp = fileLocation;
		fileLocation = FileLocation;
		setEncryptedTextFromFile(e);
		fileLocation = fileLocationTmp;
	}

	public String getKeysFileName() {
		return keysFileName;
	}

	public static void setKeysFileName(String keysFile) {
		keysFileName = keysFile;
	}


	public static String getEncryptedTextFileName() {
		return encryptedTextFileName;
	}

	public static void setEncryptedTextFileName(String encryptedTextFile) {
		encryptedTextFileName = encryptedTextFile;
	}

	public static String getFileLocation() {
		return fileLocation;
	}

	public static void setFileLocation(String FileLocation) {
		fileLocation = FileLocation;
	}

}