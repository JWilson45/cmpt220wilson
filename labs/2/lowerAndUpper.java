
import java.util.*;

public class lowerAndUpper {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input a number: ");
		int lNumber = input.nextInt();
		
		System.out.print("Input a larger number larger than " + (lNumber + 1) + ": ");
		int uNumber = input.nextInt();
		
		int multiple = uNumber + 1;

		double rando = Math.random() * multiple;
		double rando2 = Math.random() * multiple;
		double rando3 = Math.random() * multiple;

		while (!(lNumber < rando && rando < uNumber)) {
			rando = (int)(Math.random() * multiple);
		}
		System.out.println((int)rando);
		
		while (!(lNumber < rando2 && rando2 < uNumber)) {
			rando2 = (int)(Math.random() * multiple);
		}
		System.out.println((int)rando2);
		
		while (!(lNumber < rando3 && rando3 < uNumber)) {
			rando3 = (int)(Math.random() * multiple);
		}
		System.out.println((int)rando3);

	}

}