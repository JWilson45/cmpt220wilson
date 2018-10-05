

import java.util.Scanner;

public class Q3 {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("How many students are there? ");
		int Students = input.nextInt();
		double[] scores = new double[Students];
		String[] names = new String[Students];
		
		System.out.print("Enter the first name then score (seperated by a space) of...\n");
		for(int i = 0;i<Students;i++) {
			System.out.print("Student " + (i+1) + ": ");
			names[i] = input.next();
			scores[i] = input.nextInt();
		}
		
		for (int i = 0; i < scores.length; i++) {
			double currentMin = scores[i];
			String tmp = names[i];
			int currentMinIndex = i;
			for (int j = i + 1; j < scores.length; j++) {
				if (scores[j] < currentMin) {
					currentMin = scores[j];
					tmp = names[j];
					currentMinIndex = j;
				}
			}
			if (currentMinIndex != i) {
				scores[currentMinIndex] = scores[i];
				scores[i] = currentMin;
				names[currentMinIndex] = names[i];
				names[i] = tmp;
			}
		}
//		System.out.println(Arrays.toString(scores));
//	System.out.println(Arrays.toString(names));
		
		System.out.println("Scores in acending order:");
		for(int i = (names.length -1);i>=0;i--) {
			System.out.print(names[i] + " --> " + scores[i]+"\n");
		}
	}

}