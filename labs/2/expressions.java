
import java.util.Scanner;

public class expressions {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number1;
		number1 = input.nextInt();
		System.out.print("Enter another number: ");
		int number2 = input.nextInt();
		
		System.out.print(number1 + " is LESS THAN " + number2 + "? ");
		System.out.println(number1 < number2);
		
		System.out.print(number1 + " is EQUAL TO or LESS THAN " + number2 + "? ");
		System.out.println(number1 <= number2);
		
		System.out.print(number1 + " is EQUAL TO " + number2 + "? ");
		System.out.println(number1 == number2);
		
		System.out.print(number1 + " is NOT EQUAL TO " + number2 + "? ");
		System.out.println(number1 != number2);
		
		System.out.print(number1 + " is GREATER THAN " + number2 + "? ");
		System.out.println(number1 > number2);
		
		System.out.print(number1 + " is EQUAL TO or GREATER THAN " + number2 + "? ");
		System.out.println(number1 >= number2);

	}

}
