package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

abstract class Save {

	private static String fileLocation;
	private static final String keysFileName = "key.txt";
	private static final String encryptedTextFileName = "EncryptedText.txt";

	public static void save(Encrypt e) {
		try {
			//Print the encrypted text to file
			PrintWriter pw = new PrintWriter(fileLocation + encryptedTextFileName,"UTF-8");
			pw.print(e.getEncryptedText());

			//Print the first key into the keys file
			PrintWriter pw2 = new PrintWriter(fileLocation + keysFileName,"UTF-8");
			String key1Export = Arrays.toString(e.getKey());
			pw2.print(e.getKey().length + " ");
			StringBuilder keysString = new StringBuilder();
			for(int i = 1; i<key1Export.length()-1;i++) {
				if (key1Export.charAt(i) == ',')
					i++;
				keysString.append(key1Export.charAt(i));
			}

			pw2.print(keysString.toString());
			pw2.println();

			//Print the second key into the keys file
			String key2Export = e.getKey2().toString();
			keysString = new StringBuilder();
			for(int i = 1; i<key2Export.length()-1;i++) {
				if (key2Export.charAt(i) == ',')
					i++;
				keysString.append(key2Export.charAt(i));
			}

			pw2.print(keysString.toString());

			//Close the print writers
			pw2.close();
			pw.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

	}

	public static void setAllEncryptedDataFromFile(Decrypt e) {
		try {
			setKeysFromFile(e);
			setEncryptedTextFromFile(e);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
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

	public static void setKeysFromFile(Decrypt e, String fileLocation) {
		File keyTextFile = new File(fileLocation);

		try {
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

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public static void setEncryptedTextFromFile(Decrypt e, String fileLocation) {
		File encryptedText = new File(fileLocation);
		try {
			Scanner input = new Scanner(encryptedText);
			String s = input.nextLine();
			input.close();
			e.setEncryptedText(s);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public static void setDefaultKey(Encrypt e, String fileLocation) {
		File defaultKey = new File(fileLocation);
		try {
			Scanner input = new Scanner(defaultKey);
			long[] longArray = new long[input.nextInt()];

			for(int i = 0; i<longArray.length;i++)
				longArray[i] = input.nextLong();

			e.setKey(longArray);
			input.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public static String importDecryptedText(String fileLocation) {
		File decryptedTextFile = new File(fileLocation);
		StringBuilder importText = new StringBuilder();
		try {
			Scanner input = new Scanner(decryptedTextFile);
			while(input.hasNextLine()) {
				importText.append(input.nextLine());
				importText.append((char)10);
			}
			input.close();
			importText.deleteCharAt(importText.length() - 1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return importText.toString();
	}

	public static String getDefaultFilePath() {
		String userFile = System.getProperty("user.dir").substring(0, System.getProperty("user.dir").lastIndexOf(System.getProperty("file.separator")) + 1);
		final String defaultFileName = "data";
		File defaultDir = new File(userFile + defaultFileName);
		if(!defaultDir.exists()) {
			defaultDir.mkdir();
			try {
				PrintWriter pw = new PrintWriter(defaultDir + System.getProperty("file.separator") + defaultFileName + "DefaultKey.txt","UTF-8");
				pw.print("28 70 8 60 155 128 163 197 16 37 15 22 43 7 2 6 67 93 143 34 50 24 85 48 39 11 8 7 49");
				pw.close();
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return userFile + defaultFileName + System.getProperty("file.separator");

	}

	public String getKeysFileName() {
		return keysFileName;
	}

	public static String getEncryptedTextFileName() {
		return encryptedTextFileName;
	}

	public static String getFileLocation() {
		return fileLocation;
	}

	public static void setFileLocation(String FileLocation) {
		fileLocation = FileLocation;
	}

	public static void saveText(String decryptedText) {
		File decryptTextFile = new File(fileLocation);
		try {
			PrintWriter pw = new PrintWriter(decryptTextFile);
			pw.print(decryptedText);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}