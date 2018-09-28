
import java.util.Arrays;
import java.util.Scanner;

public class sort {

	public static void main(String[] args) {
		System.out.print("Enter numbers to be sorted(end input with 0): ");
		Scanner input = new Scanner(System.in);
		int[] numbers = new int[100];
		for(int i = 0; i < 100; i++) {
			int n = input.nextInt();
			if (n==0)
				break;
			numbers[i] = n;
		}
		Arrays.sort(numbers);
		for(int i = 0; i<100;i++) {
			if(numbers[i]==0)
				continue;
			System.out.println(numbers[i]);
		}
	}

}
