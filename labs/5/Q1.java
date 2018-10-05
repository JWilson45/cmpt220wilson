

import java.util.Scanner;

public class Q1 {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("Enter 10 numbers: ");
		
		double[] user_in = new double[10];
		
		for(int i = 0; i<10; i++) 
			user_in[i] = input.nextDouble();
		
		System.out.println("\nMaximum: " + max(user_in));

	}
	
	public static double max(double[] array) {
		int posOfMax = 0;
		for(int i = 0; i<10; i++) {
			if(array[posOfMax] < array[i]) {
				posOfMax = i;
			}
		}
		return array[posOfMax];
	}
}