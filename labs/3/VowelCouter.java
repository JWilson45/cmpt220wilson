
import java.util.Scanner;

public class VowelCouter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String str = input.nextLine();
		
		System.out.println("Amount of vowels in string: " + vowels(str));
		

	}
	
	public static int vowels(String str) {
		int amount = 0;
		for(int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a' || 
					str.charAt(i) == 'e' || 
					str.charAt(i) == 'i' ||
					str.charAt(i) == 'o' || 
					str.charAt(i) == 'u') 
				
				amount++;
				
		}
		
		return amount;
		
	}

}
