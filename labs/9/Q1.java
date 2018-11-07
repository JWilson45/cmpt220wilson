import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		int[] array = new int[100];
		
		for (int i = 0; i < array.length; i++)
			array[i] = (int)(Math.random()*1000);
		
		System.out.print("Enter an index of the array for the element value: ");
		System.out.println();
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();
		try {
		System.out.println(array[n]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Out of Bounds");
		}
	}

}