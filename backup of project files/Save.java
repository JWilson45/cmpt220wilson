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
			PrintWriter pw = new PrintWriter(fileLocation + encryptedTextFileName,"UTF-8");
			for(int i = 0; i<e.getEncryptedText().length();i++) {
				if (e.getEncryptedText().charAt(i) == ',')
					i++;
				pw.print(e.getEncryptedText().charAt(i));
			}
			PrintWriter pw2 = new PrintWriter(fileLocation + keysFileName,"UTF-8");
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
		return userFile + defaultFileName;
		
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

}