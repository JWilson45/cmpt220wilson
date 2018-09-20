

import java.util.Scanner;

public class PositiveNumberReader {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("Enter a positive integer, the input ends with a 0: ");
		int numbers = 1;
		double total = 0;
		int even = 0;
		double n = 0;
		numbers = input.nextInt();
		for(;numbers != 0;) {
			if(numbers % 2 == 0)
				even++;
			n++;
			total += numbers;
			numbers = input.nextInt();
			
		}
		
		System.out.println("The number of even numbers: " + even);
		System.out.println("The total sum: " + (int)total);
		System.out.println("The average is: " + total / n);
		
		
	}

}
