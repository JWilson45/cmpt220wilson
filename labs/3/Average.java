

import java.util.Scanner;

public class Average {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input a number: ");
		double num1 = input.nextDouble();
		System.out.print("Input another number: ");
		double num2 = input.nextDouble();
		System.out.print("Input one last number: ");
		double num3 = input.nextDouble();
		
		System.out.println("The average is: " + average(num1,num2,num3));
		

	}
	
	public static double average(double a, double b, double c) {
		double avg = a + b + c;
		avg = avg / 3;
		return avg;
		
	}

}
