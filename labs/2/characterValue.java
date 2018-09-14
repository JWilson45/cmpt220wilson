
import java.util.*;

public class characterValue {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input first character: ");
		int v1 = input.next().charAt(0);
		
		System.out.print("Input first character: ");
		int v2 = input.next().charAt(0);
		
		int result = v1 + v2;

		System.out.println("The result is: " + result);
	}
}
