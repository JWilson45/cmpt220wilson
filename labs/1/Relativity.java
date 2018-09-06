import java.util.Scanner;

public class Relativity {
	
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("Enter the mass in kilograms: ");
		double mass = input.nextDouble();
		System.out.println("E = " + mass * Math.pow(299972458, 2));
		

	}

}
