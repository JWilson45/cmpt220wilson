

import java.util.Arrays;
import java.util.Scanner;

public class Q4 {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Enter two sets of values");
		System.out.println("The first number is the ammount of numbers in the array, then enter n numbers in the array");
		
		System.out.print("Array 1: " );
		int n1 = input.nextInt();
		int[] array1 = new int[n1];
		for (int i=0;i<n1;i++)
			array1[i] = input.nextInt();
		
		System.out.print("Array 2: " );
		int n2 = input.nextInt();
		int[] array2 = new int[n2];
		for (int i=0;i<n2;i++)
			array2[i] = input.nextInt();
		
		//String s = equal(array1,array2)? "identical" : "not identical";
		System.out.println("The two arrays are " + (equal(array1,array2) ? "identical" : "not identical"));
	}
	
	public static boolean equal(int[] x, int[] y) {
		if(x.length != y.length)
			return false;
		Arrays.sort(x);
		Arrays.sort(y);
		if(Arrays.equals(x, y))
			return true;
		else return false;
	}


}
