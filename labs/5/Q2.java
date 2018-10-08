

import java.util.Scanner;

public class Q2 {
	
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		double[] x = new double[10];
		System.out.print("Enter 10 numbers. I will output the mean and SD.\n");
		
		for(int i=0;i<10;i++)
			x[i] = input.nextDouble();
		
		System.out.println("\nThe mean is -> " + mean(x));
		
		System.out.println("\nThe SD is -> " + deviation(x));

	}
	
	public static double deviation(double[] x) {
		double total = 0;
		double mean = mean(x);
		for (double i : x)
			total += Math.pow(i - mean,2);
		return total / (9);
		
	}
	
	public static double mean(double[] x) {
		double total = 0;
		for(double num : x)
			total += num;
		return total / 10; // JA: Why only 10?
	}

}
