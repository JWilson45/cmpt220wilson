

import java.util.Scanner;

public class Q5 {

	private static Scanner input;

	public static void main(String[] args) {
		System.out.print("Enter the size for your matrix: ");
		input = new Scanner(System.in);
		int x = input.nextInt();
		int[][] matrix = new int[x][x];
		
		System.out.println("Enter the numbers to go into the matrix (total = "+(Math.pow(x, 2))+"): ");
		for(int i = 0;i<x;i++) {
			for(int j = 0,n;j<x;j++) {
				n = input.nextInt();
				matrix[i][j] = n;
			}
		}

		print(matrix,"\nOriginal matrix:");
		print(trans(matrix),"\n\nTransposed matrix:");	
		
	}
	
	public static int[][] trans(int[][] array) {
		int x = array.length;
		int[][] transpose = new int[x][x];
		for(int i = 0;i<x;i++) {
			for(int j = 0;j<x;j++) {
				transpose[j][i] = array[i][j];
			}
		}
		return transpose;
	}
	
	public static void print(int[][] array,String s) {
		System.out.println(s);
		int x = array.length;
		for(int i = 0;i<x;i++) {
			System.out.println();
			for(int j = 0;j<x;j++) {
				System.out.printf("%2d",array[i][j]);
			}
		}
	}

}
