import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		
		File file = new File(args[1]);
		
		Scanner input;
		String s;
		ArrayList<String> fromFile = new ArrayList<>();
		
		try {
			input = new Scanner(file);
			while(input.hasNext()) {
				s = input.next();
				if (s.equals(args[0])) {
					continue;
				}
				fromFile.add(s);
				fromFile.add(" ");	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		
		try {
			PrintWriter toFile = new PrintWriter(file);
			for (int i = 0; i < fromFile.size(); i++) {
				toFile.print(fromFile.get(i));
			}
			toFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}