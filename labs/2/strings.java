
import java.util.Scanner;

public class strings {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("ENTER A STRING: ");
		String string1 = input.nextLine();
		System.out.print("ENTER ANOTHER STRING: ");
		String string2 = input.nextLine();
		if(string1.compareTo(string2)>0) {
			System.out.println(string2);
			System.out.println(string1);
		}else {
			System.out.println(string1);
			System.out.println(string2);
		}
		

	}

}
