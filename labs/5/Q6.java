

import java.util.Scanner;

public class Q6 {

	private static Scanner input;
	private static int x , y;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("Enter the dimensions for your matrix seperated by a space: ");
		x = input.nextInt();
		y = input.nextInt();
		double[][] arr = new double[x][y];
		System.out.println("Enter the numbers to go into the matrix (total = "+(x*y)+"): ");
		for(int i = 0;i<x;i++) {
			for(int j = 0;j<y;j++) {
				double n = input.nextDouble();
				arr[i][j] = n;
			}
		}
		
		System.out.print("Enter a column index to calculate the average of: ");
		int col = input.nextInt();
		
		System.out.println("The average of column index " + col + " is: "
				+ averageRow(arr,col));
	}
	
	public static double averageRow(double[][] array, int column) {
		double total = 0;
		for (int i = 0 ; i<x ; i++) {
			total += array[i][column];
		}
		return total / x;
	}

}
