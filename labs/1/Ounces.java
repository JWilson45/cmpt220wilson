import java.util.Scanner;

public class Ounces {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("Enter a value for ounces: ");
		double ounces = input.nextDouble();
		double result = 28.3495 * ounces;
		System.out.println(ounces + " ounces is " + result);
				

	}

}
