import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListSort {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);

		ArrayList<Integer> arr = new ArrayList<Integer>();

		System.out.println("Input 5 numbers to be sorted:");
		for (int i = 0; i<5; i++) {
			arr.add(input.nextInt());
		}
		sort(arr);
	}

	public static void sort(ArrayList<Integer> list) {
		Collections.sort(list);		
		System.out.println(list.toString());
	}

}
