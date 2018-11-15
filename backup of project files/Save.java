package project2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class Save {
	
	public static void save(Encrypt e) {
	try {
		PrintWriter pw = new PrintWriter("src/project2/data/EncryptedText.txt","UTF-8");
		for(int i = 0; i<e.getEncryptedText().length();i++) {
			if (e.getEncryptedText().charAt(i) == ',')
				i++;
			pw.print(e.getEncryptedText().charAt(i));
		}
		pw.close();
	} catch (FileNotFoundException | UnsupportedEncodingException e1) {
		e1.printStackTrace();
	}
	
	try {
		PrintWriter pw2 = new PrintWriter("src/project2/data/key.txt","UTF-8");
		pw2.print(e.getKey().length + " ");
		for(int i = 1; i<Arrays.toString(e.getKey()).length()-1;i++) {
			if (Arrays.toString(e.getKey()).charAt(i) == ',')
				i++;
			pw2.print(Arrays.toString(e.getKey()).charAt(i));
		}
		pw2.println();
		for(int i = 1; i<e.getStage2().toString().length()-1;i++) {
			if (e.getStage2().toString().charAt(i) == ',')
				i++;
			pw2.print(e.getStage2().toString().charAt(i));
		}
		pw2.close();
	} catch (FileNotFoundException | UnsupportedEncodingException e1) {
		e1.printStackTrace();
	}
	
	}
	
}